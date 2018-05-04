import java.util.*;
public class UVa11956{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++){
			int vals[] = new int[101];
			String commands = sc.next();
			
			int pointer = 1;
			for(int i = 0; i < commands.length(); i++){
				switch(commands.charAt(i)){
					case '>':
						pointer = (pointer + 1 == 101) ? 1 : pointer+1;
						break;
					case '<':
						pointer = ((pointer -1) == 0) ? 100 : pointer-1;
						break;
					case '+':
						vals[pointer] = (vals[pointer]+1)%256;
						break;
					case '-':
						vals[pointer] = (vals[pointer]-1 == -1) ? 255 : vals[pointer]-1;
						break;
				}
			}

			System.out.print("Case " + (t+1) + ":");
			for(int i = 1; i <= 100; i++){
				System.out.print(" " + ((Integer.toHexString(vals[i]).length() > 1) ? Integer.toHexString(vals[i]).toUpperCase() : "0" + Integer.toHexString(vals[i]).toUpperCase()));
			}
			System.out.println("");
		}
	}
}
