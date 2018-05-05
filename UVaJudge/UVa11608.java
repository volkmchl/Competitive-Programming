import java.util.*;

public class UVa11608{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = 1;
        while(sc.hasNext()){
            int[] availableProbs = new int[13];
            int[] requestedProbs = new int[12];
            
            int initialProbs = sc.nextInt();
            if(initialProbs < 0) break;
            availableProbs[0] = initialProbs;

            for(int month = 0; month < 12; month++){
                availableProbs[month+1] += sc.nextInt();
            }

            for(int month = 0; month < 12; month++){
                requestedProbs[month] = sc.nextInt();
            }

            System.out.println("Case " + testCase + ":");
            for(int month = 0; month < 12; month++){



                if(availableProbs[month] >= requestedProbs[month]){
                    availableProbs[month+1] += availableProbs[month]-requestedProbs[month];
                    System.out.println("No problem! :D");
                }
                else{
                    availableProbs[month+1] += availableProbs[month];
                    System.out.println("No problem. :(");
                }
            }

            testCase++;
        }
    }
}
