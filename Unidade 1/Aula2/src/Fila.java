public class Fila implements Emfileravel {
    //Variaveis 
    private Object dado[];
    private int head;
    private int tail;
    // construtores
    public Fila(int tamanho){
        dado=new Object [tamanho];
        head=0;
        tail=-1;
    }
    public Fila(){
        this(10);
    }
    //Metodos auxiliares 
    @Override
     public boolean is_full(){
        return(tail==dado.length-1);

     }
    @Override
     public boolean is_empt(){
        return(tail==-1);

     }
    @Override
    public String print(){
        String format="[";
        for (int i = head; i <=tail; i++) {
            if(i==head){
                format+=dado[i];
            }
            else{
                format+=dado[i]+",";
            }
        }
        return format+"]";
    }
     //Metodos auxiliares 
     @Override
     public  Object front(){
        Object front =null;
        if(!is_empt()){
            front=dado[head];
        }
        else{
            System.err.println("A fila está vazia ");
        }
        return  front;
     }
     @Override 
     public void emqueue(Object dado){
        if(!is_full()){
            tail++;
            this.dado[tail]=dado;
        }
     }
     @Override 
     public Object dequeue(){
        Object front=null;
        if(!is_empt()){
            front=dado[head];
            head++;
        }
        return front;
     }


}
