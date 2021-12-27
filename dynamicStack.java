public class dynamicStack extends Stack{

  
    public dynamicStack(){

    }

    public dynamicStack(int size){

    }  

    @Override
    public void push(int v){
     int size=getSize();
     int cap=size;
     if(size>=cap){
         size*=2;
     }    
      super.push(10);


    }

}