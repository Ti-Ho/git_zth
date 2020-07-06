#include <bits/stdc++.h>

using namespace std;

typedef struct Node{
	int data;
	Node *next;
}Node;

//1. 头插法创建链表
void List_HeadInsert(Node *L, int n){
	// 创建节点
	for(int i = 0; i < n; ++ i){
		Node *new_node = new Node;
		new_node -> data = i + 1;
		new_node -> next = L -> next;
		L -> next = new_node;
	}
}

//2. 尾插法创建链表
void List_TailInsert(Node *L, int n){
	// 初始化尾部节点为头节点
	Node *r = L;
	for(int i = 0; i < n; ++ i){
		Node *new_node = new Node;
		new_node -> data = i;
		r -> next = new_node;
		r = new_node;
	}
	r -> next = NULL;
}

//3. 按照序号查找节点值
Node *GetElem(Node *L, int i){
	Node *p = L -> next;
	int cnt = 1;
	if(i == 0) return L;
	if(i < 1) return NULL;
	while(p && cnt < i){
		p = p -> next;
		cnt ++;
	}
	return p;
}

//4. 按值查找表节点
Node *LocateElem(Node *L, int val){
	Node *p = L -> next;
	while(p != NULL && p -> data != val){
		p = p -> next;
	}
	return p;
}

//5. 插入节点操作
void InsertNode(Node *L, Node *new_node, int i){ //在第i个位置插入节点
	Node *p = GetElem(L, i - 1); // 找到插入位置的前驱节点
	new_node -> next = p -> next;
	p -> next = new_node;
}

//6. 删除节点操作
void DeleteNode(Node *L, int i){
	Node *p = GetElem(L, i - 1);
	Node *tmp = p -> next;
	p -> next = tmp -> next;
	free(tmp);
}

//遍历链表
void ShowLinkList(Node *L){
	// 第一个节点
	Node *node = L -> next;
	while(node){
		cout << node -> data << " ";
		node = node -> next;
	}
	cout << endl;
}

int main(){
	//创建头节点
	Node *L = new Node;
	L -> data = 5; // 头节点的data可以存放链表长度
	L -> next = NULL;

	// List_HeadInsert(L, L -> data);
	// ShowLinkList(L);

	List_TailInsert(L, L->data);
	ShowLinkList(L);

	// Node *res = GetElem(L, 2);
	// cout << res -> data << endl;

	// Node *res2 = LocateElem(L, 3);
	// cout << res2 -> data << endl;

	// Node *new_node;
	// new_node -> data = 10001;
	// new_node -> next = NULL;
	// InsertNode(L, new_node, 4);
	// ShowLinkList(L);

	DeleteNode(L, 2);
	ShowLinkList(L);
	return 0;
}