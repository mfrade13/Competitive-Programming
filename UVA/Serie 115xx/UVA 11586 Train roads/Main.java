import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int number = sc.nextInt();
			sc.nextLine();//comerse el enter

			char[] array = { 'M', 'F' };
			for (int i = 0; i < number; i++) {
				char[] fila = sc.nextLine().toCharArray();
				int contM = 0;
				int contF = 0;
				for (int j = 0; j < fila.length; j++) {
					if (fila[j] == array[0]) {
						contM++;
					} else if (fila[j] == array[1]) {
						contF++;
					}

				}
				if (contF == contM && contF>1 && contM>1) {
					System.out.println("LOOP");
				} else {
					System.out.println("NO LOOP");
				}
			}
		}
	}
}