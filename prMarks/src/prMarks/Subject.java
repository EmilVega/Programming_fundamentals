/*
 * Emil Dario Vega Gualan
 * 0706950151
 * Paralelo B
 */

package prMarks;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Subject {
	private String name;
	private String [] errors;
	private Student [] students;

	public Subject (String name, String[] students) throws StudentException{
		this.name=name;
		errors =new String[students.length];
		this.students=new Student[students.length];
		StringTokenizer st;
		int j=0, k=0;
		for (int i=0;i<students.length;i++){
			st = new StringTokenizer(students[i], ";");
			try{
				String dni = st.nextToken();
				String name2 = st.nextToken();
				double mark = Double.parseDouble(st.nextToken());
				this.students[j] = new Student(dni,name2,mark);
				j++;

			}catch(NumberFormatException e){
				errors[k]="ERROR. Mark is not a number: "+students[i];
				k++;
			}catch (NoSuchElementException e) {
				errors[k]= new String ("ERROR. Missing data: " + students[i]);
				k++;
			}catch(StudentException e){
				errors[k]=e.getMessage()+students[i];
				k++;
			}
		}
		Student [] student1=new Student[j];
		System.arraycopy(this.students, 0, student1, 0, j);
		this.students=student1;
		String [] error1=new String[k];
		System.arraycopy(errors, 0, error1, 0, k);
		errors=error1;

	}

	/*public Subject (String name, String[] students) throws StudentException{
		this.name=name;
		errors =new String[students.length];
		this.students=new Student[students.length];
		Scanner sc;
		int j=0, k=0;
		for (int i=0;i<students.length;i++){
			sc = new Scanner(students[i]);
			sc.useDelimiter("[;]");
			try{
				String dni = sc.next();
				String name2 = sc.next();
				double mark = Double.parseDouble(sc.next());
				this.students[j] = new Student(dni,name2,mark);
				j++;

			}catch(NumberFormatException e){
				errors[k]="ERROR. Mark is not a number: "+students[i];
				k++;
			}catch (NoSuchElementException e) {
				errors[k]= new String ("ERROR. Missing data: " + students[i]);
				k++;
			}catch(StudentException e){
				errors[k]=e.getMessage()+students[i];
				k++;
			}
		}
		Student [] student1=new Student[j];
		System.arraycopy(this.students, 0, student1, 0, j);
		this.students=student1;
		String [] error1=new String[k];
		System.arraycopy(errors, 0, error1, 0, k);
		errors=error1;
		sc.close();
	}*/

	public double getMark (Student s) throws StudentException{
		int i=0;
		boolean find = false;
		while (!find && i <students.length){
			if (students[i].equals(s)){
				find=true;
			}
			i++;
		}
		if (!find){
			throw new StudentException ("The student: "+s.getName()+" "+s.getDni()+ " is not enroled in "+name);
		}
		return students[i].getMark();
	}

	public Student [] getStudents(){
		return students;
	}

	public String [] getErrors(){
		return errors;
	}

	public double getAverage() throws StudentException{
		if(students[0]==null){
			throw new StudentException ("This subject has not any student");
		}
		double sum=0;
		for (int i=0;i<students.length;i++){
			sum=sum+students[i].getMark();
		}
		return sum/students.length;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder(students.length);
		for (int i=0; i<students.length;i++){
			sb.append(students[i]);
		}
		StringBuilder eb = new StringBuilder(errors.length);
		for (String err:errors){
			eb.append(err);
		}
		return "{ ["+sb+"],\n ["+eb+"] }";
	}

}
