#include <iostream>
#include<queue>
#include<vector>
using namespace std;


class Edge{
    public:
    int u;
    int weight;
    int v;
    Edge(int u,int v,int weight){
        this->u=u;
        this->v=v;
        this->weight=weight;
    }
};

void display(vector<int>dis){

    cout<<"Shortest distance from Source Vertex(0) for each vertex"<<endl;
    cout<<endl;
    for(int i=0;i<dis.size();i++){
        cout<<"Vertex:"<<i<<","<<"Shortest Distance:"<<dis[i]<<endl;
    }
}


void Bellman(vector<vector<Edge*>>&graph, int src,vector<int>&dis,int E,int V) 
{   
    dis[src] = 0; 

    for (int i=1; i<=V-1;i++) { 
        for (int j=0;j<E;j++) {         
            int u = graph[j][0]->u; 
            int v = graph[j][0]->v; 
            int weight = graph[j][0]->weight; 
            if (dis[u] != INT32_MAX && dis[u] + weight < dis[v]) 
                dis[v] = dis[u] + weight; 
        } 
    } 
  
    for (int i = 0; i < E; i++) { 
        int u = graph[i][0]->u; 
        int v = graph[i][0]->v; 
        int weight = graph[i][0]->weight; 
        if (dis[u] != INT32_MAX && dis[u] + weight < dis[v]) { 
            cout<<"Negative weight cycle detected"<<endl; 
            return; 
        } 
    } 
  
  display(dis); 
  
    return; 
} 



int main()
{
  int V, E;
  cout<<"Enter number of vertices"<<endl;
  cin >> V;
 
  cout<<"Enter number of edges"<<endl;
  cin>>E;
   vector<vector<Edge*>> graph(E,vector<Edge*>());

   cout<<"Enter edges with weight"<<endl; 
   for(int i=0;i<E;i++){
       int u,v,w;
       cin>>u>>v>>w;
       graph[i].push_back(new Edge(u,v,w));
   }
  
    vector<int>dis(V,INT32_MAX);  
    Bellman(graph,0,dis,E,V);
 

  return 0;
}
