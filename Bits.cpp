#include<iostream>
#include<vector>
using namespace std;
void DecimalToBinary(int n){
    vector<int>arr;
    int i=0;
    while(n>0){
        arr.push_back(n%2);
        n=n/2;
        i++;
    }
    for(int j=arr.size()-1;j>=0;j--)
    {
        cout<<arr[j];
    }
}
void ToggleGivenBit(int n,int k){
    int mask=1<<k;
    int num=(n^mask);
    DecimalToBinary(num);
}
void turnOffGivenBit(int n,int k){
    int mask=1<<k;
    int revMask=~mask;
    int num=(revMask&n);
    DecimalToBinary(num);
}
void setGivenBit(int n,int k){
    //We will use bitwise OR
    int mask=1<<k;
    int num=(n|mask);
    DecimalToBinary(num);
    cout<<endl;

}
void turnTheBitOn(int n,int k){
    //We will use bitwise AND
    int mask=1<<k;
    int num=(n&mask);
    DecimalToBinary(num);
    cout<<endl;
    if((n&mask)==0){
        cout<<"Not Set";
    }else{
        cout<<"Set";
    }
}

int main(){
    int n=5;
    int k=3;
    DecimalToBinary(n);
    cout<<endl;
    //turnTheBitOn(n,3);
    //setGivenBit(n,2);
   // turnOffGivenBit(n,3);
   //ToggleGivenBit(n,2);
    
    
}

