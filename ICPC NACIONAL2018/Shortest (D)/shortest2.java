import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;

public class shortest2 {
	  public static final int INF = 1000000000;
	  private static Vector<Vector<IntegerPair>> AdjList = new Vector< Vector< IntegerPair > >();
	  private static TreeMap<String, Integer> tm = new TreeMap<>(); 
	  public static void main(String[] args) {
		int v,u,w,V,E;
		FastReader fr = new FastReader();
		String ln;
		while( (ln = fr.nextLine())!=null ) {
			String m[]=ln.split(" ");
			V = Integer.parseInt(m[0]);
			E = Integer.parseInt(m[1]);
		    AdjList.clear();
		    tm.clear();
		    for (int i = 0; i < V; i++) {
		      Vector< IntegerPair > Neighbor = 
		        new Vector < IntegerPair >();
		      AdjList.add(Neighbor); // add neighbor list to Adjacency List
		    }	
		    for(int i=0;i<E;i++) {
		    	u = fr.nextInt();
		    	v = fr.nextInt();
		    	w = fr.nextInt();
		    	if(u!=v) {
			    	String uv =""+u+"/"+v; 
	    			String vu= v+"/"+u;
		    		if(tm.containsKey(uv) || tm.containsKey(vu)) {
		    			if(w<=tm.get(uv) || w<= tm.get(vu)) {
			    			for(int j = 0;j<AdjList.get(u).size();j++) {
			    				if(v== AdjList.get(u).get(j).first() ) {
			    					if(w <AdjList.get(u).get(j).second()) {
			    					AdjList.get(u).get(j)._second=w;
			    					AdjList.get(u).get(j).oc=1;
			    					tm.put(uv, w);
			    					} else if (w ==AdjList.get(u).get(j).second()){
			    						AdjList.get(u).get(j).oc++;	
			    					}
			    				}
			    			}
			    			for(int j = 0;j<AdjList.get(v).size();j++) {
			    				if(u== AdjList.get(v).get(j).first() ) {
			    					if(w <AdjList.get(v).get(j).second()) {
			    					AdjList.get(v).get(j)._second=w;
			    					AdjList.get(v).get(j).oc=1;
			    					tm.put(vu, w);
			    					} else if (w ==AdjList.get(v).get(j).second()){
			    						AdjList.get(v).get(j).oc++;	
			    					}
			    				}
			    			}
		    			}
		    		}else {
		    			AdjList.get(u).add(new IntegerPair(v, w));	
		    			AdjList.get(v).add(new IntegerPair(u, w));	
		    			tm.put(uv, w);
		    			tm.put(vu, w);
		    		
		    		}
		    	}

		    }
		    ////fin De llenado
		    
		    for(int i=0;i<V;i++) {
		    	System.out.print("["+i+"]: ");
		    	for(int j = 0;j<AdjList.get(i).size();j++) {
		    		System.out.print("{"+AdjList.get(i).get(j).first()  +"," +
		    				AdjList.get(i).get(j).second() +","+AdjList.get(i).get(j).oc +"}");
		    	}
		    	System.out.println();
		    }
		    //impresion
		    
		    //procesar Dijstra
		    Vector < Integer > dist = new Vector < Integer > ();
		    dist.addAll(Collections.nCopies(V, INF)); dist.set(0, 0); // INF = 1*10^9 not MAX_INT to avoid overflow
		    PriorityQueue < IntegerPair > pq = new PriorityQueue<>(new Comparator<IntegerPair>() { // overriding the compare method 
		        public int compare(IntegerPair i, IntegerPair j) {
		            return i.first() - j.first();
		          }
		        });

		    //dijkstra
		    pq.offer(new IntegerPair (0, 0));
			long[] visits = new long[V+1];
			visits[0] = 1;
		    while (!pq.isEmpty()) { // main loop
		        IntegerPair top = pq.poll(); // greedy: pick shortest unvisited vertex
		        int d = top.first(); u = top.second();
		        int reps =top.oc;
		        if (d > dist.get(u)) continue; // This check is important! We want to process vertex u only once but we can
		        Iterator it = AdjList.get(u).iterator();
		        while (it.hasNext()) { // all outgoing edges from u
		          IntegerPair p = (IntegerPair) it.next();
		          v = p.first();
		          int weight_u_v = p.second();
		          if (dist.get(u) + weight_u_v < dist.get(v)) { // if can relax      (note: Record SP spanning tree)
		            dist.set(v, (dist.get(u) + weight_u_v)% 1000000007  );// relax 	
		            if(visits[v]==0)
		            	visits[v] = (reps * p.oc) % 1000000007;
		            else {
		            	visits[v] = (visits[v] + reps ) % 1000000007;
		            }
		            //(here if needed. This is similar)
		            pq.offer(new IntegerPair(dist.get(v), v)); //      (as printpath in BFS)
		            // enqueue this neighbor regardless whether it is already in pq or not    
		      } } }
		    
		    System.out.println("Distancia minima = "+ dist.get(V-1));
		    System.out.println("Veces recorrida la distancia = " + visits[V-1]);
		}
		
	}
 
	
	static class IntegerPair implements Comparable {
		  Integer _first, _second;
		  int oc;
		  public IntegerPair(Integer f, Integer s) {
		    _first = f;_second = s;oc=1;
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
      //  	System.setIn(new FileInputStream("src/tests.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
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
