import java.util.*;

public class UVa11687{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String prev = sc.next();
			if(prev.equals("END")) break;

			int cnt = 1;
			String curr = prev.length()+"";
			while(!curr.equals(prev)){
				prev = curr;
				curr = curr.length() +"";
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
