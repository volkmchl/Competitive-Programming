import java.util.*;

public class UVa12582{

	static int[] out;

	public static int dfs(String traversal, int currPos){
		
		int nextPos = currPos+1;
		
		while(traversal.charAt(currPos) != traversal.charAt(nextPos)){
			
			out[traversal.charAt(nextPos)-65]++;
			nextPos = dfs(traversal, nextPos);
			out[traversal.charAt(currPos)-65]++;	
		
		}
		
		currPos = nextPos+1;
		
		return currPos;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t = 0; t < T; t++){
			String traversal = sc.next();
			out = new int[26];
			
			dfs(traversal, 0);

			System.out.println("Case " + (t+1));
			
			for(int i = 0; i < 26; i++){
				if(out[i] >= 1){
					System.out.println((char)(i+65) + " = " + out[i]);
				}
			}

		}
	}
}
