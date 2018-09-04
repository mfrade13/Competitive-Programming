import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class missing {

  public static final long INF = 1000000000;

  private static Vector< Vector< IntegerPair > > AdjList = new Vector< Vector< IntegerPair > >();
  
	public static void main(String[] args) {
		long v,u,w;
		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String l;
		while( (l=fr.nextLine())!=null ) {
			String r2[]=l.split(" ");
			int V = Integer.parseInt(r2[0]);	
			int E = Integer.parseInt(r2[1]);

		    AdjList.clear();

		    for (int i = 0; i < V; i++) {
		      Vector< IntegerPair > Neighbor =  new Vector < IntegerPair >();
		      AdjList.add(Neighbor); // add neighbor list to Adjacency List
		    }

		    int v1 = fr.nextInt();
		    int v2 = fr.nextInt();

		    for (int i = 0; i < E; i++) {
		        u = fr.nextInt()-1;
		        v = fr.nextInt()-1;
		        w = fr.nextInt();
		        AdjList.get((int) u).add(new IntegerPair (v, w));
		        AdjList.get((int) v).add(new IntegerPair (u, w));
		      }

		    int o =fr.nextInt()-1;
		    int f = fr.nextInt()-1;

		    Vector < Long > dist = new Vector < Long > ();
		    dist.addAll(Collections.nCopies(V, INF)); dist.set(o, (long) 0); // INF = 1*10^9 not MAX_INT to avoid overflow
		    PriorityQueue < IntegerPair > pq = new PriorityQueue<>(1,new Comparator<IntegerPair>() { // overriding the compare method 
		        public int compare(IntegerPair i, IntegerPair j) {
		            return (int) (i.first() - j.first());
		          }
		        });

		    pq.offer(new IntegerPair (0, o));
		    while (!pq.isEmpty()) { // main loop
		        IntegerPair top = pq.poll(); // greedy: pick shortest unvisited vertex
		        long d = top.first(); u = top.second();
		        if (d > dist.get((int) u)) continue; // This check is important! We want to process vertex u only once but we can
		        Iterator it = AdjList.get((int) u).iterator();
		        while (it.hasNext()) { // all outgoing edges from u
		          IntegerPair p = (IntegerPair) it.next();
		          v = p.first();
		          long weight_u_v = p.second();
		          if (dist.get((int) u) + weight_u_v < dist.get((int) v)) { // if can relax      (note: Record SP spanning tree)
		            dist.set((int) v, dist.get((int) u) + weight_u_v); // relax                  (here if needed. This is similar)
		            pq.offer(new IntegerPair(dist.get((int) v), v)); //         
		      } } }

		      double res = (double) dist.get(f)/(v1+v2);
		      pr.printf("%.2f\n",res);
		}
		pr.close();
	}
	
	static class IntegerPair implements Comparable {
		  long _first, _second;
		  public IntegerPair(long f, long s) {
		    _first = f;	    _second = s;
		  }

		  public int compareTo(Object o) {
		    if (!(this.first()==((IntegerPair)o).first()))
		      return (int) (this.first() - ((IntegerPair)o).first());
		    else
		      return (int) (this.second() - ((IntegerPair)o).second());
		  }
		  long first() { return this._first; }
		  long second() { return this._second; }
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