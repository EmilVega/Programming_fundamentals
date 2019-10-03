/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package anagram;

public class Main {
	public static void main(String [] args) {
		try{
			// Using the natural ordering
			System.out.println("Natural Ordering");
			Anagram an1 = new Anagram();
			//The words inputted as program arguments are added.
			//Only white spaces are used as separators
			for(String arg : args) {
				an1.newWord(arg);
			}
			//The information is printed on the standard output
			an1.print();
			//The information is written to the file "anagrams.txt"
			an1.writeToFile("anagrams.txt");
			// Using the alternative ordering
			System.out.println();
			System.out.println("Alternative Ordering");
			//The Anagram uses the alternative ordering. The words
			//are read from the file "words.txt"
			Anagram an2 = new Anagram(new SatWord(),"words.txt");
			an2.print();
		}catch(java.io.FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
