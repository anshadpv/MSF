package Sample;

import java.util.Scanner;
import java.text.DecimalFormat;

public class test {
	
	private static final String[] units = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	public static String convertToWords(int number) {
		if (number<0 || number>999999){
			return "Invalid Input";
		}
		if (number==0) {
			return "Zero";
		}
		
		String words="";
		
		if ((number/100000)>0) {
			words+=convertToWords(number/100000)+" Lakh ";
			number=number%100000;
		}
		if ((number/1000)>0) {
			words+=convertToWords(number/1000)+" Thousand ";
			number=number%1000;
		}
		if ((number/100)>0) {
			words+=convertToWords(number/100)+" Hundread ";
			number=number%100;
		}
		if(number>0) {
			if (number<10) {
				words+=units[number];
			}
			else if(number==10){
				words+=tens[1];
			}
			else if (number<20) {
				words+=teens[number-10];
			}
			else {
				int x=number%10;
				if (x==0) {
					words+=tens[number/10];
				}
				else {
					words+=tens[number/10]+" "+units[number%10];
				}
			}
		}
		return words;
		
	}
	public static void Comma(int number) {
		if (number<0 || number>999999){
			System.out.println("Invalid Number");
		}
		else if (number==0) {
			System.out.println("0");

		}
		else {
			String pattern="#,##,###";
			DecimalFormat chosenFormat = new DecimalFormat(pattern);
			System.out.println("In Number : "+chosenFormat.format(number));
		}

	}
	

	public static void main(String []args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		n=sc.nextInt();	
		String words = convertToWords(n);
		Comma(n);
		System.out.println("In Words : "+words+" only");
	}
	
}
