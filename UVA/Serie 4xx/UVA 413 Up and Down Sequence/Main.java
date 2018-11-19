import java.io.BufferedReader;

/*
 * @author Miguel Frade Flores
 * Parse numbers, use counters for up and down changes in the sequence
 * as well as one for a non changing value
 * 
 * */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Main {

	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l ;
		
		while((l = br.readLine())!=null ) {
			String nums []= l.split(" ");
			
			if(nums[0].charAt(0)=='0')break;

			int previous=0;
			int ups=0;
			int downs=0;
			int way=0;
			double tu=0.0;
			double td=0.0;
			
			int nCNT=0;
			int ucnt=0;
			int dcnt=0;
			int cont=0;
			for(String token : nums) {
				int act = Integer.parseInt(token);
				if (cont==0) {
					previous=act;
				}else {
					if(way==0) {
						if(act==previous) {
							nCNT++;
						}else if (act>previous){
							way=1;
							ucnt=nCNT+1;
						}else {
							if(act!=0) {
								way=-1;
								dcnt = nCNT+1;
							}
						}
					}else if(way==1) {
						if(act>=previous) {
							ucnt++;
						}else {
							ups++;
							tu+=ucnt;
							ucnt=0;
							dcnt=1;
							way=-1;
						}
						
					}else if(way==-1) {
						if(act<=previous) {
							if(act==0) {
								td+=dcnt;
								downs++;
								dcnt=0;
							}else {
								dcnt++;
							}
							ucnt++;
						}else {
							downs++;
							td+=dcnt;
							ucnt=1;
							dcnt=0;
							way=1;
						}
					}
					previous=act;
				}
				cont++;
			}
			
			double upres= ups!=0.0? tu/ups:0.0;
			double dres= downs!=0.0? td/downs:0.0;
			
			System.out.print("Nr values = "+(cont-1)+":  ");
			System.out.printf("%.6f %.6f\n",upres,dres);
		}
		
	}

}
