import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int sumD(int n) {
		String val =""+n;
		int res=n;
		while(val.length()>1) {
			res=0;
			for(int i=0;i<val.length();i++) {
				res += (val.charAt(i) -'0');
			}
			val = ""+res;
		}
		return res;
	}
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("src/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while((line = br.readLine())!= null ) {
			String n2 = br.readLine();
			int sum =0;
			int sum2 =0;
			float res = 0;
			for(int i=0;i<line.length();i++) {
				if( (line.charAt(i)>='a' && line.charAt(i) <='z') ) {
					sum+= ((int)(line.charAt(i)) - 96 );
				}else if ((line.charAt(i)>='A' && line.charAt(i) <='Z') ) {
					sum+= ((int)(line.charAt(i)) - 64 );
				}
			}
			
			for(int i=0;i<n2.length();i++) {
				if( (n2.charAt(i)>='a' && n2.charAt(i) <='z') ) {
					sum2+= ((int)(n2.charAt(i)) - 96 );
				}else if ((n2.charAt(i)>='A' && n2.charAt(i) <='Z') ) {
					sum2+= ((int)(n2.charAt(i)) - 64 );
				}
			}
			
			int na= sumD(sum);
			int nb= sumD(sum2);
			
			if(na>nb) {
				res = (float)nb/(float)na * 100;
			}else {
				res = (float)na/(float)nb * 100;
			}
			
			System.out.printf("%.2f ",res);
			System.out.println("%");
		}
		
	}

}
