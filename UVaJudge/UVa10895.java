import java.util.*;
public class UVa10895 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			int R,C;
			R = in.nextInt();
			C = in.nextInt();
			Matrix m = new Matrix(R,C);
			in.nextLine();
			for(int i = 0; i < R; i++){
				int nonZero = in.nextInt();
				int col[] = new int[nonZero];

				for(int j = 0; j < nonZero; j++){
					col[j] = in.nextInt();
				}

				in.nextLine();
				for(int j = 0; j < nonZero; j++){
					m.addData(new Element(i+1,col[j],in.nextInt()));
				}
			}
			
			m.transpose();
			System.out.println(m.R + " " + m.C);
			for(int i = 0; i < m.R; i++){
				if(m.data.get(i).size() == 0){
					System.out.print(m.data.get(i).size());
				}
				else{
					System.out.print(m.data.get(i).size() + " ");
				}
				
				for(int j = 0; j<m.data.get(i).size(); j++){
					if(j == m.data.get(i).size()-1){
						System.out.print(m.data.get(i).get(j).c);
					}
					else{
						System.out.print(m.data.get(i).get(j).c + " ");
					}
				}
				
				
				System.out.println("");
				for(int j = 0; j<m.data.get(i).size(); j++){
					if(j == m.data.get(i).size()-1){
						System.out.print(m.data.get(i).get(j).value);
					}
					else{
						System.out.print(m.data.get(i).get(j).value + " ");
					}
				}
				System.out.println();
			}
			in.nextLine();
		}
	}
}

class Matrix{
	int R,C;
	ArrayList<ArrayList<Element>> data;

	Matrix(int R,int C){
		this.R = R;
		this.C = C;
		data = new ArrayList<ArrayList<Element>>();
		for(int i = 0; i < R; i++){
			data.add(new ArrayList<Element>());
		}
	}

	public void addData(Element d){
		data.get(d.r-1).add(d);
	}
	
	public void transpose(){
		ArrayList<ArrayList<Element>> newData = new ArrayList<ArrayList<Element>>();
		for(int i=0;i<C; i++){
			newData.add(new ArrayList<Element>());
		}
		
		for(int i = 0; i < R; i++){
			for(int j = 0; j < data.get(i).size(); j++){
				Element n = new Element(data.get(i).get(j).c,data.get(i).get(j).r,data.get(i).get(j).value);
				newData.get(data.get(i).get(j).c-1).add(n);
			}
		}
		this.data = newData;
		int temp = R;
		this.R = C;
		this.C = temp;
	}

	public String toString(){
		String out = "";
		for(int i = 0; i < R; i++){
			int nonZero = data.get(i).size();
			for(int j = 0; j < nonZero; j++){
				out += data.get(i).get(j).value + " ";
			}
			out += "\n";
		}
		return out;
	}
}

class Element{
	int r,c;
	int value;

	Element(int r, int c, int value){
		this.r = r;
		this.c = c;
		this.value = value;
	}
    
}
