import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int f = sc.nextInt();
			int d = sc.nextInt();
			int m = sc.nextInt();
			int y = sc.nextInt();
			if(f==0 && d==0 && m==0 && y==0)break;
			GregorianCalendar gr = new GregorianCalendar(y, m-1, d);
			gr.add(5, f);
			//field 5 is day value    // 4 = weeks
			System.out.println(gr.get(5) + " "+ (gr.get(2)+1) + " " + gr.get(1));
		}
		
	}

}
