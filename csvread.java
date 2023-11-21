package Sample;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class csvread {
	public static void main(String []args) throws IOException {
//		FileReader myfile = new FileReader("C:\\Users\\user\\Desktop\\Book1.csv");
//		BufferedReader bf = new BufferedReader(myfile);
//		String data="";
//		while((data=bf.readLine())!=null) {
//			System.out.println(data);
//		}
//		bf.close();
//		myfile.close();
		
		Scanner sc = new Scanner(new File("C:\\\\Users\\\\user\\\\Desktop\\\\Book1.csv"));
		sc.useDelimiter(",");
		while(sc.hasNext()) {
			System.out.print(sc.next()+" ");
		}
		sc.close();
	}

}
