#include <iostream>
#include<queue>
#include<vector>
using namespace std;


class dPair{
  public:
    int src;
    int par;
    int wsf;
   dPair(int src,int par,int wsf){
       this->src=src;
       this->par=par;
       this->wsf=wsf;
   } 
  bool operator<(const dPair &p1) const {
      return this->wsf>p1.wsf;
  } 
    
    
};
class Edge{
    public:
    int weight;
    int v;
    Edge(int v,int weight){
        this->v=v;
        this->weight=weight;
    }
};

void addEdge(int u,int v,int w,vector<vector<Edge*>>&graph){
    graph[u].push_back(new Edge(v,w));
   // graph[v].push_back(new Edge(u,w));
    
}
void display(vector<vector<Edge*>>&graph,int n){
    for(int i=0;i<n;i++){
        cout<<i<<" ->";
        for(Edge* ele:graph[i]){
            cout<<"("<<ele->v<<","<<ele->weight<<")"<<" ";
        }
        cout<<endl;
    }
}

void DijkstrasAlgo(int src,vector<vector<Edge*>>&graph,vector<bool>&vis){
    priority_queue<dPair>que;
    que.push(dPair(src,-1,0));
    while(que.size()!=0){
        dPair rvtx=que.top();
        que.pop();
        if(vis[rvtx.src]){
            continue;
        }
        vis[rvtx.src]=true;
        if(rvtx.par!=-1)
        cout<<"Vertex:"<<rvtx.src<<","<<"Shortest Distance:"<<rvtx.wsf<<endl;

        for(Edge* ele:graph[rvtx.src]){
            if(!vis[ele->v]){
                que.push(dPair(ele->v,rvtx.src,ele->weight+rvtx.wsf));
            }
        }
    }
}


int main()
{
  int V, E;
  cout<<"Enter number of vertices"<<endl;
  cin >> V;
 
  cout<<"Enter number of edges"<<endl;
  cin>>E;
  vector<vector<Edge*>> graph(V,vector<Edge*>());
   cout<<"Enter edges with weight"<<endl;
   for(int i=0;i<E;i++){
       int u,v,w;
       cin>>u>>v>>w;
       addEdge(u,v,w,graph);
   }
  cout<<"Adjacency List for Input Graph"<<endl; 
  
  display(graph,V);
  vector<bool>vis(V,false);  
  
  cout<<endl; 
  cout<< "Shortest distance from Source(0) for each vertex"<<endl;
  cout<<"Vertex:0"<<","<<"Shortest Distance:0"<<endl;
  DijkstrasAlgo(0,graph,vis);

 

  return 0;
}
