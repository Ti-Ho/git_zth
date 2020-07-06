#include <bits/stdc++.h>

using namespace std;

typedef struct DNode{
	int data;
	DNode *prior, *next;
}DNode;

//尾插法创建链表
void List_TailInsert(DNode *L, int n){
	DNode *r = L;
	for(int i = 0; i < n; ++ i){
		DNode *newNode = new DNode;
		newNode -> data = i + 1;
		newNode -> prior = r;
		r -> next = newNode;
		r = newNode;
	}
	r -> next = NULL;
}

//输出双向列表
void ShowDoubleLinkedList(DNode *L){
	DNode *p = L -> next;
	while(p){
		cout << p -> data << " ";
		p = p -> next;
	}
	cout << endl;
}

// 按照序号查找节点值
DNode *GetElem(DNode *L, int i){
	DNode *p = L -> next;
	int cnt = 1;
	if(i == 0) return L;
	if(i < 1) return NULL;
	while(p && cnt < i){
		p = p -> next;
		cnt ++;
	}
	return p;
}

//双链表的插入操作
void InsertNode(DNode *L, DNode *s, int i){
	DNode *p = GetElem(L, i - 1);
	s -> next = p -> next;
	s -> prior = p;
	p -> next -> prior = s;
	p -> next = s;
}


//删除节点操作
void DeleteNode(DNode *L, int i){
	DNode *p = GetElem(L, i - 1);
	DNode *tmp = p -> next;
	p -> next = tmp -> next;
	p -> next -> prior = p;
	free(tmp);
}

int main(){
	DNode *L = new DNode;
	L -> next = NULL;
	List_TailInsert(L, 5);
	ShowDoubleLinkedList(L);


	DNode *s = new DNode;
	s -> data = 996;
	InsertNode(L, s, 4);
	ShowDoubleLinkedList(L);
	DeleteNode(L, 3);
	ShowDoubleLinkedList(L);

	return 0;
}