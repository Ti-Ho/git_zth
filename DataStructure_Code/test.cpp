#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#define InitSize 10
typedef struct {
    int *data;
    int Length,Maxsize;
}SeqList;
//初始化顺序表
void InitList(SeqList *L){
    L->data=(int *)malloc(sizeof(int)*InitSize);
    L->Maxsize=InitSize;
    L->Length=0;
}
//输出顺序表
void outputList(SeqList L)
{
    for(int i=0;i<L.Length;i++)
    {
        printf("%d",L.data[i]);
    }
    printf("\n");
}
//插入数据
bool insertElem(SeqList *L,int i,int &value){
    if(i<1||i>L->Length+1)
    {
        return false;
    }
   if(L->Length>=L->Maxsize)
   {
       return false;
   }
    for(int j=L->Length;j>i;j--)
    {
        L->data[j]=L->data[j-1];
    }
    L->data[i-1]=value;
    L->Length++;
    return true;
}
//按序删除数据
bool deleteElembyid(SeqList *L,int i,int &val)
{
    if(i<1||i>L->Length)
    {
        return false;
    }
    val = L -> data[i - 1];
    for(int j=i;j<L->Length;j++)
    {
        L->data[j-1]=L->data[j];
    }
    L->Length--;
    return true;
}
int main() {
    SeqList L;
    InitList(&L);
    for(int i=0;i<=L.Maxsize;i++)
    {
        insertElem(&L,i,i);
    }
    outputList(L);
    int val;
    deleteElembyid(&L,2, val);
    printf("%d\n", val);
    outputList(L);
    return 0;
}   