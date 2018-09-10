import java.math.BigInteger;
import java.util.Scanner;


public class pells {

	static BigInteger dp[] = new BigInteger[50001];
	static BigInteger two = BigInteger.valueOf(2);
	static BigInteger z= BigInteger.ZERO;

	static void fill(){
		dp[0]= z;
		dp[1]= BigInteger.ONE;
		
		for(int i=2;i<=50000;i++){
			dp[i]= (two.multiply(dp[i-1])).add(dp[i-2]);
		}
	}
	
	public static void main(String[] args) {
		BigInteger dd []={BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(7), BigInteger.valueOf(13)};
		fill();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int d=sc.nextInt();
			int c=0;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<5;i++){
				if(dp[d].mod(dd[i]).compareTo(z)==0 ){
					sb.append("Pell's number "+d+" is divisible by " + dd[i]);
					sb.append("\n");
				}
			}
			if(sb.length()>0)
				System.out.print(sb);
			else{
				System.out.println("-1");
			}
		}
		
	}

}
