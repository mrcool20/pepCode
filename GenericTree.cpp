#include<iostream>
#include<vector>
using namespace std;
class Node{
    public:
    int data=0;
    vector<Node*>children;
};
Node* tail=NULL;
Node* Linearize(Node *root){
    if(root==NULL){
     return ;
    }
    
 for(int i=root->children.size()-1;i>=0;i--){
   Node *ans1=Linearize(root->children[i]);
   
 }


}



int main(){

}