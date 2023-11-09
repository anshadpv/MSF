package Sample;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.DataInputStream;


public class BufferedReaderExample {
	public static void main(String []args) throws IOException {
		 FileReader myFile  = new FileReader("C:\\Users\\user\\Desktop\\example.txt");
		 BufferedReader br = new BufferedReader(myFile);
		 
	
		 
		 System.out.println("This is read using BufferedReader.");
		 String data = "";
		 while ((data=br.readLine())!=null) {
			 System.out.println(data);
		 }
		 
		 System.out.println("\nThis is read using BufferedInputStream.");
		 FileInputStream doc = new FileInputStream("C:\\Users\\user\\Desktop\\example.txt");
		 BufferedInputStream brs = new BufferedInputStream(doc);
		 int i;
		 while((i=brs.read())!=-1) {
			 System.out.print((char)i);
		 }
		 brs.close();
		 
		 System.out.println("\n\nThis is read using DataInputStream.");
		 InputStream input = new FileInputStream("C:\\Users\\user\\Desktop\\example.txt");  
		 DataInputStream inst = new DataInputStream(input);  
		 int c = input.available();
		 byte[] arr = new byte[c];
		 inst.read(arr);
		 for (byte b : arr) {
			 char k = (char) b;
			 System.out.print(k);
		 }

	}

}
