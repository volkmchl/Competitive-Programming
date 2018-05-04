import java.util.*;

public class greetingcard {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int coords = sc.nextInt();

        ArrayList<Point> points = new ArrayList<>();
        HashSet<String> pointSet = new HashSet<>();

        for (int currCoord = 0; currCoord < coords; currCoord++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            points.add(new Point(x, y));
            pointSet.add(x + "" + y);
        }

        int total = 0;
        HashSet<Point> snappingSpots = getSnappingPoints();
        for (Point point : points) {
            for (Point snappingSpot : snappingSpots) {
                int snapingX = point.x + snappingSpot.x;
                int snapingY = point.y + snappingSpot.y;

                if (pointSet.contains(snapingX + "" + snapingY)) {
                    total++;
                }
            }
        }

        System.out.println(total / 2);
    }

    private static HashSet<Point> getSnappingPoints() {
        HashSet<Point> result = new HashSet<>();

        int r = 2018;

        for (int x = -1 * r; x <= r; x++) {
            double y = Math.sqrt(Math.pow(r, 2) - Math.pow(x, 2));

            if (y % 1 == 0) {
                result.add(new Point(x, (int) y));

                if (y != 0){
                    result.add(new Point(x, (int) (-1 * y)));
				}
            }
        }

        return result;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
