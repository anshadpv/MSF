package Sample;
import java.util.*;
import java.util.ArrayList;

class Product{
	private int productId;
	private String name;
	private double price;
	private String quantity;
	
	public Product(int productId, String name, double price, String quantity) {
		this.productId=productId;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	public int getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getQuantity() {
		return quantity;
	}
}

class cartItem{
	private Product product;
	private int quantity;
	
	public cartItem(Product product, int quantity) {
		this.product=product;
		this.quantity=quantity;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
}

class shoppingCart{
	 private List<cartItem> cartItems;
	 
	 public shoppingCart() {
		 cartItems = new ArrayList<>();
	 }
	 public void addItem(cartItem item) {
		 cartItems.add(item);
	 }
	 public void removeItem(cartItem item) {
		 cartItems.remove(item);
	 }
	 public double calculateTotalCost() {
		 double totalCost=0;
		 for (cartItem item : cartItems) {
			 totalCost += item.getProduct().getPrice()*item.getQuantity();
		 }
		 return totalCost;
	 }
	 public void displayCart() {
		 for (cartItem item : cartItems) {
			 Product product = item.getProduct();
			 System.out.println("Product Id : "+product.getProductId()+
					 ", Name : "+product.getName()+
					 ", Price : $"+product.getPrice()+
					 ", Quantity : "+product.getQuantity()+
					 ", Order Quantity : "+item.getQuantity());
		 }
	 }
}
 class customer{
	 private int customerId;
	 private String name;
	 private String email;
	 
	 public customer(int customerId, String name, String email) {
		 this.customerId=customerId;
		 this.name=name;
		 this.email=email;
	 }
	 public int getCustomerId() {
		 return customerId;
	 }
	 public String getName() {
		 return name;
	 } public String getEmail() {
		 return email;
	 }
	 
 }

public class order {
	public static void main(String []args) {
		Product product1 =new Product(1,"Product A", 10,"100gm");
		Product product2 =new Product(2,"Product B", 15,"200gm");
		
		cartItem cartItem1 = new cartItem(product1,5);
		cartItem cartItem2 = new cartItem(product2,2);
		
		shoppingCart shoppingCart = new shoppingCart();
		shoppingCart.addItem(cartItem1);
		shoppingCart.addItem(cartItem2);
		
		System.out.println("Cart items : ");
		shoppingCart.displayCart();
		System.out.println("Total Cost : $"+shoppingCart.calculateTotalCost());
		
		customer customer = new customer(1,"Anshad","anshadpv4@gmail.com");
		System.out.println("Customer Id : "+customer.getCustomerId()+
				 ", Name : "+customer.getName()+
				 ", Email : "+customer.getEmail());
		
	}
	

}
