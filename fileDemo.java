package Sample;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileDemo {
	public static void main(String []args) throws Exception {
		
		//creating a file
		File myFile = new File("F:\\Sample.txt");
		try {
			if (myFile.createNewFile()) {
				System.out.println("File successfully created.");
			}else {
				System.out.println("File already exist.");
			}
		}catch (IOException e) {
			System.out.println("Exeption caught.");
		}
		
		//writing and reading to the file
		FileWriter myWriter = new FileWriter(myFile);
		myWriter.write("This is written using FileWriter class \n");
		String str = "This is Line 2";
		myWriter.write(str);
		myWriter.close();
		
		Scanner sc = new Scanner(myFile);
		while(sc.hasNextLine()) {
			String data = sc.nextLine();
			System.out.println(data);
		}
		
		//appending to an existing file
		File test = new File("F:\\test.txt");
		FileWriter fileWriter = new FileWriter(test);
		BufferedWriter bufferedFileWriter = new BufferedWriter(fileWriter);
		fileWriter.append("This line is appended to the already existing test file.");
		bufferedFileWriter.close();
		
		File rename = new File("F:\\renamed.txt");
		test.renameTo(rename);
		
		File deletefile = new File("F:\\todelete.txt");
		if (deletefile.delete()) {
			System.out.println("File deleted Successfully");
		}else {
			System.out.println("No such File.");

		}

	}
}
