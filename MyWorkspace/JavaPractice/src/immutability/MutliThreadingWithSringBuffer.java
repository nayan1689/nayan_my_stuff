package immutability;

public class MutliThreadingWithSringBuffer {
	
	public static void main (String aa[]) {
		
		StringBuffer a = new StringBuffer(5);
		Thread t1 = new Thread(new task1(a)); t1.start();
		Thread t2 = new Thread(new task1(a)); t2.start();
		Thread t3 = new Thread(new task1(a)); t3.start();
		Thread t4 = new Thread(new task1(a)); t4.start();
		Thread t5 = new Thread(new task1(a)); t5.start();
		Thread t6 = new Thread(new task1(a)); t6.start();
		Thread t7 = new Thread(new task1(a)); t7.start();
		Thread t8 = new Thread(new task1(a)); t8.start();
		Thread t9 = new Thread(new task1(a)); t9.start();
		Thread t10 = new Thread(new task1(a)); t10.start();
		Thread t11 = new Thread(new task1(a)); t11.start();
		Thread t12 = new Thread(new task1(a)); t12.start();
	}
	
	
}

 class task1 implements Runnable {
	 StringBuffer a;
	 public task1(StringBuffer a) {
		 this.a = a;
	 }
	 public void run () {
		 synchronized (a) {
			 StringBuffer b = a.append(5);
			 System.out.println("value after adding " + b.toString());
		}
	 }
 }

