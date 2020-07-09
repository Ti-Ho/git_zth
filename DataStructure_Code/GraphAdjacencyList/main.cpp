#include <iostream>
#include <queue>
#include <string.h>
#include <algorithm>

using namespace std;
/*
const int maxn = 1000005;
int ver[maxn], Next[maxn], edge[maxn], head[maxn];
int tot;
int vis[maxn];


void add(int x,int y,int z){
    ver[++ tot] = y, edge[tot] = z;
    Next[tot] = head[x], head[x] = tot;
}

void dfs(int x){
    vis[x] = 1;
    for(int i = head[x]; i; i = Next[i]){
        int y = ver[i];
        if(!vis[y]) dfs(y);
        //cout << y << " " << z << endl;
    }
}

void bfs(int x){
    queue<int> q;
    q.push(x);
    vis[x] = 1;
    while(!q.empty()){
        int x = q.front();
        q.pop();
        for(int i = head[x]; i ; i = Next[i]){
            int y = ver[i];
            if(!vis[y]){
                vis[y] = 1;
                q.push(y);
            }
        }
    }
}

//Prim算法

const int maxm = 3005;
int a[maxm][maxm], d[maxn];
bool v[maxn];
int n, m, ans;

void Prim(){
    memset(d, 0x3f, sizeof(d));
    memset(v, 0, sizeof(v));
    d[1] = 0;
    for(int i = 0; i < n - 1; ++ i){
        int x = 0;
        for(int j = 1; j <= n; ++ j)
            if(!v[j] && (d[j] < d[x])) x = j;
        v[x] = 1;
        for(int j = 1; j <= n; ++ j)
            if(!v[j]) d[j] = min(d[j], a[x][j]);
    }
}
*/
const int maxn = 500010;
typedef struct Node{
    int x, y, z;
};
Node edge[maxn];
int fa[maxn], n, m;

int findfa(int x){
    return x == fa[x] ? x : fa[x] = findfa(x);
}

bool cmp(Node x, Node y){
    return x.z < y.z;
}

int main() {
    cin >> n >> m;
    for(int i = 1; i <= m; ++ i){
        int x, y, z;
        cin >> edge[i].x >> edge[i].y >> edge[i].z;
    }
    sort(edge + 1, edge + 1 + m, cmp);
    for(int i =  1; i <= n; ++ i) fa[i] = i;
    for(int i = 1; i <= m; ++ i){
        int fx = findfa(edge[i].x);
        int fy = findfa(edge[i].y);

        if(fx == fy) continue;
        fa[fx] = fa[fy];
    }
    /*
    cin >> n >> m;
    memset(a, 0x3f, sizeof(a));
    for(int i = 1; i <= n; ++ i) a[i][i] = 0;
    for(int i = 0; i < m; ++ i){
        int x, y, z;
        cin >> x >> y >> z;
        a[x][y] = min(a[x][y], z);
    }
    Prim();

    //dfs
    int n;
    for(int i = 0; i < n; ++ i)
        if(!vis[i]) dfs(i);

    //bfs
    for(int i = 0; i < n; ++ i)
        if(!vis[i]) bfs(i);
    */
}