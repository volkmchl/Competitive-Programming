import java.util.*;

public class UVa12015 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for(int t = 0; t < T; t++){
			Queue<Wbsite> q = new LinkedList<Wbsite>();
			int maxRel = -1;
			for(int j = 0; j < 10; j++){
				Wbsite buffer = new Wbsite(in.next(), in.nextInt());
				in.nextLine();
				if(buffer.rel > maxRel){
					maxRel = buffer.rel;
					q.clear();
					q.add(buffer);
				}
				else if(buffer.rel == maxRel){
					q.add(buffer);
				}	
			}
			System.out.println("Case #" + (t+1) + ":");
			while(!q.isEmpty()){
				System.out.println(q.poll().url);
			}
		}
	}
	static class Wbsite{
		String url;
		int rel;
		Wbsite(String url, int rel){
			this.url = url;
			this.rel = rel;
		}
	}
}
