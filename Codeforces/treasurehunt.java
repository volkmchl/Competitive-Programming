import java.io.DataInputStream;
import java.io.InputStream;

//prob id: 979B

public class treasurehunt{
	public static void main(String[] args) throws Exception{
		Parser ps = new Parser(System.in);

		int n = ps.nextInt();
		String[] ribbons = new String[3];

		for(int i = 0; i < 3; i++){
			ribbons[i] = ps.next();
		}


		int[][] charOccurence = new int[3][256];
		int[] maxOccurence = new int[3];

		int maxOverall = 0;
		int maxLocation = 0;

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < ribbons[0].length(); j++){
				charOccurence[i][ribbons[i].charAt(j)]++;
				maxOccurence[i] = Math.max(charOccurence[i][ribbons[i].charAt(j)], maxOccurence[i]);
			}

			if(maxOccurence[i] == ribbons[0].length() && n == 1){
				maxOccurence[i]--;
			}
			else{
				maxOccurence[i] = Math.min(ribbons[0].length(), maxOccurence[i] + Math.min(ribbons[0].length() - maxOccurence[i], n));
			}

			if(maxOverall < maxOccurence[i]) {
				maxOverall = maxOccurence[i];
				maxLocation = i;
			}
		}

		boolean draw = false;
		for(int i = 0; i < 3; i++) {
			if (maxOccurence[i] == maxOverall && i != maxLocation) {
				draw = true;
			}
		}

		if(draw){
			System.out.println("Draw");
		}
		else{
			if(maxLocation == 0){
				System.out.println("Kuro");
			}
			else if(maxLocation == 1){
				System.out.println("Shiro");
			}
			else if(maxLocation == 2){
				System.out.println("Katie");
			}
		}

	}

	static class Parser
	{
		final private int BUFFER_SIZE = 1 << 16;

		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Parser(InputStream in)
		{
			din = new DataInputStream(in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public long nextLong() throws Exception
		{
			long ret = 0;
			byte c = read();
			while (c <= ' ') c = read();
			boolean neg = c == '-';
			if (neg) c = read();
			do
			{
				ret = ret * 10 + c - '0';
				c = read();
			} while (c > ' ');
			if (neg) return -ret;
			return ret;
		}

		//reads in the next string
		public String next() throws Exception
		{
			StringBuilder ret =  new StringBuilder();
			byte c = read();
			while (c <= ' ') c = read();
			do
			{
				ret = ret.append((char)c);
				c = read();
			} while (c > ' ');
			return ret.toString();
		}

		public int nextInt() throws Exception
		{
			int ret = 0;
			byte c = read();
			while (c <= ' ') c = read();
			boolean neg = c == '-';
			if (neg) c = read();
			do
			{
				ret = ret * 10 + c - '0';
				c = read();
			} while (c > ' ');
			if (neg) return -ret;
			return ret;
		}

		private void fillBuffer() throws Exception
		{
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1) buffer[0] = -1;
		}

		private byte read() throws Exception
		{
			if (bufferPointer == bytesRead) fillBuffer();
			return buffer[bufferPointer++];
		}
	}
}
