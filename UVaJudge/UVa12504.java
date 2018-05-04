import java.util.*;
import java.io.*;

public class UVa12504{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0){
			StringBuilder sb = new StringBuilder();
			sb.append(br.readLine());
			remBraces(sb);

			TreeMap<String, String> OLD = new TreeMap<String, String>();
			
			//key value PAIRS processing
			String[] kvPRS = sb.toString().split(",");
			for(int i = 0; i < kvPRS.length; i++){
				//key value processing
				String[] kv = kvPRS[i].split(":");
				if(kv.length > 1) OLD.put(kv[0], kv[1]);
			}

			sb.delete(0,sb.length());
			sb.append(br.readLine());
			remBraces(sb);

			ArrayList<String> ADDED = new ArrayList<String>();
			ArrayList<String> MODIF = new ArrayList<String>();

			kvPRS = sb.toString().split(",");
			for(int i = 0; i < kvPRS.length; i++){
				String[] kv = kvPRS[i].split(":");
				if(kv.length > 1){
					if(OLD.containsKey(kv[0])){
						if(!OLD.get(kv[0]).equals(kv[1])) MODIF.add(kv[0]);
						OLD.remove(kv[0]);
					}
					else{
						ADDED.add(kv[0]);
					}
				}
			}

			Collections.sort(ADDED);
			Collections.sort(MODIF);

			if(OLD.size() == 0 && ADDED.size() == 0 && MODIF.size() == 0){
				System.out.println("No changes");
			}
			else{
				if(ADDED.size() > 0){
					System.out.print("+");
					System.out.print(ADDED.get(0));
					for(int i = 1; i < ADDED.size(); i++){
						System.out.print("," + ADDED.get(i));
					}
					System.out.println();
				}
				if(OLD.size() > 0){
					System.out.print("-");
					Iterator itr = OLD.keySet().iterator();
					System.out.print(itr.next());
					while(itr.hasNext())
						System.out.print("," + itr.next());
					System.out.println();
				}
				if(MODIF.size() > 0){
					System.out.print("*");
					System.out.print(MODIF.get(0));
					for(int i = 1; i < MODIF.size(); i++){
						System.out.print("," + MODIF.get(i));
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}

	public static void remBraces(StringBuilder sb){
		sb.deleteCharAt(0);
		sb.deleteCharAt(sb.length()-1);
	}
}
