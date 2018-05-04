import java.util.*;

public class UVa394{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int R = sc.nextInt();

		Map<String, Integer[]> arr = new HashMap<String, Integer[]>();

		for(int n = 0; n < N; n++){
			String name = sc.next();
			int B = sc.nextInt();
			int Cd = sc.nextInt();
			int D = sc.nextInt();
			int lowBound[] = new int[D+1];
			int highBound[] = new int[D+1];
			for(int d = 1; d <= D; d++){
				lowBound[d] = sc.nextInt();
				highBound[d] = sc.nextInt();
			}

			Stack<Integer> stack = new Stack<Integer>();
			stack.add(Cd);
			int magic = Cd*lowBound[D];
			for(int i = D-1; i >= 1; i--){
				int Ci = stack.peek()*(highBound[i+1]-lowBound[i+1]+1);
				magic += Ci*lowBound[i];
				stack.add(Ci);
			}
			int C0 = B - magic;
			stack.add(C0);

			Integer[] ref = new Integer[stack.size()];
			int index = 0;
			while(!stack.isEmpty()){
				ref[index++] = stack.pop();
			}

			arr.put(name, ref);
		}

		for(int r = 0; r < R; r++){
			String name = sc.next();
			int[] ind = new int[arr.get(name).length-1];
			for(int i = 0; i < arr.get(name).length-1; i++){
				ind[i] = sc.nextInt();
			}

			Integer[] ref = arr.get(name);
			int physical = ref[0];
			
			for(int i = 0; i < ind.length; i++){
				physical += ind[i]*ref[i+1];
			}

			System.out.print(name + "[");
			for(int i = 0; i < ind.length; i++){
				if(i == ind.length-1){
					System.out.print(ind[i]);
				}
				else{
					System.out.print(ind[i] + ", ");
				}
			}
			
			System.out.println("] = " + physical);

		}
	}
}
