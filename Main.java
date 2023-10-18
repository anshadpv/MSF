package Sample;
import java.util.*;

class Animals{
	public void makeSound() {
	}
}
class dog extends Animals{
	public void makeSound() {
		System.out.println("Bow Bow !!");
	}
}
class cat extends Animals{
	public void makeSound() {
		System.out.println("Meow Meow !!");
	}
}
class cow extends Animals{
	public void makeSound() {
		System.out.println("Moo Moo !!");
	}
}
public class Main {
	public static void main(String []args) {
		Animals[] animal = new Animals[3];
		animal[0]=new dog();
		animal[1]=new cat();
		animal[2]=new cow();
		animal[0].makeSound();
		animal[1].makeSound();
		animal[2].makeSound();
		
	}

}
