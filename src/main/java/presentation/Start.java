/**
vlad
Apr 12, 2018

*/

package presentation;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Start extends JFrame{

	private JPanel panel;
	private JButton viewClients;
	private JButton viewProducts;
	private JButton viewOrders;
	
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100,100,800,600); 
		panel = new JPanel(); 
		panel.setLayout(null); 
		Font arialFont = new Font("Arial", Font.BOLD, 15);
		this.setTitle("Order Management");
		viewClients = new JButton("View Clients");
		viewClients.setBounds(300,200,200,30);
		viewClients.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(viewClients);
		viewProducts = new JButton("View Products");
		viewProducts.setBounds(300,240,200,30);
		viewProducts.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(viewProducts);
		viewOrders = new JButton("View Orders");
		viewOrders.setBounds(300,280,200,30);
		viewOrders.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(viewOrders);
		this.add(panel);
		this.setVisible(true);
	}
	
	public void viewClientsPressed(ActionListener e) {
		viewClients.addActionListener(e);
	}
	
	public void viewProductsPressed(ActionListener e) {
		viewProducts.addActionListener(e);
	}
	
	public void viewOrdersPressed(ActionListener e) {
		viewOrders.addActionListener(e);
	}
	
	public JFrame getStartFrame() {
		return this;
	}
}
