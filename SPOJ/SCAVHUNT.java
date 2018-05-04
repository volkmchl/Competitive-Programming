import java.util.*;

class SCAVHUNT{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		for(int i = 1; i <= t; i++){
            System.out.println("Scenario #" + i + ":");
			int n = in.nextInt();

			HashMap<String,String> map = new HashMap<String,String>();
			HashSet<String> set = new HashSet<String>();

			for(int j = 1; j < n; j++){
				String from = in.next();
				String to = in.next();
				map.put(from, to);
				set.add(from);
				set.add(to);
			}

			String value = "";
			for(String s : set){
				if(!map.containsValue(s)){
					value = s;
					break;
				}
			}

			for(int k = 0; k < n; k++){
				System.out.println(value);
				if(k != n-1){
					value = map.get(value);
				}
			}
            System.out.println();
        }
	}
}
