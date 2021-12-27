#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;
class Edge{
  public: 
    int v;
    int w;
    Edge(int v,int w){
       this->v=v;
       this->w=w; 
    }
};
const int n=9;
vector<vector<Edge*>> graph(n,vector<Edge*>());

//vector<Edge*>graph[n];
// void addEdge(int u,int v,int w){
//     Edge *e1=new Edge(v,w);
//    // Edge *e2=new Edge(u,w);
//     graph[u].push_back(e1);
//   //  graph[v].push_back(e2);
// }

void addEdge(int u,int v,int w){
    //Bidirectional Graph
    graph[u].push_back(new Edge(v,w));
    graph[v].push_back(new Edge(u,w));

}


void display_2D(vector<vector<Edge*>> graph){
    for(int i=0;i<7;i++){
        cout<<i<<"->";
        for(Edge *e :graph[i]){
         cout<<"("<<e->v<<","<<e->w<<") ";
        }
        cout<<endl;
    }
}
// void removeEdge(int u,int v){

// for(int i=0;i<graph[u].size();i++){
//     if(){

//     }
// }

// }
int searchVertex(int u,int v){

  int idx=-1;
  for(int i=0;i<graph[u].size();i++){
    if(graph[u][i]->v==v){
      idx=i;
      break; 
    }
  }
  return idx;
}
void removeEdge(int u,int v){
  //For a bidirectional graph we have to eliminate the edges from both the vertex;
  //So we have to search the indices in both of the vertices;
  int uIdx=searchVertex(u,v);
  int vIdx=searchVertex(v,u);
  //Ab agar uIDx agar exist karega to pakka vidx bhi exist karega I'm damn sure
  //Therefore we will check for uIdx
  if(uIdx!=-1){
    graph[u].erase(graph[u].begin()+uIdx);
    graph[v].erase(graph[v].begin()+vIdx);
  }
} 
void removeVertex(int u){
  for(int i=graph[u].size()-1;i>=0;i--){
    removeEdge(u,graph[u][i]->v);

  }
}

bool hasPath(int src,int dest,vector<bool>vis,string ans){
if(src==dest){
  cout<<ans+to_string(dest)<<endl;
  return true;
}

vis[src]=true;
bool res=false;
for(Edge *ele:graph[src]){
  if(!vis[ele->v])
  res=res||hasPath(ele->v,dest,vis,ans+to_string(src));
}
return res;
}
bool hasPath1(int src,int dest,vector<bool>vis,string ans){
if(src==dest){
  cout<<ans+to_string(dest)<<endl;
  return true;
}

vis[src]=true;
bool res=false;
for(int i=0;i<graph[src].size();i++){
  if(!vis[graph[src][i]->v])
  res=res||hasPath(graph[src][i]->v,dest,vis,ans+to_string(src));
}
return res;
}

int allPath(int src,int dest,vector<bool>vis,string ans){
if(src==dest){
  cout<<ans+to_string(dest)<<endl;
  return 1;
}

vis[src]=true;
int count=0;
//bool res=false;
for(Edge *ele:graph[src]){
  if(!vis[ele->v])
  count+=allPath(ele->v,dest,vis,ans+to_string(src));
}
vis[src]=false;
return count;
}

void BFS(int src,vector<bool>&vis){
  queue<int>que;
  que.push(src);
  int level=0;
  while(que.size()!=0){
   int size=que.size();
   while(size-->0){
    int rvtx=que.front();
    que.pop();
    if(vis[rvtx]==true){
      cout<<"Cycle wrt"+to_string(src)+" "+to_string(rvtx)<<endl;
      continue;
    }
    vis[rvtx]=true;
    for(Edge *e:graph[rvtx]){
      if(!vis[e->v]){
      que.push(e->v);
      }
    }
   }
   level++;
  }

}

void GCC(){
  vector<bool>vis(n,false);
  int count=0;
  for(int i=0;i<n;i++){
    if(!vis[i]){
      BFS(i,vis);
      count++;
    }
  }
  cout<<"Total Components: "<<count<<endl;
}

void display(){
    for(int i=0;i<n;i++){
       cout<<i<<"->";
        for(Edge* ele:graph[i]){
             cout<<"("<<ele->v<<","<<ele->w<<") ";
        }
        cout<<endl;
    }
   
}

void createGraph(){
    addEdge(0,1,10);
    addEdge(0,3,10);
    addEdge(1,2,10);
    addEdge(2,3,40);
    addEdge(3,4,2);
    addEdge(4,5,3);
    addEdge(4,6,4);
    addEdge(5,6,5);
    addEdge(2,7,3);
    addEdge(2,8,3);
    addEdge(7,8,3);
   // removeEdge(3,4);   //For GCC     
   // display();
    display_2D(graph);
}
// findVertexUsingBFS(int src,int dest,vector<bool>vis){
//   queue<int>que;
//   que.push(src);
//   int level=0;
//   while(!que.empty()){
//     int size=que.size();
//     while(size-->0){
//       int rvtx=que.front();
//       que.pop();
//       if(rvtx==dest){
//         cout<<"Found at level"<<level<<endl;
//       }
//       vis[rvtx]=true;
//       for(Edge *e:graph[rvtx]){
        
//       }
//     }
//   }
// }

int temp=1;
vector<int>articulationPoints(n,0);
void articulationPoint(int src,vector<int>&l, vector<int>&d,vector<bool>&vis,int parent){

    l[src]=temp;
    d[src]=temp;
     temp++;
    vis[src]=true;
    for(Edge *e:graph[src]){
      if(parent !=(e->v) && vis[e->v]){  
       l[src]=min(l[src],d[e->v]);
      }
      else if(parent!=e->v){
    articulationPoint(e->v,l,d,vis,src);
       if(l[e->v]>=d[src]){
         cout<<"articulation"<<src<<endl;
         articulationPoints[src]++;
       }else{
        l[src]=l[e->v];
       }
      }
    }
  

}
//vis is maintained for maintaining the color for the vertex
bool bipartite_BFS(int src,vector<int>&vis){
    //BFS
  queue<pair<int,int>>que;
  que.push({src,0});
  while(que.size()!=0){
    pair<int,int> rvtx=que.front();
    que.pop();
    int u=rvtx.first;
    int c=rvtx.second;
    if(vis[u]!=-1){
      if(vis[u]!=c){
        return false;
      }else{
        continue;
      }
    }
    vis[u]=c;
    for(Edge *e:graph[u]){
      if(vis[e->v]==-1){       
         que.push({e->v,(c+1)%2});
      }
    }
  }
  return true;

}
//DSU(Disjoint Sets Union)................................................

int findParent(int src,vector<int>&par){
  if(par[src]==src){
    return src;
  }
  int p=findParent(par[src],par);
  par[src]=p;  //Path Compression
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
//leetcode_684
vector<int> findRedundantConnection(vector<vector<int>>&Edges){
    vector<int>par;
    vector<int>size;
    for(int i=1;i<=Edges.size();i++){
      par[i]=i;
      size[i]=1;
    }

    for(int i=1;i<=Edges.size();i++){
    int p1=findParent(Edges[i][0],par);
    int p2=findParent(Edges[i][1],par);

    if(p1==p2){
      cout<<"Cycle";
      return {p1,p2};
    }else{
      merge(p1,p2,size,par);
    }
  }
  vector<int>ans;
  return ans;
}




void bipartite(){

vector<int> vis(n,-1);
  for(int i=0;i<n;i++){
    if(vis[i]==-1){
      cout<<(boolalpha)<<bipartite_BFS(i,vis)<<endl;
    }
  }
}


void solve(){
  createGraph();
 // cout<<searchVertex(0,3)<<endl;
  // removeEdge(0,3);
  // removeVertex(4);
  display();
   vector<bool>vis(n,false);
  // cout<<hasPath(0,5,vis,"")<<endl;
  // cout<<hasPath1(0,5,vis,"")<<endl;

  //  cout<<allPath(0,5,vis,"")<<endl;
  //  BFS(0,vis);
  //  GCC();
   //findVertexUsingBFS(0,6);
  vector<int>lowestTime(n,0);
  vector<int>discoveryTime(n,0);
  int count=0;
  vis[0]=true;
  
  for(Edge *e:graph[0]){
    {
      if(!vis[e->v]){
  articulationPoint(e->v,lowestTime,discoveryTime,vis,0);
      count++;
      }
    }
    if(count>1){
      cout<<"Articulation point at "<<0<<endl;
    }
  }
  for(int i=0;i<articulationPoints.size();i++){
      if(articulationPoints[i]==1){
        cout<<i;
      }
  }
}







int main(){
  //solve();
  cout<<endl;
  bipartite();
  return 0;
}