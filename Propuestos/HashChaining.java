package Propuestos;

import java.util.LinkedList;

public class HashChaining implements HashTable {
	//Atributos
	private final int DEFAULT_LENGTH = 10;
	private LinkedList<Item>[] table;
	private int size;

	//Constructores
	public HashChaining() {
		table = new LinkedList[DEFAULT_LENGTH];
	}
	public HashChaining(int lenght) {
		table = new LinkedList[lenght];
	}
	
	//Metodos
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(Object key) {
		int index = codeGetHash(key);

		if (table[index] != null)
			return true;
		return false;
	}

	public boolean containsValue(Object value) {
		//loop para obtener el value
		for (int i = 0; i < table.length; i++) {
			if(table[i] != null)
				//loop que internamente comprueba cada valor del linkedlist
				for(Item item: table[i]) {
					//retorna si ha encontrado el value
					if(item.getValue().equals(value)) 
						return true;
			}
		}
		return false;
	}

	public Integer get(String key) {
		//Obtencion de hashcode
		int code = codeGetHash(key); 
		//Busca en la lista si alguna clave coincide con key		
		for(Item item : table[code]) {
			if(item.getKey().equals(key))
				//Retorna el value
				return (Integer)item.getValue();
		}
		return null;
	}

	public Integer put(String key, Integer value) {
		//Obtencion del hashcode
		int code = codeGetHash(key);
		//Si el lugar esta vacio se instancia un objeto
		if (table[code] == null) {
			table[code] = new LinkedList<Item>();
		}
		//se agrega el valor a la lista
		table[code].add(new Item(key,value));
		//incremento del tamaño
		size++;
		return value;
	}

	public Integer remove(Object key) {
		//Obtencion del hashcode
		int code = codeGetHash(key);
		//Comprueba si la ubicacion esta vacia
		if(table[code] == null)
			return null;
		int size = table[code].size();

		Object value = null;
		
		for (int i = 0; i < size ; i++) {
			//Busca en la lista si la llave se encuentra dentro
			if(table[code].get(i).getKey().equals(key)){
				value = table[code].get(i).getValue();
				//Una vez encontrada se elimina
				table[code].remove(i);
				if(table[code].size()==0) 
					table[code] = null;
				//reduccion del tamaño
				size--;
				break;
			}
		}			
		return (Integer)value;
	}

	public void clear() {
		//Crea una nueva tabla con similares dimensiones
		table = new LinkedList[DEFAULT_LENGTH];
		size = 0;
	}
	//Impresion
	public String toString() {
		String text = "[\n";
		int length = table.length;
		for (int i = 0; i < length; i++) {
			//En caso de que el sitio este vacio no lo imprime
			if (table[i] == null)
				continue;
			text += printList(table[i]) + "\n";
		}
		text += "]";
		return text;
	}

	private String printList(LinkedList<Item> list) {
		//Text servira para imprimir
		String text = "( ";
		//cada elemento de la lista se almacena en text
		for (Item i: list) {
			text += i + " , ";
		}
		//cierra text con parentesis
		text += ")";
		return text;
	}

	private int codeGetHash(Object value) {
		//Si value es null
		if (value == null)
			throw new NullPointerException();
		//Obtencion del hashcode por defecto
		int code = value.hashCode();
		//si hashcode es negativo hay que hacerlo positivo
		if (code < 0)
			code = -code;
		//Reduccion del code
		code = code % table.length;
		return code;
	}

}
