package practicasCortas;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int f0=0;
		int f1=1;
		System.out.println("Ingrese  el numero de fib a obtener: ");
		int n =sc.nextInt();
		int fn=0;
		if (n<2){
			fn =n;
		}else{
			for (int i=2;i<=n;i++){
				fn = f0+f1;
				f0=f1;
				f1=fn;
			}
		}
		System.out.println("El "+n+"avo numero fibonacci es: "+fn);

	}

}
