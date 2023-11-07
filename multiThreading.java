package Sample;
import java.util.*;

class multiThread implements Runnable{
	private int threadNumber;
	public multiThread(int threadNumber){
		this.threadNumber=threadNumber;
	}
	public void run() {
		for (int i=0;i<=10;i=i+2) {
			System.out.println(i + " from "+"thread"+threadNumber);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
	            System.out.println("InterruptedException occured @ thread1"); 
			}
		}
	}
}
class multiThread2 implements Runnable{
	private int th;
	public multiThread2(int th){
		this.th=th;
	}
	public void run() {
		for (int i=1;i<=10;i=i+2) {
			System.out.println(i+" from "+"thread"+th);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
	            System.out.println("InterruptedException occured @ thread2"); 
			}
		}
	}
}

public class multiThreading {
	public static void main(String args[]) {
		multiThread obj = new multiThread(1);
		multiThread2 obj2 = new multiThread2(2);
		Thread thread = new Thread(obj);
		Thread thread2 = new Thread(obj2);
		thread.start();
		thread.interrupt();
		thread2.interrupt();
		try {
			thread.join();
		}
		catch(Exception e) {
		}
		thread2.start();


	}

}
