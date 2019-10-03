/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */


package kwic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TitleKWICTest {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("sentences.txt"));
		int n=0, i=0;
		while (sc.hasNextLine()){
			sc.nextLine();
			n++;
		}
		sc.close();
		Scanner sc2 = new Scanner(new File("sentences.txt"));
		TitleKWIC [] films = new TitleKWIC[n];
		while (sc2.hasNextLine() && i<n){
			films[i]=new TitleKWIC(sc2.nextLine());
			i++;
		}
		Arrays.sort(films);
		System.out.println("Lowest item = "+films[i-1]+"\nGreatest item = "+films[0]);
		sc2.close();
	}

}
