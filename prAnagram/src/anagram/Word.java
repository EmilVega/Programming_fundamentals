/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package anagram;

import java.util.Arrays;



public class Word implements Comparable<Word>{
	private String theWord;
	private String signature;
	
	public Word (String w){
		w = w.toLowerCase();
		theWord=w;
		char[] w2= w.toCharArray();
		Arrays.sort(w2);
		signature = new String (w2);
	}
	
	public String getString (){
		return theWord;
	}
	
	public String getSignature(){
		return signature;
	}
	
	public boolean isAnagram(Word w){
		return signature.equals(w.signature);
	}
	
	public boolean equals(Object o){
		return (o instanceof Word) && (((Word)o).theWord.equals(theWord));
	}
	
	public int hashCode(){
		return theWord.hashCode();
	}
	
	public String toString(){
		return theWord;
	}
	
	public int compareTo(Word w){
		return theWord.compareTo(w.theWord);
	}

}
