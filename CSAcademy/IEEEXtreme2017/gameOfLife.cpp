#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

int main(){
    int n,m,it;
    while(scanf("%d %d %i",&n,&m,&it)!= EOF){
        char lg[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cin>>lg[i][j];
            }
        }

        while(it-->0){
            char aux[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int liv=0;
                        for(int k=i-1;k<=i+1;k++){
                            int k2=k;
                            for(int l=j-1;l<=j+1;l++){
                                int l2=l;
                                if(k2<0)k2=n-1; 
                                if(k2>=n)k2=0;
                                if(l2<0)l2=m-1; 
                                if(l2>=m)l2=0;

                                if(i==k2 &&j==l2){
                                }else{
                                    if(lg[k2][l2]=='*'){
                                        liv++;
                                    }
                                }

                            }
                        }
                //        cout <<liv;
                        if(lg[i][j]=='*'){
                            if(liv<2) aux[i][j]='-';
                            else if(liv<4 )aux[i][j]='*';
                            else aux[i][j]='-';
                        }else{
                            if(liv==3)aux[i][j]='*';
                            else aux[i][j]='-';
                        }
                    }
                  //  cout<<endl;
                }


            memcpy(lg, aux, sizeof(aux));

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cout<<lg[i][j];
            }
            cout <<endl;
        }

    }

    return 0;
}
