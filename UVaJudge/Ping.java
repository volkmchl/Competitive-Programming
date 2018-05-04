import java.util.*;
public class Ping {
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine()){
            String seq = in.nextLine();
            
            if(seq.equals("0")){
                break;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            
            boolean[] intervals = new boolean[seq.length()+1];
            int firstIndex = 1;
            while(seq.charAt(firstIndex) != '1'){
                firstIndex++;
            }
            intervals[firstIndex] = true;
            pq.add(firstIndex);
            
            for(int i = firstIndex+1; i <seq.length(); i++){		//actually starts at firstIndex+1
                if(seq.charAt(i) == '0'){
                    //can't hear (if odd number at factor times are true: new interval)
                    
                    int count = 0;
                    for(int j = firstIndex; j <= i/2; j++){
                        if(i%j == 0 && intervals[j] == true){
                            count++;
                        }
                    }
                    
                    if(count %2 ==1){
                        //odd number of factors are TRUE
                        intervals[i] = true;
                        pq.add(i);
                    }
                }
                else{
                    ////can hear a sound (if factor time is even: new interval)
                    int count = 0;
                    for(int j = firstIndex; j <= i/2; j++){
                        if(i%j == 0 && intervals[j] == true){
                            count++;
                        }
                    }
                    if(count % 2 == 0){
                        //odd number of factors are TRUE
                        intervals[i] = true;
                        pq.add(i);
                    }
                }
            }
            while(pq.size() > 1){
                System.out.print(pq.poll() + " ");
            }
            System.out.println(pq.poll() + "");
        }
    }
}
