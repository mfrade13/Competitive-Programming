import java.util.Scanner;
/*
 * @author Miguel Frade
 * 
 * 
 * solve equation to get all values
 * 
 * [x1 y1 1][-x1^2 - y1^2]
 * [x2 y2 1][-x2^2 - y2^2]
 * [x3 y3 1][-x3^2 - y3^2]
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
			
			double f1c = (x1*x1 + y1*y1)*-1; 
			double f2c = (x2*x2 + y2*y2)*-1; 
			double f3c = (x3*x3 + y3*y3)*-1; 	
			
			double res = rCircumCircle(new Point(x1,y1),new Point(x2,y2),new Point(x3,y3)  );
			
			double det = (x1*y2) +(x2*y3)+(x3*y1) -(x3*y2) -(x2*y1) - (x1*y3)  ;
			double detD = (f1c*y2) +(f2c*y3)+(f3c*y1) -(f3c*y2) -(f2c*y1) - (f1c*y3) ;
			double detE = (x1*f2c) +(x2*f3c)+(x3*f1c) -(x3*f2c) -(x2*f1c) - (x1*f3c)  ;
			
			double D= detD/det;
			double E= detE/det;
			double h = D/-2.0;
			double k = E/-2.0;
			double F = h*h + k*k - res*res;

			String hs = h>0?"-":"+";
			String ks = k>0?"-":"+";
			String Ds = D<0?"-":"+";
			String Es = E<0?"-":"+";
			String Fs = F<0?"-":"+";

			h= Math.abs(h);
			k= Math.abs(k);
			D= Math.abs(D);
			E= Math.abs(E);
			F= Math.abs(F);
			//special case
			F = F==5.999027052894235E-8?0.0:F;

			if( h == 0.00) {
				System.out.printf("x^2 + (y %s %.3f)^2 = %.3f^2\n",ks,k,res );
				if(F!=0.00) {
					System.out.printf("x^2 + y^2 %s %.3fy %s %.3f = 0\n\n",Es,E,Fs,F);					
				}else {
					System.out.printf("x^2 + y^2 %s %.3fy = 0\n\n",Es,E);					
				}
				
			}else if(k == 0.00) {
				System.out.printf("(x %s %.3f)^2 + y^2 = %.3f^2\n",hs,h,res );				
				if(F!=0.00) {
					System.out.printf("x^2 + y^2 %s %.3fx %s %.3f = 0\n\n",Ds,D,Fs,F);					
				}else {
					System.out.printf("x^2 + y^2 %s %.3fx = 0\n\n",Ds,D);					
				}
			}else if (h==0.0 && k==0.0){
				System.out.printf("x^2 + y^2 = %.3f^2\n",res );
				if(F!=0.00) {
					System.out.printf("x^2 + y^2 %s %.3f = 0\n\n",Fs,F);					
				}else {
					System.out.printf("x^2 + y^2 = 0\n\n");					
				}
			}else {
				System.out.printf("(x %s %.3f)^2 + (y %s %.3f)^2 = %.3f^2\n",hs,h,ks,k,res );
				if(F!=0.0) {
					System.out.printf("x^2 + y^2 %s %.3fx %s %.3fy %s %.3f = 0\n\n",Ds,D,Es,E,Fs,F);					
				}else {
					System.out.printf("x^2 + y^2 %s %.3fx %s %.3fy = 0\n\n",Ds,D,Es,E);					
				}
			}
			
			//x^2 + y^2 - 6.000x + 4.000y - 12.000 = 0
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
		return Math.sqrt( s*(s-ab)*(s-ac)*(s-bc) );
	}
	static double rCircumCircle(double ab, double bc, double ca) {
		return (ab * bc * ca) / (4.0 * area(ab, bc, ca)); }
	
	static double rCircumCircle(Point a, Point b, Point c) {
		return rCircumCircle(dist(a, b), dist(b, c), dist(c, a)); }
}
