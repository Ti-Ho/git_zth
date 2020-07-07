#include <bits/stdc++.h>

using namespace std;

typedef struct Node{
    int data;
    Node *l, *r;
}Node;
int n, a[10000005];
Node *BST_insert(Node *root, int x){
    if(root == NULL){
        root = new Node;
        root -> l = NULL;
        root -> r = NULL;
        root -> data = x;
        return root;
    }
    if(root->data > x) root->l = BST_insert(root->l, x);
    if(root->data < x) root->r = BST_insert(root->r, x);
    return root;
}

Node *Create_BST(){
    Node *root = NULL;
    for(int i = 0; i < n; ++ i)
        root = BST_insert(root, a[i]);
    return root;
}

void InOrder(Node *node){
    if(node != NULL){
        InOrder(node->l);
        cout << node->data;
        InOrder(node->r);
    }
}

int main(){
    cin >> n;
    for(int i = 0; i < n; ++ i) cin >> a[i];
    Node *root = Create_BST();
    InOrder(root);
}

/*
6
45 24 53 45 12 24
 * */