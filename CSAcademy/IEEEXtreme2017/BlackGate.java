import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * @Author: Miguel Frade Flores
 * 
 * 
 * */

class Pri implements Comparable {

	int height;
	String name;

	Pri() {

	}

	Pri(String n, int h) {
		height = h;
		name = n;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Pri ot = (Pri) o;
		if (this.height < ot.height)
			return -1;
		else if (this.height > ot.height)
			return 1;
		else if ((this.name).compareTo(ot.name) > 1)
			return 1;
		else if ((this.name).compareTo(ot.name) < 1)
			return -1;

		return 0;
	}

}

public class BlackGate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			Pri p[] = new Pri[n];
			for (int i = 0; i < n; i++) {
				p[i] = new Pri(sc.next(), sc.nextInt());
			}
			Arrays.sort(p);
			StringBuilder sb = new StringBuilder();
			int ch = p[0].height;
			for (int i = 0, j = 0, k=0; i < n; i++) {
			
				if (ch == p[i].height) {
					sb.append(p[i].name + " ");
					k++;
				} else {
					int l = (k == 1) ? j + 1 : j+k;
					sb.append((j + 1) + " " + (l) + "\n");
					sb.append(p[i].name + " ");
					
					j = i;
					ch = p[i].height;
					k =1;
				}
				if (i == n - 1) {
					sb.append((j + 1) + " " + (i + 1) + "\n");

				}
			}
			System.out.print(sb);

		}

	}
}
