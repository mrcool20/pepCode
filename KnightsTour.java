import java.util.Scanner;
public class KnightsTour{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args){
        // int m=scn.nextInt();
        // int n=scn.nextInt();
        int[][] board=new int[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j]=-1;
            }
        }
       // boolean[][] vis=new boolean[8][8]; 
        //vis[0][0]=true;
        board[0][0]=0;
        Knights(board,0,0,1);
    }
   public static int[][]dir={{2,1}, 
                             {1,2},
                             {-1,2},
                             {-2,1},
                             {-2,-1},
                             {-1,-2},
                             {1,-2},
                             {2,-1}};

     public static boolean isSafe(int r, int c, int[][] board) { 
     return (r >= 0 && r< board.length && c >= 0 && 
     c < board[0].length && board[r][c] == -1); 
     }                          
  
  public static  void Knights(int[][] board,int sr,int sc,int move){
    
    if(move==((board.length)*(board[0].length))){
        for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            System.out.print(board[i][j]+" ");
        }
        System.out.println();
        }
        return;
    }
    
    for(int i=0;i<8;i++){
        int modr=sr+dir[i][0];
        int modc=sc+dir[i][1];
        if(isSafe(modr, modc, board) ){
        //vis[modr][modc]=true;
        board[modr][modc]=move;
     Knights(board, modr,modc, move+1);
        // board[modr][modc]=-1;
       // vis[modr][modc]=false;

        }
    }
    
    }
  
}