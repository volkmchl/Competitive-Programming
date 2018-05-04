import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class UVa11503 {

	public static HashSet<String> people;
	public static HashMap<String, Integer> map;
	public static ArrayList<Integer> cliqueSize;

	public static ArrayList<Integer> parent;
	public static ArrayList<Integer> rank;


	public static void addPerson(String a){
		map.put(a, people.size());
		parent.add(people.size());
		people.add(a);
		rank.add(0);
		cliqueSize.add(1);
	}

	public static int find(int a){
		if (parent.get(a) == a) return a;

		int par = find(parent.get(a));
		parent.set(a,par);
		return par;
		
	}

	public static int union(int a, int b){
		int rA = find(a);
		int rB = find(b);

		if(rA == rB){
			return cliqueSize.get(rA);
		}

		if(rank.get(rA) > rank.get(rB)){
			parent.set(rB,rA);
			cliqueSize.set(rA, cliqueSize.get(rA) + cliqueSize.get(rB));
			cliqueSize.set(rB, 0);
		}
		else{
			parent.set(rA, rB);
			cliqueSize.set(rB, cliqueSize.get(rB) + cliqueSize.get(rA));
			cliqueSize.set(rA, 0);
		}

		if(rank.get(rA) == rank.get(rB)){
			rank.set(rB, rank.get(rB) + 1);
		}

		return(cliqueSize.get(parent.get(rA)));

	}

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while(T --> 0){

			people = new HashSet<String>();
			map = new HashMap<String, Integer>();
			cliqueSize = new ArrayList<Integer>();
			parent = new ArrayList<Integer>();
			rank = new ArrayList<Integer>();

			int F = sc.nextInt();
			while(F --> 0){
				String a = sc.next();
				String b = sc.next();



				if(!people.contains(a)) addPerson(a);
				if(!people.contains(b)) addPerson(b);

				int mapA = map.get(a);
				int mapB = map.get(b);

				System.out.println(union(mapA,mapB));

			}
		}
	}
}

