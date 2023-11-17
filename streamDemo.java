package Sample;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Stdnt{
	private String name;
	private int age;
	
	public Stdnt(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return "Name : "+name+" Age : "+age; 
	}
}

public class streamDemo {
	public static void main(String []args) throws Exception {
		Stdnt s1 = new Stdnt("Anshad",22);
		Stdnt s2 = new Stdnt("Karthik",23);
		Stdnt s3 = new Stdnt("Aadith",24);
		Stdnt s4 = new Stdnt("Sreenu",21);
		Stdnt s5 = new Stdnt("Nagsai",25);
		
		ArrayList<Stdnt> students = new ArrayList<Stdnt>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
		long count = students.stream().filter(Student -> Student.getAge()>22).count();
		System.out.println(count);
		List result=students.stream().filter(Student -> Student.getAge()>22).collect(Collectors.toList());
		System.out.println(result);
		students.stream().filter(s->s.getAge()>22).map(s->s.getName()).forEach(s->System.out.print(s+" "));
		System.out.println();
		students.stream().filter(s->s.getName().startsWith("A")).map(s->s.getName()).forEach(s->System.out.print(s+" "));
		System.out.println();
		List sortedNames = (List) students.stream().map(s->s.getName()).sorted().collect(Collectors.toList());		
		System.out.println(sortedNames);
	}
}
