#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int n=8;
vector<vector<int>>graph(n,vector<int>());

void addEdge(int u,int v){
    graph[u].push_back(v);
}
void display(){
    for(int i=0;i<n;i++){
        cout<<i<<"->";
        for(int ele:graph[i]){
            cout<<ele<<",";
        }
        cout<<endl;
    }
}
void topo_dfs(int src,vector<bool>&vis,vector<int>&stack){
  vis[src]=true;
  for(int ele:graph[src]){
      if(!vis[ele]){
          topo_dfs(ele,vis,stack);
      }
    }
    stack.push_back(src);
      

}



void topologicalSortUsingDfs(){
    vector<bool>vis(n,false);
    vector<int>st;
    for(int i=0;i<n;i++){
        if(!vis[i]){
          topo_dfs(i,vis,st);
        }
    }
    for(int i=st.size()-1;i>=0;i--){
        cout<<st[i]<<" ";
    }
    cout<<endl;

}

void createGraph(){
    addEdge(0,1);
    addEdge(1,2);
    addEdge(2,3);
    addEdge(0,6);
    addEdge(5,3);
    addEdge(4,5);
    addEdge(7,4);
    addEdge(7,6);

    display();
}
void KhansAlgo(){
    vector<int>incidentEdges(n,0);
    for(int i=0;i<n;i++){
        for(int ele:graph[i]){
            incidentEdges[ele]++;
        }
    }
    queue<int>que,ans;
    for(int i=0;i<incidentEdges.size();i++){
        if(incidentEdges[i]==0){
            que.push(i);
        }
    }
// BFS tarversal
   while(que.size()!=0){
    int rvtx=que.front();
    que.pop();
    ans.push(rvtx);
    for(int ele:graph[rvtx]){
        if(--incidentEdges[ele]==0){
            que.push(ele);
        }
      
    }
   }
   if(ans.size()==graph.size()){
       cout<<"Topological sort:";
       while(ans.size()!=0){
           cout<<ans.front()<<" ";
           ans.pop();
       }
       cout<<endl;
   }else{
       cout<<"Cycle Detected"<<endl;
   }


}

//Using dfs  
//Cycle Detection using dfs
bool topo_dfs02(int src,vector<bool>&vis,vector<bool>&cycle,vector<int>&stack){
    vis[src]=true;
    cycle[src]=true;
    bool res=false;
    for(int ele:graph[src]){
      if(!vis[ele] ){
    res=res||topo_dfs02(ele,vis,cycle,stack);
      }else{ 
      if( cycle[ele]){
              cout<<"Cycle Detected";
              res=true;
              return res;
          }
    }
    }
    cycle[src]=false;
    stack.push_back(src);
    return res;
}


vector<int> leetcode_207And211(){
    vector<bool>vis(n,false);
    vector<bool>cycle(n,false);
    vector<int>stack;
    bool res=false;
    for(int i=0;i<n ;i++){
        if(!vis[i]){
            res=res|| topo_dfs02(i,vis,cycle,stack);
        }
    }
    
  
    if(res){
        stack.clear();
        return stack;
    }else{
        return stack;
    }
}

void solve(){
    createGraph();
    topologicalSortUsingDfs();
    KhansAlgo();
    vector<int>ans=leetcode_207And211();
    cout<<"Topological Sort using Dfs:";
    for(int i=ans.size()-1;i>=0;i--){
        cout<<ans[i]<<" ";
    }
    cout<<endl;
    cout<<"Topological Sort using less space i.e avoiding cycle vector used in above method"<<endl;

}

int main(){

solve();


}