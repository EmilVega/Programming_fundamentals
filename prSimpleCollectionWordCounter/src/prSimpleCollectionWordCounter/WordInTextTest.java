/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prSimpleCollectionWordCounter;

public class WordInTextTest {

	public static void main(String[] args) {
		WordInText w1 = new WordInText("jirafa");
		WordInText w2 = new WordInText ("gato");
		w1.increment();
		w1.increment();
		w1.increment();
		w2.increment();
		w2.increment();
		WordInText w3 = new WordInText("cap");
		WordInText w4 = new WordInText("CAP");
		w3.increment();
		w3.increment();
		w3.increment();
		w4.increment();
		w4.increment();
		System.out.println("Word 1 = " + w1);
		System.out.println("Word 2 = " + w2);
		System.out.println("Word 3 = " + w3);
		System.out.println("Word 4 = " + w4);
		int res = w1.compareTo(w2);
		int res2 = w3.compareTo(w4);
		if (res==0)
			System.out.println("The words 1 and 2 are equal");
		if (res<0)
			System.out.println("The word 1 is greatest");
		else
			System.out.println("The word 2 is greatest");
		if (res2==0)
			System.out.println("The words 3 and 4 are equal");
		if (res2<0)
			System.out.println("The word 3 is greatest");
		else
			System.out.println("The word 4 is greatest");
	}

}
