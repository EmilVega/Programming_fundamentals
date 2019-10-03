/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


package kwic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class KWIC {
	protected SortedMap<String, SortedSet<TitleKWIC>> index;
	protected List<String> meaningless;
	
	public KWIC(){
		index = new TreeMap<String, SortedSet<TitleKWIC>>();
		meaningless = new ArrayList<String>();
	}
	
	public void meaninglessWords(String fileName) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(fileName));
		meaninglessWords(sc);
		sc.close();
	}
	
	private void meaninglessWords(Scanner sc){
		while (sc.hasNext()){
			Scanner line = new Scanner(sc.nextLine());
			while(line.hasNext()){
				meaningless.add(line.next());
			}
			line.close();
		}
	}
	
	public void createIndex(String fileName) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(fileName));
		createIndex(sc);
		sc.close();
	}
	
	public void createIndex(Scanner sc){
		while (sc.hasNextLine()){
			add(sc.nextLine());
		}
		
	}
	
	protected void add(String film){
		Scanner sc = new Scanner(film);
		while (sc.hasNext()){
			String word=sc.next();
			if (!meaningless.contains(word.toLowerCase())){
				if(!index.containsKey(word.toUpperCase())){
					SortedSet<TitleKWIC> tFilm = new TreeSet<TitleKWIC>();
					index.put(word.toUpperCase(), tFilm);
				}else{
					(index.get(word.toUpperCase())).add(new TitleKWIC(film));
				}
			}			
		}
		sc.close();
	}
	
	public void printIndex(String fileName) throws FileNotFoundException{
		PrintWriter pw=new PrintWriter(fileName);
		printIndex(pw);
		pw.close();
	}
	
	public void printIndex(PrintWriter pw){
		for (String key : index.keySet()) {
			pw.println(key);
			for (TitleKWIC title : index.get(key)) {
				pw.println("\t"+title.sentence);
			}
		}	
	}
}
