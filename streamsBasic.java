package Sample;
import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;

public class streamsBasic {
	public static void main(String []args) throws Exception {
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(4,5,2,8,9,6,10,34,67,22));
		numbers.stream().filter(n -> n%2==0).forEach(n->System.out.print(n+" "));
		System.out.println();
		numbers.stream().filter(n -> n%2!=0).forEach(n->System.out.print(n+" "));
		System.out.println();
		long even = numbers.stream().filter(n->n%2==0).count();
		System.out.println("Number of even numbers : "+even);
		long odd = numbers.stream().filter(n->n%2!=0).count();
		System.out.println("Number of odd numbers : "+odd);
		List oneDigit = (List) numbers.stream().filter(n->n<10).collect(Collectors.toList());
		List twoDigit = (List) numbers.stream().filter(n->n>=10).collect(Collectors.toList());
		System.out.println("List of one digit numbers : "+oneDigit);
		System.out.println("List of two digit numbers : "+twoDigit);
		List sort = (List) numbers.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted List : "+sort);
		long sum = numbers.stream().mapToLong(Integer::intValue).sum();
		System.out.println("Sum : "+sum);
		int max = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Max element : "+max);
		int min = numbers.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Min element : "+min);
	}

}
