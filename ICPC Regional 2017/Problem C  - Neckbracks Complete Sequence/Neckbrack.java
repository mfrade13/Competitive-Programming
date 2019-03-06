import java.util.Scanner;


/*
 * @author Miguel Frade
 * Problema Regional ICPC 2017
 * Contar las ocurrencias de los valores, usar un valor promedio {m} 
 * ver si existe un valor mayor y uno menor unico para completar la secuencia.
 * 
 * */

public class Neckbrack {

	static int most=0, less =0;
	public static void main(String[] args) {
		Scanner fr = new Scanner(System.in);
		int k = fr.nextInt();
		int n = fr.nextInt();

		int arr[] = new int [k+1];
		boolean solved = true;
		
		for (int i = 0;i<n;i++) {
			int v = fr.nextInt();
			arr[v]++;
		}	
		int m = (n+1)/k;

		for(int i =1;i<arr.length;i++) {
			if(Math.abs(arr[i]-m)>1) {
				solved=false;
				break;
			}else {
				if(arr[i]>m) {
					if (most == 0) {
						most = i;
					}else {
						solved=false;
						break;
					}
				}else if(arr[i]<m) {
					if (less == 0) {
						less = i;
					}else {
						solved=false;
						break;
					}
				}
				
			}
		}
		
		if (solved) {
			if(most!=0 && less !=0) {
				System.out.println("-"+most+" +" + less);
			}else if(most!=0) {
				System.out.println("-"+most);
			}else {
				System.out.println("+"+less);
			}
			
		}else {
			System.out.println("*");
		}
		
		
	}

}
