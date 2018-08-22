import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
public class Main {

	public static int l, c;
	public static int a[];
	public static int mat[][];	
	
	public static int calc(int left, int right) {
		if (left +1 == right) 
			return 0;
		if( mat[left][right]!=-1 )
			return mat[left][right];
		
		int res = Integer.MAX_VALUE;
		for(int i =left+1; i< right;i++ ) {
			res = Math.min(res, calc(left, i) + calc(i, right) +a[right] -a [left] );
		}
		
		return mat[left][right] = res;
	}
	
	public static void main(String[] args) throws IOException {

	//	System.setIn(new FileInputStream("src/tests.txt"));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			l = sc.nextInt();
			if(l==0)break;
			c = sc.nextInt();
			a = new int [c+2];
			a[0]=0;
			a[c+1]=l;
			for(int i =1; i<=c;i++) {
				a[i] = sc.nextInt();
			}
			mat = new int[c+2][c+2];
			for (int[] row : mat)
				Arrays.fill(row,-1);
			
			int res = calc(0,c+1);
			System.out.println("The minimum cutting is "+res+".");
		}
	}

}
