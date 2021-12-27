#include<bits/stdc++.h>
using namespace std;

int maxSumAtMostKEle(int* arr,int idx,int k){
   
   if(idx>=7 || k==0) return 0; 

   int ans1= arr[idx]+ maxSumAtMostKEle(arr,idx+2,k-1);
   int ans2= maxSumAtMostKEle(arr,idx+1,k); 
   
   return max(ans1,ans2);

}

int main(){

 int arr[7]={-3,-5,11,10,-8,2,-18};
 cout<<maxSumAtMostKEle(arr,0,3);

}