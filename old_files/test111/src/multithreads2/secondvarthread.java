package multithreads2;

public class secondvarthread implements Runnable {

	threadcounter local_counter = new threadcounter();

	secondvarthread(threadcounter arg1) {
		this.local_counter = arg1;
	}

	@Override
	public void run() {
		System.out.println("other way with Runnable");
		System.out.println("tread " + Thread.currentThread().getId() + " started");
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getId() + " tread works...");
			inccount1();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void inccount1() {
		local_counter.incoint();
	}

}
