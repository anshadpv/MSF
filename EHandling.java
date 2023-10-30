package Sample;
import java.util.*;

class Task {
	private String description;
	private boolean isCompleted;
	
	public Task(String description) {
		this.description=description;
		this.isCompleted=false;
	}
	
	public String getDescription() {
		return description;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void markAsCompleted() {
		isCompleted = true;
	}
	
}

public class EHandling {
	private static ArrayList<Task> tasks = new ArrayList<>();
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		boolean isRunning = true;
		
		while(isRunning) {
			System.out.println("ToDo List Application");
			System.out.println("1. Add Task");
			System.out.println("2. View Tasks");
			System.out.println("3. Mark Task as Completed");
			System.out.println("4. Remove Task");
			System.out.println("5. View Completed Tasks");
			System.out.println("6. View Pending Tasks");
			System.out.println("7. Exit");
			System.out.println("Enter your Choice : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1 : 
				System.out.println("Enter task description :  ");
				String description = sc.nextLine();
				addTask(description);
				break;			

			case 2 :
				viewTasks();
				break;
				
			case 3 :
				System.out.println("Enter the index of the task to mark as completed : ");
				int completeTask = sc.nextInt();
				markTaskAsCompleted(completeTask);
				break;
			case 4 :
				System.out.println("Enter the index of the task to remove : ");
				int removeIndex = sc.nextInt();
				removeTask(removeIndex);
				break;
			case 5 :
				viewCompletedTasks();
				break;
			case 6 :
				viewPendingTasks();
				break;
			case 7 :
				isRunning=false;
				System.out.println("Exiting ToDo List Application.");
				break;
			default :
				System.out.println("Invalid choice.");
				break;
			}
		}
		sc.close();
	}
	
	private static void addTask(String description) {
		Task task = new Task(description);
		tasks.add(task);
		System.out.println("Task added successfully");
	}
	
	private static void viewTasks() {
		System.out.println("Tasks : ");
		for (int i=0;i<tasks.size();i++) {
			Task task = tasks.get(i);
			String status  = task.isCompleted() ? "Completed"  : "Pending";
			System.out.println(i+1+".  "+task.getDescription()+" - "+status);
		}
		
	}
	private static void markTaskAsCompleted(int index) {
		try {
			Task task = tasks.get(index);
			if(!task.isCompleted()) {
				task.markAsCompleted();
				System.out.println("Task marked as Completed.");
			}
			else {
				System.out.println("Task is already Completed.");
			}
		}
		catch (Exception e ) {
			System.out.println("Excepton caught."+e.getMessage());
		}
		
	}
	private static void removeTask(int index) {
		if (index>=0 && index<tasks.size()) {
			tasks.remove(index);
			System.out.println("Task removed successfully.");
		}
		else {
			System.out.println("Invalid Task Index.");
		}
		
	}
	private static void viewCompletedTasks() {
		System.out.println("Completed Tasks :  ");
		for (int i=0;i<tasks.size();i++) {
			Task task = tasks.get(i);
			if(task.isCompleted()) {
				System.out.println(task.getDescription());
			}
		}
	}
	private static void viewPendingTasks() {
		System.out.println("Completed Tasks :  ");
		for (int i=0;i<tasks.size();i++) {
			Task task = tasks.get(i);
			if(!task.isCompleted()) {
				System.out.println(task.getDescription());
			}
		}
	}
	
}