import java.util.*;

public class UVa661{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int sequence = 1;
		while(sc.hasNext()){
			int DEV = sc.nextInt();
			int OPS = sc.nextInt();
			int CAP = sc.nextInt();

			if(DEV == 0){
				System.out.println("");             // print extra line after end of input
				break;
			}

			int[] CONSUMPTION = new int[DEV+1];
			boolean[] status = new boolean[DEV+1];
			
			int currentConsumption = 0;
			int maxConsumption = 0;

			boolean blownFuse = false;

			for(int dev = 1; dev <= DEV; dev++){
				CONSUMPTION[dev] = sc.nextInt();
			}

        
            
            //single traversal algorithm, keep track of status of device
            //add or subtract from current consumption based on status of device after toggle
			for(int op = 0; op < OPS; op++){
				int device = sc.nextInt();
				status[device] = !status[device];
				if(status[device]){
					currentConsumption += CONSUMPTION[device];
					blownFuse = (currentConsumption >  CAP) ? true : blownFuse;
					maxConsumption = (currentConsumption > maxConsumption) ? currentConsumption : maxConsumption;
				}
				else{
					currentConsumption -= CONSUMPTION[device];
				}
			}

			if(sequence != 1){System.out.println("");}

			System.out.println("Sequence " + sequence++);
			System.out.println( (blownFuse) ? "Fuse was blown." : "Fuse was not blown.\nMaximal power consumption was " + maxConsumption + " amperes.");
		}
	}
}
