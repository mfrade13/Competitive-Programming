import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		while(sc.hasNext()) {
			int n = sc.nextInt();
			if(n==0)break;
			int arr [] = new int[n];
			
			for(int i =0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			for(int i =0;i<n;i++) {
				sb.append(arr[i] +" ");
			}
			pr.println(sb.toString().trim());
		}
		pr.close();
	}

}
