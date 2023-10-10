package Sample;
import java.util.*;

public class LargestNo {
	public static void main(String []args) {
		int a,b,c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter three numbers :");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		if (a>b &&  a>c) {
			System.out.println("Biggest Number is : "+a);
		}
		else if(b>c &&  b>c){
			System.out.println("Biggest Number is : "+b);
		}
		else {
			System.out.println("Biggest Number is : "+c);
		}
	}
}
