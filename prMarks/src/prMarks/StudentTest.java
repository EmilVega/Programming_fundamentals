/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prMarks;

public class StudentTest {

	public static void main(String[] args) throws StudentException {
		try{
			Student st1 = new Student ("22456784F", "Gonzalez Perez, Kevin", 5.5);
			Student st2 = new Student ("33456777S","Gonzalez Perez, Kevin",-3.4);
			System.out.println(st1.toString()+"\n"+st2.toString());
			if (st1.equals(st2)) {
				System.out.println("Both are the same");
			}
		} catch (StudentException e){
			System.out.println(e.getMessage());
		}

	}

}
