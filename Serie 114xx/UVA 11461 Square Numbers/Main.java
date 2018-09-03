import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/*
 *author: Miguel Frade Flores
 */


public class Main {

	static Set<Integer> hs = new TreeSet<Integer>();
	
	static void fill() {
		for(int i=1;i*i<100000;i++) {
			hs.add(i*i);
		}
	}
	
	public static void main(String[] args) {

		int a,b;
		fill();
		Scanner sc = new Scanner(System.in);
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		while(sc.hasNext()) {
			a = sc.nextInt();
			b = sc.nextInt();
			if(a==0 && b==0)break;
			int c=0;
			for(int i =a;i<=b;i++) {
				if(hs.contains(i))
					c++;
			}
			
			pr.println(c);
		}
		
		pr.close();
	}

}
