import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			
			String deck = sc.nextLine();
			String cards [] = deck.split(" ");
			
			Vector<Character> sp = new Vector<>();
			Vector<Character> he = new Vector<>();
			Vector<Character> di = new Vector<>();
			Vector<Character> cl = new Vector<>();
			
			boolean stop[]=new boolean[4];
			
			int points = 0;
			int lr =0;
			char suit = 'C';
			
			for(int i=0;i<cards.length;i++ ) {
				if(cards[i].charAt(0)=='K' ) {
					points+=3;
				}else if(cards[i].charAt(0)=='Q' ) {
					points+=2;
				}if(cards[i].charAt(0)=='A' ) {
					points+=4;
				}if(cards[i].charAt(0)=='J' ) {
					points+=1;
				}
				
				if(cards[i].charAt(1) == 'S' ) {
					sp.add(cards[i].charAt(0));
				}else if(cards[i].charAt(1) == 'H' ) {
					he.add(cards[i].charAt(0));
				}if(cards[i].charAt(1) == 'D' ) {
					di.add(cards[i].charAt(0));
				}if(cards[i].charAt(1) == 'C' ) {
					cl.add(cards[i].charAt(0));
				}
				
			}
				//substract
				
				if(sp.contains('K') && sp.size()<2) points--;
				if(he.contains('K') && he.size()<2) points--;
				if(di.contains('K') && di.size()<2) points--;
				if(cl.contains('K') && cl.size()<2) points--;
				
				if(sp.contains('Q') && sp.size()<3) points--;
				if(he.contains('Q') && he.size()<3) points--;
				if(di.contains('Q') && di.size()<3) points--;
				if(cl.contains('Q') && cl.size()<3) points--;
				
				if(sp.contains('J') && sp.size()<4) points--;
				if(he.contains('J') && he.size()<4) points--;
				if(di.contains('J') && di.size()<4) points--;
				if(cl.contains('J') && cl.size()<4) points--;
				
				//stopped suit
				if ( (sp.contains('A')   || sp.contains('K') && sp.size()>=2) || (sp.contains('Q') && sp.size()>=3)) stop[0]=true;
				if ( (he.contains('A')   || he.contains('K') && he.size()>=2) || (he.contains('Q') && he.size()>=3)) stop[1]=true;
				if ( (di.contains('A')   || di.contains('K') && di.size()>=2) || (di.contains('Q') && di.size()>=3)) stop[2]=true;
				if ( (cl.contains('A')   || cl.contains('K') && cl.size()>=2) || (cl.contains('Q') && cl.size()>=3)) stop[3]=true;
				
				// add
				if(sp.size()==2) lr++;
				if(he.size()==2) lr++;
				if(di.size()==2) lr++;
				if(cl.size()==2) lr++;
				
				if(sp.size()<=1) lr+=2;
				if(he.size()<=1) lr+=2;
				if(di.size()<=1) lr+=2;
				if(cl.size()<=1) lr+=2;
				
				//high suit
	
				
				if(sp.size() >=he.size() && sp.size()>=di.size() && sp.size()>=cl.size() ) suit='S';
				else if ( he.size()>=di.size() && he.size()>=cl.size() && he.size()>=sp.size()) suit='H';
				else if (di.size() >=cl.size() ) suit='D';
				
	
			
			
		
			if( points+lr <14 ) {
				System.out.println("PASS");
			}else if( points >= 16 && stop[1] && stop[2]  && stop[3]  && stop[0] ) {
				System.out.println("BID NO-TRUMP");
			}else {
				System.out.println("BID " + suit );
			}
			
		}
		

	}

}
