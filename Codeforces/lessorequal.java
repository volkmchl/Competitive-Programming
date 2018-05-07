import java.util.*;

// prob id: 977C 

public class lessorequal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<Integer, Integer> occurences = new TreeMap<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            occurences.put(num, occurences.getOrDefault(num, 0) + 1);
        }


        List<Integer> keys = new ArrayList<>(occurences.keySet());

        if (keys.get(0) == 1 && k == 0) {
            System.out.println("-1");
        } else if (keys.get(0) != 1 && k == 0) {
            System.out.println("1");
        } else {
            int totalOccurences = 0;
            int currentIndex = 0;
            while (totalOccurences < k && currentIndex < keys.size()) {
                totalOccurences += occurences.get(keys.get(currentIndex++));
            }

            if (totalOccurences != k) {
                System.out.println("-1");
            } else {
                System.out.println(keys.get(currentIndex - 1));
            }

        }
    }
}
