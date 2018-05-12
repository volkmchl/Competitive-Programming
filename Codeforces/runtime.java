import java.util.*;

public class runtime {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		
		for(int i = 0; i < cases; i++){
			int numCount = in.nextInt();
			int[] numbers = new int[numCount];
			int multipl = in.nextInt();
			
			for(int j = 0; j < numCount; j++){
				numbers[j] = in.nextInt();
			}
			
			Arrays.sort(numbers);
			
			int front = 0;
			int back = numCount-1;
			while(true){
				if(front == back){
					System.out.println("-1");
					break;
				}
				else if(numbers[front] * numbers[back] == multipl){
					System.out.println(numbers[front] + " " + numbers[back]);
					break;
				}
				else if(numbers[front] * numbers[back] < multipl){
					front++;
				}
				else if(numbers[front] * numbers[back] > multipl){
					back--;
				}
			}
			
		}
	}
}
