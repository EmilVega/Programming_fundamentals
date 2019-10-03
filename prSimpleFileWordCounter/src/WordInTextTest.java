/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

public class WordInTextTest {
	
	public static void main (String[] args){
		WordInText word1=new WordInText("cap");
		WordInText word2=new WordInText("cap");
		word1.increment();
		System.out.println(word1+"\n"+word2);
		if(word1.equals(word2)){
			System.out.println("The words are equal");
		}
	}

}
