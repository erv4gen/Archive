// new git
package find_the_best_job_title;

import java.util.concurrent.TimeUnit;

public class main {

	public static void main(String[] args) {

		Parallel_tread pt = new Parallel_tread();
		Parallel_tread2 pt2 = new Parallel_tread2();
		pt2.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pt.start();
	}

}
