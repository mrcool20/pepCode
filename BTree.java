import java.util.Scanner;
import java.util.LinkedList;

public class BTree {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        // int[]
        // arr={10,20,30,-1,-1,40,-1,-1,50,60,70,80,-1,-1,-1,70,90,-1,100,-1,-1,-1};
       int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        // int []arr1={-15,5,-8,2,-1,-1,6,6,3,-1,-1,9,-1,0,4,-1,-1,7,10,-1,-1,-1};
        // Node root1=Construct(arr1);
        // display(root1);
       Node root = Construct(arr);
         display(root);
    //     System.out.println(size(root));
    //     System.out.println(MaxNode(root));
    //     System.out.println(height(root));
    //     System.out.println(find(root, 80));
           System.out.println(find_02(root, 80));
    //     BstPair ans=IsBST(root);
    //     System.out.println(ans.isbst);
    //     System.out.println(ans.countBsts);
    //     System.out.println(ans.maxSize);
    //     Linearize(root);
    //     display(root);
    // System.out.println(MaxSumPossible(root1));
    //  int []arr2={1,-1,3,-1,2,-1,-1};
    //  Node root2=Construct(arr2);
    //  display(root2);
    // BSTRecover(root2,root2);
    // display(root2); 
    //    int[] arr3={50,25,20,10,30,75,65,80};
    //    Node node=createBST(arr3,(int) -1e8,0 ,(int) 1e8);
    //    display(node);
    //   int[] arr4={10,20,30,40,50,60,70,80};
    //   Node root4=createBSTfromSortedArray(arr4,0,arr4.length-1);
    //   addData(root4,32);
    //   display(root4);
    //  Node ans= LCAInBST(root4, 50, 80);
    //  System.out.println(ans.data);
    //  printInRangeInBST(root4,60,80);
    //  int w=width(root4,true);
    //  int []arr5=new int[w];
     //PreOrderUsingIter(root1);
    }

    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // To construct Tree from array
    static int idx = 0;

    public static Node Construct(int[] arr) {
        if (idx >= arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }
        Node newNode = new Node(arr[idx], null, null);
        idx++;
        newNode.left = Construct(arr);
        newNode.right = Construct(arr);

        return newNode;
    }
    // public static Node create(int[] arr) {
    // if (idx == arr.length || arr[idx] == -1) {
    // idx++;
    // return null;
    // }

    // Node nnode = new Node(arr[idx], null, null);
    // idx++;
    // nnode.left = create(arr);
    // nnode.right = create(arr);
    // return nnode;
    // }
    public static void display(Node root) {
        if (root == null) {
            return;
        }
        String ans = "";
        ans += root.left == null ? "." : root.left.data;
        ans += "->" + root.data + "<-";
        ans += root.right == null ? "." : root.right.data;
        System.out.println(ans);
        display(root.left);
        display(root.right);

    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        int lsize = size(root.left);
        int rsize = size(root.right);
        return lsize + rsize + 1;
    }

    public static int MaxNode(Node root) {
        if (root == null) {
            return -1;
        }
        int leftMax = MaxNode(root.left);
        int rightMax = MaxNode(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));

    }

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean find(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (find(root.left, data)) {
            return true;
        } else {
            if (find(root.right, data)) {
                return true;
            }
        }
        return false;
    }
    public static boolean find_02(Node node,int data){
      if(node==null) return false;
      if(node.data==data) return true;
      boolean res=false;
      res=res||find_02(node.left, data);
      res=res||find_02(node.right, data);
       return res;      
    }

    public static class BstPair {
        int maxSize = 0;
        int max = (int) 1e8;
        int min = (int) -1e8;
        int countBsts = 0;
        Node rootNode = null;
        boolean isbst = true;
        // Bst(int maxSize,int max,int min,int count,boolean isbst){
        // }
    }

    public static BstPair IsBST(Node root) {
        if (root == null) {
            BstPair obj = new BstPair();
            return obj;
        }
        BstPair lpart = IsBST(root.left);
        BstPair rpart = IsBST(root.right);
        BstPair myAns = new BstPair();
        if (lpart.isbst && (rpart.isbst) && lpart.max < root.data && root.data <= rpart.min) {
            myAns.countBsts = lpart.countBsts + rpart.countBsts + 1;
            myAns.maxSize = myAns.countBsts;
            myAns.rootNode = root;

        } else {
            myAns.isbst = false;
            myAns.countBsts = lpart.countBsts + rpart.countBsts;
            if (lpart.maxSize > rpart.maxSize) {
                myAns.maxSize = lpart.maxSize;
                myAns.rootNode = lpart.rootNode;
            } else {
                myAns.maxSize = rpart.maxSize;
                myAns.rootNode = rpart.rootNode;

            }

            // myAns.rootNode=;
        }

        myAns.max = Math.max(Math.max(lpart.max, rpart.max), root.data);
        myAns.min = Math.min(Math.min(lpart.min, rpart.min), root.data);

        return myAns;

    }
    public static Node Linearize(Node root){
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
         return root;
        }
        Node leftTail=Linearize(root.left);
        Node rightTail=Linearize(root.right);
        if(leftTail==null){
            root.left=root.right;

        }
        else{
         leftTail.left=root.right;
        }
        root.right=null;
        return rightTail!=null?rightTail:leftTail;
    }
    public static int MaxSumPossible(Node node){
        if(node==null){
          return 0;
        }
    int leftMax=MaxSumPossible(node.left);
    int rightMax=MaxSumPossible(node.right);
     
    return Math.max(Math.max(leftMax,rightMax),(leftMax+rightMax+node.data));
    }

    void swap(int data1,int data2){
    int temp=data1;
    data1=data2;
    data2=temp;
    }

   public static void BSTRecover(Node root,Node prev){
       if(root==null){
           return;
       }
    if(prev.data>root.left.data){
        //swap(prev.data,root.left.data);
        prev=root.left;
        BSTRecover(root.left,prev);
    }
    
    BSTRecover(root.right,prev);

   }  
   //Create BST from Inorder
   public static int idx1=0;
   public static Node createBST(int[] arr,int lb,int ele,int ub){
    if(ele<lb || ele>ub || idx1==arr.length){
        return null;
    }  
    Node node=new Node(arr[idx1],null,null);
    ele=arr[idx1];   
    idx1++;
        if(idx1<arr.length){
         node.left=createBST(arr,lb,arr[idx1],ele);
        }
        if(idx1<arr.length)
         node.right=createBST(arr,ele,arr[idx1],ub);

     
     return node;
   }
   public static Node createBSTfromSortedArray(int []arr,int start,int end){
    if(start>end){
    return null;
    }
    int mid=(start+end)/2 ;  //(start+end)>>1;  //To avoid overflow :si +(ei-si)/2;

    Node newNode=new Node(arr[mid],null,null);
    newNode.left=createBSTfromSortedArray(arr,start,mid-1);
    newNode.right=createBSTfromSortedArray(arr, mid+1,end);
    return newNode;

   }
  public static Node addData(Node root,int data){
    if(root==null){
        Node newNode=new Node(data,null,null);
        return newNode;
    }

    if(data<root.data){
       root.left= addData(root.left,data);
    }
    if(data>root.data){
       root.right=addData(root.right,data);
    }
    return root;
  }
  public static Node removeNode(Node root,int data){

   root.left=removeNode(root.left,data);
   root.right=removeNode(root.right,data);

   return root;
  }
  public static Node LCAInBST(Node node,int a,int b){
      if(node==null){
          return null;
      }
    
    
    
    if(a>node.data){
      Node right=LCAInBST(node.right, a, b);
      return right;
     }

     else if(b<node.data){
     Node left= LCAInBST(node.left, a, b);
     return left;
    }
    else{
        return node;
    }

    
  }
  public static void printInRangeInBST(Node node,int a,int b){
      if(node==null){
          return ;
      }
      if(node.data<a){
          printInRangeInBST(node.right, a, b);
      }
      else if(b<node.data){
          printInRangeInBST(node.left, a, b);
      }else{
          System.out.println(node.data);
          printInRangeInBST(node.left, a, b);
          printInRangeInBST(node.right, a, b);
      }
  }



  // public static CreateBSTfromPreorder(int []arr,int []idx,int lb,int )
// public static int VerticallySum(Node node,int level){
//     if(node==null){
//         return 0;
//     }

//     int leftSum=VerticallySum(node.left,level-1);
//     int rightSum=VerticallySum(node.right, level+1);

// }



public static int width(Node node,boolean isLeftWidth){
     if(node==null){
         return -1;
     }
     int left=width(node.left,isLeftWidth)+(isLeftWidth?1:-1);
     int right=width(node.right,isLeftWidth)+(isLeftWidth?-1:1);
     return Math.max(left,right);
}

// public static void VerticalSum(Node node,int level){
//     if(node==null){
//         return ;
//     }
//     VerticalSum(node.left);

// }
public static class Prop{
    Node node;
    boolean selfDone=false;
    boolean leftDone=false;
    boolean rightDone=false;
    Prop(Node node){
        this.node=node;
    }
}
public static void PreOrderUsingIter(Node node){
  LinkedList<Prop> stack=new LinkedList<>();
  Prop obj=new Prop(node);
  stack.addFirst(obj);
  while(stack.size()>0){
     Prop top=stack.getFirst();
     if(top.node==null){
         stack.removeFirst();
         continue;
     }
      if(top.selfDone==false){
          top.selfDone=true;
          System.out.print(top.node.data+" ");

      }else if(top.leftDone==false){
          top.leftDone=true;
          stack.addFirst(new Prop(top.node.left));

      }else if(top.rightDone==false){
          top.rightDone=true;
          stack.addFirst(new Prop(top.node.right));

      }else{
          stack.removeFirst();
      }
  }

}

}