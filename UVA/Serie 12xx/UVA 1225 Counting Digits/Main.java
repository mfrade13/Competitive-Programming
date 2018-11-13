import java.util.Scanner;

/*
 * @author Miguel Frade
 * concateneate the numbers and then count the digits 
 * in a static array for the 10 digits
 * 
 * 
 * */

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int ns []= new int[10];
			char[] cc = createNumber(n).toCharArray();
			
			for(Character c:cc) {
				int v = c-'0';
				ns[v]++;
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<10;i++) {
				sb.append(ns[i]+ " ");
			}
			System.out.println(sb.toString().trim());
		}
		
	}

	static String createNumber(int a) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=a;i++) {
			sb.append(i);
		}
		
		return sb.toString();
	}
	
}
