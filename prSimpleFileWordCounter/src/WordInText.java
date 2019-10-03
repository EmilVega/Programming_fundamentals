/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

public class WordInText {
	
	private String word;
	private int occurrence;
	
	public WordInText (String word){
		this.word=word.toUpperCase();
		occurrence = 1;
	}
	
	public void increment (){
		occurrence++;
	}
	
	public boolean equals (Object o){
		return (o instanceof WordInText) && (((WordInText)o).word.equals(word));
	}
	
	public int hashCode (){
		return word.hashCode();
	}
	
	public String toString (){
		return word+": "+occurrence;
	}

}
