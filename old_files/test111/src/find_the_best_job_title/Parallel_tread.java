package find_the_best_job_title;

public class Parallel_tread extends Thread {

	public void run() {
		System.out.println("tread " + Thread.currentThread().getId() + " started");
		for (int i = 0; i < 10; i++) {
			System.out.println("second tread works...");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
