

package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Order;


public class OrderDAO {

	ArrayList<Order> orders;
	Connection connection;
	public OrderDAO(){
		this.orders = new ArrayList<Order>();
		this.connection = new DatabaseConnection().getConn();
	}
	
	public ResultSet showOrders() throws SQLException{
		try {
			String select = "select * from `order`";
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(select);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet insertOrder(Order order) throws SQLException{
		try {
			String update= "insert into `order`(customer_id, product_id, customerName, productName, quantity)"
					+ " values('" + order.getCustomer_id() + "','" + order.getProduct_id() + "','" 
					+ order.getClient() + "','"+order.getProduct()+"','"+ order.getQuantity()+"')";
			Statement statement= connection.createStatement();
			statement.executeUpdate(update);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet deleteOrder(int id) throws SQLException{
		try {
			String delete="delete from `order` where idorder='"+ id +"';";
			Statement statement= connection.createStatement();
			statement.executeUpdate(delete);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet updateOrder(Order order) throws SQLException{
		try {
			String update="update `order` set customerName='"+order.getClient()+
					"',productName='"+order.getProduct()+
					"',quantity='"+order.getQuantity()+
					"' where id='"+order.getId()+"';";
			Statement statement= connection.createStatement();
			statement.executeUpdate(update);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
