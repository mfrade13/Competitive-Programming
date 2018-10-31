import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner fr = new Scanner(System.in);
		
		String ln ;
		Vector<Double> le = new Vector<>();
		Vector<Double> up = new Vector<>();
		Vector<Double> ri = new Vector<>();
		Vector<Double> down = new Vector<>();
		Vector<Double> rad = new Vector<>();
		Vector<Character> type = new Vector<>();
		
		int f =1;
		while((ln=fr.nextLine())!= null) {
			if(ln.charAt(0)=='*')break;
			
			String [] cor = ln.split(" ");
			type.add(cor[0].charAt(0));
			if (ln.charAt(0)=='r') {
			
				le.add(Double.parseDouble(cor[1]));
				up.add(Double.parseDouble(cor[2]));
				ri.add(Double.parseDouble(cor[3]));
				down.add(Double.parseDouble(cor[4]));
				rad.add(0.0);
			}else if (ln.charAt(0)=='c'){
				le.add(Double.parseDouble(cor[1]));
				up.add(Double.parseDouble(cor[2]));
				ri.add(Double.parseDouble("0.0"));
				down.add(Double.parseDouble("0.0" ));
				rad.add(Double.parseDouble(cor[3]));				
			}
			f++;
		}
		//System.out.println(le.toString() );
		StringBuilder sb = new StringBuilder();
		int v=1;
		String ll;
		while((ll=fr.nextLine())!= null) {
			String points [] = ll.split(" ");
			double x = Double.parseDouble(points[0]);
			double y = Double.parseDouble(points[1]);
			if (x==9999.9 && y ==9999.9) break;
			boolean in = false;
			
			for(int i =0;i<le.size();i++) {
				if(type.get(i)=='r' ) {
					if(x>le.get(i) && x<ri.get(i) && y>down.get(i) && y<up.get(i) ) {
						sb.append("Point "+v+" is contained in figure "+(i+1) + "\n");
						in =true;
					}
				}else {
					double dist = Math.sqrt( Math.pow(x-le.get(i), 2) + Math.pow(y-up.get(i),2)   ); 
					if (dist < rad.get(i)) {
						sb.append("Point "+v+" is contained in figure "+(i+1) + "\n");
						in =true;						
					}
					
				}
			}
			if (!in) {
				sb.append("Point "+v+" is not contained in any figure\n");
			}
			v++;
		}
		System.out.print(sb);
		
	}
}
