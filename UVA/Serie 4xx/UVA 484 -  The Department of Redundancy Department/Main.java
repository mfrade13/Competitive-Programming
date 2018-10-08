import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/*
 * @author Miguel Frade Flores
 * Mapping
 * Use vector to preserve the input order
 * use tests file to test
 * 
 * 
 * */


public class Main {

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/tests.txt"));
		Scanner sc = new Scanner(System.in);
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Map<Integer, Integer> hm = new HashMap<>();
		Vector<Integer> vec = new Vector<>();
		while(sc.hasNext()) {
			int a = sc.nextInt();
			if (!hm.containsKey(a)) {
				hm.put(a, 1);
				vec.add(a);
			}else {
				hm.put(a,hm.get(a)+1);
			}
		}
		
		for (Integer v : vec  ) {
			pr.println(v + " " + hm.get(v) );
		}
		pr.close();
	}

}
