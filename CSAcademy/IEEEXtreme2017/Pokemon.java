import java.util.Scanner;
/*
 * @Author: Mauricio Loza
 * 
 * 
 * */


public class Pokemon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
		    int r = sc.nextInt();
        	int c = sc.nextInt();
        	int [][] viridianVida = new int[r][c];
        	int [][] viridianCosto = new int[r][c];
        	for(int i = 0; i < r; i++) {
        		for(int j = 0; j < c; j++) {
        			int value = sc.nextInt();
        			if(i == 0 && j == 0) {
        				viridianVida[i][j] = 0;
        				viridianCosto[i][j] = 0;
        			}else if(i == 0) {
        				int damage = viridianVida[i][j-1]+value;
        				viridianVida[i][j] = (damage <=0)? 0: damage; 
        				viridianCosto[i][j] = ((damage <0)? damage: 0) + viridianCosto[i][j-1]; 
        			}else if(j == 0) {
        				int damage = viridianVida[i-1][j]+value;
        				viridianVida[i][j] = (damage <=0)? 0: damage; 
        				viridianCosto[i][j] = ((damage <0)? damage: 0) + viridianCosto[i-1][j]; 
        			}else {
        				int damage = viridianVida[i-1][j]+value;
        				int damage2 = viridianVida[i][j-1]+value;
        				
        				if(damage > damage2) {
        					viridianVida[i][j] = (damage <=0)? 0: damage; 
        					int damage3 = viridianCosto[i-1][j];
        					int damage4 = viridianCosto[i][j-1];
        					viridianCosto[i][j] = ((damage >0)? 0: damage)+ ((damage3 > damage4)? viridianCosto[i-1][j]: viridianCosto[i][j-1]);
        				}else {
        					viridianVida[i][j] = (damage2 <=0)? 0: damage2; 
        					int damage3 = viridianCosto[i-1][j];
        					int damage4 = viridianCosto[i][j-1];
        					viridianCosto[i][j] = ((damage2 >0)? 0: damage2) + ((damage3 > damage4)? viridianCosto[i-1][j]: viridianCosto[i][j-1]);
        				}
        			}
        		}
        	}
		    System.out.println(Math.abs(viridianCosto[r-1][c-1])+1);
		}
	}
}