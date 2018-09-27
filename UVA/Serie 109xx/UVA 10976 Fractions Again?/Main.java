import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

/*
 * @Author Miguel Frade
 * 
 * Hint iterate from k+1 to k*2
 * Complete Search
 * */

public class Main {

	public static void main(String[] args)throws IOException {
		System.setIn(new FileInputStream("src/tests.txt"));
		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String a;
		Vector<Pair> res = new Vector<>();
		
		while( (a=fr.nextLine())!=null ) {
			res.clear();
			long k = Integer.parseInt(a);
			StringBuilder sb = new StringBuilder();
			int count = 0;
			long x,y;
			y= k+1;
			x=k*2;
//			while(y>k) {
//				long aux = k*x;
//				long aux2 = x-k;
//				y=aux/aux2;
//				if(aux%aux2==0) {
//					count++;
//					res.add(new Pair(x, y));
//				}
//				x++;
//			}
			
			for(y = k+1;y<=k*2;y++) {
				long aux = k*y;
				long aux2 = y-k;
				x = aux/aux2;
				if(aux%aux2==0) {
					count++;
					res.add(new Pair(x, y));
				}
			}
			
			for(int i=0;i<res.size();i++) {
				sb.append("1/"+k+" = 1/"+res.get(i).a+" + 1/"+res.get(i).b+"");
				if(i!=res.size()-1) {
					sb.append("\n");
				}
			}
			
			pr.println(count);
			pr.println(sb);
		}
		pr.close();
		
	}
	static class FastReader{
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
        	br = new BufferedReader(new InputStreamReader(System.in));
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
	static class Pair{
		long a;
		long b;
		Pair(long a, long b){
			this.a=a;
			this.b=b;
		}
		
	}
}
