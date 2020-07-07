#include <bits/stdc++.h>

using namespace std;

typedef struct Node{
    char data;
    Node *lchild, *rchild;
}Node;

Node* CreateTree(int prel, int prer, int inl, int inr){
    if(prel > prer) return NULL;
    int i;
    Node *now = new Node;
    now -> data = pre[prel];
    for(i = inl; i <= inr; ++ i){
        if(in[i] == pre[prel]) break;
    }
    int cnt_l = i - inl;
    now -> lchild = CreateTree(prel + 1, prel + cnt_l, inl, i - 1);
    now -> rchild = CreateTree(prel + 1 + cnt_l, prer, i + 1, inr);
    return now;
}

int main(){
    cin >> t >> p;
    lent = t.length();
    lenp = p.length();

    getNext();

    int ans = kmp();
    cout << ans << endl;
    return 0;
}