mport java.util.*;
public class UVa978 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 0; t < T; t++){
			PriorityQueue<Integer> grnArmies = new PriorityQueue<Integer>(Collections.reverseOrder());
			PriorityQueue<Integer> bluArmies = new PriorityQueue<Integer>(Collections.reverseOrder());
			int fields = in.nextInt();
			int SG = in.nextInt();
			int SB = in.nextInt();
			in.nextLine();
			
			for(int i = 0; i < SG; i++){
				grnArmies.add(in.nextInt());
				in.nextLine();
			}
			
			for(int i = 0; i < SB; i++){
				bluArmies.add(in.nextInt());
			}
			
			//FIGHT ON
			
			while(!grnArmies.isEmpty() && !bluArmies.isEmpty()){
				int maxBattles = Math.min(grnArmies.size(), bluArmies.size());
				maxBattles = Math.min(maxBattles, fields);
				
				Queue<Integer> remainGrn = new LinkedList<Integer>();
				Queue<Integer> remainBlu = new LinkedList<Integer>();
				
				for(int i = 0; i < maxBattles; i++){
					int grnForce = grnArmies.poll();
					int bluForce = bluArmies.poll();
					if(grnForce > bluForce){
						grnForce = grnForce - bluForce;
						remainGrn.add(grnForce);
					}
					else{
						bluForce = bluForce - grnForce;
						if(bluForce != 0){
							remainBlu.add(bluForce);
						}
					}
				}
				
				while(!remainGrn.isEmpty()){
					grnArmies.add(remainGrn.poll());
				}
				while(!remainBlu.isEmpty()){
					bluArmies.add(remainBlu.poll());
				}
				
			}
			
			//FIGHT OFF
			
			
			if(grnArmies.isEmpty() && bluArmies.isEmpty()){
				System.out.println("green and blue died");
				if(t != T-1){
					System.out.println("");
				}
			}
			else{
				if(!grnArmies.isEmpty()){
					System.out.println("green wins");
					while(!grnArmies.isEmpty()){
						System.out.println(grnArmies.poll());
					}
					if(t != T-1){
						System.out.println("");
					}
				}
				else{
					System.out.println("blue wins");
					while(!bluArmies.isEmpty()){
						System.out.println(bluArmies.poll());
					}
					if(t != T-1){
						System.out.println("");
					}
				}
			}
		}
	}
}
