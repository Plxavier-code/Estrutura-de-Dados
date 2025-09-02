package Aula.src;

public class  Pilha implements Empilhavel{
//variaveis
private Object dado[];
private int pointertop;
//Construtores 
public Pilha(int tamanho){
    pointertop=tamanho;
    dado=new Object[tamanho];
}
public Pilha (){
    this(10);
}
//metodos auxiliares 
@Override
public boolean is_full(){
    return(pointertop==0);
}
@Override 
public boolean is_empty(){
    return(pointertop==dado.length);
}
@Override 
public String print(){
    String format="[";
    for(int i=pointertop; i<=dado.length; i++) {
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
        pointertop--;
        this.dado[pointertop]=dado;
    }else{
        System.err.println("A pilha está cheia!");
    }
}
@Override
public Object pop(){
    Object top= null;
    if(!is_empty()){
        top=dado[pointertop];
        pointertop++;    
    }
    else{
        System.err.println("A pilha está vazia");

    }
    return top;
}

}