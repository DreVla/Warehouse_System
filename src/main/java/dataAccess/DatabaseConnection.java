/**
vlad
Apr 9, 2018

*/

package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import model.Client;
import model.Product;


public class DatabaseConnection {

	private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/warehouse";
	private static final String USER = "root";
	private static final String PASS = "";
	private Connection connection;
	
	public DatabaseConnection() {
		if(connection == null) {
			try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(DBURL,USER,PASS);
				//System.out.println("Database connected");
			} catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	//	return connection;
	}
	
	public Connection getConn() {
		return connection;
	}
	
	public void disconnect() {
		if(connection!=null) {
			try {
				connection.close();
				connection = null;
				System.out.println("Disconnected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
//	public ResultSet showClients() throws SQLException{
//		try {
//			String select = "select * from client";
//			Statement stmt = connection.createStatement();
//			ResultSet result = stmt.executeQuery(select);
//			return result;
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public ResultSet insertClient(Client client) throws SQLException{
//		try {
//			String update= "insert into client(name, email, address) values('"
//					+ client.getName()+ "','"+client.getEmail()+"','"+ client.getAddress()+"')";
//			Statement statement= connection.createStatement();
//			statement.executeUpdate(update);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public ResultSet deleteClient(Client c) throws SQLException{
//		try {
//			String delete="delete from client where id='"+ c.getId() +"';";
//			Statement statement= connection.createStatement();
//			statement.executeUpdate(delete);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public ResultSet updateClient(Client c) throws SQLException{
//		try {
//			String update="update client set name='"+c.getName()+
//					"',email='"+c.getEmail()+
//					"',address='"+c.getAddress()+
//					"' where id='"+c.getId()+"';";
//			Statement statement= connection.createStatement();
//			statement.executeUpdate(update);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public ResultSet showProducts() throws SQLException{
//		try {
//			String select = "select * from products";
//			Statement stmt = connection.createStatement();
//			ResultSet result = stmt.executeQuery(select);
//			return result;
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public ResultSet insertProduct(Product product) throws SQLException{
//		try {
//			String update= "insert into products(name, price, quantity) values('"
//					+ product.getName()+ "','"+product.getPrice()+"','"+ product.getQuantity()+"')";
//			Statement statement= connection.createStatement();
//			statement.executeUpdate(update);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public ResultSet deleteProduct(Product p) throws SQLException{
//		try {
//			String delete="delete from products where name='"+p.getName()+"'and id='"+ p.getId() +"';";
//			Statement statement= connection.createStatement();
//			statement.executeUpdate(delete);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public ResultSet updateProduct(Product p) throws SQLException{
//		try {
//			String update="update products set price='"+p.getPrice()+
//					"',quantity='"+p.getQuantity()+
//					"',name='"+p.getName()+
//					"' where id='"+p.getId()+"';";
//			Statement statement= connection.createStatement();
//			statement.executeUpdate(update);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
}
