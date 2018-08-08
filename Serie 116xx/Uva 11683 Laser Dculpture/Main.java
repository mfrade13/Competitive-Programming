import java.util.Scanner;

public class Main{

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      int h = sc.nextInt();
      int w = sc.nextInt();
      int v[] = new int[w];
      int co = 0;
      v[0] = sc.nextInt();
      co+= h-v[0];
        for(int i=1;i<w;i++){
            v[i] = sc.nextInt();
            if(v[i] != h){
              int temp = v[i-1]-v[i];
                if (temp>0){
                    co+=temp;
                }
           }
        }
          System.out.println(co);
      }
   }
}