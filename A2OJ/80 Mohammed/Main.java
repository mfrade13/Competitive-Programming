import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;
/*
 * @Author Miguel Frade
 * 
 * Use Dijkstra
 * 
 * 
 * */
public class Main {
  public static final int INF = 1000000000;
  private static Vector< Vector< IntegerPair > > AdjList = new Vector< Vector< IntegerPair > >();
	
	public static void main(String[] args) {

		int v,u,w;
		
		FastReader sc = new FastReader();
				
		
			int c = sc.nextInt();
			
			for (int k =1;k<=c;k++) {
			
			int V = sc.nextInt();	
			int E = sc.nextInt();
			
		    AdjList.clear();
		    for (int i = 0; i < V; i++) {
		      Vector< IntegerPair > Neighbor = 
		        new Vector < IntegerPair >();
		      AdjList.add(Neighbor); // add neighbor list to Adjacency List
		    }
		    	    
		    for (int i = 0; i < E; i++) {
		        u = sc.nextInt()-1;
		        v = sc.nextInt()-1;
		        w = sc.nextInt();
		        AdjList.get(u).add(new IntegerPair (v, w)); // first time using weight
		        AdjList.get(v).add(new IntegerPair (u, w)); // first time using weight
		        
		      }
			
		    int o =sc.nextInt()-1;
		    int f = sc.nextInt()-1;
		    
		    Vector < Integer > dist = new Vector < Integer > ();
		    dist.addAll(Collections.nCopies(V, INF)); dist.set(o, 0); // INF = 1*10^9 not MAX_INT to avoid overflow
		    PriorityQueue < IntegerPair > pq = new PriorityQueue<>(new Comparator<IntegerPair>() { // overriding the compare method 
		        public int compare(IntegerPair i, IntegerPair j) {
		            return i.first() - j.first();
		          }
		        });
		    
		    pq.offer(new IntegerPair (0, o));
		    while (!pq.isEmpty()) { // main loop
		        IntegerPair top = pq.poll(); // greedy: pick shortest unvisited vertex
		        int d = top.first(); u = top.second();
		        if (d > dist.get(u)) continue; // This check is important! We want to process vertex u only once but we can
		        Iterator it = AdjList.get(u).iterator();
		        while (it.hasNext()) { // all outgoing edges from u
		          IntegerPair p = (IntegerPair) it.next();
		          v = p.first();
		          int weight_u_v = p.second();
		          if (dist.get(u) + weight_u_v < dist.get(v)) { // if can relax      (note: Record SP spanning tree)
		            dist.set(v, dist.get(u) + weight_u_v); // relax                  (here if needed. This is similar)
		            pq.offer(new IntegerPair(dist.get(v), v)); //      (as printpath in BFS)
		            // enqueue this neighbor regardless whether it is already in pq or not    
		      } } }
		    
		      System.out.println("Case "+k+": " + dist.get(f));
		}
		
		
	}
	
	static class IntegerPair implements Comparable {
		  Integer _first, _second;

		  public IntegerPair(Integer f, Integer s) {
		    _first = f;
		    _second = s;
		  }

		  public int compareTo(Object o) {
			  
		    if (!(this.first()==((IntegerPair)o).first()))
		      return this.first() - ((IntegerPair)o).first();
		    else
		      return this.second() - ((IntegerPair)o).second();
		  }

		  Integer first() { return this._first; }
		  Integer second() { return this._second; }
		}

	static class FastReader{
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
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
