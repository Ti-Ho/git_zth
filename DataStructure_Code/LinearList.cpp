#include <bits/stdc++.h>

using namespace std;

//定义动态分配内存的线性表
#define InitSize 100
typedef struct a{
	char *data;
	int length, MaxSize;
}SqList;

//1. 插入操作
bool ListInsert(SqList &L, int i, char e){
	if(i < 1 || i > L.length + 1) return false;
	if(L.length >= L.MaxSize) return false;
	for(int j = L.length; j >= i; -- j)
		L.data[j] = L.data[j - 1];
	L.data[i - 1] = e;
	L.length ++;
	return true;
}

//2. 删除操作
bool ListDelete(SqList &L, int i, char &e){
	if(i < 1 || i > L.length) return false;
	e = L.data[i - 1];
	for(int j = i; j < L.length; j ++)
		L.data[j - 1] = L.data[j];
	L.length --;
	return true;
}

//3. 按值查找
int LocateElem(SqList L, char e){
	int i;
	for(i = 0; i < L.length; ++ i)
		if(L.data[i] == e)
			return i + 1;
	return -1;
}

//显示线性表
void ShowLinearList(SqList L){
	for(int i = 0; i < L.length; i ++)
		printf("%c", L.data[i]);
	printf("\n");
	return;
}

int main(){
	//0. 初始化线性表
	SqList L;
	L.data = new char[1005];
	L.length = 0;
	L.MaxSize = 1005;

	//1. 测试插入操作
	ListInsert(L, 1, 'z');
	ListInsert(L, 2, 't');
	ListInsert(L, 3, 'h');
	ShowLinearList(L);

	//2. 测试删除操作
	char del_ch;
	ListDelete(L, 1, del_ch);
	printf("deleted character is %c\n", del_ch);
	ShowLinearList(L);

	//3. 测试按值查找
	int loc = LocateElem(L, 'h');
	printf("%d\n", loc);

	return 0;
}