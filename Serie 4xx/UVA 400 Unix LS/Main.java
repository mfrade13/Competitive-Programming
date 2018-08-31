import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class FastReader{
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()  {
     //   	System.setIn(new FileInputStream("src/tests.txt"));
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
	
	public static String fillSpaces(int n) {
		StringBuilder sb = new StringBuilder();
		while(n-->0) {
			sb.append(" "); 
		}
		return sb.toString();
	}
	
	public static void main(String[] args){

		FastReader fr = new FastReader();
		String x;
		while((x= fr.nextLine())!=null) {
			int n = Integer.parseInt(x);
			String names [] = new String[n];
			int maxL=0;
			for(int i = 0;i<n;i++) {
				names[i]=fr.next();
				maxL = names[i].length()>maxL? names[i].length():maxL;
			}
			
			int columns =  maxL==60?1: 60 / (maxL+2);
			Arrays.sort(names);
			int nextInit = maxL+2;
			
			int r = names.length/columns;
			r = names.length%columns==0? r: r+1;
			
			StringBuilder res = new StringBuilder();
			int d =60;
			while(d-->0) {
				res.append("-");
			}
			res.append("\n");
			
			for(int i=0;i<r;i++) {
				StringBuilder aux = new StringBuilder();
				for (int j= i;j<names.length;j+=r) {
					aux.append(names[j]);
					if(aux.length()+nextInit<60)
					aux.append(fillSpaces((nextInit-names[j].length())));
				}
				aux.append(fillSpaces(60-aux.length()));
				res.append(aux);
				res.append("\n");
			}
			System.out.print(res);
		}
	}

}
