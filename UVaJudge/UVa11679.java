import java.util.*;
public class UVa11679 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int B = in.nextInt();
            int N = in.nextInt();
            
            if(B == 0){
                break;
            }
            int reserves[] = new int[B];
            for(int i = 0; i < B; i++){
                reserves[i] = in.nextInt();
            }
            
            for(int i = 0; i < N; i++){
                int debtor = in.nextInt()-1;
                int credit = in.nextInt()-1;
                int value = in.nextInt();
                reserves[debtor] -= value;
                reserves[credit] += value;
            }
            
            boolean bailOut = false;
            for(int i = 0; i < B; i++){
                if(reserves[i] < 0){
                    bailOut = true;
                    break;
                }
            }
            
            System.out.println(bailOut ? "N" : "S");
        }
    }
}
