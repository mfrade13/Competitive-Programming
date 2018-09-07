// Don't place your source in a package
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Please name your class Main
class pairs {
	public static void main (String[] args) throws  IOException {
	    Scanner sc = new Scanner(System.in);
	    FastReader fr = new FastReader();
	    int n = fr.nextInt();
//        int r [] = new int[n];
        long mods [] = new long[3];
        for(int i=0;i<n;i++){
            int f=fr.nextInt();
            if(f%3==0)
                mods[0]++;
            else if(f%3==1)
                mods[1]++;
            else
                mods[2]++;
        }
        long cont=0;
        cont+= (mods[1]*mods[2]);
        if(mods[0]>1 ){
            for(int i =1;i<mods[0];i++){
                cont+=i;
            }
        }
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         if( (r[i]+r[j])%3==0 )cont++;
        //     }
        // }
        System.out.println(cont);

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