/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package anagram;

import java.util.*;

public class SatWord implements Comparator<Word>{
	
	public int compare(Word w1,Word w2) {
		int res = new Integer(w1.getString().length()).compareTo(new Integer(w2.getString().length()));
		if (res==0) {
			res = w1.getString().compareToIgnoreCase(w2.getString());
		}
		return res;
	}

}
