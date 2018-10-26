import java.util.Scanner;

/*
 * @author Miguel Frade
 * 
 * 
 * Circunference = 2*r * pi
 * 
 * */

public class Main {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		
		while(sc.hasNext()) {
			double x1 = sc.nextDouble();
			double y1 = sc.nextDouble();
			double x2 = sc.nextDouble();
			double y2 = sc.nextDouble();
			double x3 = sc.nextDouble();
			double y3 = sc.nextDouble();
			
			double res = rCircumCircle(new Point(x1,y1),new Point(x2,y2),new Point(x3,y3)  );
			double pi =Math.PI;	
			double circ = res*2*pi;
			System.out.printf("%.2f\n",circ );
		}
	}

	
	static class Point {
		double x,y;
		Point(double x1, double y1){
			x=x1;
			y=y1;
		}
	}
	static double dist(Point a, Point b) {
		return Math.sqrt( Math.pow((a.x-b.x),2)+Math.pow((a.y-b.y),2) );
	}
	static double per(double ab,double ac, double bc) {
		return ab+ac+bc;
	}
	static double area(double ab,double ac, double bc) {
		double s = per(ab,ac,bc)/2;
	//	System.out.println(ab + "  "  +ac+ " " + bc + " perimetro: " + s);
		return Math.sqrt( s*(s-ab)*(s-ac)*(s-bc) );
	}
	static double rCircumCircle(double ab, double bc, double ca) {
		return (ab * bc * ca) / (4.0 * area(ab, bc, ca)); }
	
	static double rCircumCircle(Point a, Point b, Point c) {
		return rCircumCircle(dist(a, b), dist(b, c), dist(c, a)); }
}
