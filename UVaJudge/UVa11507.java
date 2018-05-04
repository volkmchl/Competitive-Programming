import java.util.*;

public class UVa11507{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int L = sc.nextInt();
			if(L == 0) break;

			String currentDirection = "+x";
			for(int l = 0; l < L-1; l++){
				String towards = sc.next();
				currentDirection = bend(currentDirection, towards);
			}
			System.out.println(currentDirection);
		}
	}
	public static String bend(String currentDirection, String towards){
		if(currentDirection.equals("+x")){
			switch(towards){
				case "+y":
					currentDirection = "+y";
					break;
				case "-y":
					currentDirection = "-y";
					break;
				case "+z":
					currentDirection = "+z";
					break;
				case "-z":
					currentDirection = "-z";
					break;
				}
		}

		else if(currentDirection.equals("-x")){
			switch(towards){
                case "+y":
                    currentDirection = "-y";
                    break;
                case "-y":
                    currentDirection = "+y";
                    break;
                case "+z":
                    currentDirection = "-z";
                    break;
                case "-z":
                    currentDirection = "+z";
                    break;
				}
		}

		else if(currentDirection.equals("+y")){
			switch(towards){
                case "+y":
                    currentDirection = "-x";
                    break;
                case "-y":
                    currentDirection = "+x";
                    break;
                case "+z":
                    currentDirection = "+y";
                    break;
                case "-z":
                    currentDirection = "+y";
                    break;
				}
		}

		else if(currentDirection.equals("-y")){
			switch(towards){
                case "+y":
                    currentDirection = "+x";
                    break;
                case "-y":
                    currentDirection = "-x";
                    break;
                case "+z":
                    currentDirection = "-y";
                    break;
                case "-z":
                    currentDirection = "-y";
                    break;
				}
		}

		else if(currentDirection.equals("+z")){
			switch(towards){
                case "+y":
                    currentDirection = "+z";
                    break;
                case "-y":
                    currentDirection = "+z";
                    break;
                case "+z":
                    currentDirection = "-x";
                    break;
                case "-z":
                    currentDirection = "+x";
                    break;
				}
		}
		else if(currentDirection.equals("-z")){
			switch(towards){
                case "+y":
                    currentDirection = "-z";
                    break;
                case "-y":
                    currentDirection = "-z";
                    break;
                case "+z":
                    currentDirection = "+x";
                    break;
                case "-z":
                    currentDirection = "-x";
                    break;
			}
		}
		
		return currentDirection;
	}
}
