import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/*
 * @author: Miguel Frade Flores
 * 
 * Create all numbers and sort them, then query them, Use suffix rule for numbers 1,2,3.
 * 
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vector<Long> hn = new Vector<>();
			hn.addElement((long) 0);
			for(int i =0;i<20;i++) {
				for(int j =0;j<20;j++) {
					for(int k =0;k<27;k++) {
						for(int l =0;l<50;l++) {
							long val = (long) (Math.pow(2, l) *Math.pow(3, k) *Math.pow(5, j) *Math.pow(7, i)  ) ; 
							
							if (!hn.contains(val)) {
								if(val <=2000000000) {
								   hn.addElement(val);	   
								}else {
									break;
								}
							}
							if(hn.size()>10000) {
								k=j=i=100;
								break;
							}
						}	
					}	
				}	
			}
		
			Collections.sort(hn);

			while(sc.hasNext()) {
				int i=sc.nextInt();
				if(i==0)break;
				String pref="";
				long val = hn.get(i);
				
				  if( i%100/10!=1 && i%10==1) {
					pref="st";  
				  }else if ( i%100/10!=1 && i%10==2) {
					pref="nd";  
				  }else if ( i%100/10!=1 && i%10==3) {
					pref="rd";  
				  }else {
					pref="th";  
				  }	
				System.out.println("The "+i+""+pref+" humble number is "+val+".");
				
			}
		
	}

}
