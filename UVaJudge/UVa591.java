import java.util.*;

public class UVa591{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int set = 1;
        while(sc.hasNext()){
            int stackCount = sc.nextInt();
            
            if(stackCount == 0) break;

            int stack[] = new int[stackCount];
            
            int totalBricks = 0;
            for(int s = 0; s < stackCount; s++){
                stack[s] = sc.nextInt();
                totalBricks += stack[s];
            }

            int average = (int)(totalBricks/stackCount);

            int absDiff = 0;
            for(int s = 0; s < stackCount; s++){
                if(stack[s] > average){
                    absDiff += stack[s]-average;
                }
            }

            System.out.println("Set #" + set++);
            System.out.println("The minimum number of moves is " + absDiff + ".");
            System.out.println();
        }
    }
}
