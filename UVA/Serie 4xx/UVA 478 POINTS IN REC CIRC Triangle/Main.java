import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Scanner;
/*
 *@author Miguel Frade
 *check if it is inside a rectangle boundaries
 *check if distance of point is less than the radius for circle
 *check if distance to either one side of the triangle is less than zero 
 * 
 * */
public class Main {

	public static void main(String[] args) {
		Scanner fr = new Scanner(System.in);
		
		String ln ;
		Vector<Double> le = new Vector<>();
		Vector<Double> up = new Vector<>();
		Vector<Double> ri = new Vector<>();
		Vector<Double> down = new Vector<>();
		Vector<Double> tx = new Vector<>();
		Vector<Double> ty = new Vector<>();
		
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
				tx.add(0.0);
				ty.add(0.0);
				
			}else if (ln.charAt(0)=='c'){
				le.add(Double.parseDouble(cor[1]));
				up.add(Double.parseDouble(cor[2]));
				ri.add(Double.parseDouble("0.0"));
				down.add(Double.parseDouble("0.0" ));
				rad.add(Double.parseDouble(cor[3]));				
				tx.add(0.0);
				ty.add(0.0);
				
			}else if (ln.charAt(0)=='t'){
				le.add(Double.parseDouble(cor[1]));
				up.add(Double.parseDouble(cor[2]));
				ri.add(Double.parseDouble(cor[3]));
				down.add(Double.parseDouble(cor[4]));
				tx.add(Double.parseDouble(cor[5]));
				ty.add(Double.parseDouble(cor[6]));
				rad.add(0.0);
			}
			f++;
		}

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
				}else if(type.get(i)=='c'){
					double dist = Math.sqrt( Math.pow(x-le.get(i), 2) + Math.pow(y-up.get(i),2)   ); 
					if (dist < rad.get(i)) {
						sb.append("Point "+v+" is contained in figure "+(i+1) + "\n");
						in =true;						
					}
				}else {
					boolean t =PointInTriangle(new Point(x,y),new Point(le.get(i),up.get(i)),
							new Point(ri.get(i),down.get(i)), new Point(tx.get(i),ty.get(i)) );
					if(t) {
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
	
	static boolean PointInTriangle (Point pt, Point v1, Point v2, Point v3)	{
	    double d1, d2, d3;
	    boolean has_neg, has_pos;

	    d1 = sign(pt, v1, v2);
	    d2 = sign(pt, v2, v3);
	    d3 = sign(pt, v3, v1);

	    has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
	    has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

	    return !(has_neg && has_pos);
	}
	
	static double sign (Point p1, Point p2, Point p3)	{
	    return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
	}
	
	static class Point {
		double x,y;
		Point(double x0, double y0){
			x=x0;
			y=y0;
		}
	}
	
	
}
