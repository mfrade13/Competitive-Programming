import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static class FastReader{
	    static BufferedReader br= new BufferedReader(new
		         InputStreamReader(System.in));;
	    static StringTokenizer st;

	    static String next(){
	        while (st == null || !st.hasMoreElements()){
	            try{
	                st = new StringTokenizer(br.readLine());
	            }catch (IOException  e){
	                e.printStackTrace();
	            }
	        }
	        return st.nextToken();
	    }

	    static int nextInt(){
	        return Integer.parseInt(next());
	    }
	   
	    static long nextLong(){
	        return Long.parseLong(next());
	    }

	    static double nextDouble(){
	        return Double.parseDouble(next());
	    }

	    static String nextLine(){
	        String str = "";
	        try{
	            str = br.readLine();
	        }catch (IOException e){
	            e.printStackTrace();
	        }
	        return str;
	    }
	    static int read() {
	    	int n=0;
	    	try {
				n= br.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	return n;
	    }
	}

	
	public static void main(String[] args)  {

		
		int n = FastReader.nextInt();
		while(n-->0) {
			int c = FastReader.nextInt();
			HashMap<Byte, Integer> hm = new HashMap<>();
			for(int i = 0;i<255;i++) {
				hm.put((byte)i,0);
			}
			
			while(c-->0) {
				String l [] = FastReader.nextLine().split(" ");
				hm.put((byte) l[0].charAt(0),Integer.parseInt( l[1]));
			}
			int m = FastReader.nextInt();
			double p = 0;
			byte x;
			while(m-->0) {
                while ((x = (byte) FastReader.read()) != '\n') {
                    p += hm.get(x);
                }
			}

			System.out.printf("%.2f$\n",p/100);
			
		}
	}

}



