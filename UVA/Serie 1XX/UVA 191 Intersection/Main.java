import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		while(sc.hasNext()) {
			int n = sc.nextInt();
			while(n-->0) {
				int sx = sc.nextInt();
				int sy = sc.nextInt();
				int ex = sc.nextInt();
				int ey = sc.nextInt();

				int lx = sc.nextInt();
				int yt = sc.nextInt();
				int rx = sc.nextInt();
				int by = sc.nextInt();
				
				int minx = lx<rx?lx:rx;
				int maxx = lx>rx?lx:rx;
				int miny = by<yt?by:yt;
				int maxy = by>yt?by:yt;
				
				
				boolean inter = false;	
				
		        if(intersection(sx,sy,ex,ey,minx,maxy,maxx,maxy)) inter=true;
		        else if(intersection(sx,sy,ex,ey,minx,miny,maxx,miny)) inter=true;
		        else if(intersection(sx,sy,ex,ey,minx,maxy,minx,miny)) inter=true;
		        else if(intersection(sx,sy,ex,ey,maxx,maxy,minx,miny)) inter=true;
		        else if(sx>=minx && sx<=maxx && ex>=minx && ex<=maxx && sy >= miny && sy <=maxy && ey >= miny && ey <= maxy) inter =true;
				
				
				if(inter) {
					System.out.println("T");
				}else {
					
					System.out.println("F");
				}
			}
			
		}
		
	}

	static class Point{
		int x,y;
		Point(int x0,int y0){
			x=x0;
			y=y0;
		}
	}
	static class Segment{
		Point s,e;
		Segment(Point s0,Point e0){
			s=s0;
			e=e0;
		}
	}
	static boolean in(double a,double b, double c) {
		return c>=a && c<=b;
	}
	static boolean onLine(Segment a, Point c) {
		double minx,miny,maxx,maxy;
		minx = a.s.x<a.e.x?a.s.x:a.e.x;
		maxx = a.s.x>a.e.x?a.s.x:a.e.x;
		miny = a.s.y<a.e.y?a.s.y:a.e.y;
		maxy = a.s.y>a.e.y?a.s.y:a.e.y;
		if( in(minx,maxx,c.x) && in(miny,maxy,c.y)) {
			if( ((a.s.x-a.e.x)*(c.y-a.s.y))   == ((a.s.y-a.e.y)*(c.x-a.s.x))  ) {
				return true;
			}
		}
		
		return false;
	}
	static double cross(Point o, Point a, Point b) {
	    return (a.x-o.x)*(b.y-o.y)-(a.y-o.y)*(b.x-o.x);
	}

	static boolean intersection(Segment a, Segment b) {
	    if(onLine(a, b.s) || onLine(a, b.e) || onLine(b, a.s) || onLine(b, a.e))
	        return true;
	    if(cross(a.s, a.e, b.s)*cross(a.s, a.e, b.e) < 0 &&
	       cross(a.e, a.s, b.s)*cross(a.e, a.s, b.e) < 0 &&
	       cross(b.s, b.e, a.s)*cross(b.s, b.e, a.e) < 0 &&
	       cross(b.e, b.s, a.s)*cross(b.e, b.s, a.e) < 0
	       )
	        return true;
	    return false;
	}
	
	static boolean intersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
	    int a1,a2,a3,a4;

	    a1=area(x1,y1,x3,y3,x2,y2);
	    a2=area(x1,y1,x4,y4,x2,y2);
	    a3=area(x3,y3,x1,y1,x4,y4);
	    a4=area(x3,y3,x2,y2,x4,y4);
	    
	    if(a1*a2<0 && a3*a4<0) return true;
	    if(a1==0 && (x3-x1)*(x3-x2)<=0 && (y3-y1)*(y3-y2)<=0) return true;
	    if(a2==0 && (x4-x1)*(x4-x2)<=0 && (y4-y1)*(y4-y2)<=0) return true;
	    if(a3==0 && (x1-x3)*(x1-x4)<=0 && (y1-y3)*(y1-y4)<=0) return true;
	    if(a4==0 && (x2-x3)*(x2-x4)<=0 && (y2-y3)*(y2-y4)<=0) return true;
	    
	    return false;
	}
	
	
	
	static int area(int x1, int y1, int x2, int y2, int x3, int y3){
	    return x1*y2+x2*y3+x3*y1-y1*x2-y2*x3-y3*x1;
	}
	
	
}
