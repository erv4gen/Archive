package find_the_best_job_title;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Getterdata {

	Getterdata(String filename) {

		f = new File(filename);
		name = filename;

	}

	private ArrayList<String> items = new ArrayList<String>();
	File f;
	private String name = new String();
	Map<String, Long> result;
	Map<String, Long> finalMap = new LinkedHashMap<>();

	public void getStringfromFile() {
		try {

			/* read data from file */
			BufferedReader br;

			if (!f.exists()) {
				System.out.println("net"); // file do not exist

			} else {
				System.out.println("yes, file excist, reading...");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				br = new BufferedReader(new FileReader(getName()));
				String str;
				while ((str = br.readLine()) != null) {
					this.items.add(str); // get string from file
				}
				br.close();
				System.out.println("well done! first line is: " + items.get(0));
				System.out.println("last line is: " + items.get(items.size() - 1));
				System.out.println("--------");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void calculate_best_title() {
		System.out.println("caclulating best title...");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		// Sort a map and add to finalMap
		result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println("here we are, well done. gonna write it to the file...");

	}

	public void writedowntheresults() {
		File f = new File("filename18_res.txt");
		PrintWriter pw = null;
		try {
			f.createNewFile();
			pw = new PrintWriter(f);
			Iterator<Entry<String, Long>> itr = finalMap.entrySet().iterator();
			while (itr.hasNext()) {
				pw.println(itr.next());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pw.close();
			System.out.println("good, file has comlpeted, check it");
		}

	}

}
