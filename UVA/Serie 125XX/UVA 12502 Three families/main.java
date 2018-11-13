import java.util.Scanner;

class Main{

public static void main(String args[]){

  Scanner sc = new Scanner(System.in);
  while(sc.hasNext()){
  int n = sc.nextInt();

  while(n-->0){
  int a = sc.nextInt();
  int b = sc.nextInt();
  int c = sc.nextInt();

  int res =  c*(a+ (a-b))/(a+b);
  if (res<0)
    System.out,println(0);
  else{
    System.out,println(res);
 
  }

}
}
}
}