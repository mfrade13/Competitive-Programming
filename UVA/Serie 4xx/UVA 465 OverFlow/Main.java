	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static class FastReader{
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
	public static void main(String[] args) {

		FastReader fr = new FastReader();
		String ln;
		BigInteger max = BigInteger.valueOf(Integer.MAX_VALUE);
		while((ln=fr.nextLine())!=null ) {
			String exp[]=ln.split(" ");
			BigInteger a = new BigInteger(exp[0]);
			
			BigInteger b = new BigInteger(exp[2]);
			
			BigInteger res;
			if(exp[1].equals("+")) {
				res = a.add(b);
			}else  {
				res = a.multiply(b);
			}
			
			System.out.println(ln);
			
			if(a.compareTo(max)>0 ) {
				System.out.println("first number too big");
			}
			if(b.compareTo(max)>0 ) {
				System.out.println("second number too big");
			}
			if(res.compareTo(max)>0 ) {
				System.out.println("result too big");
			}
			
			
			
		}
		
	}

}
