import java.util.*;

//prob id: R on 2015-2016 ICPC Pacific NW Regional Contest

public class classtime {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int numStudents = sc.nextInt();
		sc.nextLine();
		
		String [] students = new String[numStudents];
		
		for(int i = 0; i < numStudents; i++){
			String firstName = sc.next();
			String lastName = sc.next();
			students[i] = lastName + " " + firstName;
		}
		
		Arrays.sort(students);
		
		for(int i = 0; i < numStudents; i++){
			Scanner reverse = new Scanner(students[i]);
			String lastName = reverse.next();
			String firstName = reverse.next();
			
			System.out.println(firstName + " " + lastName);
			
		}

	}
}
