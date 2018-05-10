import java.util.*;

public class coloringatreefast{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] color = new int[N+1];
        int[] parent = new int[N+1];

        for(int i = 2; i <= N; i++){
            parent[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++){
            color[i] = sc.nextInt();
        }

        int sol = 0;
        if(color[1] != 0) sol = 1;

        for(int i = 2; i <= N; i++)
            if(color[i] != color[parent[i]]) sol++;

        System.out.println(sol);
    }   
}
