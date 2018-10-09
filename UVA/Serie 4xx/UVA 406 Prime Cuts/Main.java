import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
/*
 * @author Miguel Frade
 * 
 * Generate primes using cribba
 * push to list, set boundaries of the list print number requested
 * 
 * Tip a deque can add both first and last 
 * 
 * 
 * */

public class Main {

	static Vector <Integer> primes = new Vector<>();
	static BitSet bs = new BitSet(1010);
	static void fill() {
		primes.addElement(1);
		bs.set(2, 1001);
		for(int i=2;i<=1000;i++) {
			if(bs.get(i)) {
				primes.addElement(i);
				for(int j=i;j<=1000;j=j+i) {
					bs.set(j, false);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		fill();
		
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			
			LinkedList<Integer> range = new LinkedList<>();
			for (int i =0;i<primes.size();i++) {
				if(primes.get(i) <=n) {
					range.add(primes.get(i));
				}else {
					break;
				}
				
			}
			int tam = range.size();
			int mid;
			int mid1;
			Deque<Integer> dq= new LinkedList<>();
			if(tam%2==1) {
				mid = tam/2;
				dq.add(range.get(mid));
				
				for(int k=1;k<c;k++) {
					int aux = mid-k;
					int aux2 = mid+k;
					if(aux>=0 && aux2<tam) {
						dq.addFirst(range.get(aux));
						dq.addLast(range.get(aux2));
					}else {
						break;
					}
				}
				
				
			}else {
				mid = tam/2 -1;
				mid1 = tam/2;
				
				dq.add(range.get(mid));
				dq.add(range.get(mid1));
				for(int k=1;k<c;k++) {
					int aux = mid-k;
					int aux2 = mid1+k;
					if(aux>=0) {
						dq.addFirst(range.get(aux));
					}else {
						break;
					}
					if(aux2<tam) {
						dq.addLast(range.get(aux2));
					}else {
						break;
					}
					
					
					
				}
				
			}
			StringBuilder sb = new StringBuilder();
			sb.append(n + " " + c+":");
			for (Integer l : dq) {
				sb.append(" " + l);
			}
			pr.println(sb.toString());
			pr.println();
		}
		
		
		pr.close();
		
		
	}

}
