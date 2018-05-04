import java.util.*;
public class UVa10038 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			int N = in.nextInt();
			boolean jolly[] = new boolean[N-1];
			int ar[] = new int[N];
			
			if(N == 1){
				System.out.println("Jolly");//edge case
				in.nextLine();
				continue;
			}
			
			for(int i = 0; i < N; i++){
				ar[i] = in.nextInt();
			}
			
			in.nextLine();
			
			for(int i = 0; i < N-1; i++){
				if(Math.abs(ar[i]-ar[i+1])-1 < N-1 && Math.abs(ar[i]-ar[i+1])-1 >= 0){
					jolly[Math.abs(ar[i]-ar[i+1])-1] = true;
				}
			}
			
			boolean flag = true;
			for(int i =0; i < N-1; i++){
				if(jolly[i] == false){
					flag = false;
					break;
				}
			}
			if(flag){
				System.out.println("Jolly");
			}
			else{
				System.out.println("Not jolly");
			}
		}
	}
}
