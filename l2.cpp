#include<iostream>
using namespace std;
 getVisited(int **arr,int s,int d){
   arr[s][d]=1;
}
int findPath(int **arr,int s,int d,int m,int n){
 if(s==d){
     return 0;
 }
    if((s<0 && d<0) ||(s>=n && d>=m) ){
    return 0;
    }
     
     int x=findPath(arr,s,d+1,m,n);
     int y=findPath(arr,s+1,d,m,n);
     int z=findPath(arr,s-1,d,m,n);
     int w=findPath(arr,s,d-1,m,n);
    
}

int main(){

//     int a[5][5];
// for(int i=0;i<5;i++){
//     for(int j=0;j<5;j++){
//         cin>>a[i][j];
//     }
// }
int s,d;
vector<vector<int>>arr(5,vector<int>(5,0));
cin>>s>>d;
cout<<findPath(arr,s,d,5,5);
}