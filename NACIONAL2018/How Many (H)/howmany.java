import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class howmany {

	public static void main(String[] args) {

		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		double l5 = Math.log10(5);		
		double l2 = Math.log10(2);		
		
			int n =fr.nextInt();
			while(n-->0){
				int a = fr.nextInt();
				int b = fr.nextInt();
				int cc=0;
				int min = Math.min(a, b);
				cc+=min;
				if(a>=b){
					int dif=a-b;
					int val = (int) Math.floor(dif*l2) +1 ;
					cc+=val;
				}else{
					int dif=b-a;
					int res = (int) Math.floor( dif*l5 )+1;
					cc+=res;
				}
				pr.println(cc);
			}
			pr.close();
		}
		
	}
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

int read() {
    int n=0;
    try {
      n= br.read();
    }catch (IOException e) {
       e.printStackTrace();
     }
    return n;
	}
}

