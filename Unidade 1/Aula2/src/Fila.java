public class Fila implements Emfileravel {
    //Variaveis 
    private Object dado[];
    private int total_elements;
    private int head;
    private int tail;
    // construtores
    public Fila(int tamanho){
        dado=new Object [tamanho];
        head=0;
        tail=-1;
        total_elements=0;
    }
    public Fila(){
        this(10);
    }
    //Metodos auxiliares 
    @Override
     public boolean is_full(){
        return(total_elements==dado.length);

     }
    @Override
     public boolean is_empt(){
        return(total_elements==0);

     }
    @Override
    public String print(){
        String format="[";
        int aux=head;
        for (int i = head; i < total_elements; i++) {
            if(i!=total_elements){
                format+=",";
                aux=next(aux);
            }
            else{
                format+=dado.length+",";
            }
        }
        return format+"]";

    }
    public int next(int index){
        return(index+1)%dado.length;
    }
     //Metodos Principais
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
     public void enqueue(Object dado){
        if(!is_full()){
            tail=next(tail);
            this.dado[tail]=dado;
            total_elements ++;
        }
        else{
            System.err.println("fila esta cheia");
        }
     }
     @Override 
     public Object dequeue(){
        Object front=null;
        if(!is_empt()){
            front=dado[head];
            head=next(head);
            total_elements --;
        }
        return front;
     }


}
