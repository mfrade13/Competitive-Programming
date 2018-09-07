	import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;

public class Main {

	static class FastReader{
	        BufferedReader br;
	        StringTokenizer st;
	 
	        public FastReader() throws IOException{
	        	System.setIn(new FileInputStream("src/tests.txt"));
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
	public static void main(String[] args) throws IOException{

		FastReader fr = new FastReader();
		int x = 0;
		int cont=0;
		int tc=0;
		String l;
		StringBuilder sb = new StringBuilder();
		while((l=fr.nextLine())!=null) {
			if(l.isEmpty()) {
				System.out.print(sb);
				sb= new StringBuilder();
				if(tc>=0)System.out.println();
				tc++;
				x=0;
				cont=0;
			}
			if(x>0 && !l.isEmpty()) sb.append("\n");
			for (int i = 0;i<l.length();i++) {
				char aux = l.charAt(i);
				if(aux=='!') {
					sb.append("\n");
				}else if(aux=='b') {
					for(int n=0;n<cont;n++) {
						sb.append(" ");
					}
					cont=0;
				}else if(aux>='0' && aux<='9') {
					cont += (aux -'0');
				}else if((aux>='A' && aux<='Z')|| aux=='*' ){
					for(int n=0;n<cont;n++) {
						sb.append(aux);
					}
					cont=0;
				}
			}
				x++;
		}
		if(sb.length()>0)
			System.out.print(sb);
	}

}
