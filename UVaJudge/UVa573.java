import java.util.*;

public class UVa573{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double H = sc.nextDouble();
			double U = sc.nextDouble();
			double D = sc.nextDouble();
			double F = sc.nextDouble();
			
			double downDistance = (double)U * (double)(F)/100.0;

			if(H == 0) break;

			double currentHeight = 0;
			int currentDay = 1;
			while(currentHeight >= 0 && currentHeight <= H){
				currentHeight = currentHeight + U;			//climb possible distance
				if(currentHeight > H) break;

				currentHeight = currentHeight - D;			//slide down
				if(currentHeight < 0){
					break;
				}
				U = U - downDistance;
				if(U < 0){U = 0;}			
				currentDay++;
			}

			System.out.println((currentHeight > H) ? "success on day " + (currentDay) : "failure on day " + (currentDay));
		}
	}
}

