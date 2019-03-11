/**
vlad
Apr 12, 2018

*/

package presentation;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class OrdersPage extends JFrame{

	private JPanel panel;
	private JButton back;
	private JLabel selectClient, selectProduct, quantityLabel;
	private ArrayList<String> clients;
	private ArrayList<String> products;
	private JComboBox productsList;
	private JComboBox clientsList;
	private JButton placeOrder;
	private JTextField quantity;
	private JTable ordersTable;
	private JScrollPane scroll;
	private JLabel idLabel;
	private JTextField id;
	private JButton deleteOrder;
	
	
	public OrdersPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100,100,800,600); 
		panel = new JPanel(); 
		panel.setLayout(null); 
		Font arialFont = new Font("Arial", Font.BOLD, 15);
		this.setTitle("Orders");
		back = new JButton("Go back");
		back.setBounds(10,520,100,30);
		panel.add(back);
		selectClient = new JLabel("Select Client:");
		selectClient.setBounds(10,10,200,30);
		selectClient.setFont(arialFont);
		panel.add(selectClient);
		clientsList = new JComboBox();
		clientsList.setBounds(10,50,100,30);
		panel.add(clientsList);
		selectProduct = new JLabel("Select Product");
		selectProduct.setBounds(10,90,200,30);
		selectProduct.setFont(arialFont);
		panel.add(selectProduct);
		productsList = new JComboBox();
		productsList.setBounds(10,130,100,30);
		panel.add(productsList);
		quantityLabel = new JLabel("Quantity");
		quantityLabel.setFont(arialFont);
		quantityLabel.setBounds(10,170,100,30);
		panel.add(quantityLabel);
		quantity = new JTextField();
		quantity.setBounds(10,210,100,30);
		panel.add(quantity);
		placeOrder = new JButton("Place order");
		placeOrder.setBounds(10,250,150,30);
		panel.add(placeOrder);
		idLabel = new JLabel("ID to delete");
		idLabel.setFont(arialFont);
		idLabel.setBounds(10,290,150,30);
		panel.add(idLabel);
		id = new JTextField();
		id.setBounds(10,330,100,30);
		panel.add(id);
		deleteOrder = new JButton("Delete order");
		deleteOrder.setBounds(10,370,150,30);
		panel.add(deleteOrder);
		
		ordersTable = new JTable();
		ordersTable.setBounds(180,10,600,530);
		scroll = new JScrollPane(ordersTable);
		scroll.setBounds(180,10,600,530);
		panel.add(scroll);
		
		this.add(panel);
		this.setVisible(false);
	}
	
	public int getQuantity() {
		return Integer.parseInt(quantity.getText());
	}
	
	public String getClientCombo() {
		return clientsList.getSelectedItem().toString();
	}
	
	public String getProductCombo() {
		return productsList.getSelectedItem().toString();
	}
	
	public void setClients(ArrayList<String> clients) {
		this.clients = clients;
		clientsList.removeAll();
		DefaultComboBoxModel model = new DefaultComboBoxModel(this.clients.toArray());
		clientsList.setModel(model);
	}

	public void setProducts(ArrayList<String> products) {
		this.products = products;
		productsList.removeAll();
		DefaultComboBoxModel model = new DefaultComboBoxModel(this.products.toArray());
		productsList.setModel(model);
	}
	
	public void placePressed(ActionListener e) {
		placeOrder.addActionListener(e);
	}
	
	public int deleteId() {
		return Integer.parseInt(id.getText());
	}
	
	public void deletePressed(ActionListener e) {
		deleteOrder.addActionListener(e);
	}
	
	public void modifyTable(TableModel tableModel) {
		this.ordersTable.setModel(tableModel);
	}
	
	public void backPressed(ActionListener e) {
		back.addActionListener(e);
	}
	
	public JFrame getOrdersFrame() {
		return this;
	}
}
