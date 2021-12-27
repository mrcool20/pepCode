#include<bits/stdc++.h>
using namespace std;

int findParent(int src,vector<int>&parent){
    
    if(parent[src]==src) return src;
    
    int p=findParent(parent[src],parent);

    parent[src]=p; 
    
    return p;
}


void merge(int p1,int p2,vector<int>&size,vector<int>&par){
    
    if(size[p1]<size[p2]){
        par[p1]=p2;
        size[p2]+=size[p1];
    }else{
        
        par[p2]=p1;
        size[p1]+=size[p2];
    }
    
}


int main(){
  int v,e;
  cout<<"Enter number of vertices"<<endl;
  cin >> v;
 
  cout<<"Enter number of edges"<<endl;
  cin>>e;
    
    vector<vector<int>>Edges;
    cout<<"Enter edges with weight"<<endl;
    for(int i=0;i<e;i++){
        int e1,e2,w;
        cin>>e1>>e2>>w;
        Edges.push_back({e1,e2,w});
    }
    
  sort(Edges.begin(),Edges.end(),[](vector<int> a ,vector<int>b){
       return  a[2]<b[2];
  });
    
   vector<vector<int>> mst;
    vector<int>parent(v,0);
    vector<int>size(v,1);
    size[0]=0;
    
    for(int i=1;i<v;i++){
        parent[i]=i;
        size[i]=1;
    }
    
    for(int i=0;i<e;i++){
        
         vector<int>edge=Edges[i];
        int p1=findParent(Edges[i][0],parent);
        int p2=findParent(Edges[i][1],parent);
        
        int minCost=0;
        
        if(p1!=p2){
            merge(p1,p2,size,parent);
            mst.push_back(edge);
            minCost+=edge[2];
        }
    }
    cout<<"MST for the given graph using Kruskal's Algorithm is:"<<endl;
    cout<<"v1 "<<" v2 "<<" weight"<<endl;
    for(vector<int> ele : mst){
            if(ele[0]<ele[1]){
                cout<<ele[0]<<"   "<<ele[1]<<"    "<<ele[2];
            }else{
                cout<<ele[1]<<"   "<<ele[0]<<"    "<<ele[2];

            }
        cout<<endl;
    }
}
