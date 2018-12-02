package multithreads2;

public class Manin2 {

	public static void main(String[] args) throws InterruptedException {
		threadcounter thc = new threadcounter();
		Thread new1 = new Thread(new secondvarthread(thc));
		Thread new2 = new Thread(new secondvarthread(thc));
		Thread new3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(
						"ok, here is " + Thread.currentThread().getName() + " " + "thread, i'll do something here..");
			}

		});
		/// -------------
		new1.start();
		new2.start();
		new3.start();
		new1.join();
		new2.join();
		new3.join();
		//// ----------------

		System.out.println("---------");
		System.out.println("counter is: " + threadcounter.getCount());
		// System.out.println("counter is: " + thc.getCount());

	}

}
