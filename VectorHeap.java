/**
 * Oscar Fernando López Barrios
 * Carné 20679
 * 
 * VectorHEap
 */

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{

	protected Vector<E> data; // the data, kept in heap order

	public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}

	public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}
	
	/** 
	 * pre: 0 <= i < size
	 * @param int es el padre que se ingresa del arbol
	 * @return int se regresa el index del padre del nodo
	 */
	protected static int parent(int i)
	// post: returns parent of node at location i
	//Regresa el index del padre
	{
		return (i-1)/2;
	}

	
	/** 
	 * pre: 0 <= i < size
	 * @param i es la posicion de la rama izquierda
	 * @return int es el index de la rama hija
	 */
	protected static int left(int i)
	// post: returns index of left child of node at location i
	//Regresa el index de la izquierda
	{
		return 2*i+1;
	}

	
	/** 
	 * pre: 0 <= i < size
	 * @param i es la posicion de la 
	 * @return int es el index de la rama hija
	 */
	protected static int right(int i)
	// post: returns index of right child of node at location i
	//Regresa el index de la derecha
	{
		return (2*i+1) + 1;
	}

	
	/** 
	 * pre: 0 <= leaf < size
	 * @param leaf es el nodo que se movera
	 */
	protected void percolateUp(int leaf)
	// post: moves node at index leaf up to appropriate position
	//Se mueve el nodo a la posicion apropiada
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

	
	/** 
	 * pre: value is non-null comparable
	 * @param value es el valor a ingresar en data
	 */
	public void add(E value)
	// post: value is added to priority queue
	//Se ingresa el valor al vector
	{
		data.add(value);
		percolateUp(data.size()-1);
	}

	
	/** 
	 * pre: 0 <= root < size
	 * @param root es la raiz que se desea mover
	 */
	protected void pushDownRoot(int root) 
	//post: moves node at index root down
	//to appropriate position in subtree
	//Mueve los nodos a la posicion apropiada del arbol
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo(data.get(childpos)) < 0))
				{
					childpos++;
				}
			// Assert: childpos indexes smaller of two children
			if ((data.get(childpos)).compareTo(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}

	
	/** 
	 * pre: !isEmpty()
	 * @return E
	 */
	public E remove()
	// post: returns and removes minimum value from queue
	//Toma el primer valor y lo remueve, ademas mueve los nodos del arbol
	{
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}

	
	/** 
	 * pre: se tiene el valor para comparar
	 * @param o es el valor del objeto
	 * @return int regresa el valor del comparable
	 */
	@Override
	public int compareTo(E o) {
		//Regresa la comparacion
		return 0;
	}

	
	/** 
	 * pre: Se tienen objetos en data
	 * @return E regresa el primer dato
	 */
	@Override
	public E getFirst() {
		//Regresa el primer elemento
		return data.firstElement();
	}

	/** 
	 * pre: Se tienen objetos en data
	 * post: se limpian los objetos de data
	 */
	@Override
	public void clear() {
		//Limpia el vector
		data.clear();
		
	}

	
	/** 
	 * pre: se encuentra el data
	 * @return boolean se regresa si esta vacio o no
	 */
	@Override
	public boolean isEmpty() {
		//Regresa si el vector esta vacio
		return data.isEmpty();
	}

	
	/** 
	 * pre: se tiene el data
	 * @return int se regresa la cantidad de objetos en data
	 */
	@Override
	public int size() {
		//Se regresa el tamaño del vector
		return data.size();
	}

	/** 
	 * pre: Se tienen objetos en data
	 * post: Se obtiene el primer objeto
	 */
	public void removeFirst(){
		//Se remueve el primer elemento
		data.remove(getFirst());
	}

	/** 
	 * pre: Se tienen objetos en data
	 * post: se limpian los objetos de data
	 */
	public void imprimirCorto(){
		//Se imprime el vector completo
		while(!isEmpty()){
			E first = remove();
			System.out.println(first);
		}
	}

	
	/** 
	 * pre: se tiene el el objeto a imprimir 
	 * @return String es el string
	 */
	@Override
	public String toString() {
		return data.toString();//Se regresa el toString
	}

}