import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String num1 = sc.next();
			String num2 = sc.next();
			sc.nextLine();
			
			if(num1.compareTo("0")==0 && num2.compareTo("0")==0)break;
			
			int l1=num1.length();
			int l2=num2.length();
			int min = l1<=l2?l1:l2 ;
			int carry=0;
			int acc=0;
			StringBuilder s1= new StringBuilder(num1);
			s1=s1.reverse();
			StringBuilder s2= new StringBuilder(num2);
			s2=s2.reverse();
			String longest = l1>l2?s1.toString():s2.toString();
			for(int i=0;i<min;i++){
				int n1=s1.charAt(i)-'0';
				int n2 = s2.charAt(i)-'0';
				acc=(n1+n2+acc)/10;
				if(n1+n2+acc>=10){
					carry++;
				}
				
			}
			while(acc>0){
				if(min>=longest.length())break;
				int n=longest.charAt(min)-'0';
				if(n+acc>=10)carry++;
				
				acc=(acc+n)/10;
				
				min++;
			}
			
			if(carry==0){
				System.out.println("No carry operation.");
			}else if(carry==1){
				System.out.println(carry + " carry operation.");
			}else{
				System.out.println(carry + " carry operations.");
			}

		}
		
	}

}
