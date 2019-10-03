/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prSimpleCollectionWordCounter;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class MeanWordCounter extends WordCounter {
	private Collection <String> meaningless; 
	
	
	public MeanWordCounter(Collection <String> wordsNM){
		super();
		Iterator <String>itr = wordsNM.iterator();
		meaningless= new TreeSet<String>();
		while(itr.hasNext()){
			meaningless.add(((String)itr.next()).toUpperCase());
		}
	}
	
	public MeanWordCounter(String fileNotMean, String sep){
		super();
		meaningless= new TreeSet<String>();
		this.readNotMeanWords(fileNotMean, sep);
	}

	
	private void readNotMeanWords(String fileNotMean, String sep){
		try{
			File fileNM = new File("/home/sjronqui/workspace/prSimpleFileWordCounter/src/"+fileNotMean);
			Scanner sc = new Scanner(fileNM);
			while(sc.hasNextLine()){
				Scanner scLine = new Scanner(sc.nextLine());
				scLine.useDelimiter(sep);
				this.readNotMeanWords(scLine, sep);
				scLine.close();
			}
			sc.close();
		}catch(Exception e){}
	}
	
	private void readNotMeanWords(Scanner sc, String sep){
		while(sc.hasNext()){
			meaningless.add(sc.next().toUpperCase());
		}
	}
	
	protected void add(String w){
		if(!isMeaningless(w)){
			super.add(w);
		}
	}
	
	protected boolean isMeaningless(String w){
		Iterator <String> itr = meaningless.iterator();
		while(itr.hasNext()){
			if(itr.next().equals(w.toUpperCase())){
				return true;
			}
		}
		return false;
	}
	
}
