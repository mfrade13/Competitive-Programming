import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("src/test.txt"));
		Scanner sc = new Scanner(System.in);
		int tc=1;
		while(sc.hasNext()) {
			int n ,m,c;
			n=sc.nextInt();
			m=sc.nextInt();
			c = sc.nextInt();
			if(n==0&& m==0 && c==0)break;
			
			boolean flags [] = new boolean[n];
			int vals [] = new int [n];
			for (int i =0;i<n;i++) {
				vals[i]=sc.nextInt();
			}
			int power=0,max=0;
			boolean up=false;
			for(int j=0;j<m;j++) {
				int ci = sc.nextInt() -1;
				if(flags[ci]) {
					flags[ci]=false;
					power-=vals[ci];
				}else {
					flags[ci]=true;
					power+=vals[ci];
					if(power >max) max=power;
					
					if(power>c) {
						up=true;
					}
				}
				
			}
			
			System.out.println("Sequence " + tc);
			if(up) {
				System.out.println("Fuse was blown.");
			}else {
				System.out.println("Fuse was not blown.");
				System.out.println("Maximal power consumption was " +max + " amperes.");
			}
			tc++;
			System.out.println();
			
		}
		
	}

}
