import java.util.*;

public class bank{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();
        PriorityQueue<Depositor> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            pq.add(new Depositor(sc.nextInt(), sc.nextInt()));
        }

        TreeSet<Integer> availableTimes = new TreeSet<>();
        for(int i = 0; i <= T; i++){
            availableTimes.add(i);
        }
        int cash = 0;
        while(!pq.isEmpty() && !availableTimes.isEmpty()){

            Depositor d = pq.poll();
            if(availableTimes.floor(d.T) != null){
                availableTimes.remove(availableTimes.floor(d.T));
                cash += d.cash;
            }
        }

        System.out.println(cash);
    }
}

class Depositor implements Comparable<Depositor>{
    int cash, T;

    public Depositor(int cash, int T){
        this.cash = cash;
        this.T = T;
    }
    
    public int compareTo(Depositor other){
        if(this.cash == other.cash) return other.T - this.T;
        return other.cash - this.cash;
    }

    public String toString(){
        return (cash + " " + T);
    }
}
