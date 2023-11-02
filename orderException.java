package Sample;
import java.util.*;
import java.util.ArrayList;

class OutOfStockException extends Exception{
	public OutOfStockException(String str) {
		super(str);
	}
}

class EmptyCartException extends Exception{
	public EmptyCartException(String str) {
		super(str);
	}
}

class Product{
	private int productId;
	private String name;
	private double price;
	private boolean stock;
	
	public Product(int productId, String name, double price, boolean stock) {
		this.productId=productId;
		this.name=name;
		this.price=price;
		this.stock=stock;
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
	public boolean getStock() {
		return stock;
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
		 try {
			 if (item.getProduct().getStock()==false) {
				 throw new OutOfStockException(item.getProduct().getName()+" is out of stock.");
			 }
			 cartItems.add(item);
		 }
		 catch(OutOfStockException e) {
			 System.out.println("Exception caught : "+e.getMessage());
		 }
	}
	 public void removeItem(cartItem item) {
		 cartItems.remove(item);
	 }
	 public double calculateTotalCost() {
		 try {
			 if (cartItems.isEmpty()) {
				 throw new EmptyCartException("Cart is empty.");
			 }
		 }
		 catch(EmptyCartException e) {
			 System.out.println("EmptyCartException caught");
		 }
		 finally {
			 System.out.println("All exceptions handled.");
		 }
		 
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
					 ", Stock : "+product.getStock()+
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

public class orderException {
	public static void main(String []args) {
		Product product1 =new Product(1,"Product A", 10,true);
		Product product2 =new Product(2,"Product B", 15,false);
		Product product3 =new Product(3,"Product C", 20,true);

		
		cartItem cartItem1 = new cartItem(product1,5);
		cartItem cartItem2 = new cartItem(product2,2);
		cartItem cartItem3 = new cartItem(product3,1);
		
		shoppingCart shoppingCart = new shoppingCart();
		shoppingCart.addItem(cartItem1);
		shoppingCart.addItem(cartItem2);
		shoppingCart.addItem(cartItem3);

		System.out.println("Cart items : ");
		shoppingCart.displayCart();
		System.out.println("Total Cost : $"+shoppingCart.calculateTotalCost());
		
		customer customer = new customer(1,"Anshad","anshadpv4@gmail.com");
		System.out.println("Customer Id : "+customer.getCustomerId()+
				 ", Name : "+customer.getName()+
				 ", Email : "+customer.getEmail());
		
	}
	

}
