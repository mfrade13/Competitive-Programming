/*
 * @Author: Miguel Frade
 * 
 * Use: Apply reminder theory to avoid overflow; 
 * 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	static int ones [] =new int[10001]; 
	static void fill() {
		ones[1]=1;
		for(int i=3;i<10001;i+=2) {
			if(i%5!=0) {
				int d =1;
				long base=1;
				while(base%i!=0) {
					base = (base*10 +1)%i;
					d++;
				}
				
				ones[i]=d;
			}
		}
	}
	
	public static void main(String[] args) {

		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String l;
		fill();

		while((l=fr.nextLine())!=null) {
			int d = Integer.parseInt(l);
			System.out.println(ones[d] );
		}
		
	}
	static class FastReader{
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
      //  	System.setIn(new FileInputStream("src/tests.txt"));
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
