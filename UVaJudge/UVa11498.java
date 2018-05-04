import java.util.*;

public class UVa11498 {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine()){
            
            int T = in.nextInt();
            if(T == 0)break;
            
            int x = in.nextInt();
            int y = in.nextInt();
            
            for(int t = 0; t < T; t++){
                int X = in.nextInt();
                int Y = in.nextInt();
                
                if(X == x || Y == y){
                    System.out.println("divisa");
                }
                else if(X < x){
                    if(Y > y){
                        System.out.println("NO");
                    }
                    else{
                        System.out.println("SO");
                    }
                }
                else{
                    if(Y > y){
                        System.out.println("NE");
                    }
                    else{
                        System.out.println("SE");
                    }
                }
                
            }
            
        }
    }
}
