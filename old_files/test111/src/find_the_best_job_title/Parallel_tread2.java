package find_the_best_job_title;

public class Parallel_tread2 extends Thread {

	public void run() {
		System.out.println("tread " + Thread.currentThread().getId() + " started");
		String filename = "filename18.txt";
		Getterdata getterdata = new Getterdata(filename);
		getterdata.getStringfromFile(); // read file
		getterdata.calculate_best_title(); // group by count
		getterdata.writedowntheresults(); // write back to file
	}

}
