public class Lista implements Listavel{
    private int head;
    private int tail;
    private Object[]dado;
    private int number_elements;    
    public Lista(){
        this(10);
    }
    public Lista(int tamanho){
        head=0;
        tail=-1;
        dado=new Object[tamanho];
        number_elements=0;

    }  // metodos auxiliares
    private int mapVetor(int logic_index){
        return((head+logic_index)%dado.length);

    }
    private int next(int index){
        return((index+1)% dado.length);

    }
    private int back(int index){
        return(((index-1)+dado.length)%dado.length);
    }
    @Override
    public boolean is_full(){
        return(number_elements==dado.length);
    }
    @Override
    public boolean is_empty(){
        return(number_elements==0);
    }
    @Override
    public String print(){
		String format= "[";
		int Aux = head;
		for (int i = 0; i < number_elements; i++) {			
			format += dado[Aux];
			if (i != number_elements - 1) 
				format+= ",";
			
			Aux = next(Aux); 
		return format+ "]";
	}
}
// metodos auxiliares
public void append(Object dado){
    if(!is_full()){
        tail=next(tail);
        this.dado[tail]=dado;
        number_elements ++;
    }
    else{
        System.err.println("Lista está cheia");

    }
}
public void insert(int logical_index, Object dado){
    if(!is_full()){
        if(logical_index>=0&&logical_index<=number_elements){
            int index=mapVetor(logical_index);
            int x=tail;
            int y=next(x);q
            
        }
    }
}
}