import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 * @author: Miguel Frade FLores
 * Topics: BigInteger
 * String manipulation -- String Buffer very useful.
 * */

public class Main {

	public static void main(String[] args) {

		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int tc = fr.nextInt();
		
		while(tc-->0) {
			String ln[]= fr.nextLine().split(" ");
			StringBuffer sb = new StringBuffer(ln[0]);
			BigInteger b1 = new BigInteger(sb.reverse().toString());
			StringBuffer sb2 = new StringBuffer(ln[1]);
			BigInteger b2 = new BigInteger(sb2.reverse().toString());
			BigInteger res = new BigInteger(new StringBuffer(b1.add(b2).toString()).reverse().toString());
			pr.println(res);
		}
		pr.close();
		
	}
	
	static 
class FastReader{
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt(){
            return Integer.parseInt(next());
        }
 
        long nextLong(){
            return Long.parseLong(next());
        }
 
        double nextDouble(){
            return Double.parseDouble(next());
        }
 
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
