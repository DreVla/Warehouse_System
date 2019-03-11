/**
vlad
Apr 12, 2018

*/

package presentation;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class ClientsPage extends JFrame{

	private JPanel panel;
	private JButton back;
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JButton addNewClient;
	private JButton updateClient;
	private JButton deleteClient;
	private JTable clientsTable;
	private JScrollPane scroll;
	
	public ClientsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100,100,800,600); 
		panel = new JPanel(); 
		panel.setLayout(null); 
		Font arialFont = new Font("Arial", Font.BOLD, 15);
		this.setTitle("Clients");
		back = new JButton("Go back");
		back.setBounds(10,520,100,30);
		panel.add(back);
		idLabel = new JLabel("ID:");
		idLabel.setBounds(10,10,200,30);
		idLabel.setFont(arialFont);
		panel.add(idLabel);
		idTextField = new JTextField();
		idTextField.setBounds(10,40,100,30);
		idTextField.setFont(arialFont);
		panel.add(idTextField);
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(10,70,200,30);
		nameLabel.setFont(arialFont);
		panel.add(nameLabel);
		nameTextField = new JTextField();
		nameTextField.setBounds(10,100,100,30);
		nameTextField.setFont(arialFont);
		panel.add(nameTextField);
		emailLabel = new JLabel("Email:");
		emailLabel.setBounds(10,130,200,30);
		emailLabel.setFont(arialFont);
		panel.add(emailLabel);
		emailTextField = new JTextField();
		emailTextField.setBounds(10,160,100,30);
		emailTextField.setFont(arialFont);
		panel.add(emailTextField);
		addressLabel = new JLabel("Address:");
		addressLabel.setBounds(10,190,200,30);
		addressLabel.setFont(arialFont);
		panel.add(addressLabel);
		addressTextField = new JTextField();
		addressTextField.setBounds(10,220,100,30);
		addressTextField.setFont(arialFont);
		panel.add(addressTextField);
		addNewClient = new JButton("Add new client");
		addNewClient.setBounds(10,250,130,30);
		panel.add(addNewClient);
		updateClient = new JButton("Update Client");
		updateClient.setBounds(10,285,130,30);
		panel.add(updateClient);
		deleteClient = new JButton("Delete Client");
		deleteClient.setBounds(10,320,130,30);
		panel.add(deleteClient);
		clientsTable = new JTable();
		clientsTable.setBounds(180,10,600,530);
		scroll = new JScrollPane(clientsTable);
		scroll.setBounds(180,10,600,530);
		panel.add(scroll);
		
		this.add(panel);
		this.setVisible(false);
	}
	
	public void modifyTable(TableModel tableModel) {
		this.clientsTable.setModel(tableModel);
	}
	
	public String getName() {
		return nameTextField.getText();
	}
	
	public String getEmail() {
		return emailTextField.getText();
	}
	
	public String getAddress() {
		return addressTextField.getText();
	}
	
	public int getID() {
		return Integer.parseInt(idTextField.getText());
	}
	
	public void addClientPressed(ActionListener e) {
		addNewClient.addActionListener(e);
	}
	
	public void updateClientPressed(ActionListener e) {
		updateClient.addActionListener(e);
	}
	
	public void deleteClientPressed(ActionListener e) {
		deleteClient.addActionListener(e);
	}
	
	public void backPressed(ActionListener e) {
		back.addActionListener(e);
	}
	
	public JFrame getClientsFrame() {
		return this;
	}
}
