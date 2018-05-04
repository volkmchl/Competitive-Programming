import java.util.*;

public class UVa10141{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int currentRFP = 1;
		while(sc.hasNext()){
			int rqrts = sc.nextInt();
			int props = sc.nextInt();
			if(rqrts == 0 && props == 0) break;
			
			sc.nextLine();
			for(int i = 0; i < rqrts; i++){
				sc.nextLine();
			}

			String ans = "";
			double currentCompliance = 0;
			double currentPrice = 0;
			
			for(int i = 0; i < props; i++){
				String supplier = sc.nextLine();
				double offeringPrice = sc.nextDouble();
				int fulfilledRqrts = sc.nextInt();
				if(fulfilledRqrts > currentCompliance){
					ans = supplier;
					currentCompliance = fulfilledRqrts;
					currentPrice = offeringPrice;
				}
				else if((fulfilledRqrts == currentCompliance) && offeringPrice < currentPrice){
					ans = supplier;
				}
				
				sc.nextLine();
				for(int j = 0; j < fulfilledRqrts; j++) sc.nextLine();
			}

            if(currentRFP != 1){
                System.out.println("");
            }
            System.out.println("RFP #" + currentRFP++);
			System.out.println(ans);

		}
	}
}
