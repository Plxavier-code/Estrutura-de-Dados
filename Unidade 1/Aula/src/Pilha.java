package Aula.src;

public class  Pilha implements Empilhavel{
//variaveis
private Object dado[];
private int pointertop;
//Construtores 
public Pilha(int tamanho){
    pointertop=-1;
    dado=new Object[tamanho];
}
public Pilha (){
    this(10);
}
//metodos auxiliares 
@Override
public boolean is_full(){
    return(pointertop==dado.length-1);
}
@Override 
public boolean is_empty(){
    return(pointertop==-1);
}
@Override 
public String print(){
    String format="[";
    for(int i=pointertop; i>=0; i--) {
        System.out.println(dado[i]);
        if(i==0){
            format+=dado[i];
        }
        else{
            format+=dado[i]+",";
        }  
    }
    return format+ "]";
}
// metodos Principais
@Override
public Object peek(){
    Object top= null;
    if(!is_empty()){
        top=dado[pointertop];
    }
    else{
        System.err.println("A pilha está vazia");
    }
    return top;
}
@Override
public void push(Object dado){
    if(!is_full()){
        pointertop++;
        this.dado[pointertop]=dado;

    }
}
@Override
public Object pop(){
    Object top= null;
    if(!is_empty()){
        top=dado[pointertop];
        pointertop--;    
    }
    else{
        System.err.println("A pilha está vazia");

    }
    return top;
}

}