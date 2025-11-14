public class DoubleNode<T> {
	
	/** O dado armazenado no nó */
	private T data;
	
	/** Referência para o nó anterior */
	private DoubleNode<T> previous;
	
	/** Referência para o próximo nó */
	private DoubleNode<T> next;

	/**
	 * Já cria um nó com o dado.
	 *
	 * @param data o dado a ser armazenado no nó
	 */
	public DoubleNode(T data) {
		this.data = data;
	}

	/**
	 * Retorna o dado armazenado no nó.
	 *
	 * @return o dado do nó
	 */
	public T getData() {
		return data;
	}

	/**
	 * Define o dado a ser armazenado no nó.
	 *
	 * @param data o dado a ser armazenado no nó
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Retorna a referência para o nó anterior.
	 *
	 * @return o nó anterior
	 */
	public DoubleNode<T> getPrevious() {
		return previous;
	}

	/**
	 * Define a referência para o nó anterior.
	 *
	 * @param previous o novo nó anterior
	 */
	public void setPrevious(DoubleNode<T> previous) {
		this.previous = previous;
	}

	/**
	 * Retorna a referência para o próximo nó.
	 *
	 * @return o próximo nó
	 */
	public DoubleNode<T> getNext() {
		return next;
	}

	/**
	 * Define a referência para o próximo nó.
	 *
	 * @param next o novo próximo nó
	 */
	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}
}