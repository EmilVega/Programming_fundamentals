/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


package kwic;

public class TitleKWIC implements Comparable <TitleKWIC> {
	
	protected String sentence;
	
	public TitleKWIC (String sentence){
		this.sentence = sentence;
	}
	
	public boolean equals (Object o){
		return (o instanceof TitleKWIC) && (((TitleKWIC)o).sentence.equalsIgnoreCase(sentence));
	}
	
	public int hashCode(){
		return sentence.hashCode();
	}
	
	public int compareTo(TitleKWIC t){
		return sentence.compareToIgnoreCase(t.sentence);
	}
	
	public String toString(){
		return sentence;
	}
	

}
