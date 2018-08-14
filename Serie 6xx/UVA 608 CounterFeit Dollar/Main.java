import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		//uncoment to test using test.txt file 
//		System.setIn(new FileInputStream("src/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l;
		while((l=br.readLine())!=null) {
			int tc= Integer.parseInt(l);
			while(tc-->0) {
				boolean vals []=new boolean[12]; 
				int wei []= new int [12];
				int wei2 []= new int [12];
				
				for(int i=0;i<3;i++) {
					String [] n = br.readLine().split(" ");
					char left [] = n[0].toCharArray();
					char right [] = n[1].toCharArray();
					if(n[2].compareTo("even")==0) {
						for(char c : left) {
							int pos = (int)(c-'A');
							wei2[pos]=-3;
							wei[pos]=-3;
						}
						for(char c : right) {
							int pos = (int)(c-'A');
							wei2[pos]=-3;
							wei[pos]=-3;
						}
					}else if(n[2].compareTo("up")==0) {
						for(char c : left) {
							int pos = (int)(c-'A');
								wei[pos]++;
						}
						for(char c : right) {
							int pos = (int)(c-'A');
								wei2[pos]++;
						}
					}else if(n[2].compareTo("down")==0) {
						for(char c : left) {
							int pos = (int)(c-'A');
								wei2[pos]++;
						}
						for(char c : right) {
							int pos = (int)(c-'A');
								wei[pos]++;
						}
					}
				}
				//Process Result
				char res=' ';
				String we = "";
				int max=-5;
					for(int i =0;i<12;i++) {
						if(max<wei[i]) {
							max=wei[i];
							we="heavy";
							res = (char)('A'+i);
						}
						if(max<wei2[i]) {
							max=wei2[i];
							we="light";
							res = (char)('A'+i);
						}
						
					}
				System.out.println( res +" is the counterfeit coin and it is "+we +".");
				
			}
		}
		
	}

}
