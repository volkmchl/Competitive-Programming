import java.util.*;

public class armystrength{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T --> 0){
            int nG = sc.nextInt();
            int nM = sc.nextInt();

            int maxGodzilla = -1;
            int maxMecha = -1;

            for(int i = 0; i < nG; i++){
                maxGodzilla = Math.max(maxGodzilla,sc.nextInt());
            }

            for(int i = 0; i < nM; i++){
                maxMecha = Math.max(maxMecha, sc.nextInt());
            }

            if(maxGodzilla >= maxMecha){
                System.out.println("Godzilla");
            }
            else{
                System.out.println("MechaGodzilla");
            }
        }
    }
}
