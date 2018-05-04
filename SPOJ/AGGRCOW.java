import java.util.*;

class AGGRCOW{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T --> 0){
            int N = sc.nextInt();       //num of stalls
            int C = sc.nextInt();       //num of cows;

            int stall[] = new int[N];
            int maxStall = -1;

            for(int i = 0; i < N; i++){
                stall[i] = sc.nextInt();
                maxStall = Math.max(stall[i], maxStall);
            }

            Arrays.sort(stall);

            int l = 1;
            int h = maxStall-1;
            int max = 1;

            while(l <= h){
                int mid = l + (h-l)/2;

                int remainingCows = C;
                int prev = -1;

                for(int i = 0; i < stall.length; i++){
                    if(prev == -1){
                        remainingCows--;
                        prev = stall[i];
                    }
                    else if(stall[i] - prev >= mid){
                        remainingCows--;
                        prev = stall[i];
                    }

                    if(remainingCows == 0) break;
                }

                if(remainingCows == 0){
                    max = Math.max(max, mid);
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }

            System.out.println(max);
        }
    }
}
