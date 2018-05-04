import java.util.*;

public class UVa920{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 0; t < T; t++){

            PriorityQueue<Point> points = new PriorityQueue<Point>();
            int pts = sc.nextInt();
            for(int pt = 0; pt < pts; pt++){
                points.add(new Point(sc.nextDouble(), sc.nextDouble()));
            }

            double totalDistance = 0;

            Point rightLow = points.poll();
            Point high = points.poll();
            totalDistance += high.distanceTo(rightLow);
            
            while(points.size() > 1){
                rightLow = points.poll();
                Point highBuffer = points.poll();

                if(highBuffer.y > high.y){
                    double slope = (rightLow.y-highBuffer.y)/(rightLow.x-highBuffer.x);
                    double b = highBuffer.y-slope*highBuffer.x;
                    double newX = (high.y - b)/slope;
                    totalDistance += highBuffer.distanceTo(new Point(newX, high.y));
                    high = new Point(newX, highBuffer.y);
                }
            }

            System.out.printf("%.2f\n",totalDistance);
        }
    }
}

class Point implements Comparable<Point>{
    double x,y;

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other){
        return Math.sqrt(Math.pow(this.x-other.x,2)+Math.pow(this.y-other.y,2));
    }

    @Override
    public int compareTo(Point other){
        if(this.x > other.x) return -1;
        return 1;
    }
}
