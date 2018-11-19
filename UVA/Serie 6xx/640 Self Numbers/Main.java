import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * @author Miguel Frade Flores
 * 
 * use generator an add all numbers below to the limit, print non added values
 * 
 * */


public class Main {

	public static void main(String[] args) {
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		boolean flag[]=new boolean[1000001];

		for (int i=1;i<1000000;i++) {
			int res = genD(i);
			if (res<=1000000)
				if(!flag[res]) {
					flag[res]=true;
				}
		}
		StringBuilder sb = new StringBuilder();
		for(int i =1;i<=1000000;i++) {
			if(!flag[i])
				sb.append(i+"\n");

		}
		pr.print(sb);
		pr.close();
	}

	static int genD(int a) {
		int acc=a;
		String ac=""+a;
		
		for (char i : ac.toCharArray()) {
			int v = (int)(i -'0' );
			acc+=v;
		}
		
		return acc; 
	}
	
}
