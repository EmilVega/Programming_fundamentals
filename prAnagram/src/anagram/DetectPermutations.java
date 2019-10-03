/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package anagram;

import java.io.*;
import java.util.*;

public class DetectPermutations {
	
	public static void main(String [] args) {
		
		System.out.println("Please insert your decimal digit sequences. Type END to finish.");
		Scanner keyboard = new Scanner(System.in);
		
		try{
			while(keyboard.hasNext()){
				String line = keyboard.next();
				if(line.equalsIgnoreCase("END")){  
					keyboard.close();
				}else{	
					try{
						Word l = new Word(line);
						Scanner sc = new Scanner(new File("sequences.txt"));
						sc.useDelimiter("[, ]");
						Set<Word> set = new TreeSet<Word>();
						while(sc.hasNext()){
							Word word1 = new Word(sc.next());
							if(word1.isAnagram(l)){
								set.add(word1);
							}
						}
						if(set.isEmpty()){
							System.out.println("The sequence " + line + " has not permutations.");
						}else{
							int i = 0;
							String out = "The sequence " + line + " is permutation of ";
							for(Word ws : set){
								out += ws;
								if(i < set.size()-1){
									out += ", ";
								}
								i++;
							}
							out += ".";
							System.out.println(out);
						}
						sc.close();
					}catch(NumberFormatException e){
						System.out.println("Your sequence is not a decimal digit sequence.");	
					}
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("The file to compare does not exist.");		
		}catch(IllegalStateException e){
			System.out.println("The program has finished.");
		}
	}
	
}
