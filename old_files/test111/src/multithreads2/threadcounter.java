package multithreads2;

public class threadcounter {
	private static int count = 0;
	// private int count = 0;

	public static int getCount() {
		// public int getCount() {
		return count;
	}

	public synchronized void incoint() {
		// TODO Auto-generated method stub
		count++;
	}
}
