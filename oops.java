package Sample;
import java.util.*;

class car {
	  String model;
	  int num;
	  String color;
	  
	  public void show() {
		  System.out.println("Details of Car");
	  }
	}

class kia extends car{
	public void display() {
		System.out.println("Model : "+model);
		System.out.println("Number : "+num);
		System.out.println("Color : "+color);
	}	
}

public class oops {
	
	public static void main(String []args) {
		kia k = new kia();
		k.show();
		k.model = "Kia Seltos";
		k.num=5848;
		k.color="Grey";
		k.display();
	}

}
