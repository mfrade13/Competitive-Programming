import java.util.Scanner;
/*
 * @Author: Miguel Frade
 * --BruteForce seems not to be the best answer
 * 
 * */
public class RecXOR {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext() ){
			int t =sc.nextInt();
			while(t-->0){
				int in=sc.nextInt();
				int top=sc.nextInt();
				int n=sc.nextInt();
				int d1=sc.nextInt();
				int d2=sc.nextInt();
				
				int dx1=0,dx2=0,dy1=0,dy2=0;
				int m1,m2;
				int ma[][]=new int [top][in];
				
				for(int i=0;i<top;i++){
					for(int j =0;j<in;j++){	
						if(n==d1){ dx1=j;dy1=i;}
						if(n==d2){ dx2=j;dy2=i;}		
						ma[i][j]=n;
						n++;
					}
				}
				if(dx1<dx2){m1=dx1;m2=dx2; }else{m1=dx2;m2=dx1; }
				
				int res=0;	
				for(int i=0;i<top;i++){
					for(int j=0;j<in;j++){
						if(i>=dy1 && i<=dy2  && j>=m1 && j<=m2 ){
						}else
							res^=ma[i][j];
						
					}
					
				}
				System.out.println(res);
			}
		}
	}

}
