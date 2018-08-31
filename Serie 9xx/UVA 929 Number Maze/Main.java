import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = new int[] {-1,0,1,0};
	public static int[] dy = new int[] {0,-1,0,1};
	
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

	
	public static void main(String[] args) {

		FastReader s = new FastReader();
		PrintWriter pr = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)));
		int cases = s.nextInt();
		for(int ca = 0; ca < cases; ca++) {
			int n = s.nextInt();
			int m = s.nextInt();
			int[][] costs = new int[n][m];
			int[][] dj = new int[n][m];
//			boolean[][] visited = new boolean[n][m];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					costs[i][j] =  s.nextInt();
					dj[i][j] = Integer.MAX_VALUE;
				}
			}
			dj[0][0] = costs[0][0];
			pq.offer(new Node(0, 0, dj[0][0]));
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				if(node.r == n -1 && node.c == m -1) {
					pr.println(dj[node.r][node.c]);
					break;
				}//else if(!visited[node.r][node.c]) {
//					visited[node.r][node.c] = true;
					for(int i = 0; i < 4; i++) {
						int y = node.r + dy[i];
						int x = node.c + dx[i];
						if(y >= 0 && y < n && x >= 0 && x < m && node.cost + costs[y][x] < dj[y][x]) {
							dj[y][x] = node.cost+costs[y][x];
							pq.add(new Node(y, x, dj[y][x]));
						}
					}
//				}
				
			}
		}
		pr.close();
	}

}
class Node implements Comparable<Node>{
	int r, c, cost;
	public Node(int r, int c, int cost) {
		this.r = r;
		this.c = c;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node o) {
		return this.cost-o.cost;
	}
	
}