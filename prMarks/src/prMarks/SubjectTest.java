/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prMarks;

public class SubjectTest {
	static String [] students = { 
			"12455666F;Lopez Perez, Pedro;6.7", 
			"33678999D;Merlo Gomez, Isabel;5.8", 
			"23555875G;Martinez Herrera, Lucia;9.1"};


	public static void main(String[] args) throws StudentException {
		Subject ingles = new Subject("Ingles", students);
		try {
			System.out.printf("Ingles %4.2f\n", ingles.getAverage());
			System.out.println("Students...");
			for(Student student: ingles.getStudents()) {
				System.out.println(student + ": " + student.getMark());
			}
			Student st = new Student("12455666F","Lopez Lopez, Pedro");
			System.out.println(st + "'s mark : " + ingles.getMark(st));
		} catch(StudentException e) { 
			System.err.println(e.getMessage());
		}
	}

}
