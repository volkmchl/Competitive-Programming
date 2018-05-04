import java.util.*;
import java.lang.Math;

public class zigzag {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int favNum = sc.nextInt();
        
        char result[] = new char[(int)(Math.ceil((double)favNum/25)+1)];
        
        int tot = (result.length-1) * 25;
        
        
        for(int i = 0; i < result.length; i++){
            if(i % 2 == 0)
                result[i] = 'a';
            else
                result[i] = 'z';

            if(i == 1){
                if(result.length == 2){
                    while(tot-favNum>0){
                        tot--;
                        result[i]--;
                    }
                }
                else{
                    while(tot-favNum>=2){
                        tot-=2;
                        result[i]--;
                    }
                }
            }
            
            if(i == result.length-1){
                while(tot-favNum>0){
                    if(i % 2 == 0){
                        tot--;
                        result[i]++;
                    }
                    else{
                        tot--;
                        result[i]--;
                    }
                }
            }
            
            
        }
        System.out.print(String.valueOf(result));
    }
}
