#include <bits/stdc++.h>
#include<queue>
#include<vector>
using namespace std;

 void addEdge(int u,int v,vector<vector<int>>&graph){
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
  void display(vector<vector<int>>&graph){
        for(int i=1;i<graph.size();i++){
            cout<<i<<"->"<<" ";
            for(int ele:graph[i]){
                cout<<ele<<" ";
            }
            cout<<endl;
        }
    }

int main(){
    int q;
    cin>>q;
    while(q-->0){
    int n,m;
    cin>>n>>m;
    vector<vector<int>>graph(n+1,vector<int>());
    for(int i=0;i<m;i++){
        int u,v;
        cin>>u,v;
        addEdge(u,v,graph);
    }
    
   int src;
    cin>>src;
    display(graph);
}
}