import java.util.*;

public class UVa11586{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t = 0; t < T; t++){
			String tracks = sc.nextLine();
			int M = 0;
			int F = 0;
			for(int i = 0; i < tracks.length(); i++){
				if(tracks.charAt(i) == 'M') M++;
				if(tracks.charAt(i) == 'F') F++;
			}
			System.out.println((M==F && M >=2) ? "LOOP" : "NO LOOP");
		}
	}
}
