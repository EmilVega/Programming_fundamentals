/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prSimpleCollectionWordCounter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
//import java.util.StringTokenizer;
import java.io.*;
public class WordCounter {
	/**
	 * Each object has a dynamic array of WordInText objects
	 */
	private SortedSet<WordInText> words;
	
	public WordCounter() {
		words = new TreeSet<WordInText>();
	}
		
	/**
	 * A word is added to the counter.
	 * If it was already added then its number of occurrences is incremented
	 * @param w The word to add
	 */
	protected void add(String w) {
		try{
			WordInText myW = find(w);
			myW.increment();
		}catch (NoSuchElementException e){
			words.add(new WordInText(w));
		}
	}
	
	
	private void addAll(String line, String del) {
		Scanner stk = new Scanner(line);
		stk.useDelimiter(del);
		while (stk.hasNext()) {
			String word = stk.next();
			add(word);
		}
		stk.close();
	}
	
	/**
	 * All words in the strings stored in the array text are added. 
	 * @param text	Array of String objects
	 * @param del	Delimiters
	 */
	public void addAll(String [] text, String del) {
		for (String line : text) {
			addAll(line, del);
		}
	}
	
	private void readFile(Scanner sc, String del) throws FileNotFoundException {
		while (sc.hasNext()){
			String line=sc.nextLine();
			addAll(line, del);			
		}
	}
	
	/**
	 * Each word in the file whose name is fileName are added.
	 * @param fileName	Name of the file
	 * @param del	Delimiters
	 */
	public void addAllFile(String fileName, String del) throws IOException {
		Scanner sc=new Scanner(new File (fileName));
		readFile(sc,del);
		sc.close();
	}
	
	/**
	 * It finds in the array the WordInText object corresponding to the given string.
	 * If the word does not exist an exception is thrown.
	 * @param w   The string
	 * @return 	  WordInText object corresponding to w
	 */
	public WordInText find(String w) {
		boolean found= false;
		Iterator<WordInText> iter = words.iterator();
		WordInText myW = new WordInText(w);
		WordInText resul=null;
		while (iter.hasNext() && !found){
			resul = iter.next();
			found= resul.equals(myW); 
		}
		if (!found){
			throw new NoSuchElementException("The word does not exist");
		}
		return resul;
	}

	public String toString(){
		StringBuilder sb=new StringBuilder("[");
		Iterator<WordInText> iter = words.iterator();
		while (iter.hasNext()){
			sb.append(iter.next());
			if(iter.hasNext()){
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public void printWords(String outputFile) throws IOException{
		PrintWriter pw=new PrintWriter(outputFile);
		printWords(pw);
		pw.close();
	}
	
	public void printWords(PrintWriter pw){		
		for (WordInText w: words){
			pw.println(w);
		}		
	}
	
	
}
