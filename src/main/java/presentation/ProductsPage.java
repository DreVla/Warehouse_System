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
import javax.swing.table.TableModel;

public class ProductsPage extends JFrame{

	private JPanel panel;
	private JButton back;
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel priceLabel;
	private JTextField priceTextField;
	private JLabel quantityLabel;
	private JTextField quantityTextField;
	private JButton addNewProduct;
	private JButton updateProduct;
	private JButton deleteProduct;
	private JTable productsTable;
	private JScrollPane scroll;
	
	
	public ProductsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100,100,800,600); 
		panel = new JPanel(); 
		panel.setLayout(null); 
		Font arialFont = new Font("Arial", Font.BOLD, 15);
		this.setTitle("Products");
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
		priceLabel = new JLabel("Price:");
		priceLabel.setBounds(10,130,200,30);
		priceLabel.setFont(arialFont);
		panel.add(priceLabel);
		priceTextField = new JTextField();
		priceTextField.setBounds(10,160,100,30);
		priceTextField.setFont(arialFont);
		panel.add(priceTextField);
		quantityLabel = new JLabel("Quantity:");
		quantityLabel.setBounds(10,190,200,30);
		quantityLabel.setFont(arialFont);
		panel.add(quantityLabel);
		quantityTextField = new JTextField();
		quantityTextField.setBounds(10,220,100,30);
		quantityTextField.setFont(arialFont);
		panel.add(quantityTextField);
		addNewProduct = new JButton("Add new product");
		addNewProduct.setBounds(10,250,150,30);
		panel.add(addNewProduct);
		updateProduct = new JButton("Update Product");
		updateProduct.setBounds(10,285,150,30);
		panel.add(updateProduct);
		deleteProduct = new JButton("Delete Product");
		deleteProduct.setBounds(10,320,150,30);
		panel.add(deleteProduct);
		productsTable = new JTable();
		productsTable.setBounds(180,10,600,530);
		scroll = new JScrollPane(productsTable);
		scroll.setBounds(180,10,600,530);
		panel.add(scroll);
		
		this.add(panel);
		this.setVisible(false);
	}
	
	public void modifyTable(TableModel tableModel) {
		this.productsTable.setModel(tableModel);
	}
	
	public int getID() {
		return Integer.parseInt(idTextField.getText());
	}
	
	public String getName() {
		return nameTextField.getText();
	}
	
	public int getPrice() {
		return Integer.parseInt(priceTextField.getText());
	}
	
	public int getQuantity() {
		return Integer.parseInt(quantityTextField.getText());
	}
	
	public void addProductPressed(ActionListener e) {
		addNewProduct.addActionListener(e);
	}
	
	public void updateProductPressed(ActionListener e) {
		updateProduct.addActionListener(e);
	}
	
	public void deleteProductPressed(ActionListener e) {
		deleteProduct.addActionListener(e);
	}
	
	public void backPressed(ActionListener e) {
		back.addActionListener(e);
	}
	
	public JFrame getProductsFrame() {
		return this;
	}
}
