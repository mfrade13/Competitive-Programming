import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int tc = sc.nextInt();
			sc.nextLine();
			while(tc-->0) {
				String s = sc.nextLine();
				int tam = s.length();
				if(s.compareTo("1")==0 || s.compareTo("4")==0 || s.compareTo("78")==0  ) {
					System.out.println("+");
				}else if(s.length()>=2 &&  s.charAt(tam-1)=='5' && s.charAt(tam-2)=='3') {
					System.out.println("-");
				}else if(s.startsWith("190")) {
					System.out.println("?");
				}else if(s.charAt(0)=='9' && s.charAt(tam-1)=='4' ) {
					System.out.println("*");
				}
				
			}
		}
	}

}
