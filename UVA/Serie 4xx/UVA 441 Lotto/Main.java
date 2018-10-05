import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
/*
 * @Author Miguel Frade
 * Complete Search
 * 
 * */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int f=0;
		while(sc.hasNext()) {

			
			int s = sc.nextInt();
			if (s==0)break;
			if(f!=0) pr.println();
			int d [] = new int[s];
			for(int i =0;i<s;i++) {
				d[i]=sc.nextInt();
			}
			Arrays.sort(d);
			StringBuilder sb = new StringBuilder();
			for(int a1=0;a1<d.length-5;a1++) {
				for(int a2=a1+1;a2<d.length;a2++) {
					for(int a3=a2+1;a3<d.length;a3++) {
						for(int a4=a3+1;a4<d.length;a4++) {
							for(int a5=a4+1;a5<d.length;a5++) {
								for(int a6=a5+1;a6<d.length;a6++) {
									sb.append(d[a1] + " " +d[a2]+" "+d[a3]+" "+d[a4]+" "+d[a5]+ " "+d[a6] + "\n");
								}
							}
						}						
					}	
				}
			}
			
			pr.print(sb);
			f++;
		}
		pr.close();
	}

}
