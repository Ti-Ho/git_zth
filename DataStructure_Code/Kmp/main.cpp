#include <bits/stdc++.h>

using namespace std;

const int maxn = 1000005;
int Next[maxn], lent, lenp;
string t, p;
int cnt = 0;
void getNext(){
    int i , j;
    j = Next[0] = -1;

    i = 0;
    while(i < lenp){
        while(j != -1 && p[i] != p[j])
            j = Next[j];
        Next[++ i] = ++ j;
    }
}



void getNextVal(){  // KMP进一步优化
    int i , j;
    j = Next[0] = -1;

    i = 0;
    while(i < lenp){
        while(j != -1 && p[i] != p[j])
            j = Next[j];
        i ++;
        j ++;

        if(p[i] != p[j]) Next[i] = j;
        else Next[i] = Next[j];
    }
}

int kmp(){ //在t串找p串  返回下标
    int i = 0, j = 0;
    while(i < lent && j < lenp){
        while(j != -1 && t[i] != p[j])
            j = Next[j];
        i ++;
        j ++;
    }
    if(j == lenp)
        return i - j;
    return -1;
}


int kmp2(){ //返回匹配次数
    int i = 0, j = 0;
    while(i < lent && j < lenp){
        while(j != -1 && t[i] != p[j])
            j = Next[j];
        if(j == lenp - 1){
            j = Next[j];
            cnt ++;
        }
        i ++;
        j ++;
    }
    return cnt;
}

int kmp3(){ //返回t串中有多少个p串
    int i = 0, j = 0;
    while(i < lent && j < lenp){
        while(j != -1 && t[i] != p[j])
            j = Next[j];
        if(j == lenp - 1){
            j = -1;
            cnt ++;
        }
        i ++;
        j ++;
    }
    return cnt;
}
int main(){
    cin >> t >> p;
    lent = t.length();
    lenp = p.length();

    getNextVal();

    for(int i = 0; i < lenp; ++ i)
        cout << Next[i] << " ";
    cout << endl;

    int ans = kmp();
    cout << ans << endl;

//    cout << kmp3() << endl;
    return 0;
}