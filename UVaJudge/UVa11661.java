import java.util.*;

public class UVa11661{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int highwayLength = sc.nextInt();
			if(highwayLength == 0) break;

			String highway = sc.next();

			int currMinDistance = Integer.MAX_VALUE;
			int bufferDistance = 0;
			boolean metRestaurant = false;
			boolean metDrugStore = false;
			for(int i = 0; i < highwayLength; i++){
				
				if(highway.charAt(i) == 'Z'){
					currMinDistance = 0;
					break;
				}

				else if(highway.charAt(i) == 'D'){
					if(metRestaurant && bufferDistance < currMinDistance){
						currMinDistance = bufferDistance;
					}
					metDrugStore = true;
					metRestaurant = false;
					bufferDistance = 0;
				}
				
				else if(highway.charAt(i) == 'R'){
					if(metDrugStore && bufferDistance < currMinDistance){
						currMinDistance = bufferDistance;
					}
				bufferDistance = 0;
				metRestaurant = true;
				metDrugStore = false;
				}
				bufferDistance++;
			}

			System.out.println(currMinDistance);
		
		}
	}
}
