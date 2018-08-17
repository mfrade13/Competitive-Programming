import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("src/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l ;
		while((l=br.readLine())!=null) {
			int tc = Integer.parseInt(l);
			if(tc ==0)break;
			char[][] d = new char [tc][tc]; 
			int cols [] = new int[tc];
			int rows[] = new int[tc];
			int ur =0;
			int uc=0;
			int cr=0;
			int cc=0;
			for(int i = 0;i<tc;i++) {
				String [] lines = br.readLine().split(" ");
				for(int j = 0;j<tc;j++) {
					char aux =lines[j].charAt(0);
					d[i][j]=aux;
					if(aux=='1') {
						rows[i]++;
						cols[j]++;
					}
				}
			}
			
			for(int i = 0;i<tc;i++) {
				if(rows[i]%2!=0) {
					cr=i;
					ur++;
				}
			}

			for(int i = 0;i<tc;i++) {
				if(cols[i]%2!=0) {
					cc=i;
					uc++;
				}
			}
			if (uc==0 && ur ==0) {
				System.out.println("OK");
			}else if (uc==1 && ur==1) {
				System.out.println("Change bit ("+(cr+1)+","+(cc+1)+")");
			}else {
				System.out.println("Corrupt");
			}
		}
	}

}
