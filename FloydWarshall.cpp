#include <bits/stdc++.h> 
using namespace std; 
    
 
  
void display(vector<vector<int>>&shortDis)  
{  
    cout<<"The shortest distance between all pair of vertices are tabulated below"<<endl;  
   
      for(vector<int> v:shortDis){
          for(int ele: v){
              cout<<ele<<" ";
          }
          cout<<endl;
      }

}    
 
void Floyd(vector<vector<int>>&graph)  
{  
   
    vector<vector<int>>shortDis(graph.size(),vector<int>(graph.size(),0));
   
    for (int i=0;i<graph.size();i++)  
        for (int j=0;j<graph.size();j++)  
            shortDis[i][j]=graph[i][j];  
  
      for (int k=0;k<graph.size();k++)  
    {  
        
        for (int i=0;i<graph.size();i++)  
        {  
            for (int j=0;j<graph.size();j++)  
            {  
                if (shortDis[i][k]+shortDis[k][j]<shortDis[i][j])  
                    shortDis[i][j]=shortDis[i][k]+shortDis[k][j];  
            }  
        }  
    }  
  
     
    display(shortDis);  
}  

int main()  
{  
    int v;
    cout<<"Enter the number of vertices:";
    cin>>v; 
    
    int INF=99;
    vector<vector<int>> graph(v,vector<int>(v,0));
     cout<<"Enter weights less than 99 only"<<endl; 
     cout<<"If there is no edge between two vertices input -1 as a weight"<<endl;
     cout<<"Enter weights of the edges respectively"<<endl;
    for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
            cin>>graph[i][j];
            if(graph[i][j]==-1){
                graph[i][j]=INF;
            }
        }
    }

    Floyd(graph);  
    return 0;  
}  
      // int graph[V][V] = { {0,3,INF,5},  
    //                     {2, 0,INF,4},  
    //                     {INF,1,0,INF},  
    //                     {INF,INF,2,0}  
    //                 };  
  
    // Print the solution  
