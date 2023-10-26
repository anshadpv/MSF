package Sample;
import java.util.*;
import java.util.Scanner;
import java.util.LinkedList;

class Book {
	private String title;
	private String author;
	
	public Book(String title, String author) {
		this.title=title;
		this.author=author;

	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String toString() {
		return "Title: "+title+" Author: "+author;
	}
}

class Library {
	private List<Book> books;
	private List<Book> borrowed;
	
	public Library() {
		books = new LinkedList<>();
		borrowed = new LinkedList<>();
	}
	
	public void addBook(Book b) {
		books.add(b);
	}
	
	public void borrowBook(String t) {
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(t)) {
				borrowed.add(book);
				books.remove(book);
				System.out.println("Borrowed Successfully.");
				return;
			}
		}
		System.out.println("Book not found.");
	}
	
	public void returnBook(String b) {
		for (Book book : borrowed) {
			if(book.getTitle().equalsIgnoreCase(b)) {
				books.add(book);
				borrowed.remove(book);
				System.out.println("Book returned successfully.");
				return;
			}
		}
		System.out.println("This book is not borrowed.");
	}
	
	public void listBooks() {
		for (Book b : books) {
			System.out.println(b);
		}
	}
	
}
public class LibraryManagement {
	public static void main(String []args) {
		Library library = new Library();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Library Management System");
			System.out.println("1. Add Book");
			System.out.println("2. Borrow Book");
			System.out.println("3. Return Book");
			System.out.println("4. List Books");
			System.out.println("5. Exit");
			System.out.println("Enter your choice : ");
			
			int  choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 :
				System.out.println("Enter the book name : ");
				String title = sc.nextLine();
				System.out.println("Enter author name :  ");
				String author = sc.nextLine();
				Book newBook = new Book(title, author);
				library.addBook(newBook);
				System.out.println("Book added successfully.");
				break;
				
			case 2 :
				System.out.println("Enter title of book : ");
				String t = sc.nextLine();
				library.borrowBook(t);
				break;
				
			case 3 :
				System.out.println("Enter the borrowed book title : ");
				String bt = sc.nextLine();
				library.returnBook(bt);
				break;
				
			case 4 :
				library.listBooks();
				break;
				
			case 5 :
				System.out.println("Exiting Program.");
				System.exit(0);
				break;
				
			default :
				System.out.println("Invalid Choice.");
				break;
			}
		}
	}

}
