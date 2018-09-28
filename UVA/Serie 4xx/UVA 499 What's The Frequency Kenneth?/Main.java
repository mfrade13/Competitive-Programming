import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
/*
 * @Author Miguel Frade
 * Use a Map to store the values with more frequency
 * 
 */
public class Main {

	public static void main(String[] args)throws IOException {
	//	System.setIn(new FileInputStream("src/tests.txt"));
		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out))); 
		String ln ;
		while((ln=fr.nextLine())!=null ) {
			TreeMap<Character, Integer> tm = new TreeMap<>();
			char l [] =ln.toCharArray(); 
			int max=1;
			for (char i:l) {
				if((i>='A' && i<='Z') || (i>='a'&& i<='z'))
				if(tm.containsKey(i)) {
					int val = tm.get(i)+1;
					tm.put(i, val);
					if(val>max) max=val;
				}else {
					tm.put(i, 1);
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<26;i++) {
				char c = (char)(i+65);
	//			System.out.println(c);
				if(tm.containsKey(c)){
					if(tm.get(c)==max) {
						sb.append(c);
					}
				}
			}
			for(int i = 0;i<26;i++) {
				char c = (char)(i+'a');
				if(tm.containsKey(c)){
					if(tm.get(c)==max) {
						sb.append(c);
					}
				}
			}
			
			sb.append(" " + max);
			pr.println(sb);
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
