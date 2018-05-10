import java.util.*;

public class egggrop {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int eggs = in.nextInt();				//number of eggs previously dropped that we can gather information from
        int levels = in.nextInt();				//total number of levels in the building 

        int currSafeLev = 1;					
        //considering that we might not get any information regarding a safe level
        //we initialize the currentSafeLevel to 1 because it is provided to us in problem
        //statement that the first level is safe

        int currBreakLev = levels;
        //in the same manner that we might not get any information regarding a safe level
        //we initialize the currentBreakingLevel to the highest level because it is provided
        //to use in the problem statement that the last level is not safe (the egg will 100%
        //of the times break when dropped from highest level)

        //for the number of eggs previous dropped that we can gather information from
        for(int i = 0; i < eggs; i++){
            int level = in.nextInt();		//get the level
            String outcome = in.next();		//get the outcome of the drop

            switch(outcome.charAt(0)){
                case 'S':											//if the level was safe and the egg did not break
                    if(level > currSafeLev) currSafeLev = level;    //then we set the currentSafeLev to the level provided in the respective drop
                    break;											//only if that level was higher than what we initially had as a currentSafeLev
                                                                    //because you want the highest safe level possible

                case 'B':											//if the level was not safe and the egg broke
                    if(level < currBreakLev) currBreakLev = level;  //the we set the currentBreakLev to the level provided in the respective drop
                    break;											//only if that level was smaller than what we initially had as a currentBreakLev
            }                                                       //because you want the lowest unsafe level possible
        }


        int probHighLev;		//variable for the highest possible level where the egg MIGHT not break			
        int probBreakLev;		//variable for the lowest possible level where the egg MIGHT break

        //the highest level that could possibly be safe and the egg might not break is the lowest unsafe level - 1
        //so if the lowest unsafe level - 1 is not already known as 100% safe, then we set the highest level where
        //the egg might not break to that respective level (lowest unsafe level - 1)
        if(currBreakLev - 1 != currSafeLev){
            probHighLev = currBreakLev - 1;
        }
        else{
            probHighLev = currSafeLev;
        }
        //if the lowest unsafe level - 1 is already known as a 100% safe level(currBreakLev - 1 == currSafeLev), then the previous if statement wouldn't
        //evaluate as true and the highest safe level is already what was established based on the information given in previous drops

        //the lowest level that could possibly be unsafe and the egg might break is the highest safe level + 1
        //so if the highest safe level + 1 is not already known as 100% unsafe, then we set the lowest level where
        //the egg might break to that respective level (highest safe level + 1)
        if(currSafeLev + 1 != currBreakLev){
            probBreakLev = currSafeLev+1;
        }
        else{
            probBreakLev = currBreakLev;
        }
        //if the highest safe level + 1 is already known as a 100% unsafe level(currSafeLev + 1 == currBreakLev), then the previous if statement wouldn't
        //evaluate as true and the lowest unsafe level is already what was established based on the information given in the previous drops

        System.out.println(probBreakLev + " " + probHighLev);

    }
}
