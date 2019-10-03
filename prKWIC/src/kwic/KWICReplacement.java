/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package kwic;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class KWICReplacement extends KWIC {

	public KWICReplacement() {
		super();
	}

	protected void add(String title) {
		//TitleKWICReplacement film = new TitleKWICReplacement(title);
		Scanner sc = new Scanner(title);
		while (sc.hasNext()) {
			String word =sc.next();
			if (!meaningless.contains(word.toLowerCase())) {
				SortedSet<TitleKWIC> tfilm = new TreeSet<TitleKWIC>();
				//TitleKWICReplacement tf = new TitleKWICReplacement(film.sentence);
				if (!index.containsKey(word.toUpperCase())) {
					//tfilm.add(new TitleKWIC(tf.replace(word)));
					index.put(word.toUpperCase(), tfilm);
				} // else {
			//index.get(word.toUpperCase()).add(new TitleKWIC(tf.replace(word)));
				//}
			}
			index.get(word.toUpperCase()).add(new TitleKWICReplacement(title));
		}
		sc.close();
	}
	
	public void printIndex(PrintWriter pw){
		for (String key : index.keySet()) {
			pw.println(key);
			for (TitleKWIC title : index.get(key)) {
				pw.println("\t"+ ((TitleKWICReplacement)title).replace(key));
			}
		}
	}
	

}
