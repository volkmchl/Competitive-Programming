import java.util.*;

//prob id: A on Codeforces #453 (Div 2)

public class visitingfriend{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] accessible = new boolean[105];
        accessible[0] = true;

        for(int i = 0; i < N; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();

            for(int j = l+1; j <= r; j++){
                accessible[j] = true;
            }
        }

        boolean noDrive = true;
        for(int i = 0; i <= M; i++){
            if(!accessible[i]){
                noDrive = false;
                break;
            }
        }

        if(noDrive){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }   
}
