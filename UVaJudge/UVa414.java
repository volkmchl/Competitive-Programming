import java.util.*;

public class UVa414{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            int rows = sc.nextInt();
            if(rows == 0) break;
            sc.nextLine();
            String[] picture = new String[rows];
            int[] blanks = new int[rows];
            int maxX = 0;
            for(int r = 0; r < rows; r++){
                picture[r] = sc.nextLine();
                int bufferX = 0;
                for(int i = 0; i < picture[r].length(); i++){
                    bufferX = (picture[r].charAt(i) == 'X') ? bufferX + 1 : bufferX;
                }
                blanks[r] = 25-bufferX;
                if(bufferX > maxX){
                    maxX = bufferX;
                }
            }
            
            
            int totalBlanks = 0;
            for(int r = 0; r < rows; r++){
                if(blanks[r] > 25-maxX){
                    totalBlanks += blanks[r]-(25-maxX);
                }
            }
            System.out.println(totalBlanks);
        }
    }
}
