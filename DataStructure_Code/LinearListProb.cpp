#include <bits/stdc++.h>

using namespace std;

#define MaxSize 1005
typedef struct{
	int data[MaxSize];
	int length;
}SqList;

void showData(SqList L){
	for(int i = 0; i < L.length; ++ i)
		printf("%d\t", L.data[i]);
	printf("\n");
	return;
}

//初始化一个一般的顺序表
void InitList(SqList &L){
	L.data[0] = 5;
	L.data[1] = 1;
	L.data[2] = 3;
	L.data[3] = 8;
	L.data[4] = 9;
	L.data[5] = 16;
	L.data[6] = 74;
	L.data[7] = 4;
	L.length = 8;
	return;
}

//初始化一个有序的顺序表
void InitOrderedList(SqList &L){
	L.data[0] = 1;
	L.data[1] = 2;
	L.data[2] = 2;
	L.data[3] = 4;
	L.data[4] = 4;
	L.data[5] = 5;
	L.data[6] = 8;
	L.data[7] = 9;
	L.length = 8;
	return;
}

void InitOrderedList2(SqList &L){
	L.data[0] = 1;
	L.data[1] = 3;
	L.data[2] = 3;
	L.data[3] = 5;
	L.data[4] = 6;
	L.data[5] = 7;
	L.data[6] = 10;
	L.data[7] = 11;
	L.data[8] = 19;
	L.data[9] = 20;
	L.length = 10;
	return;
}

//p19 T1
bool Del_Min(SqList &L, int &value){
	if(L.length == 0) return false;
	value = L.data[0];
	int pos = 0;
	for(int i = 1; i < L.length; ++ i)
		if(L.data[i] < value){
			value = L.data[i];
			pos = i;
		}
	L.data[pos] = L.data[L.length - 1];
	L.length --;
	return true;
}

//p19 T2
void Reverse(SqList &L){
	int tmp;
	for(int i = 0; i < L.length/2; ++ i){
		tmp = L.data[i];
		L.data[i] = L.data[L.length - 1 - i];
		L.data[L.length - i - 1] = tmp;
	}
}

//p19 T3
void del_x_1(SqList &L, int x){
	int k = 0;
	for(int i = 0; i < L.length; ++ i)
		if(L.data[i] != x)
			L.data[k ++] = L.data[i];
	L.length = k;
}

void del_x_2(SqList &L, int x){
	int k = 0, i = 0;
	while(i < L.length){
		if(L.data[i] == x) k ++;
		else L.data[i - k] = L.data[i];
		i ++;
	}
	L.length = L.length - k;
}

//p19 T4
bool Del_s_t(SqList &L, int s, int t){
	int i, j;
	if(s >= t || L.length == 0) return false;
	for(i = 0; i < L.length && L.data[i] < s; ++ i);
	if(i >= L.length) return false;
	for(j = i; j < L.length && L.data[j] <= t; ++ j);
	for(; j < L.length; ++ i, ++j)
		L.data[i] = L.data[j];
	L.length = i;
	return true;
}

//p19 T5
void del_s_t2(SqList &L, int s, int t){
	int k = 0, i = 0;
	for(i = 0; i < L.length; ++ i){
		if(L.data[i] < s || L.data[i] > t)
			L.data[k ++] = L.data[i];
	}
	L.length = k;
}

//p19 T6
bool Del_Same(SqList &L){
	if(L.length == 0) return false;
	int k = 1, i;
	for(i = 1; i < L.length; ++ i){
		if(L.data[i] != L.data[i - 1])
			L.data[k ++] = L.data[i];
	}
	L.length = k;
	return true;
}

//p19 T7
void Merge(SqList L1, SqList L2, SqList &L3){
	int i, j;
	for(i = 0, j = 0; i < L1.length && j < L2.length;){
		if(L1.data[i] <= L2.data[j]){
			L3.data[i + j] = L1.data[i];
			i ++;
		} 
		else{
			L3.data[i + j] = L2.data[j];
			j ++;
		} 
	}
	while(i < L1.length){
		L3.data[i + j] = L1.data[i];
		i ++;
	}
	while(j < L2.length){
		L3.data[i + j] = L2.data[j];
		j ++;
	}
	L3.length = L1.length + L2.length;
}

//p120 T9
int B_Search(SqList L,int x){
	int l = 0, r = L.length;
	while(l < r){
		int mid = l + r >> 1;
		if(L.data[mid] >= x) r = mid;
		else l = mid + 1;
	}
	if(L.data[l] == x) return l;
	else return -1;
}

int main(){
	// 初始化线性表	
	SqList L;
	InitList(L);
	// 初始化有序线性表	
	SqList L2, L3;
	InitOrderedList(L2);
	InitOrderedList2(L3);


	// printf("----------------TEST T9----------------\n");
	// showData(L3);
	// int pos = B_Search(L3, 10);
	// printf("%d\n", pos);

	// printf("----------------TEST T7----------------\n");
	// SqList Result;
	// showData(L2);
	// showData(L3);
	// Merge(L2, L3, Result);
	// showData(Result);

	// printf("----------------TEST T1----------------\n");
	// int res;
	// Del_Min(L, res);
	// printf("%d\n", res);
	// showData(L);

	// printf("----------------TEST T2----------------\n");
	// Reverse(L);
	// showData(L);

	// printf("----------------TEST T3----------------\n");
	// del_x_1(L, 8);
	// showData(L);
	// del_x_2(L, 3);
	// showData(L);

	// printf("----------------TEST T4----------------\n");
	// showData(L2);
	// Del_s_t(L2, 2, 3);
	// showData(L2);

	// printf("----------------TEST T6----------------\n");
	// showData(L2);
	// Del_Same(L2);
	// showData(L2);

	return 0;
}