import java.util.Scanner;
import java.util.TreeSet;
public class Main {

	static String createRanges(TreeSet<Integer> v) {
		StringBuilder sb = new StringBuilder();
		int x [] = new int [v.size()];
		int i =0;
		for (Integer a : v ) {
			x[i]=a;
			i++;
		}
		
		for (int a =0,c=0;a<x.length;a++) {
			if( a+1<x.length && x[a]+1==x[a+1] ) {
				c++;
			}else {
				if(c==0) {
					sb.append(x[a] + ", ");
				}else {
					sb.append( ((x[a])-c) +"-"+(x[a]) +", "   );
					c=0;
				}
			}
		}
		
		return sb.toString().substring(0, sb.length()-2);
	}
	
	
	static double fmod(double a, int b) {
		double res;
		int as = (int)a;
		int a2 = as/ b;

		
		res = a - (b*a2);
		
		return res;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c=1;
		while(sc.hasNext()) {
			int n = sc.nextInt();
			if (n==-1) break;
			double dist[] = new double[n];
			int g[] = new int [n];
			int y[] = new int [n];
			int r[] = new int [n];
			int mod[] = new int[n];
			int all[]= new int[n];
			for (int i =0; i<n;i++) {
				dist[i]=sc.nextDouble();
				g[i] = sc .nextInt();
				y[i] = sc.nextInt();
				r[i] = sc.nextInt();
				mod[i] = g[i]+y[i]+r[i];
				all[i] = g[i]+y[i];	
			}
			
			TreeSet<Integer> res = new TreeSet<>();
			for (int i = 30;i<=60;i++) {
				boolean can=true;
				for (int j =0;j<n;j++) {
					
					double d =  dist[j]*3600/i;
//					double in =  (int) (((d)) % mod[j]);
					double in = fmod(d, mod[j]);
		//			System.out.println("vel " + i + " " + d + " " + in );
					if(in>all[j]) {
						can=false;
						break;
					}
				}
				if (can) {
					res.add(i);
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("Case "+c+": ");
			if (res.size()==0)
				sb.append("No acceptable speeds.");
			else
				sb.append(createRanges(res));
			
			
			System.out.println(sb);
			c++;
		}
		
	}

}
