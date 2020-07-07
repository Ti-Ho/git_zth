#include <iostream>

using namespace std;

const int maxn = 1000005;

int fa[maxn];

int findfa(int x){
    return x == fa[x]?x:fa[x]=findfa(fa[x]);
}

void join(int x, int y){
    int fx = findfa(x);
    int fy = findfa(y);

    if(fx != fy)
        fa[fx] = fy;
}

int main()
{
    int n, m;
    cin >> n >> m;
    for(int i = 1; i <= n; ++ i) fa[i] = i;
    for(int i = 0; i < m; ++ i){
        int op,x,y;
        cin >> op >> x >> y;
        if(op == 1) join(x,y);
        else{
            int fx = findfa(x);
            int fy = findfa(y);
            if(fx == fy) cout << "Y" << endl;
            else cout << "N" << endl;
        }
    }
//    cout<<"Hello, World!"<<endl;
    return 0;
}

