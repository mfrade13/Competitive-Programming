import java.util.HashMap;
import java.util.Scanner;

public class AeneasCriptographic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int lenght = sc.nextInt();
			HashMap<Character, Double> x = new HashMap<>();
			HashMap<Character, Double> y = new HashMap<>();
			for(int i = 0; i < 26; i ++) {
				String letter = sc.next();
				double angle = sc.nextDouble();
				x.put(letter.charAt(0), Math.cos(Math.toRadians(angle))*lenght);
				y.put(letter.charAt(0), Math.sin(Math.toRadians(angle))*lenght);
			}
			sc.nextLine();
			String message = sc.nextLine();
			message = message.replaceAll("[^A-Za-z]","").toUpperCase();
			double thread = lenght;
			char currentChar = message.charAt(0);
			for(int i = 1; i < message.length(); i++) {
				char nextChar = message.charAt(i);
				if(currentChar == nextChar) {
					continue;
				}else{
					double distance =   Math.sqrt(Math.pow(x.get(currentChar)-x.get(nextChar), 2)+Math.pow(y.get(currentChar)-y.get(nextChar), 2));
					thread += distance;
					currentChar = nextChar;
				}
			}
			System.out.println((int)thread+1);
		}
	}
}
