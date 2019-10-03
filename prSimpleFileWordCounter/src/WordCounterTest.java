/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


public class WordCounterTest {

	public static void main(String[] args) {
		WordCounter wordCnt = new WordCounter(5);
		String [] data = {
				"This is the first sentence in the example",
				"and this is the second one"};
		wordCnt.addAll(data, "[ ]");
		System.out.println(wordCnt);

	}

}
