import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		//		System.setIn(new FileInputStream("src/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ;
		while((line = br.readLine())!= null) {
			int tc = Integer.parseInt(line);
			while(tc-->0){
				String lines = br.readLine();
				String nums = lines.replace(" ","");
				int dbs=0;
				int odd=0;
				
				for(int i =0;i<nums.length();i++) {
					int num = nums.charAt(i) - '0';
					if(i%2==0) {
						int aux = num*2;
						if(aux>=10) {
							dbs+= (aux%10)+(aux/10);
						}else {
							dbs+=aux;
						}
					}else {
						odd+=num;
					}
				}
				int res = dbs + odd;
				if(res%10==0) {
					System.out.println("Valid");
				}else {
					System.out.println("Invalid");
				}
			}
		}
	}

}
