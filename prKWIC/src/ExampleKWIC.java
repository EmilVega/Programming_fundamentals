

import java.io.*;
import kwic.KWIC;
import kwic.KWICReplacement;
public class ExampleKWIC {
	public static void main(String[] args) {
		try {
			KWIC k = new KWIC();
			k.meaninglessWords("meaningless.txt");
			k.createIndex("sentences.txt");System.out.println("Basic index, without replacing words by ...");
			System.out.println("----------------------------------------------");
			PrintWriter pw = new PrintWriter(System.out, true);
			k.printIndex(pw);
			k.printIndex("output.txt");
			KWICReplacement krep = new KWICReplacement();
			krep.meaninglessWords("meaningless.txt");
			krep.createIndex("sentences.txt");
			System.out.println("\n\nExtended index, with the word replacement");
			System.out.println("----------------------------------------------");
			krep.printIndex(pw);
			krep.printIndex("output-replac.txt");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}