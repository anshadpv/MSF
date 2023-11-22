package Sample;
import java.io.*;
import java.util.*;

public class avg_salary {
	public static void main(String []args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		//checking csv file
		File myFile = new File("C:\\Users\\user\\Desktop\\employees.csv");
		if(myFile.exists()) {
			System.out.println("CSV File found.");
		}
		else {
			System.out.println("No such CSV File.");

		}
		
		//reading and storing elements into map
		FileReader fr = new FileReader(myFile);
		BufferedReader br = new BufferedReader(fr);
		Map<String,Integer> map = new HashMap<>();
        List<String[]> data = new ArrayList<>();
		String line;
		while((line=br.readLine())!=null) {
			String []values = line.split(",");
			data.add(values);
		}
		
		int eng=0,mkt=0;
		 for (String[] row : data.subList(1, data.size())) {
			 if(row[1].equalsIgnoreCase("Engineering")) {
				 eng++;
			 }
			 if(row[1].equalsIgnoreCase("Marketing")) {
				 mkt++;
			 }
			 
			 if(map.containsKey(row[1])) {
				 map.put(row[1], map.get(row[1])+Integer.parseInt(row[2]));
			 }
			 else {
				 map.put(row[1], Integer.parseInt(row[2])); 
			 }
	        }
//		 System.out.println(map);
//		 System.out.println("Average salary of Engineering : "+map.get("Engineering")/eng);
//		 System.out.println("Average salary of Marketing : "+map.get("Marketing")/mkt);
		 
		 //creating result file
		 File resultFile = new File("C:\\Users\\user\\Desktop\\result.txt");
		 if(resultFile.createNewFile()) {
			 System.out.println("Result file created.");
		 }
		 else {
			 System.out.println("Error in result file creation");
		 }
		 
		 //writing to result file
		 FileWriter writer = new FileWriter(resultFile);
		 writer.write("Average salary of Engineering : "+map.get("Engineering")/eng+"\n");
		 writer.write("Average salary of Marketing : "+map.get("Marketing")/mkt);
		 writer.close();

	}
		
}
