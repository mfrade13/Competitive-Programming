import java.util.Scanner:

class Main(){
  static long [] dp = new long[1000005];
  static void fill(){
   dp[3]=0;dp[4]=1;  
    int b=3;
    for(int i =5;i<=1000000;i++){
      if(i%2==0) b++;
       dp[i]=dp[i-1] + i*(i-1) - (i+1)(i-b) - b*(b-1);
    }
  }
  public static void main(String args []){
   fill();
   Scanner sc = new Scanner(System.in);
     while(sc.hasNext()){
      int n = sc.nextInt();
      
      if(n==0) break;  
       System.out,println(dp[n]);   
       
    }
  }
}
