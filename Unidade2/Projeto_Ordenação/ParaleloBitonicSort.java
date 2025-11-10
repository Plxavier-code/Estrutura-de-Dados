//Bibliotecas
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
public class ParaleloBitonicSort extends RecursiveAction {
    //Variaveis: 
    private static final int userThreads=16;
    private int[] array;
    private boolean guidance;
    private int initialindex;
    private int elements;
    //construtor
    public ParaleloBitonicSort (int[] array,int initialindex, int elements, boolean guidance){
        this.array=array;
        this.initialindex=initialindex;
        this.elements=elements;
        this.guidance=guidance;

    }
      public static void sort(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        ParaleloBitonicSort tarefa = new ParaleloBitonicSort(array, 0, array.length, true);
        pool.invoke(tarefa);
    }
    /* 
    **
    ***
    Verifica se o numero de elementos é pequeno o suficiente para ordenar sequencialmente, caso não seja, optar pela abordagem paralela.
    Se for sequencial, chamar a função de ordenação bitônica sequencial.
    Se for paralela, dividir o array em duas metades.
    Ordena a primeira metade em ordem crescente e a segunda em decrscentete.
    Invoca as duas tarefas paralelamente.
    chamar a função de mesclagem para unir as duas metades ordenadas em uma sequência bitônica.
    ***
    **
    */ 

    @Override
    protected void compute() {
        if(elements>1) {
            if(elements<=userThreads) {
                BitonicSortSequential(array, initialindex, elements, guidance);
            }else{
                int k= elements/2;
                ParaleloBitonicSort growing = new ParaleloBitonicSort(array, initialindex, k, true); 
                ParaleloBitonicSort decreasing = new ParaleloBitonicSort(array, initialindex + k, elements - k, false);
                invokeAll(growing, decreasing);
                BitonicMerge(array, initialindex, elements, guidance);
            }
        }
    }
    private void BitonicMerge(int[]array, int initialindex, int elements, boolean guidance) {
                if(elements>1) {
                    int k= elements/2;
                    for(int i=initialindex; i<initialindex + k; i++) {
                        if (i + k < array.length)
                      compareAndSwap(array, i, i + k, guidance);
                    }
                    BitonicMerge(array, initialindex, k, guidance);
                    BitonicMerge(array, initialindex + k, elements - k, guidance);
                }
    }
    private void compareAndSwap(int[] array, int i, int j, boolean guidance){
        if((array[i]>array[j])==guidance) {
            int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
        }
    }
    private void BitonicSortSequential(int[] array, int initialindex, int elements, boolean guidance) {
        if(elements>1) {
            int k= elements/2;
            BitonicSortSequential(array, initialindex, k, true);
            BitonicSortSequential(array, initialindex + k, k, false);
            BitonicMerge(array, initialindex, elements, guidance);
        }
    }
    //dividir array em duas metades 
    //ordenar a primeira metade crescente
    //ordenar a segunda metade decrescente
    //mesclar as duas metades formando uma sequencia bitonica
    // transformar a ssequencia bitonica em uma sequencia totalmente ordenada
    
}
