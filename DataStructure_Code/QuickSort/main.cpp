#include <iostream>

using namespace std;

const int maxn = 100005;
int a[maxn];

int Partition(int l, int r){
    int pivot = a[l];
    int i = l, j = r;
    while(i < j){
        while(i < j && a[j] >= pivot) j --;
        a[i] = a[j];
        while(i < j && a[i] <= pivot) i ++;
        a[j] = a[i];
    }
    a[i] = pivot;
    return i;
}

void QuickSort(int l, int r){
    if(l < r){
        int k = Partition(l, r);
        QuickSort(l, k - 1);
        QuickSort(k + 1, r);
    }
}

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; ++ i) cin >> a[i];
    QuickSort(0, n - 1);

    for(int i = 0; i < n; ++ i) cout << a[i] << " ";
    cout << endl;

    return 0;
}