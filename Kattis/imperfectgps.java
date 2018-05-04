import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

class imperfectgps {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int pos = sc.nextInt();
        int interval = sc.nextInt();

        ArrayList<Point> actualPoints = new ArrayList<>(pos);
        ArrayList<Point> gpsPoints = new ArrayList<>();

        Point start = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());

        actualPoints.add(start);
        gpsPoints.add(start);

        double actualDistance = 0;
        double computDistance = 0;

        for (int i = 1; i < pos; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int nextTime = sc.nextInt();
            actualPoints.add(new Point(X, Y, nextTime));


            Point previousComputed = (gpsPoints.size() == 1) ? gpsPoints.get(0) : gpsPoints.get(gpsPoints.size() - 1);
            for (int time = previousComputed.time + interval; time <= nextTime; time += interval) {

                Point prevACTPoint = actualPoints.get(i - 1);
                Point currACTPoint = actualPoints.get(i);

                double dACTX = currACTPoint.x - prevACTPoint.x;
                double dACTY = currACTPoint.y - prevACTPoint.y;
                double dACTT = currACTPoint.time - prevACTPoint.time;

                double dACTXPERTIME = dACTX / dACTT;
                double dACTYPERTIME = dACTY / dACTT;

                double compX = dACTXPERTIME * (time - prevACTPoint.time) + prevACTPoint.x;
                double compY = dACTYPERTIME * (time - prevACTPoint.time) + prevACTPoint.y;

                gpsPoints.add(new Point(compX, compY, time));


            }

            if(i == pos-1){
                gpsPoints.add(new Point(X,Y,nextTime));
            }


            actualDistance += actualPoints.get(i).distanceTo(actualPoints.get(i - 1));
        }

        for (int i = 1; i < gpsPoints.size(); i++) {
            //System.out.println(gpsPoints.get(i - 1).x + " " + gpsPoints.get(i - 1).y);
            computDistance += gpsPoints.get(i).distanceTo(gpsPoints.get(i - 1));
        }

        System.out.println(Math.abs(computDistance-actualDistance)/actualDistance * 100);

    }

    public static class Point {
        double x, y;
        int time;

        Point(double x, double y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public double distanceTo(Point other) {
            return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() {
            this(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}

