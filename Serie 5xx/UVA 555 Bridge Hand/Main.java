import java.util.Scanner;
import java.util.Vector;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		while(sc.hasNext()) {
			String player = sc.nextLine();
			if(player.charAt(0) == '#')break;
			
			Player players []= new Player [4];
			players[0] = new Player();
			players[2] = new Player();
			players[3] = new Player();
			players[1] = new Player();
			int cp=0;
			if(player.charAt(0) == 'S') cp=1;
			else if(player.charAt(0) == 'W') cp=2;
			else if(player.charAt(0) == 'N') cp=3;
			else if(player.charAt(0) == 'E') cp=0;
			
			char [] order = {'S','W','N','E' };
			
			String cards = sc.nextLine();
			for(int i =0;i<cards.length()-1;i+=2) {
				players[cp].cards.addElement(""+cards.charAt(i) + cards.charAt(i+1)  );
				cp++;
				if(cp>3)cp=0;
			}
			
			String cards2 = sc.nextLine();
			for(int i =0;i<cards2.length()-1;i+=2) {
				players[cp].cards.addElement(""+cards2.charAt(i) + cards2.charAt(i+1)  );
				cp++;
				if(cp>3)cp=0;
			}
			
			for(int i =0;i<4;i++) {
				players[i].sortCards();
				System.out.println( order[i] + ":" + players[i].pcards());
			}
			
			
			
		}
		
	}

}


class Player {
	
	Vector<String> cards = new Vector<>() ;
	Vector<String> sortCards = new Vector<>() ;
	char suits []= {'C' ,'D', 'S', 'H'}; 
	char vals [] = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'}; 
	public void sortCards() {
		for (int i = 0;i<4;i++) {
			for(int j = 0;j<13;j++) {
				String res = ""+suits[i] + vals[j];
				if(cards.contains(res)) {
					sortCards.addElement(res);
				}
			}
		}
	}
	
	public String pcards() {
		StringBuilder sb = new StringBuilder("");
		for (String card : sortCards) {
			sb.append(" ");
			sb.append(card);
		}
		return sb.toString();
	}
}