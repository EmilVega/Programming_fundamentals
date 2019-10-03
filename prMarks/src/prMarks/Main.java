/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prMarks;

public class Main {

	static String [] students = {
			"25653443S;Garcia Gomez, Juan;8.1",
			"23322443K;Lopez Turo, Manuel;4.3",
			"24433522M;Merlo Martinez, Juana;5.3",
			"53553421D;Santana Medina, Petra;-7.1",
			"55343442L,Godoy Molina, Marina;6.3",
			"34242432J;Fernandez Vara, Pedro;2.k",
	"42424312G;Lopez Gama, Luisa;7.1" };

	public static void main(String[] args) throws StudentException {
		Subject algebra = new Subject("Algebra", students);
		try {
			Student st1 = new Student("23322443k","Lopez Turo, Manuel");
			Student st2 = new Student("34242432J","Fernandez Vara, Pedro");
			System.out.println(st1 + "'s mark : " + algebra.getMark(st1));
			System.out.println(st2 + "'s mark : " + algebra.getMark(st2)); // El average no se imprime a menos que el error de st2 no se realice
			System.out.printf("Average %4.2f\n", algebra.getAverage());
		} catch(StudentException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Students...");
		for(Student student: algebra.getStudents()) {
			System.out.println(student + ": " + student.getMark() );
		}
		System.out.println("Errors...");
		for(String error: algebra.getErrors()) {
			System.out.println(error);
		}
		System.out.println(algebra);
	}
}
