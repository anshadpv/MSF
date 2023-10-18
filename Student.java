package Sample;
import java.util.*;

public class Student {
	String firstName;
	String lastName;
	int age;
	
	public Student() {
		firstName="Anshad";
		lastName="PV";
		age=22;
	}
	public static void main(String []args) {
		Student s = new Student();
		System.out.println(s.firstName);
		System.out.println(s.lastName);
		System.out.println(s.age);
	}

}
