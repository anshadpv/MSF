package Sample;

import java.util.Scanner;

public class pattern {
	public static void main(String []args) {
		int n,i,j;
		System.out.println("Enter the number of rows : ");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		for (i=1;i<=n;i++) {
			for(j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

}
