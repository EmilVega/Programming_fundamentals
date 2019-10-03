/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */
package anagram;

import java.util.*;
import java.io.*;

public class Anagram {

	private Map<Word,Set<Word>> anagrams;

	public Anagram() {
		anagrams= new TreeMap<Word, Set<Word>>();
	}
	
	public Anagram(Comparator<Word> sat) {
		anagrams= new TreeMap<Word, Set<Word>>(sat);
	}

	public Anagram(String fileName) throws FileNotFoundException {
		this();
		readWordsFile(fileName);
	}
	
	public Anagram(Comparator<Word> sat, String fileName) throws FileNotFoundException {
		this(sat);
		readWordsFile(fileName);
	}

	private void readWordsFile(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName));
		sc.useDelimiter("[, ]+");
		while (sc.hasNext()){
			String word= sc.next();
			newWord(word);
		}
		sc.close();
	}

	public void newWord(String word) {
		Word w = new Word(word);
		boolean thereIs=false;
		Iterator<Word> iter = anagrams.keySet().iterator();
		while (iter.hasNext()) {
			if(iter.next().equals(w) && !thereIs) {
				thereIs=true;
			}
		}
		if (thereIs==false) {
			Set<Word> values = new TreeSet<Word>();
			for (Word wkey: anagrams.keySet()) {
				if (wkey.isAnagram(w)) {
					anagrams.get(wkey).add(w);
					values.add(wkey);
				}
			}
			anagrams.put(w, values);
		}
	}

	public void print() {
		for(Map.Entry<Word,Set<Word>> entry : anagrams.entrySet()) {
			StringBuilder sb = new StringBuilder();
			for(Word ws : entry.getValue()){
				sb.append(ws+" ");
			}
			System.out.println(entry.getKey()+"\t( "+sb.toString()+")");
			sb=null;
		}
	}

	public void writeToFile(String fileName) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		printAnagram(pw);
		pw.close();
	}

	private void printAnagram(PrintWriter pw) {
		for (Map.Entry<Word,Set<Word>> entry : anagrams.entrySet()) {
			pw.print(entry.getKey() + ":\t (");
			pw.print(entry.getValue());
			pw.println(")");
		}
	}

	public boolean containsAnagram(String word) {
		Word w = new Word(word);
		boolean thereIs=false;
		Iterator<Word> iter = anagrams.keySet().iterator();
		while (iter.hasNext() && !thereIs) {
			if(iter.next().isAnagram(w)) {
				thereIs=true;
			}
		}
		return thereIs;
	}

}
