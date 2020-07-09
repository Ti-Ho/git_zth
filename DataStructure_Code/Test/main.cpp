#include <bits/stdc++.h>

using namespace std;

const int maxn = 10005;
char str[maxn];
char ans[maxn];
int cnt = 1;

bool iszimu(char x){
    return 'a' <= x && x <= 'z';
}

bool isdig(char x){
    return '0' <= x && x <= '9';
}

bool issame(char x1, char x2){
    return (iszimu(x1) && iszimu(x2)) || (isdig(x1) && isdig(x2));
}

int main(){
    int op1, op2, op3;
    scanf("%d %d %d", &op1, &op2, &op3);
    scanf("%s", str);
    int n = strlen(str);
    ans[0] = str[0];

    for(int i = 1; i < n - 1; ++ i){
        if(str[i] == '-'){
            char x1 = str[i - 1], x2 = str[i + 1];
            if(issame(x1, x2)){
                if(x1 < x2){
                    if(op3 == 1){
                        for(int j = x1 + 1; j < x2; ++ j){
                            for(int k = 0; k < op2; k ++){
                                if(op1 == 3) ans[cnt ++] = '*';
                                else{
                                    if(op1 == 2){
                                        if(iszimu(x1)){
                                            ans[cnt ++] = j - 'a' + 'A';
                                        }else{
                                            ans[cnt ++ ] = j;
                                        }
                                    }else{
                                        ans[cnt ++] = j;
                                    }
                                }
                            }
                        }
                    }else{
                        for(int j = x2 - 1; j > x1; -- j){
                            for(int k = 0; k < op2; k ++){
                                if(op1 == 3) ans[cnt ++] = '*';
                                else{
                                    if(op1 == 2){
                                        if(iszimu(x1)){
                                            ans[cnt ++] = j - 'a' + 'A';
                                        }else{
                                            ans[cnt ++ ] = j;
                                        }
                                    }else{
                                        ans[cnt ++] = j;
                                    }
                                }
                            }
                        }
                    }
                }
                else ans[cnt++] = str[i];
            }else{
                ans[cnt ++] = str[i];
            }
        }
        else ans[cnt++] = str[i];
    }
    ans[cnt ++ ] = str[n - 1];
    ans[cnt] = '\0';
    printf("%s\n",ans);
    return 0;

}