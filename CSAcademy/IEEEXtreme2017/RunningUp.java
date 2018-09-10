import java.math.BigInteger;
import java.util.Scanner;

public class RunningUp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger bg = BigInteger.ZERO;
		int casos = sc.nextInt();
		for (int i = 0; i < casos; i++) {
			int n = sc.nextInt();
			BigInteger[] m = new BigInteger[n+2];
			m[1] = BigInteger.valueOf(1);
			m[2] = BigInteger.valueOf(2);
			for (int j = 3; j <= n; j++) {
				m[j] = m[j - 1].add(m[j - 2]);
			}
			System.out.println(m[n]);
		}
	}
}
