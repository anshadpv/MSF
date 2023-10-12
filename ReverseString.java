package Sample;
import java.util.*;

public class ReverseString {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String str = sc.nextLine();
		String []words=str.split(" ");
		String revStr = "";
		for (String w:words) {
			StringBuilder sb = new StringBuilder(w);
			sb.reverse();
			revStr+=sb.toString()+" ";
			
		}
		System.out.println(revStr);
	}

}
