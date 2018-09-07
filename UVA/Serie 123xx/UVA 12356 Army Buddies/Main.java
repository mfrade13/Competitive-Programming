import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
class Main {

	public static void main(String [] args) throws IOException{
	//	System.setIn(new FileInputStream("src/tests.txt"));
	//	Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		String ln;
		int n,q,a,b,l,r;
		int le [],der[];
		while((ln=br.readLine())!=null) {
			if(ln.charAt(0)=='0') break;;
			String res []= ln.split(" ");
			n = Integer.parseInt(res[0]);
			q = Integer.parseInt(res[1]);
			le = new int[n+2];
			der = new int [n+2];
			for(int i=0;i<=n;i++) {
				le[i+1]=i;
				der[i]=i+1;
			}
			der[n]=-1;
			le[1] =-1;

			while(q-->0) {
				String nums []= br.readLine().split(" ");
				a = Integer.parseInt(nums[0]); 
				b = Integer.parseInt(nums[1]);
				l  = le[a];
				r = der[b];
				StringBuilder sb = new StringBuilder();
				
				if (l ==-1)
					sb.append("*");
				else {
					sb.append(l);
					der[l]=r;
				}
				sb.append(" ");
				if (r ==-1) {
					sb.append("*");
				}
				else {
					sb.append(r);
					le[r]=l;
				}
				pr.println(sb);
			}
			pr.println("-");
		}
		pr.close();
	}
}
