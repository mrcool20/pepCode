import java.util.Scanner;

public class CoinChange{
    public static Scanner scn = new Scanner(System.in);
 public static void main(String []args){
     int []arr={2,3,5,7};
     //int []arr={10,1,2,7,6,1,5};
   System.out.println("Total Answer:"+PermutationsInfinite(arr,10,"",0)); 
   // System.out.println("Total Answer:"+PermutationsWithoutRepeatation(arr,10,"",0)); 
    //System.out.println(CombinationsInfinite(arr,10,"",0));
   //System.out.println(CombinationsWithoutRepeatation(arr,8,"",0));
   // System.out.println(CombiWithSubseqWithoutRep(arr,10,"",0));
   // System.out.println(CombiWithSubseqRepeatation(arr,10,"",0));
   //System.out.println(PermutationwithSubseqWithRepeatation(arr,10,"",0));
   //System.out.println(PermutationwithSubseqWithoutRepeatation(arr,10,"",0));
   //System.out.println(PermutationwithSubseqWithoutRepeatationBits(arr,10,"",0));


 }
 //Permutations with Repeatation
 //Here we don't need any vidx used by mistaske only..........
public static int PermutationsInfinite(int []arr,int target,String asf,int vidx){
     if(target==0){
         System.out.println(asf);
         return 1;
     }
     int count=0;
    for(int i=0;i<arr.length;i++){
       if((target-arr[i])>=0){
       count+=PermutationsInfinite(arr,target-arr[i],asf+" "+arr[i],i+1);
       }
   }
   return count;
}
public static boolean[] vis=new boolean[4];
public static int PermutationsWithoutRepeatation(int []arr,int target,String asf,int vidx){
    if(target==0){
        System.out.println(asf);
         return 1;
    }
    
    int count=0;
    for(int i=0;i<arr.length;i++){
        if(vis[i]==false){
            
        if(target-arr[i]>=0){   
            vis[i]=true;       
       count+=PermutationsWithoutRepeatation(arr, target-arr[i], asf+arr[i],i);
        vis[i]=false;
        }
    }
    }
    return count;
}
//leu:last element used index
public static int CombinationsInfinite(int []arr,int target,String asf,int leu){
    if(target==0){
        System.out.println(asf);
        return 1;
    }
    int count=0;
    for(int i=leu;i<arr.length;i++){
        if(target-arr[i]>=0)
        count+=CombinationsInfinite(arr,target-arr[i], asf+arr[i],i);


    }
    return count;

}
public static int CombinationsWithoutRepeatation(int []arr,int target,String asf,int leuidx){
    if(target==0){
        System.out.println(asf);
        return 1;
    } 
    int count=0;
    for(int i=leuidx;i<arr.length;i++){
        if(target-arr[i]>=0)
        count+=CombinationsWithoutRepeatation(arr, target-arr[i], asf+arr[i], i+1);

    }
    return count;
}
//Using Bit Masking
public static int visited=0;
public static int PermutationwithSubseqWithoutRepeatationBits(int []arr,int target,String asf,int idx){
    if(target==0|| idx==arr.length){
     if(target==0){
         System.out.println(asf);
         return 1;
     }        
     return 0;
    }

    int count=0;
    //boolean[] vis=new boolean[4];
   
    int mask=1<<idx;
    count+=PermutationwithSubseqWithoutRepeatationBits(arr,target,asf,idx+1);
     if((visited&mask)==0 && (target-arr[idx]>=0)){
      visited=(visited^mask);
    count+=PermutationwithSubseqWithoutRepeatationBits(arr,target-arr[idx],asf+arr[idx],0);
    visited=(visited^mask);
    
}
    return count;
}


//Using boolean array
public static int PermutationwithSubseqWithoutRepeatation(int []arr,int target,String asf,int idx){
    if(target==0|| idx==arr.length){
     if(target==0){
         System.out.println(asf);
         return 1;
     }        
     return 0;
    }

    int count=0;
    //boolean[] vis=new boolean[4];
    count+=PermutationwithSubseqWithoutRepeatation(arr,target,asf,idx+1);
     if(!vis[idx] && (target-arr[idx]>=0)){
      vis[idx]=true;
    count+=PermutationwithSubseqWithoutRepeatation(arr,target-arr[idx],asf+arr[idx],0);
    vis[idx]=false;
    
}
    return count;
}
public static int PermutationwithSubseqWithRepeatation(int []arr,int target,String asf,int idx){
    int count=0;
    if(target==0 || idx==arr.length){
        if(target==0){
            System.out.println(asf);
            return 1;
        }
        return 0;
    }
    count+=PermutationwithSubseqWithRepeatation(arr, target, asf, idx+1);
    if(target-arr[idx]>=0){
        count+=PermutationwithSubseqWithRepeatation(arr, target-arr[idx], asf+arr[idx], 0);

    }
    return count;    
}

public static int CombiWithSubseqRepeatation(int []arr,int target,String asf,int idx){
    if(target==0 || idx==arr.length){
         if(target==0){
        System.out.println(asf);
        return 1;
        }
        return 0;
        
    }


    int count=0;
    if((target-arr[idx])>=0){
        count+=CombiWithSubseqRepeatation(arr, target-arr[idx], asf+arr[idx], idx);
    }
        count+=CombiWithSubseqRepeatation(arr, target, asf, idx+1);
     return count;
}

public static int CombiWithSubseqWithoutRep(int []arr,int target,String asf,int idx){
    if(target==0||idx==arr.length){
        if(target==0){
        System.out.println(asf);
        return 1;
        }
        return 0;
    }
    int count=0;
    if((target-arr[idx])>=0){    
   
    count+=CombiWithSubseqWithoutRep(arr, target-arr[idx], asf+arr[idx],idx+1);
    }
    count+=CombiWithSubseqWithoutRep(arr,target,asf,idx+1);
    return count;
}


}