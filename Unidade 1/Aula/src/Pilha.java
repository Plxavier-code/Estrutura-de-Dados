package Aula.src;

public class  Pilha implements Empilhavel{
//variaveis
private Object dado[];
private int pointertop1;
private int pointertop2;
//Construtores 
public Pilha(int tamanho){
    pointertop1=-1;
    pointertop2=tamanho;
    dado=new Object[tamanho];
}
public Pilha (){
    this(10);
}
//metodos auxiliares 
@Override
public boolean is_full1(){
    return(pointertop1==(pointertop2-1));
    
}
@Override
public boolean is_full2(){
    return is_full1();
}
@Override 
public boolean is_empty1(){
    return(pointertop1==-1);

}
@Override
public boolean is_empty2(){
    return(pointertop2==dado.length);
}
@Override 
public String print1(){
    String format="[";
    for(int i=pointertop1; i>=0; i--) {
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
@Override 
public String print2(){
    String format="[";
    for(int i=pointertop2; i<dado.length; i++) {
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
public Object peek1(){
    Object top= null;
    if(!is_empty1()){
        top=dado[pointertop1];
    }
    else{
        System.err.println("A pilha está vazia");
    }
    return top;
}
@Override
public Object peek2(){
    Object top= null;
    if(!is_empty2()){
        top=dado[pointertop2];
    }
    else{
        System.err.println("A pilha está vazia");
    }
    return top;
}
@Override
public void push1(Object dado){
    if(!is_full1()){
        pointertop1++;
        this.dado[pointertop1]=dado;
    }else{
        System.err.println("A pilha está cheia!");
    }
}
@Override
public void push2(Object dado){
    if(!is_full2()){
        pointertop2--;
        this.dado[pointertop2]=dado;
    }else{
        System.err.println("A pilha está cheia!");
    }
}
@Override
public Object pop1(){
    Object top= null;
    if(!is_empty1()){
        top=dado[pointertop1];
        pointertop1--;    
    }
    else{
        System.err.println("A pilha está vazia");

    }
    return top;
}
@Override
public Object pop2(){
    Object top= null;
    if(!is_empty2()){
        top=dado[pointertop2];
        pointertop2++;    
    }
    else{
        System.err.println("A pilha está vazia");

    }
    return top;
}
}