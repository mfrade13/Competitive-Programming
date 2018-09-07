import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class Main {

	public static void main(String args[]) throws IOException{
//		System.setIn(new FileInputStream("src/tests.txt"));
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int tc=sc.nextInt();
			while(tc-->0) {
				int k = sc.nextInt();
				int mat [][] = new int [k][k];
				int f[] = new int[k];
				int r[] = new int [k];
				for(int i = 0;i<k;i++) {
					f[i]=sc.nextInt();
				}
				for(int i = 0;i<k;i++) {
					r[i]=sc.nextInt();
				}
				
				int m =0;
				for(int i=0;i<k;i++) {
					for (int j=0;j<k;j++) {
							mat[i][k-1-j]+=Math.min(r[j],f[i]);
							m+=mat[i][k-1-j];
					}
				}
				
				Arrays.sort(f);
				Arrays.sort(r);
				int n=0;
				for(int i=0;i<k;i++) {
					for (int j=0;j<k;j++) {
						if(r[j]==f[i]) {
							n+=r[j];
							r[j]=0;
							f[i]=0;
							break;
						}
					}
				}
				for(int i=0;i<k;i++) {
					n+=r[i]+f[i];
				}

				int mn=m-n;
				System.out.println("Matty needs at least "+n+" blocks, and can add at most "+mn+" extra blocks.");
			}
		}
		
	}
	
}
