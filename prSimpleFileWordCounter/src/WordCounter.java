/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordCounter {

	private int numWords;
	private static final int INIT_SIZE=10;
	private WordInText [] words;

	public WordCounter (int size){
		words = new WordInText[size];
		numWords=0;
	}

	public WordCounter (){
		this(INIT_SIZE);
	}

	private int contains(String w){
		boolean found = false;
		int i =0;
		WordInText w2=new WordInText (w);
		while(!found && i<numWords){
			if (words[i].equals(w2)){
				found=true;
			}
			i++;
		}
		return found?(i-1):-1;
	}

	protected void add(String w){
		int pos = contains(w);
		if (pos==-1){
			if(words.length==numWords){
				WordInText [] newArray= new WordInText[words.length*2];
				System.arraycopy(words,0, newArray, 0, words.length);
				words=newArray;
			}
			words[numWords]=new WordInText(w);
			numWords++;

		}else{
			words[pos].increment();
		}
	}

	private void addAll(String line, String del){
		Scanner sc = new Scanner(line);
		sc.useDelimiter(del);
		while (sc.hasNext()){
			String w = sc.next();
			add(w);
		}
		sc.close();
	}

	public void addAll(String [] text, String del){
		for(int i=0;i<text.length;i++){
			addAll(text[i],del);
		}
	}

	public void addAllFile(String filename, String del) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(filename));
		readFile(sc,del);
		sc.close();
	}

	private void  readFile(Scanner sc, String del){
		while (sc.hasNextLine()){
			String line= sc.nextLine();
			addAll(line,del);
		}
	}

	public WordInText find(String w){
		int i = contains(w);
		if (i==-1){
			throw new NoSuchElementException("The word "+w+" is not found in the array");
		}
		return words[i];
	}

	public String toString (){
		StringBuilder sb = new StringBuilder(numWords);
		for (int i=0; i<numWords;i++){
			if (i==numWords-1){
				sb.append(words[i]);
			}else{
				sb.append(words[i]+", ");
			}
		}
		return "["+sb+"]";
	}
	
	public void printWords(String fileName) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(fileName);
		printWords(pw);
		pw.close();
	}
	
	public void printWords(PrintWriter pw){
		for (int i=0;i<numWords;i++){
			pw.println(words[i]);
		}
		
	}
}
