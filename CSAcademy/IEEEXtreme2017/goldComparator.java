import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

/*
 * @Author: Miguel Frade Flores
 * Technique: Shortest Path with Dijkstra, Mapping, Use BigInteger, Prime Numbers
 * 
 * 
 * */

class IntegerPair implements Comparable {
	  Integer _first, _second;

	  public IntegerPair(Integer f, Integer s) {
	    _first = f;
	    _second = s;
	  }

	  public int compareTo(Object o) {
	    if (!(this.first()==((IntegerPair) o).first())  )
	      return this.first() - ((IntegerPair)o).first();
	    else
	      return this.second() - ((IntegerPair)o).second();
	  }

	  Integer first() { return _first; }
	  Integer second() { return _second; }
	}

public class goldComparator {
	  public static final int INF = 1000000000;
	  private static Vector< Vector< IntegerPair > > AdjList = new Vector< Vector< IntegerPair > >();
	  static int u,v,w;
	  
	  static int primes[]={2,3,5,7,11,13,17,19,23,29,31};
	  
	  
	  static int countPrime(int num){
		  int cont=0;
		  int ti=-1;
		  int res=1;	  
		  while(res<=num){
			res*=primes[cont];  
			cont++;
			ti++;
		  }
		  return ti;
	  }
	  
	  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m =sc.nextInt();
		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
		HashMap<Integer,Integer> hm2 = new HashMap<Integer, Integer>();
		int ver[]=new int[n];
		
		
		  AdjList.clear();
		    for (int i = 0; i < n; i++) {
		      Vector< IntegerPair > Neighbor = 
		        new Vector < IntegerPair >();
		      AdjList.add(Neighbor); // add neighbor list to Adjacency List
		    }
		
		    for(int i=0;i<n;i++){
		    	ver[i]=sc.nextInt();
		    }
		    Arrays.sort(ver);
		    for(int i=0;i<n;i++){
		    	hm.put(i, ver[i]);
		    	hm2.put(ver[i], i);
		    }
		    
		    for (int i = 0; i < m; i++) {
		        u = sc.nextInt();
		        v = sc.nextInt();
		        w = sc.nextInt();
		        AdjList.get(hm2.get(u)).add(new IntegerPair (hm2.get(v), w)); // first time using weight
		        AdjList.get(hm2.get(v)).add(new IntegerPair (hm2.get(u), w)); // first time using weight
			    
		    }
		    int s=0;
		    Vector < Integer > dist = new Vector < Integer > ();
		    Vector < Integer > gold = new Vector < Integer > ();
		    dist.addAll(Collections.nCopies(n, INF)); dist.set(s, 0); // INF = 1*10^9 not MAX_INT to avoid overflow
		    gold.addAll(Collections.nCopies(n, 0));
		    gold.set(s, countPrime(hm.get(s)));
		    PriorityQueue < IntegerPair > pq = new PriorityQueue < IntegerPair >(1, 
		      new Comparator< IntegerPair >() { // overriding the compare method 
		        public int compare(IntegerPair i, IntegerPair j) {
		          return i.first() - j.first();
		        }
		      }
		    );
		    pq.offer(new IntegerPair (0, s)); // sort based on increasing distance

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
		          gold.set(v, gold.get(u) + countPrime(hm.get(v)));
		          pq.offer(new IntegerPair(dist.get(v), v)); //      (as printpath in BFS)
		          // enqueue this neighbor regardless whether it is already in pq or not    
		    } } }
		
		    System.out.println(gold.get(n-1));
	}
	
}
