/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prSimpleCollectionWordCounter;

public class WordInText implements Comparable<WordInText>{
	/**
	 * Stores a word in upper case and its number of occurrences
	 */
	private String word;
	private int occurrences;
	
	public WordInText(String p) {
		word = p.toUpperCase();
		occurrences = 1;
	}
	
	public void increment() {
		occurrences++;
	}
	
	/**
	 * It only takes into account the word ignoring the letter case
	 */
	public boolean equals(Object o) {
		return o instanceof WordInText &&
			 ((WordInText)o).word.equalsIgnoreCase(word);
	}
	
	public int hashCode() {
		return word.toUpperCase().hashCode();
	}
	
	public String toString() {
		return word + ": "+ occurrences;
	}
	
	public int compareTo(WordInText w){
		int result = word.compareToIgnoreCase(w.word);
		if(result==0){
			result=(new Integer(occurrences)).compareTo(new Integer(w.occurrences));
		}
		return result;
	}

}
