import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * @author Miguel Frade FLores
 * 
 * Calculate all the areas of the triangles
 * greedy algorithm, soth sides from mid to boundaries
 * order ... 7,5,3,1,2,4,6...
 * being 1 the longest side
 * get area from a*n*sin(@)/2
 * 
 * */

//RENAME CLASS TO MAIN OR D TO SUBMIT
public class triangles {

	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		
		double angle = Math.PI*2/l;
		
		int sides []= new int [l]; 
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for(int i=0;i<l;i++) {
			sides[i] =sc.nextInt();
		}
		
		Arrays.sort(sides);
		
		for(int i=l-1;i>=0;i--) {
			//sides[i] =sc.nextInt();
			int aux = sides[i];
			if(i==l-1) {
				dq.addLast(aux);
			}else {
				
				if(i%2==0 ) {
					dq.addFirst(aux);
				}else {
					dq.addLast(aux);
				}
			}		

		}		
		
		int v []=new int[l]; 
		int in=0;
		while(!dq.isEmpty()) {
			int val = dq.poll();
			v[in]=val;
			in++;
		}
		double res= 0;
		for(int i=l-1,j=l-2;i>=0;i--,j--) {
			if(j==-1)j=l-1;
			res+=calcArea(v[i], v[j], angle);		
		}

		System.out.printf("%.3f\n",res);


	}
	
	
	static double calcArea(double a, double b,double angle) {
		return a*b* (Math.sin(angle) )/2;
	}
}
