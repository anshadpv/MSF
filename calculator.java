package Sample;
import java.util.*;
import java.lang.Exception;

class Operations{
	
	public void add(double x, double y) {
		double res=x+y;
		System.out.println("Sum of numbers = "+res);
	}
	public void subtract(double x, double y) {
		double res=x-y;
		System.out.println("Difference of numbers = "+res);
	}
	public void multiply(double x, double y) {
		double res=x*y;
		System.out.println("Result = "+res);
	}
	public void divide(double x, double y) {
		double res;
		try {
			if(y==0) {
				throw new ArithmeticException();
			}
			res=x/y;
			System.out.println("Result = "+res);
		}
		catch (ArithmeticException e) {
			System.out.println("Division by Zero Exception Caught");
		}
	}
}

public class calculator {
	public static void main (String []args) {
		Operations op = new Operations();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the operation(+,-,*,/) : ");
		String operator = sc.next();
		double x,y;
		switch (operator) {
		case "+" :
			System.out.println("Enter two numbers : ");
			x=sc.nextDouble();
			y=sc.nextDouble();
			op.add(x,y);
			break;
		case "-" :
			System.out.println("Enter two numbers : ");
			x=sc.nextDouble();
			y=sc.nextDouble();
			op.subtract(x,y);
			break;
		case "*" :
			System.out.println("Enter two numbers : ");
			x=sc.nextDouble();
			y=sc.nextDouble();
			op.multiply(x,y);
			break;
		case "/" :
			System.out.println("Enter two numbers : ");
			x=sc.nextDouble();
			y=sc.nextDouble();
			op.divide(x,y);
			break;	
		default :
			System.out.println("Enter valid operator");
			break;
		}
	}
}


