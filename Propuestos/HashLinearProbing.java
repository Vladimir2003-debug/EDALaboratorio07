package Propuestos;

public class HashLinearProbing implements HashTable {
	//Atributos
	private Item[] table;
	private int DEFAULT_LENGTH = 10;
	private int size;
	//Constructores
	public HashLinearProbing() {
		table = new Item[DEFAULT_LENGTH];
	}
	public HashLinearProbing(int length) {
		table = new Item[length];
	}
	//Metodos
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(Object key) {
		int i = codeGetHash(key,table.length);
		//Si el primer lugar de key no es nulo entonces key existe
		if(table[i] != null){
			return true;
		}
		return false;
	}

	public boolean containsValue(Object value) {
		int i = 0;
		//Busqueda de value en la tabla
		while (i < table.length) {
			if(table[i] != null)
				//Al obtener value retorna true
				if (table[i].getValue().equals(value))
					return true;
			i++;
		}
		return false;
	}

	public Integer get(String key) {
		Integer value = getIndex(key);
		//Comprobacion 
		return (value != null) ? (Integer)table[value].getValue(): null;
	}

	public Integer put(String key, Integer value) {
		int i = codeGetHash(key,table.length);
		//Redimensiona la tabla si esta demasiado llena
		if(size > (table.length*80)/100)
			reSize();
		while (i < table.length) {
			if (table[i] == null){
				break;
			}else
				i++;
		}
		//Inserccion de la clave/valor		
		table[i] = new Item(key, value);

		size++;
		return value;
	}

	private void reSize() {
		Item[] tmp = new Item[this.table.length*2];
		//Inserta en cada pocicion de la anterior tabla
		for (int i = 0; i < table.length; i++)
			tmp[i] = this.table[i];
		this.table = tmp; 
	}

	public Integer remove(Object key) {
		Integer i = getIndex(key);

		if(i != null) {
			//Almacena el valor que se va a eliminar		
			Integer value = (Integer)table[i].getValue();
			//Elimina el objeto asociado al sitio
			table[i] = null;
			size--;
			return value;
		} else
			return null;
	}

	private Integer getIndex(Object key) {
		Integer i = codeGetHash(key,table.length);
		int length = table.length;
		//Mientras el tamaño no sea cero
		while(length != 0) {
			while (i < size || table[i] != null) {
				//cuando encuentra el index lo retorna
				if (table[i].getKey().equals(key))
					return i;
				else
					i++;
			}
			//division del valor tabla
			length = length/2;
			i = codeGetHash(key,length);
		}

		return null;
	}

	public void clear() {
		//Crea una nueva tabla
		table = new Item[DEFAULT_LENGTH];
		size = 0;
	}

	private int codeGetHash(Object value,int lenght) {
		//Si el valor es null
		if (value == null)
			throw new NullPointerException();
		int code = value.hashCode();
		//Si code es negativo lo hace positivo
		if (code < 0)
			code = -code;
		//Reduce el valor de code
		code = code % lenght;
		return code;
	}

	public String toString() {
		String text = "";
		//Itera sobre todos los items de la tabla
		for (int i = 0; i < table.length ; i++) {
			//Si el lugar no tiene valor no se imprime
			if(table[i] == null)
				continue;
			else
				text += table[i] + "\n";
		}
		return text;
	}

}
