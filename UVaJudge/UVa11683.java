import java.util.*;

public class UVa11683{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int H = sc.nextInt();
			if(H == 0) break;
			int W = sc.nextInt();
			
			int prevDepth = H;	//laser starts at highest level initially (going from left to right)
			int currDepth = 0;
			int total = 0;

			/*
			add to total only when going down in depth; addition is reference height - currentDepth
			if we go up, reference height is updated: prevDepth = currDepth
			*/

			for(int level = 0; level < W; level++){
				currDepth = sc.nextInt();
				if(currDepth < prevDepth){
					total += prevDepth-currDepth;
				}
				prevDepth = currDepth;
			}
			System.out.println(total);
		}
	}
}
