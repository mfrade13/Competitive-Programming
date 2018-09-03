import java.util.Scanner;
/*
 * @author: Mauricio Guillermo Loza Arce
 * */
public class counting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] matrix = new long[10001];
		for(int i = 0; i < 10001; i++) {
			matrix[i] = 1;
		}
		
		for(int i = 2; i < 10001; i++) {
			for(int j = i; j < 10001; j++) {
				matrix[j] = (matrix[j]+matrix[j-i])%(1000000007);
			}
		}
		while(sc.hasNext()) {
			int val = sc.nextInt();
			System.out.println(matrix[val]);
		}
	}
}