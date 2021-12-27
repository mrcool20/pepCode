import java.util.Scanner;
public class Experiment{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args){
        String word="";
        word+=scn.nextLine();
    
    String []Split=word.split(";");
    for(int i=0;i<Split.length;i++){
        System.out.println(Split[i]);
    }
    }
}