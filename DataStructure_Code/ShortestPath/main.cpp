#include <bits/stdc++.h>

using namespace std;

int n;
char ch;
int main(){
    scanf("%d %c",&n, &ch);

    int now = 1, base = 1;
    int cengshu = 1;
    int used = 1;
    int maxx = 1;
    for(int i = 2; i <= 500; ++ i){
        base += 2;
        now += base * 2;
        if(now <= n){
            maxx = base;
            used = now;
            cengshu = i;
        }else{
            break;
        }
    }
    cout << cengshu << endl;
    for(int i = 0; i < cengshu; ++ i){
        for(int j = 0; j < i; ++ j){
            cout << " ";
        }
        for(int j = 0; j < maxx; ++ j){
            cout << ch;
        }
        maxx -= 2;
        cout << endl;
    }
    maxx += 4;
    for(int i = 1; i < cengshu; ++ i){
        for(int j = cengshu - 1 - i; j > 0; j --){
            cout << " ";
        }
        for(int j = 0; j < maxx; ++ j){
            cout << ch;
        }
        maxx += 2;
        cout << endl;
    }
    cout << n - used << endl;
    return 0;
}