package Aula.src;

public class Pilha implements Epilhavel {
    // variáveis globais
    private Object[] dados;
    private int topo;

    // construtor 
    public Pilha() {
        this(10); 
    }
    public Pilha(int tamanho) {
        dados = new Object[tamanho];
        topo = -1;
    }
    // metodos auxiliares
    @Override
    public boolean estaCheia(){
      return (topo==dados.length-1);
    }
	  @Override
    public boolean estaVazia(){
     return (topo==-1);
  }
    @Override
	  public String imprimir() {
		String resultado = "[";
		for(int cont = topo; cont>= 0; cont--) {
			if (cont == 0) {
				resultado += dados[cont];
			}
			else {
				resultado += dados[cont] + ",";
			}
		}
		return resultado + "]";
   }
  
    //Metodos principais 
    @Override
    public Object Peek(){
    Object topoDosDados=null;
      if(!estaVazia()){
       topoDosDados=dados[topo];
    }
    else{
      System.out.println(" A pilha vazia ");
    }
    return topoDosDados;

    }
    public void Push(Object dado ){
      if(!estaCheia()){
        topo+=1;
        dados[topo]= dado;

      }
    }
    public Object Pop(){
      Object topoDosDados=null;
      if(!estaVazia()){
        topoDosDados=dados[topo];
        topo-=1;
      }
      return topoDosDados;

    }
}


