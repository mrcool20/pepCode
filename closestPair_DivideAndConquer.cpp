#include<bits/stdc++.h>
using namespace std;

float minDistanceFormula(vector<vector<int>>&points){
    float minDistance=FLT_MAX;
    
    for(int i=0;i<points.size();i++){
        for(int j=i+1;j<points.size();j++){
              float d = sqrt((points[j][0]- points[i][0]) * (points[j][0]- points[i][0]) +
                                 (points[j][1]- points[i][1]) * (points[j][1]- points[i][1]));
               minDistance=min(minDistance,d);                  
        }
    }
    return minDistance;
}

float minMiddleArray(vector<vector<int>> &middleArray,float d){

     float minDist=d;
     sort(middleArray.begin(),middleArray.end(),[](vector<int>& a , vector<int>& b ){
           
           return a[1]<b[1]; 
     });

     for(int i=0;i<middleArray.size();i++){
        for(int j=i+1;j<middleArray.size() && abs(middleArray[j][1] - middleArray[j][0])<d;j++){
              float d = sqrt((middleArray[j][0]- middleArray[i][0]) * (middleArray[j][0]- middleArray[i][0]) +
                                 (middleArray[j][1]- middleArray[i][1]) * (middleArray[j][1]- middleArray[i][1]));
               minDist=min(minDist,d);                  
        }
    }
    return minDist;


    
     
}


float minDistance(vector<vector<int>> &points,int si,int ei){

 if((ei-si)+1 < 4)  return minDistanceFormula(points); 

  int mid = si+((ei-si)/2);
  int midx = points[mid][0];
  int midy = points[mid][1];
float leftMinDist=minDistance(points,si,mid);
float rightMinDist=minDistance(points,mid+1,ei);

float overallMinDist=min(leftMinDist,rightMinDist);

vector<vector<int>>middleArray;

for(int i=0;i<=ei;i++){
   if(abs(points[i][0] - midx)<=overallMinDist){
       middleArray.push_back(points[i]);
   }
}


  return min(overallMinDist,minMiddleArray(middleArray,overallMinDist));
   

}

int main(){

vector<vector<int>> points={{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};

// Sort on basis of x coordinate;
sort(points.begin(),points.end());
cout<<minDistance(points,0,points.size()-1);

}