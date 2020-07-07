#include <bits/stdc++.h>

using namespace std;

typedef struct Node{
    char data;
    struct Node *lchild, *rchild;
}Node;

char pre[105];
char in[105];

//1. 先序遍历
void PreOrder(Node *node){
    if(node != NULL){
        cout << node->data;
        PreOrder(node->lchild);
        PreOrder(node->rchild);
    }
}

//2. 中序遍历
void InOrder(Node *node){
    if(node != NULL){
        InOrder(node->lchild);
        cout << node->data;
        InOrder(node->rchild);
    }
}

//3. 后序遍历
void PostOrder(Node *node){
    if(node != NULL){
        PostOrder(node->lchild);
        PostOrder(node->rchild);
        cout << node->data;
    }
}

//4. 层次遍历
void LevelOrder(Node *root){
    queue<Node*> q;
    q.push(root);
    while(!q.empty()){
        Node *now = q.front();
        q.pop();
        cout << now->data << " ";
        if(now->lchild != NULL)
            q.push(now->lchild);
        if(now->rchild != NULL)
            q.push(now->rchild);
    }
}

//按照前序遍历创建树
Node *CreateTree(){
    Node* node = NULL;  //这里要加NULL,不然会出错
    char ch = getchar();
    if(ch != '#'){
        node = new Node;
        node->data = ch;
        node->lchild = CreateTree();
        node->rchild = CreateTree();
    }
    return node;
}

//按照先序和中序创建二叉树
Node* createByPreAndIn(int preL, int preR, int inL, int inR){
    if(preL > preR) return NULL;
    Node *root = new Node;
    root -> data = pre[preL];
    int i;
    for(i = inL; i <= inR; ++ i){
        if(in[i] == pre[preL]) break;
    }
    int cnt_l = i - inL;
    root->lchild = createByPreAndIn(preL + 1, preL + cnt_l, inL, i - 1);
    root->rchild = createByPreAndIn(preL + 1 + cnt_l, preR, i + 1, inR);
    return root;
}

int main() {
    Node *root = CreateTree();
    PreOrder(root);
    cout << endl;
    InOrder(root);
    cout << endl;
    PostOrder(root);
    cout << endl;
    LevelOrder(root);
    cout << endl;
    int n;
    cin >> n;
    for(int i = 0; i < n; ++ i) cin >> in[i];
    for(int i = 0; i < n; ++ i) cin >> pre[i];
    root = createByPreAndIn(0, n-1, 0, n-1);
    PreOrder(root);
    return 0;
}

/*input
124##56##7##3#89##c##

8
7 2 3 4 6 5 1 8
5 3 7 2 6 4 8 1
 * */