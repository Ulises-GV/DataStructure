public class ArbolBinario{

	private Nodo raiz;
	public ArbolBinario(){
		this.raiz = null;
	}
	
//usando recursividad
	public void insertar(Object elemento){
		raiz = insertarRecursivo(raiz, elemento);
	}
	
	private Nodo insertarRecursivo(Nodo nodo, Object elemento){
		if(nodo == null){
			return new Nodo(elemento);
		}
		if(comparar(elemento, nodo.getValor()) < 0){
			nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), elemento));	
		}else if(comparar(elemento, nodo.getValor()) > 0){
			nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), elemento));
		}
		return nodo;
	}

//Mismo metodo insertar sin usar la recursividad
/*	public void insertar(Object elemento){
		Nodo nuevoNodo = new Nodo(elemento);
		
		if(raiz == null){
			raiz = nuevoNodo;
		}else{
			Nodo nodoActual = raiz;
			while(true){
				if(comparar(elemento, nodoActual.getValor()) < 0){
					if(nodoActual.getIzquierdo() == null){
						nodoActual.setIzquierdo(nuevoNodo);
						break;
					}else{
						nodoActual = nodoActual.getIzquierdo();
					}
					
				}else if(comparar(elemento, nodoActual.getValor()) > 0){
					if(nodoActual.getDerecho() == null){
						nodoActual.setDerecho(nuevoNodo);
						break;
					}else{
						nodoActual = nodoActual.getDerecho();
					}
				
				}else{
					break;
				}
			}
		}
	}*/	
	
	public void recorrerEnOrden() {
        	recorrerEnOrdenRecursivo(raiz);
        	System.out.println();
    	}

    	private void recorrerEnOrdenRecursivo(Nodo nodo) {
        	if (nodo != null) {
            		recorrerEnOrdenRecursivo(nodo.getIzquierdo());
            		System.out.print(nodo.getValor() + " ");
            		recorrerEnOrdenRecursivo(nodo.getDerecho());
        	}
    	}
    	
    	public int comparar(Object a, Object b ){
    		if(a instanceof String && b instanceof String){
    			String aux1 = String.valueOf(a);
    			String aux2 = String.valueOf(b);
    			if(aux1.compareTo(aux2) > 0){
    				return 1;
    			}else if(aux1.compareTo(aux2) < 0){
    				return -1;
    			}else{
    				return 0;
    			}
    		}else if(a instanceof Number && b instanceof Number){
    			Number aux1 = (Number)a;
    			Number aux2 = (Number)b;
    			if(aux1.doubleValue() > aux2.doubleValue()){
    				return 1;
    			}else if(aux1.doubleValue() < aux2.doubleValue() ){
    				return -1;
    			}else{
    				return 0;
    			}
    			
    		}else if(a instanceof Number && b instanceof String || a instanceof String && b instanceof Number){
    			String aux1 = String.valueOf(a);
    			String aux2 = String.valueOf(b);
    			if(aux1.compareTo(aux2) > 0){
    				return 1;
    			}else if(aux1.compareTo(aux2) < 0 ){
    				return -1;
    			}else{
    				return 0;
    			}
    			
    		
    		}else{
    			return 0;
    		}
    		
    	}
    	
	public static void main(String[] args){
		
		ArbolBinario arbol = new ArbolBinario();
		
		arbol.insertar("a");
		arbol.insertar(50);
		arbol.insertar(1.2);
		arbol.insertar(1.1);
		arbol.insertar("dsa");
		arbol.insertar("v");
		arbol.insertar("t");
		arbol.insertar("b");
		arbol.insertar("m");
		arbol.insertar(1);
		arbol.insertar(2);
		arbol.insertar(".");
		arbol.insertar("carpeta 1");
		arbol.insertar("carpeta 3");
		arbol.insertar("carpeta 2");
		arbol.insertar(".carpeta 1");
		
		arbol.recorrerEnOrden();	
		
	}
	
	
}

class Nodo{
	
	private Object valor;
	private Nodo derecho;
	private Nodo izquierdo;
	
	public Nodo(Object elemento){
		this.valor = elemento;
		this.derecho = null;
		this.izquierdo = null;
	}
	
	public Object getValor(){
		return this.valor;
	}
	
	public Nodo getDerecho(){
		return derecho;
	}
	
	public void setDerecho(Nodo sigDerecho){
		this.derecho = sigDerecho;
	}
	
	public Nodo getIzquierdo(){
		return izquierdo;
	}
	
	public void setIzquierdo(Nodo sigIzquierdo){
		this.izquierdo = sigIzquierdo;
	}
	

}

