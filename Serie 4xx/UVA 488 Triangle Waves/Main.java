import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws IOException{
	//	System.setIn(new FileInputStream("src/tests.txt") );
		Scanner sc = new Scanner(System.in);
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
			int tc = sc.nextInt();
			
			while(tc-->0) {
				int a = sc.nextInt();
				int f= sc.nextInt();
				
				while(f-->0) {
					StringBuilder sb = new StringBuilder();
					for(int i =1;i<=a;i++) {
						for(int j = 1;j<=i;j++) {
							sb.append(i);
						}
						sb.append("\n");
					}
					for(int i =a-1;i>0;i--) {
						for(int j = 1;j<=i;j++) {
							sb.append(i);
						}
						sb.append("\n");
					}
					
					pr.print(sb);
					if(f!=0)
						pr.println();
				}
				if(tc!=0)
					pr.println();
			}
				
		
		pr.close();
	}

}
