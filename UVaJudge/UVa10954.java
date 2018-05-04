import java.util.*;
public class UVa10954 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			int N = in.nextInt();
			if(N == 0){
				break;
			}
			in.nextLine();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

			for(int i = 0; i < N; i++){
				pq.add(in.nextInt());
			}
			in.nextLine();

			int cost = 0;
			int temp = 0;

			while(!pq.isEmpty() && pq.size() > 1){
				temp = pq.poll() + pq.poll();
				pq.add(temp);
				cost += temp;
			}
			System.out.println(cost);
			
		}
	}
}
