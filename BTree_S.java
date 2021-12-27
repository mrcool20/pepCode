import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class BTree_S {
    public static Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
       // int[]arr={10,20,30,-1,-1,40,-1,-1,50,60,70,80,-1,-1,-1,70,90,-1,100,-1,-1,-1};
       //int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        //int[] arr1={50,-1,-1};

        int[] arrcpp={1,2,4,-1,-1,5,8,-1,9,-1,-1,-1,3,6,-1,-1,7,-1,-1}; 
        Node rootcpp = Construct(arrcpp);
        // Node root = Construct(arr);
       //  Node root1=Construct(arr1);
        //  display(root);
    //    display(root1);
    //     System.out.println(size(root));
    //     System.out.println(MaxNode(root));
    //     System.out.println(height(root));
    //     System.out.println(find(root, 80));
    //     System.out.println(find1(root, 80));
        //    preOrder(root1);
        //   System.out.println();    
        //    postOrder(root1);
        //    System.out.println();
         //  inOrder(root1);
             // levelOrder(root1);
             // printBinaryuptoNumberN(15);
             // levelOrderWithLevelIndication(root1);
            // levelOrder02(root1);
             //  Node ans=findwithReturn(root,50);
            //   System.out.println(ans.data);
            // Kaway(ans,2,null); 
            //  ArrayList<Node>ans1=NodeToRootPath(root1, 30);
            //  for(int i=0;i<ans1.size();i++){
            //      System.out.print(ans1.get(i).data+" ");
            //  }
            // }
          //  Kfar(root1,25,3,null);
           // Kfar_02(root,2,50);
         //  PreOrderUsingIter(root);
            //postOrderUsingIteration(root1);
            //InOrderUsingIter(root1);
        //     int n=scn.nextInt();
        //     int arr2[]=new int[n];
        //     for(int i=0;i<n;i++){
        //     arr2[i]=scn.nextInt();
        //     }
           
        //    Node root2= ConstructfromLevelOrder(arr2,0);
        //    display(root2);
        //    InOrderUsingIter(root2);
        //    System.out.println();
        //    inOrder(root2);
        //     AllPair ans=new AllPair();
        //     allSol(root1, 0, 50, ans);
        //     System.out.println(ans.size);
        //     System.out.println(ans.height);
        //     System.out.println(ans.find);
        //     System.out.println(ans.ceil);
        //     System.out.println(ans.floor);
        //     if(ans.pred==null )
        //      System.out.println(-1);
        //      else
        //      System.out.println(ans.pred.data);
        //      if(ans.succ==null )
        //      System.out.println(-1);
        //      else
        //      System.out.println(ans.succ.data); 
        //    System.out.println(IsBST(root1));
          //  PathSum();
        //   int []arr=/*{10,2,10,20,1,-1,-25,-1,-1,-1,-1,3,4}*/{-10,9,20,-1,-1,15,7};

        //    Node node=ConstructfromLevelOrder(arr, 0);
        //    display(node);
        //     MaxNodeToNodeSum(node);
        //     System.out.println(Max_nodeToNode);
    //     int []arr={10,5,8,2,20,-1,-1};
    //     Node node=ConstructfromLevelOrder(arr, 0);
    //         display(node);
    //     if(RecoverBST(node)){
    //     if(x!=null && y!=null){
    //     System.out.println(x.data + " "+ y.data);
    //     }
    // }
    //    find_BST(node, x, y);
    //    display(node);
    //     int []arr_M={1,2,3,4,5,6,7,8,9,-1,-1,-1,-1,13,-1,10,11,-1,-1,-1,-1};
    //    Node root_M=ConstructfromLevelOrder(arr_M, 0);
    //    display(root_M);
    //    MorrisTraversal(root_M);
        //   int [] pre={5,1,3,0,6,7,2,4};
        //   String[] charData={"N", "N","L","N","L","L","N","L"};
        //   Node Sroot=constructSpecial(pre, charData);
         // display(Sroot);
        //  int [] arr_DLL={1,2,3,-1,5,6,7};
        //Node root_DLL= ConstructfromLevelOrder(arr_DLL,0);
        //display(root_DLL); 
        // createDLL(root_DLL);
        //   while(head_!=null){
        //       System.out.print(head_.data+"->");
        //       head_=head_.right;
        //   }
          //preOrder_PrevMonitor(root_DLL);
           BSTpair ans=BSTSol_(rootcpp);
           System.out.println(ans.isBst);
           System.out.println(ans.count);
           System.out.println(ans.lBSTsize);
           System.out.println(ans.lBstRoot.data);
           System.out.println(ans.min);
           System.out.println(ans.max);

          
        }
       
       
       
        public static void PathSum(){
        int [] arr={5,4,11,7,-1,-1,2,-1,-1,-1,8,13,-1,-1,4,-1,1,-1,-1};
        Node root=Construct(arr);
        display(root);
        System.out.println(pathSumRootToLeaf(root,22));
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

    public static class BSTpair {
        boolean isBst = true;
        int count = 0;
        int lBSTsize = 0;
        Node lBstRoot = null;

        int min = (int) 1e8;
        int max = (int) -1e8;

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
    
    public static Node ConstructfromLevelOrder(int[] arr,int i){
        if(i>=arr.length || arr[i]==-1){
        
            return null;
        }
        Node newNode=new Node(arr[i],null,null);
        newNode.left=ConstructfromLevelOrder(arr,2*i+1);
        newNode.right=ConstructfromLevelOrder(arr,2*i+2);
        return newNode;
    }
    
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
    public static boolean find1(Node node, int data){
        if(node==null)
        return false;
        if(node.data==data){
            return true;
        }
      boolean res=false;
      res=find1(node.left,data);
      res=res||find1(node.right,data);
      return res;
    }
    public static Node findwithReturn(Node node,int data){
        if(node==null){
            return null;
        }
        if(node.data==data){
            return node;
        }
        Node leftNode=findwithReturn(node.left, data);
        if(leftNode!=null){
            return leftNode;
        }
        Node rightNode=findwithReturn(node.right, data);
         if(rightNode!=null){
             return rightNode;
         }
         return null;
    }
    public static void preOrder(Node node){
        if(node==null){
            return ;
        }
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void postOrder(Node node){
        if(node==null){
            return ;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");


    }
    public static void inOrder(Node node){
        if(node==null){
            return ;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    public static void levelOrder(Node node){
        if(node==null){
            return ;
        }
        LinkedList<Node>queue=new LinkedList<>();
        queue.addLast(node);
        
        while(!queue.isEmpty()){
            Node removedNode=queue.removeFirst();
            System.out.print(removedNode.data+" ");
            
            if(removedNode.left!=null){
                queue.addLast(removedNode.left);
            }
            if(removedNode.right!=null){
                queue.addLast(removedNode.right);
            }
            
        }
      
    }
     public static void levelOrderWithLevelIndication(Node node){
        if(node==null){
            return ;
        }
        int level=0;
        LinkedList<Node>queue=new LinkedList<>();
        queue.addLast(node);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            System.out.print(level+"->");
            while(size-->0){
            Node removedNode=queue.removeFirst();
            System.out.print(+removedNode.data+" ");
            
            if(removedNode.left!=null){
                queue.addLast(removedNode.left);
            }
            if(removedNode.right!=null){
                queue.addLast(removedNode.right);
            }
        }
        level++;
       System.out.println();
        }
      
    }
    //Level Order with using null for next level indication
    public static void levelOrder02(Node node){
        if(node==null){
            return ;
        }
      LinkedList<Node>queue=new LinkedList<>();
      queue.addLast(node);
      queue.addLast(null);
      int level=0;
      
       System.out.print(level+"->");
       while(queue.size()!=1){  
       Node rnode=queue.removeFirst();
       System.out.print(rnode.data+" ");
       if(rnode.left!=null){
           queue.addLast(rnode.left);
       }   
       if(rnode.right!=null){
           queue.addLast(rnode.right);
       }
       if(queue.getFirst()==null){
           queue.addLast(null);
           queue.removeFirst();
           level++;
           System.out.println();
           System.out.print(level+"->");
       }
    }
   
}
      
    
    //Application of Level Order
    private static class Pair{
        int number=0;
        String binary="";
        Pair(int number,String binary){
            this.number=number;
            this.binary=binary;
        }
    }
    public static void printBinaryuptoNumberN(int n){
       LinkedList<Pair> queue=new LinkedList<>();
       queue.addLast(new Pair(1,"1") );
       while(!queue.isEmpty()){
           Pair removePair=queue.removeFirst();
           System.out.println(removePair.number+"->"+removePair.binary);
           if(2*removePair.number<=n){
           queue.addLast(new Pair(2*removePair.number,removePair.binary+"0"));
           }
           if(2*removePair.number+1<=n)
           queue.addLast(new Pair(2*removePair.number+1,removePair.binary+"1"));

       }

    }
    //Given node se k distance (down) dur saare nodes print karne hai!!!
    public static void Kaway(Node node,int k,Node rnode){
        if(node==null){
            return ;
        }
        if(node==rnode){
            return ;
        }
        if(k==0){
            System.out.print(node.data+" ");
        }
        Kaway(node.left, k-1, rnode);
        Kaway(node.right, k-1, rnode);
    }
    //Node to Root Path
    public static ArrayList<Node> NodeToRootPath(Node node,int data){
     if(node==null){
      
      return null;
     }
     if(node.data==data){
        ArrayList<Node>ans=new ArrayList<>();
        ans.add(node);
        return ans;
     }
      ArrayList<Node>left=NodeToRootPath(node.left, data);
      if(left!=null){
          left.add(node);
          return left;
      }
      ArrayList<Node>right=NodeToRootPath(node.right, data);
      if(right!=null){
          right.add(node);
          return right;
      }
      return null;
    }
     public static void Kfar(Node node,int data,int k,Node rnode){
      ArrayList<Node>path=NodeToRootPath(node, data);
      rnode=null;
      for(int i=0;i<path.size();i++){
          Kaway(path.get(i),k-i,rnode);
          rnode=path.get(i);
      }
     }
// Kfar without using extra space
//Here we will use the concept of depth and a mix of find 
    public static int Kfar_02(Node node,int k,int data){
     if(node==null){
      return -1;
     }
     if(node.data==data){
         Kaway(node, k, null);
         return 1;  // return 1 means it says that it is 1 distance apart from his parent.
     }
     int leftDepth=Kfar_02(node.left, k, data);
     if(leftDepth!=-1){
         if(leftDepth==k){
             System.out.print(node.data+" ");
         }
         //Now we're at the situation where we know that the value of k must be greater than
         //k so we need to explore the RHS part also.
         else{
         Kaway(node, k-leftDepth, node.left);
         }
         return leftDepth+1;
     }
     int rightDepth=Kfar_02(node.right, k, data);
     if(rightDepth!=-1){
         if(rightDepth==k){
             System.out.print(node.data+" ");
         }else{
             Kaway(node, k-rightDepth,node.right);
         }
         return rightDepth+1;
     }
     return -1;
    }

  //PreOrder using Iteration
  public static class Prop{
      Node node;
      boolean print=false;
      boolean lcall=false;
      boolean rcall=false;
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
        if(top.print==false){
            top.print=true;
            System.out.print(top.node.data+" ");

        }else if(top.lcall==false){
            top.lcall=true;
            stack.addFirst(new Prop(top.node.left));

        }else if(top.rcall==false){
            top.rcall=true;
            stack.addFirst(new Prop(top.node.right));

        }else{
            stack.removeFirst();
        }
    }

  }

public static void postOrderUsingIteration(Node node){
    LinkedList<Prop> stack=new LinkedList<>();
    Prop obj=new Prop(node);
    stack.addFirst(obj);
    while(stack.size()>0){
       Prop top=stack.getFirst();
       if(top.node==null){
           stack.removeFirst();
           continue;
       }
        if(top.lcall==false){
            top.lcall=true;
            stack.addFirst(new Prop(top.node.left));

        }else if(top.rcall==false){
            top.rcall=true;
            stack.addFirst(new Prop(top.node.right));

        }else if(top.print==false){
            top.print=true;
            System.out.print(top.node.data+" ");

        }
        else{
            stack.removeFirst();
        }
    }
}
//No Recursion
public static void InOrderUsingIter(Node node){
    LinkedList<Prop> stack=new LinkedList<>();
    Prop obj=new Prop(node);
    stack.addFirst(obj);
    while(stack.size()>0){
       Prop top=stack.getFirst();
       if(top.node==null){
           stack.removeFirst();
           continue;
       }
         if(top.lcall==false){
            top.lcall=true;
            stack.addFirst(new Prop(top.node.left));

        }else if(top.print==false){
            top.print=true;
            System.out.print(top.node.data+" ");

        }
        else if(top.rcall==false){
            top.rcall=true;
            stack.addFirst(new Prop(top.node.right));

        }else{
            stack.removeFirst();
        }
    }

  }
 
 
  public static class AllPair{
   int height=0;
   int size=0;
   
   int ceil=Integer.MAX_VALUE;// given data se next largest element
   int floor=Integer.MIN_VALUE;//given data se smallest element 
   boolean find=false;
   Node pred=null;
   Node succ=null;
   Node prev=null;

  }
  public static void allSol(Node node,int level,int data,AllPair sol){
    if(node==null){
       return;
   }
   sol.size++;
   sol.height=Math.max(sol.height,level);
   sol.find=sol.find||node.data==data;
   if(node.data>data && node.data<sol.ceil){
       sol.ceil=node.data;
   }
   if(node.data<data && node.data>sol.floor){
       sol.floor=node.data;
   }
   if(node.data==data && sol.pred==null){
    sol.pred=sol.prev;
   }
   if(sol.prev!=null && sol.succ==null && sol.prev.data==data ){
       sol.succ=node;
   }
   sol.prev=node;
   allSol(node.left,level+1,data,sol);
   allSol(node.right,level+1,data,sol);
   

  }
  static int prev=(int)-1e8;
  public static boolean IsBST(Node node){
   if(node==null){
       return true;
   }
   if(!IsBST(node.left)){
   return false;
   }
//Inorder
   if(prev>node.data)
   return false;
   prev=node.data;

   if(!IsBST(node.right))
   return false;
   
   return true;
  }

  public static boolean pathSumRootToLeaf(Node node,int tar){

    if(node==null){
        return false;
    }
    if(node.left==null && node.right==null && tar-node.data==0){
    return true;
    }
    boolean left=pathSumRootToLeaf(node.left, tar-node.data);
    // if(left){
    //     return true;
    // }
    boolean right=pathSumRootToLeaf(node.right, tar-node.data);
    // if(right){
    //     return true;
    // }
    return left || right;

  }
  public static int Max_nodeToNode=Integer.MIN_VALUE;
  public static int MaxNodeToNodeSum(Node node){
    if (node == null)
    return  0;

 int leftNodeToNode = MaxNodeToNodeSum(node.left);
  int rightNodeToNode = MaxNodeToNodeSum(node.right);

  int maxviaRoot =Math.max(Math.max(leftNodeToNode, rightNodeToNode) + node.data,node.data);
 // System.out.println("Left:" +leftNodeToNode +" Right:"+rightNodeToNode);
  int globalMaxHelper = Math.max(maxviaRoot,leftNodeToNode + rightNodeToNode +node.data);
 // System.out.println("G:"+globalMaxHelper);
  Max_nodeToNode=Math.max(Max_nodeToNode,globalMaxHelper);
 // System.out.println(Max_nodeToNode);         
  return maxviaRoot; 

  }
  static Node x,y,prevForBST;
  public static boolean RecoverBST(Node node){
      if(node==null){
          return false;
      }
      boolean res=false;
      res=res||RecoverBST(node.left);
      if( prevForBST!=null && node.data<prevForBST.data ){
          y=node;
          if(x==null){
              x=prevForBST;
          }
          else{
              return true;
          }
        }
      prevForBST=node;
      res=res|| RecoverBST(node.right);
    return res;
  }
  public static void find_BST(Node node,Node x,Node y){
     if(node==null){
         return;
     }
    if(node.data==x.data){
      node.data=y.data;
      return ;
    }
    else if(node.data==y.data){
        node.data=x.data;
        return ;
    }
    find_BST(node.left,x,y);
    find_BST(node.right,x,y);
  }
//   static Node curr=null;
//   static Node next;
//   public static Node RightMost(Node node,Node current){
//       while(node.next!=null && node.next!=current){
//           node=node.next;
//       }
//       return node;
//   }
//  public static void MorrisTraversal(Node node){
//     if(node==null){
//         return ;
//     } 
//     curr=node;
//     while(curr!=null){
//         if(curr.left==null){
//             System.out.println(curr);
//         }
//        next=curr.left;
//        Node rightmost=RightMost(node, current)
//        next.right=curr;
//        curr=curr.left;

//    }
   
//   public static void makeThread(Node next,Node curr){
     

//    }
static int myIND=0;
public static Node constructSpecial(int[] preData, String[] lnData) {
    if(myIND==preData.length ){
        return null;
    }
   Node node=new Node(preData[idx],null,null);
   boolean ans=false;
    if(lnData[myIND].equals("N")){
       ans=true;
   }
   myIND++;
    if(ans){
    
           
    
        node.left=constructSpecial(preData,lnData);
        node.right=constructSpecial(preData,lnData);
    
    }
                return node;


} 
  public static Node head_=null;
  public static Node prev_=null;
public static void createDLL(Node node){
    if(node==null){
        return ;
    }
    createDLL(node.left);
    if (prev_ == null)  
    head_ = node; 
    else
    { 
    node.left = prev_; 
    prev_.right = node; 
    } 
    prev_ = node; 
    createDLL(node.right);

}
static Node prevCheck=null;
public static void preOrder_PrevMonitor(Node node){
    if(node==null){
        return ;
    }
    prevCheck=node;
    System.out.println(prevCheck.data);
    preOrder_PrevMonitor(node.left);
    preOrder_PrevMonitor(node.right);
}

public static BSTpair BSTSol_(Node node) {
    if (node == null) {
        return new BSTpair();
    }

    BSTpair lp = BSTSol_(node.left);
    BSTpair rp = BSTSol_(node.right);

    BSTpair myPair = new BSTpair();
    myPair.count = lp.count + rp.count;

    if (lp.isBst && rp.isBst && lp.max < node.data && node.data <= rp.min) {
        myPair.count++;
        myPair.lBSTsize = myPair.count;
        myPair.lBstRoot = node;
    } else {
        myPair.isBst = false;
        if (lp.lBSTsize > rp.lBSTsize) {
            myPair.lBSTsize = lp.lBSTsize;
            myPair.lBstRoot = lp.lBstRoot;
        } else {
            myPair.lBSTsize = rp.lBSTsize;
            myPair.lBstRoot = rp.lBstRoot;
        }
    }

    myPair.min = Math.min(Math.min(lp.min, rp.min), node.data);
    myPair.max = Math.max(Math.max(lp.max, rp.max), node.data);

    return myPair;
}


  
}