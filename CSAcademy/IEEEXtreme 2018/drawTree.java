// Don't place your source in a package
import java.util.Scanner;

/*
* @author: Miguel Frade Flores
* Use recursive method to fill the tree with the level of each node
*
*/

class Main {
    
    static char[][] mat;
    static String a;
    static String b;
    
    
    static void  fillMat(String p, String q, int lvl){
        if(p.length()==0 ){
            return;
        }else if (p.length()==1 ){
            int pos =0;
            for(int i=0;i<a.length();i++ ){
                if( p.charAt(0) == a.charAt(i) ){
                    pos=i;break;
                }
            }
            mat[lvl][pos]=p.charAt(0);
        }else{
            char q0 = q.charAt(0);
            int p0 = 0;
            
            for(int i =0;i<p.length();i++){
                if(p.charAt(i)==q0 ){
                    p0=i;break;
                }
            }
            
            fillMat(""+q0 ,""+q0 ,lvl);
            
            String lp = p.substring(0,p0);
            int qs = lp.length();
            String lq = q.substring(1,qs+1);//start from next index to size of qs+1
            
            String rp = p.substring(p0+1, p.length() );
            String rq = q.substring(qs+1, q.length() );
            
            fillMat(lp,lq,lvl+1);
            fillMat(rp,rq,lvl+1);    
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            a = sc.nextLine();
            b = sc.nextLine();
            
            int s = a.length();
            mat = new char[s][s];
            for(int i =0;i<s;i++){
                for(int j =0;j<s;j++){
                    mat[i][j]='0';
                }    
            }
            fillMat(a,b,0);
    
            StringBuilder sb = new StringBuilder();        
            for(int i =0;i<s;i++){
                for(int j =0;j<s;j++){
                    char c = mat[i][j];
                    if(c=='0'){
                        sb.append(" ");
                    }else{
                        sb.append(c);
                    }
                }    
                sb.append("\n");
            }   
            System.out.println(sb);
        }
	}
}