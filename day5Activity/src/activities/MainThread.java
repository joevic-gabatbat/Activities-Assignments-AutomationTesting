package activities;

public class MainThread implements Runnable {

	public static void main(String[] args) throws InterruptedException {

		Thread1 t1 = new Thread1();
		t1.start();
		
		Runnable mt = new MainThread();
		Thread th = new Thread(mt);
		th.sleep(10000);
		th.start();

	}

	@Override
	public void run() {
		System.out.println("Thread #2 is now running after 10 seconds...");
		
	}
}
