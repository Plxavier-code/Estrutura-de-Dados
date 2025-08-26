public class ArrayStack {
    
    private int ponteiroTopo;
    private Object[] dados;

    public ArrayStack(int tamanho) {
        ponteiroTopo = -1;
        dados = new Object[tamanho];
    }

    public ArrayStack() {
        this(10);
    }

    public void empilhar(Object dado) {
        if(!estaCheia()) {
            ponteiroTopo++;
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Pilha Cheia!");
        }
    }

    public void atualizar(Object dado) {
        if(!estaVazia()) {
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Pilha Vazia!");
        }
    }
    
    public Object desempilhar() {
        Object dadoTopo = null;
        if(!estaVazia()) {
            dadoTopo = dados[ponteiroTopo];
            ponteiroTopo--;
        } else {
            System.err.println("Pilha Vazia!");
        }
        return dadoTopo;
    }
    
    public Object espiar() {
        Object dadoTopo = null;
        if(!estaVazia()) {
            dadoTopo = dados[ponteiroTopo];
        } else {
            System.err.println("Pilha Vazia!");
        }
        return dadoTopo;
    }
    
    public boolean estaCheia() {
        return (ponteiroTopo == dados.length - 1);
    }
        
    public boolean estaVazia() {
        return (ponteiroTopo == -1);
    }
        
    public String imprimir() {
        String resultado = "[";
        for (int i = ponteiroTopo; i >= 0; i--) {
            resultado += dados[i];
            if (i > 0) {
                resultado += ", ";
            }
        }
        return resultado + "]";
    }
}
