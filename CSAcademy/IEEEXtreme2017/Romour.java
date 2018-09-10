import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
 * @Author: Mauricio Loza
 * -- Brute Force, fill the tree and compare length to top, seems not to be the best asnwer
 * 
 * 
 * */
public class Romour {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for(int i =0; i < q; i++) {
			long f = sc.nextLong();
			long s = sc.nextLong();
			ArrayList<Long> f_l = new ArrayList<>();
			ArrayList<Long> s_l = new ArrayList<>();
			while( f>=1) {
				f_l.add(f);
				f = (f%2 == 0)? f/2: (f-1)/2;
			}
			while( s>=1) {
				if(!f_l.contains(s)) {
					s_l.add(s);
					s = (s%2 == 0)? s/2: (s-1)/2;
				}else {
					s_l.add(s);
					int index = f_l.indexOf(s);
					f_l = new ArrayList<Long>(f_l.subList(0, index+1));
					break;
				}
			}
			System.out.println(f_l.size()+s_l.size()-2);
		}
	}

}
