import java.util.Scanner;

/*
 * @Author: Miguel Frade FLores
 * 
 * Problem URL https://csacademy.com/ieeextreme-practice/task/ed8629419f140a5a2c923b049aba1224/
 * Basic KnapSack Problem
 */

public class beetlebag {

	  private static final int MAX_N = 201; //Max value for items according to input 
 	  private static final int MAX_W = 501; // Max value for capacity or Weight.
	  private static int N,c;
	  private static int[] V = new int[MAX_N],S = new int[MAX_N];
	  private static int[][] memo = new int[MAX_N][MAX_W];

	  private static int value(int id, int w) {
		    if (id == N || w == 0) return 0;
		    if (memo[id][w] != -1) return memo[id][w];
		    if (S[id] > w)         return memo[id][w] = value(id + 1, w);
		    return memo[id][w] = Math.max(value(id + 1, w), V[id] + value(id + 1, w - S[id]));
		  }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		while(sc.hasNext()) {
			t= sc.nextInt();
			while(t-->0) {
				for(int i =0;i<MAX_N;i++) 
					for(int j=0;j<MAX_W;j++)
						memo[i][j]=-1;

				c = sc.nextInt();
				N =sc.nextInt();
				for (int i=0;i<N;i++) {
					S[i]=sc.nextInt();
					V[i]=sc.nextInt();
				}
				int res = value(0, c);
				System.out.println(res);			
			}
		}
	}
}
