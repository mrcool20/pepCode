#include<bits/stdc++.h>
using namespace std;


void bfs(vector<vector<int>>&graph, int src,vector<bool>&vis){

  queue<int>que;
  que.push(src);
  int level=0;
  while(que.size()!=0){
   int size=que.size();
   while(size-->0){
    int rvtx=que.front();
    
    que.pop();
    if(vis[rvtx]==true){
        cout<<endl;
     // cout<<"Cycle wrt"+to_string(src)+" &"+to_string(rvtx)<<endl;
      cout<<"Cycle Detected"<<endl;
      continue;
    }
    cout<<rvtx<<" ";
    vis[rvtx]=true;
    for(int ele:graph[rvtx]){
      if(!vis[ele]){
      que.push(ele);
      }
    }
   }
   level++;
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

    vector<bool>vis(v,false);
    cout<<"BFS Traversal"<<endl;
    bfs(graph,0,vis);
    return 0;

}