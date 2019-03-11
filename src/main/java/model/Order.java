/**
vlad
Apr 11, 2018

*/

package model;

public class Order {
	
	private int id,customer_id,product_id;
	private String customerName;
	private String productName;
	private int quantity;
	
	public Order(int customer_id, int product_id, String client, String product, int quantity) {
		//this.id = id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.customerName = client;
		this.productName = product;
		this.quantity = quantity;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getClient() {
		return customerName;
	}

	public void setClient(String client) {
		this.customerName = client;
	}

	public String getProduct() {
		return productName;
	}

	public void setProduct(String product) {
		this.productName = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
