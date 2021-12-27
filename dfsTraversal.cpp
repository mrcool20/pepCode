#include<bits/stdc++.h>
using namespace std;

void dfs(vector<vector<int>>&graph,vector<bool>&vis,int u){
   
   vis[u]=true;
   cout<<u<<" ";

   for(int ele:graph[u]){
       if(!vis[ele]){
           dfs(graph,vis,ele);
       }
   }

}

void addEdge(vector<vector<int>>&graph,int u,int v){
    //Bidirectional Graph
    graph[u].push_back(v);
    graph[v].push_back(u);

}

int main(){

int v,e;
  cout<<"Enter number of vertices"<<endl;
  cin >> v;
 
  cout<<"Enter number of edges"<<endl;
  cin>>e;
    
    vector<vector<int>>graph(v,vector<int>());
    cout<<"Enter edges:"<<endl;
    for(int i=0;i<e;i++){
        int v1,v2;
        cin>>v1>>v2;
        addEdge(graph,v1,v2);
    }

    cout<<"Adjacency List:"<<endl;
    for(int i=0;i<graph.size();i++){
        cout<<i<<"->";
        for(int ele:graph[i]){
          cout<<ele<<",";
        }
        cout<<endl;
    }

    vector<bool>vis(v,false);
    cout<<"DFS Traversal"<<endl;
    dfs(graph,vis,0);
    return 0;

}