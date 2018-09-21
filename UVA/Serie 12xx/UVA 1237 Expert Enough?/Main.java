import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * Author Miguel Frade Flores
 * Technique: Brute Force
 * COmments, input is not to big, query size can be solve with brute force.
 * 
 * */

public class Main {

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int tc = fr.nextInt();
		while(tc-->0) {
			int D = fr.nextInt();
			String names [] = new String[D];
			int l [] =new int [D];
			int h []= new int [D];
			for(int i=0;i<D;i++) {
				names[i]=fr.next();
				l[i]=fr.nextInt();
				h[i]=fr.nextInt();
			}
			
			
			int q = fr.nextInt();		
			
			for(int i=0;i<q;i++) {
				int c=0;
				StringBuilder sb = new StringBuilder();
				int p =fr.nextInt();
				for(int j=0;j<D;j++) {
					if(p>=l[j] && p<=h[j]) {
						c++;
						if(c>1) {
							break;
						}
						sb.append(names[j]);
					}
				}	
				
				if(c==1) {
					pr.println(sb);
				}else {
					pr.println("UNDETERMINED");
				}
				
			}
			if(tc!=0) {
				pr.println();
			}
		}
		pr.close();
		
	}
	static class FastReader{
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
      //  	System.setIn(new FileInputStream("src/tests.txt"));
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
}
