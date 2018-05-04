import java.util.*;

public class UVa665{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();           //datasets
        for(int t = 0; t < T; t++){
            int C = sc.nextInt();       //coins
            HashSet<Integer> badCoins = new HashSet<Integer>();
            for(int c = 1; c <= C; c++) badCoins.add(c);
            int W = sc.nextInt();       //weightings
            
            for(int w = 0; w < W; w++){
                int coinsWeighted = sc.nextInt();
                HashSet<Integer> left = new HashSet<Integer>();
                HashSet<Integer> right = new HashSet<Integer>();
                for(int c = 0; c < coinsWeighted; c++){
                    left.add(sc.nextInt());
                }
                for(int c = 0; c < coinsWeighted; c++){
                    right.add(sc.nextInt());
                }
                
                char result = sc.next().charAt(0);
                if(result == '='){
                    for(Integer coin : left){
                        badCoins.remove(coin);
                    }
                    for(Integer coin : right){
                        badCoins.remove(coin);
                    }
                }
                else if(result == '<' || result == '>'){
                    Queue<Integer> coinsToRemove = new LinkedList<Integer>();
                    for(Integer coin : badCoins){
                        if(!left.contains(coin) && !right.contains(coin)){
                            coinsToRemove.add(coin);
                        }
                    }
                    while(!coinsToRemove.isEmpty()){
                        badCoins.remove(coinsToRemove.poll());
                    }
                }
            }
            
            if(t != 0 ){System.out.println("");}
            
            if(badCoins.size() > 1){
                System.out.println("0");
            }
            else{
                for(Integer coin : badCoins){
                    System.out.println(coin);
                }
            }
        }
    }
}
