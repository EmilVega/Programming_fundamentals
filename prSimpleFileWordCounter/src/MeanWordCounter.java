/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MeanWordCounter extends WordCounter {
	
	private String [] meaningless;
	private static final int SIZE =20;
	private int numWords;
	
	public MeanWordCounter(int n, String[] wordsNM){
		super(n);
		numWords=wordsNM.length;
		meaningless = new String[numWords];
		for(int i=0;i<wordsNM.length;i++){
			meaningless[i]=wordsNM[i].toUpperCase();
		}
		
	}
	
	public MeanWordCounter(String[] wordsNM){
		super();
		numWords=wordsNM.length;
		meaningless = new String[numWords];
		for(int i=0;i<wordsNM.length;i++){
			meaningless[i]=wordsNM[i].toUpperCase();
		}
	}
	
	public MeanWordCounter(String filNotMean, String sep) throws FileNotFoundException{
		super();
		numWords=0;
		meaningless = new String[SIZE];
		readFileNotMean(filNotMean, sep);
	}
	
	public MeanWordCounter(int n, String filNotMean, String sep) throws FileNotFoundException{
		super(n);
		numWords=0;
		meaningless = new String[SIZE];
		readFileNotMean(filNotMean, sep);
	}
	
	private void readFileNotMean(String filNotMean, String sep) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(filNotMean));
		readNotMeanWords(sc,sep);
		sc.close();
	}
	
	private void readNotMeanWords(Scanner sc, String sep){
		while (sc.hasNextLine()){
			String line= sc.nextLine();
			Scanner lsc = new Scanner(line);
			lsc.useDelimiter(sep);
			while (lsc.hasNext()){
				String w = lsc.next();
				addNotMeanWordsToArray(w);
			}
			lsc.close();
		}
	}
	
	private void addNotMeanWordsToArray(String wNM){
		if(meaningless.length==numWords){
			String [] newArray= new String[numWords*2];
			System.arraycopy(meaningless,0, newArray, 0, meaningless.length);
			meaningless=newArray;
		}
		meaningless[numWords]= wNM;
		numWords++;
	}
	
	protected void add(String w){
		boolean found = false;
		int i=0;
		while(!found && i<numWords){
			if (meaningless[i].equals(w.toUpperCase())){
				found=true;
			}
			i++;
		}
		if(!found){
			super.add(w);
		}
	}

}
