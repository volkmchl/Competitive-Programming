import java.util.*;

public class notafraid{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int U = sc.nextInt();
		int G = sc.nextInt();

		boolean groupsSafe = true;
		for(int g = 0; g < G; g++){
			boolean[] safety = new boolean[U];

			int R = sc.nextInt();
			int[] signUP = new int[R];

			boolean groupSafe = false;
			for(int r = 0; r < R; r++){
				signUP[r] = sc.nextInt();
				if(signUP[r] < 0) safety[Math.abs(signUP[r])-1] = true;
			}

			for(int r = 0; r < R; r++){
				if(signUP[r] > 0 && safety[signUP[r]-1]) groupSafe = true;
			}

			if(!groupSafe) groupsSafe = false;
		}

		System.out.println(groupsSafe ? "NO" : "YES");
	}
}
