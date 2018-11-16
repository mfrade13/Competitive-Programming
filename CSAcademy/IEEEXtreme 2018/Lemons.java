import java.util.Scanner;

/*
* @author Miguel Frade
*
* round the n number of pups to its log(2) base due a binary chanse of right or left
*
*/

class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt();
        double aux = 	Math.ceil( Math.log(n)/Math.log(2));
	//	System.out.print(aux);
        
        int res = (int)(s*aux) + ( (n-1)*m );

		System.out.print(res);
	}
}