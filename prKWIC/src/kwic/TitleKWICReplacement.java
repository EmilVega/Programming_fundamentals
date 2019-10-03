/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


package kwic;

import java.util.Scanner;

public class TitleKWICReplacement extends TitleKWIC {
	 
	public TitleKWICReplacement (String sentence){
		 super(sentence);
	 }
	 
	 public String replace(String word){
		 
		 StringBuilder sb=new StringBuilder(word);
		 StringBuilder sbAux = new StringBuilder (sentence.toUpperCase());
		 int i = sbAux.indexOf(word.toUpperCase());
		 while (i != -1){
			 sb.replace(i, i+word.length(), "...");
			 sbAux.replace(i, i+word.length(), "...");
			 i = sbAux.indexOf(word.toUpperCase());
		 }
		 return sb.toString();
		 
//		 Scanner sc = new Scanner(super.sentence);
//		 String newSentence="";
//		 while(sc.hasNext()){
//			 String w=sc.next();
//			 if(w.equalsIgnoreCase(word)){
//				 newSentence=newSentence+" ...";
//			 }else{
//				 newSentence=newSentence + " "+w;
//			 }
//		 }
//		 sc.close();
//		 return newSentence;
		 
	 }
	 
	 

}
