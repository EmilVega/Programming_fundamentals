/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prSimpleCollectionWordCounter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;

import prSimpleCollectionWordCounter.MeanWordCounter;
import prSimpleCollectionWordCounter.WordCounter;


public class Main {
	public static void main(String [] args) {
		String [] data = {	
			"Guerra tenía una jarra y Parra tenía una perra, ",
			"pero la perra de Parra rompió la jarra de Guerra.",
			"Guerra pegó con la porra a la perra de Parra. ",
			"¡Oiga usted buen hombre de Parra! ",
			"Por qué ha pegado con la porra a la perra de Parra.",
			"Porque si la perra de Parra no hubiera roto la jarra de Guerra,",
			"Guerra no hubiera pegado con la porra a la perra de Parra."};
		
		// Remove the comment to use a StringTokenizer instead of a Scanner object
		String delimiters = "[ .,:;\\-\\!\\¡\\¿\\?]+";    // With Scanner
		// String delimiters = " .,:;-!¡¿?";              // With StringTokenizer 
		
		System.out.println("A word counter is created");
		WordCounter counter = new WordCounter();
		// Each word in data is included
		counter.addAll(data, delimiters);
		System.out.println(counter + "\n");
		
		try {
			System.out.println(counter.find("parra"));
			System.out.println(counter.find("Gorra"));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage()+"\n");
		}
		
		//The steps are repeated. This time a file is used........................
		System.out.println("The program runs again. The data are in a file this time");
		counter = new WordCounter();
		// Each word in data.txt is included	
		try{
			counter.addAllFile("data.txt", delimiters);
			System.out.println(counter + "\n");
			
		    //Data are printed on screen
			System.out.println("Screen output: ");
			PrintWriter pw = new PrintWriter(System.out, true);
			counter.printWords(pw);
			
			//Data are written to a file
			System.out.println("\nOutput file: output.txt\n");
			counter.printWords("output.txt");
			                                          
		}catch (IOException e){
			System.out.println("ERROR:"+ e.getMessage());
		}
		
		
		// A meaningful word counter is created .....................................
		
		String [] meaningless = {"A", "Con", "De", "La", "NO", "SI", "una", "y"};
		Collection<String> wordsNS = new HashSet<String>();
		for (String p : meaningless){ wordsNS.add(p); }
		
		System.out.println("A meaningful word counter is created: ");
		MeanWordCounter meanCounter = new MeanWordCounter(wordsNS);
		meanCounter.addAll(data, delimiters);
		System.out.println(meanCounter + "\n");
		
		//The program runs again using files ................
		System.out.println("We create another meaningful word counter using data in a file");
				
		// Each word in data.txt are added. The meaningless words are in fileNotMean.txt	
		try{
			meanCounter = new MeanWordCounter("fileNotMean.txt", delimiters);
			meanCounter.addAllFile("data.txt", delimiters);
			System.out.println(meanCounter + "\n");
					
			
			System.out.println("Screen output:");
			PrintWriter pw = new PrintWriter(System.out, true);
			meanCounter.printWords(pw);
					
			
			System.out.println("\nOutput file: outputMean.txt");
			meanCounter.printWords("outputMean.txt");
					                                          
		}catch (IOException e){
			System.out.println("ERROR:"+ e.getMessage());
		}
		
		
	}
}
