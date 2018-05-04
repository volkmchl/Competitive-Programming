import java.util.*;
public class UVa12554 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        String birthday[] = {"Happy","birthday","to","you","Happy","birthday","to","you","Happy","birthday","to","Rujia","Happy","birthday","to","you"};
        int P = in.nextInt();
        in.nextLine();
        String name[] = new String[P];
        for(int p = 0; p < P; p++){
            name[p] = in.nextLine();
        }
        
        int person = 0;
        while(person < P){
            
            for(int step = 0; step < 16; step++){
                System.out.println(name[person++%P] + ": " + birthday[step]);
            }
        }
        
        
    }
}
