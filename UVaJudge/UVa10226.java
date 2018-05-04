import java.util.*;
public class UVa10226 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		in.nextLine();
		
		String output = "";
		for(int t = 0; t<T; t++){
			HashMap<String, Integer> freqTable = new HashMap<String, Integer>();
			PriorityQueue<Tree> alphaTrees = new PriorityQueue<Tree>();
			

			int count = 0;
			if( t >0){
				System.out.println("");
			}
			while(in.hasNextLine()){
				String species = in.nextLine();
				if(species.equals("")){
					break;
				}
				if(!freqTable.containsKey(species)){
					freqTable.put(species, 1);
					alphaTrees.add(new Tree(species));
				}
				else{
					freqTable.put(species, freqTable.get(species)+1);
				}
				count++;
			}
			
			while(!alphaTrees.isEmpty()){
				String species = alphaTrees.poll().name;
				double fract = (double)freqTable.get(species)/(double)count*100;
				System.out.print(species + " ");
				System.out.printf("%.4f\n", fract);
			}
		}
	}
}

class Tree implements Comparable<Tree>{
	String name;
	Tree(String name){
		this.name= name;
	}
	
	public int compareTo(Tree other){
		if(this.name.compareTo(other.name) < 0){
			return -1;
		}
		return 1;
	}
}
