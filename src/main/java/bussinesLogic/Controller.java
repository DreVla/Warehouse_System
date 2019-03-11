/**
vlad
Apr 9, 2018

*/

package bussinesLogic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dataAccess.ClientDAO;
import dataAccess.DatabaseConnection;
import dataAccess.OrderDAO;
import dataAccess.ProductDAO;
import model.Client;
import model.Order;
import model.Product;
import presentation.ClientsPage;
import presentation.OrdersPage;
import presentation.ProductsPage;
import presentation.Start;

public class Controller {

	private Start start;
	private ClientsPage viewClients;
	private ProductsPage viewProducts;
	private OrdersPage viewOrders;
	private ResultSet tableData;
	private ResultSet rs;
	private ArrayList<String> clientsNames = new ArrayList<>();
	private ArrayList<String> productsNames = new ArrayList<>();
	private static Vector<String> tableColumns = new Vector<>();
	
	public Controller() {
		DatabaseConnection connection = new DatabaseConnection();
		ClientDAO clientsDao = new ClientDAO();
		ProductDAO productsDao = new ProductDAO();
		OrderDAO orderDao = new OrderDAO();
		//ResultSet tableData = null;
		start = new Start();
		viewClients = new ClientsPage();
		viewProducts = new ProductsPage();
		viewOrders = new OrdersPage();
//		clientsNames = new ArrayList<String>();
//		productsNames = new ArrayList<String>();
		// start page controller
		start.viewClientsPressed(e->{
			viewClients.getClientsFrame().setVisible(true);
			//retrieveProperties(new Client());
			try {
				tableData = clientsDao.showClients();
				viewClients.modifyTable(this.buildTableModel(new Client(), tableData));
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			start.getStartFrame().setVisible(false);
		});
		
		start.viewProductsPressed(e->{
			viewProducts.getProductsFrame().setVisible(true);
			
			try {
				tableData = productsDao.showProducts();
				viewProducts.modifyTable(this.buildTableModel(new Product(), tableData));
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			start.getStartFrame().setVisible(false);
		});
		
		start.viewOrdersPressed(e->{
			start.getStartFrame().setVisible(false);
			
			try {
				tableData = orderDao.showOrders();
				viewOrders.modifyTable(this.buildTableModel(new Order(), tableData));
				rs = clientsDao.getClientsNames();
				while(rs.next()) {
					String names = rs.getString("name");
					clientsNames.add(names);
				}
				rs = productsDao.getProductsNames();
				while(rs.next()) {
					String names = rs.getString("name");
					productsNames.add(names);
				}
				viewOrders.setClients(clientsNames);
				viewOrders.setProducts(productsNames);
				clientsNames.clear();
				productsNames.clear();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			viewOrders.getOrdersFrame().setVisible(true);
		});
		// ends start page
		
		// clients page controller
		viewClients.addClientPressed(e->{
			Client newClient = new Client(
					viewClients.getName(),
					viewClients.getEmail(),
					viewClients.getAddress());
			try {
				clientsDao.insertClient(newClient);
				tableData = clientsDao.showClients();
				viewClients.modifyTable(this.buildTableModel(new Client(), tableData));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		viewClients.updateClientPressed(e->{
			Client updateClient = new Client(
					viewClients.getID(),
					viewClients.getName(),
					viewClients.getEmail(),
					viewClients.getAddress());
			try {
				clientsDao.updateClient(updateClient);
				tableData = clientsDao.showClients();
				viewClients.modifyTable(this.buildTableModel(new Client(), tableData));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		viewClients.deleteClientPressed(e->{
			Client deleteClient = new Client(
					viewClients.getID(),
					viewClients.getName(),
					viewClients.getEmail(),
					viewClients.getAddress());
			try {
				clientsDao.deleteClient(deleteClient);
				tableData = clientsDao.showClients();
				viewClients.modifyTable(this.buildTableModel(new Client(), tableData));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		viewClients.backPressed(e->{
			start.getStartFrame().setVisible(true);
			viewClients.getClientsFrame().setVisible(false);
		});
		// ends clients page
		
		// product page controller
		viewProducts.addProductPressed(e->{
			Product newProduct = new Product(
					viewProducts.getName(),
					viewProducts.getPrice(),
					viewProducts.getQuantity());
			try {
				productsDao.insertProduct(newProduct);
				tableData = productsDao.showProducts();
				viewProducts.modifyTable(this.buildTableModel(new Product(), tableData));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		viewProducts.updateProductPressed(e->{
			Product updateProduct = new Product(
					viewProducts.getID(),
					viewProducts.getName(),
					viewProducts.getPrice(),
					viewProducts.getQuantity());
			try {
				productsDao.updateProduct(updateProduct);
				tableData = productsDao.showProducts();
				viewProducts.modifyTable(this.buildTableModel(new Product(), tableData));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		viewProducts.deleteProductPressed(e->{
			Product deleteProduct = new Product(
					viewProducts.getID(),
					viewProducts.getName(),
					viewProducts.getPrice(),
					viewProducts.getQuantity());
			try {
				productsDao.deleteProduct(deleteProduct);
				tableData = productsDao.showProducts();
				viewProducts.modifyTable(this.buildTableModel(new Product(), tableData));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		viewProducts.backPressed(e->{
			start.getStartFrame().setVisible(true);
			viewProducts.getProductsFrame().setVisible(false);
		});
		// product page ends
		
		// order page controller
		viewOrders.placePressed(e->{
			int quantity = viewOrders.getQuantity();
			int clientId = 0, productId = 0, productQuantity = 0;
			String clientName, productName;
			clientName = viewOrders.getClientCombo();
			productName = viewOrders.getProductCombo();
			try {
				rs = clientsDao.getClientId(clientName);
				while(rs.next()) {
					clientId = rs.getInt("id");
				}
				System.out.println(clientId);
				rs = productsDao.getProductId(productName);
				while(rs.next()) {
					productId = rs.getInt("id");
				}
				System.out.println(productId);
				rs = productsDao.getProductQuantity(productId);
				while(rs.next()) {
					productQuantity = rs.getInt("quantity");
				}
				if(quantity > productQuantity) {
					JOptionPane.showMessageDialog(null, "Product quantity not in stock!","Error!", JOptionPane.ERROR_MESSAGE);
				} else {
					factura(clientId, productId, quantity, clientName, productName);
					Order newOrder = new Order(clientId, productId, clientName, productName, quantity);
					orderDao.insertOrder(newOrder);
					productsDao.updateProductQuantity(productId, productQuantity - quantity);
					tableData = orderDao.showOrders();
					viewOrders.modifyTable(this.buildTableModel(new Order(), tableData));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		viewOrders.deletePressed(e->{
			try {
				orderDao.deleteOrder(viewOrders.deleteId());
				tableData = orderDao.showOrders();
				viewOrders.modifyTable(this.buildTableModel(new Order(), tableData));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		viewOrders.backPressed(e->{
			start.getStartFrame().setVisible(true);
			viewOrders.getOrdersFrame().setVisible(false);
		});
		// order page ends
		
	}
	
	public DefaultTableModel buildTableModel(Object object, ResultSet rs) throws SQLException{
		tableColumns.clear();
		int i = 0;
		for(Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				tableColumns.add(field.getName());
				System.out.println(tableColumns.get(i));
				i++;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		while(rs.next()) {
			Vector<String> row = new Vector<String>();
			for(i = 1; i <= tableColumns.size(); i++) {
				row.add(rs.getString(i));
			}
			data.add(row);
		}
		return new DefaultTableModel(data,tableColumns);
	}
	
	public void factura(int clientId, int productId, int quantity, String clientName, String productName) {
		System.out.println("Factura noua");
		File factura = new File("factura" + productId + clientId + ".txt");
		try {
			factura.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (FileWriter fileWrite = new FileWriter(factura, true);
				BufferedWriter buffer = new BufferedWriter(fileWrite);){
			//PrintWriter print = new PrintWriter("factura" + productId + clientId + ".txt", "UTF-8");
			buffer.write("Factura " + clientId + productId + "\n");
			buffer.write("Client:" + clientName + " with id: " + clientId + "\n");
			buffer.write("Product: " + productName + " quantity: " + quantity + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
