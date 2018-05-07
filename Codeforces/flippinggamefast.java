import java.util.*;

//prob id: 327A, complexity: N

public class flippinggamefast {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;
        int best = -1;
        int running = 0;

        //idea: keep track of best running sum you could get (when all elements in sequence are flipped)
        for (int i = 0; i < n; i++){

            int next = sc.nextInt();
            if(next == 0){
                running++;                          //add to running best sum when encountering 0's         (when flipped, value is gained)
                best = Math.max(best, running);     //update best sum found
            }
            else{
                running--;                          //subtract from best running sum when encountering 1's  (when flipped, value is lost)
                if(running < 0) running = 0;
            }

            sum += next;                            //add all 1's already existing in sequence to variable keeping track of max you can get from 0's

        }
        
        //try running the code in your head with the following input:
        //8
        //0 1 0 1 0 1 0 1

        System.out.println(sum + best);



    }
}
