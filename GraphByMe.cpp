#include<iostream>
#include<vector>
using namespace std;

class Edge
{
public:
    int v = 0;
    int w = 0;

    Edge(int v, int w)
    {
        this->v = v;
        this->w = w;
    }
};
const int n=7;
vector<Edge*>graph[n];// Created vector array of size n;
void addEdge(int u,int v,int w){
    //Bidirectional Graph
    graph[u].push_back(new Edge(v,w));
    graph[v].push_back(new Edge(u,w));

}
void display(){
    for(int i=0;i<n;i++){
       cout<<i<<"->";
        for(Edge* ele:graph[i]){
            cout<<ele->v<<","<<ele->w;
        }
        cout<<endl;
    }
    cout<<endl;
}
void createGraph(){
    addEdge(0, 1, 10);
    addEdge(0, 3, 10);
    addEdge(1, 2, 10);
    addEdge(2, 3, 40);
    addEdge(3, 4, 2);
    addEdge(4, 5, 2);
    addEdge(4, 6, 8);
    addEdge(5, 6, 3);

    addEdge(7, 8, 3);
    addEdge(2, 7, 3);
    addEdge(2, 8, 3);
    display();
}

int main(){
createGraph();
return 0;
}
