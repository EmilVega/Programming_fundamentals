/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


package kwic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class KWICTest {
	
	public static void main(String[] args) throws FileNotFoundException{
		KWIC kw = new KWIC();
		kw.meaninglessWords("meaningless.txt");
		kw.createIndex("sentences.txt");
		kw.printIndex("output.txt");
		PrintWriter pw = new PrintWriter(System.out, true);
		kw.printIndex(pw);
	}
	
	

}
