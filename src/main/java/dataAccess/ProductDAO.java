/**
vlad
Apr 14, 2018

*/

package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;

public class ProductDAO {

	ArrayList<Product> products;
	Connection connection;
	public ProductDAO(){
		this.products = new ArrayList<Product>();
		this.connection = new DatabaseConnection().getConn();
	}
	
	public ResultSet showProducts() throws SQLException{
		try {
			String select = "select * from products";
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(select);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet insertProduct(Product product) throws SQLException{
		try {
			String update= "insert into products(name, price, quantity) values('"
					+ product.getName()+ "','"+product.getPrice()+"','"+ product.getQuantity()+"')";
			Statement statement= connection.createStatement();
			statement.executeUpdate(update);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet deleteProduct(Product p) throws SQLException{
		try {
			String delete="delete from products where name='"+p.getName()+"'and id='"+ p.getId() +"';";
			Statement statement= connection.createStatement();
			statement.executeUpdate(delete);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet updateProduct(Product p) throws SQLException{
		try {
			String update="update products set price='"+p.getPrice()+
					"',quantity='"+p.getQuantity()+
					"',name='"+p.getName()+
					"' where id='"+p.getId()+"';";
			Statement statement= connection.createStatement();
			statement.executeUpdate(update);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet getProductsNames() throws SQLException{
		try {
			String select = "select name from products";
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(select);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet getProductId(String name) throws SQLException{
		try {
			String select = "select id from products where name ='" + name + "';";
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(select);
			return result;
		}  catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet getProductQuantity(int id) throws SQLException{
		try {
			String select = "select quantity from products where id ='" + id + "';";
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(select);
			return result;
		}  catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet updateProductQuantity(int id, int decrement) throws SQLException{
		try {
			String update="update products set quantity='"+decrement+
					"' where id='"+id+"';";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(update);
		}  catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
