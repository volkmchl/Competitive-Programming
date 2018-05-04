import java.util.*;

public class UVa10050{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            int P = sc.nextInt();

            HashSet<Integer> off = new HashSet<Integer>();
            for(int p = 0; p < P; p++){
                int hartal = sc.nextInt();
                for(int i = 1; i <= N; i++){
                    if(i % 7 != 6 && i % 7 != 0 && i % hartal == 0){
                        off.add(i);
                    }
                }
            }
            System.out.println(off.size());
        }
    }
}
