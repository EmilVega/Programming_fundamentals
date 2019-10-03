/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) {
		String [] data = {
				"Guerra tenía una jarra y Parra tenía una perra, ",
				"pero la perra de Parra rompió la jarra de Guerra.",
				"Guerra pegó con la porra a la perra de Parra. ",
				"¡Oiga usted buen hombre de Parra! ",
				"Por qué ha pegado con la porra a la perra de Parra.",
				"Porque si la perra de Parra no hubiera roto la jarra de Guerra,",
		"Guerra no hubiera pegado con la porra a la perra de Parra."};
		//Remove the comment to use a StringTokenizer instead of a Scanner object
		String delimiters = "[ .,:;\\-\\!\\¡\\¿\\?]+";
		// With Scanner
		// String delimiters = " .,:;-!¡¿?";
		// With StringTokenizer
		String [] notMean = {"CON", "LA", "A", "DE", "NO", "SI", "Y", "UNA"};
		WordCounter counter = null, counterMean = null;
		// If no numeric parameter is given, the counters are also created
		try {
			int n = Integer.parseInt(args[0]);
			System.out.println("Argument: " + n);
			counter = new WordCounter(n);
			counterMean = new MeanWordCounter(n, notMean);
		} catch (RuntimeException e) {
			System.out.println("By default...");
			counter = new WordCounter();
			counterMean = new MeanWordCounter(notMean);
		}
		// Each word in data is included
		counter.addAll(data, delimiters);
		counterMean.addAll(data, delimiters);
		System.out.println(counter + "\n");
		System.out.println(counterMean + "\n");
		try {
			System.out.println(counter.find("parra"));
			System.out.println(counter.find("Gorra"));
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}
		//The program runs again using I/O operations
		System.out.println("This time the program works with files");
		WordCounter counterMeanFich=null;
		//If no parameter a default configuration is used
		try {
			int n = Integer.parseInt(args[0]);
			System.out.println("Argument : " + n);
			counter = new WordCounter(n);
			counterMeanFich= new MeanWordCounter(n,"fileNotMean.txt",delimiters);
		} catch (RuntimeException e) {
			System.out.println("By default...");
			counter = new WordCounter();
			try {
				counterMeanFich= new MeanWordCounter("fileNotMean.txt",delimiters);
			} catch (IOException e1) {
				//
				System.out.println("ERROR:"+ e1.getMessage());
			}
		} catch (IOException e){
			System.out.println("ERROR:"+ e.getMessage());
		}
		// Each word in the file is included
		try{
			counter.addAllFile("data.txt",delimiters);
			counterMeanFich.addAllFile("data.txt", delimiters);
			System.out.println(counter + "\n");
			System.out.println(counterMeanFich + "\n");
			//methods to print on screen
			PrintWriter pw=new PrintWriter(System.out, true);
			counter.printWords(pw);
			//output sent to a file
			counter.printWords("output.txt");
			System.out.println();
			//methods to print on screen in the case of meaningless words
			counterMeanFich.printWords(pw);
			//output sent to a file
			counterMeanFich.printWords("outputNotMean.txt");
		}catch (IOException e){
			System.out.println("ERROR:"+ e.getMessage());
		}

	}

}
