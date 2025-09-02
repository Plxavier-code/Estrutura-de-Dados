public class fila implements queue {
    private int ponteiroInicio;	//cabeca = head
	private int ponteiroFim;	//cauda  = tail
	private Object[] dados;
    //construtores
	public fila(int tamanho) {
		ponteiroInicio = 0;
		ponteiroFim = -1;
		dados = new Object[tamanho];
	}

	public fila() {
		this(10);
}
// metodos auxiliares

public print}