/**
vlad
Apr 14, 2018

*/

package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Client;

public class ClientDAO {

	private Client client;
	private Connection connection;
	public ClientDAO(){
		this.client = new Client();
		this.connection = new DatabaseConnection().getConn();
	}
	
	public ResultSet showClients() throws SQLException{
		try {
			String select = "select * from client";
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(select);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet insertClient(Client client) throws SQLException{
		try {
			String update= "insert into client(name, email, address) values('"
					+ client.getName()+ "','"+client.getEmail()+"','"+ client.getAddress()+"')";
			Statement statement= connection.createStatement();
			statement.executeUpdate(update);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet deleteClient(Client c) throws SQLException{
		try {
			String delete="delete from client where id='"+ c.getId() +"';";
			Statement statement= connection.createStatement();
			statement.executeUpdate(delete);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet updateClient(Client c) throws SQLException{
		try {
			String update="update client set name='"+c.getName()+
					"',email='"+c.getEmail()+
					"',address='"+c.getAddress()+
					"' where id='"+c.getId()+"';";
			Statement statement= connection.createStatement();
			statement.executeUpdate(update);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet getClientsNames() throws SQLException{
		try {
			String select = "select name from client";
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(select);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet getClientId(String name) throws SQLException{
		try {
			String select = "select * from client where name ='" + name + "';";
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(select);
			return result;
		}  catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}