import java.util.*;
import java.io.*;
public class UVa11991 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		while(line != null){
			String NQ = line;
			String[] ar = NQ.split(" ");
			int N = Integer.parseInt(ar[0]);
			int Q = Integer.parseInt(ar[1]);
			
			
			Map<Integer,ArrayList<Integer>> locations = new HashMap<Integer,ArrayList<Integer>>();
			
			line = reader.readLine();
			ar = line.split(" ");
			
			int i = 0;
			for(i = 0; i < N; i++){
				int val = Integer.parseInt(ar[i]);
				if(!locations.containsKey(val)){
					ArrayList<Integer> loc = new ArrayList<Integer>();
					loc.add(i+1);
					locations.put(val, loc);
				}
				
				else if(locations.containsKey(val)){
					ArrayList<Integer> loc = locations.get(val);
					loc.add(i+1);
					locations.put(val, loc);
				}
			}
			
			
			StringBuilder sb = new StringBuilder();
			i = 0;
			for(i = 0; i < Q; i++){
				line = reader.readLine();
				ar = line.split(" ");
				int occurence = Integer.parseInt(ar[0]);
				int val = Integer.parseInt(ar[1]);
				
				if(!locations.containsKey(val)){
					sb.append("0\n");
				}
				else if(locations.get(val).size() < occurence){
					sb.append("0\n");
				}
				else{
					sb.append(locations.get(val).get(occurence-1) + "\n");
				}
				
			}
			System.out.print(sb);
			line = reader.readLine();
		}
	}
}
