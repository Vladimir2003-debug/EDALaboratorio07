package Propuestos;

public class HashLinearProbing implements HashTable {

	private Item[] table;
	private int DEFAULT_LENGTH = 10;
	private int size;

	public HashLinearProbing() {
		table = new Item[DEFAULT_LENGTH];
	}
	public HashLinearProbing(int length) {
		table = new Item[length];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(Object key) {
		int i = codeGetHash(key);

		if(table[i] != null){
			return true;
		}
		return false;
	}

	public boolean containsValue(Object value) {
		int i = 0;
		while (i < table.length) {
			if(table[i] != null)
				if (table[i].getValue().equals(value))
					return true;
			i++;
		}
		return false;
	}

	public Integer get(String key) {
		Integer value = getIndex(key);
		return (value != null) ? (Integer)table[value].getValue(): null;
	}

	public Integer put(String key, Integer value) {
		int i = codeGetHash(key);

		if(size > (table.length*80)/100)
			reSize();
		while (i < table.length) {
			if (table[i] == null){
				break;
			}else
				i++;
		}
		if(i == table.length)
			reSize();
		
		table[i] = new Item(key, value);

		size++;
		return value;
	}

	private void reSize() {
		Item[] tmp = new Item[this.table.length*2];
		for (int i = 0; i < table.length; i++)
			tmp[i] = this.table[i];
		this.table = tmp; 
	}

	public Integer remove(Object key) {
		Integer i = getIndex(key);

		if(i != null) {		
			Integer value = (Integer)table[i].getValue();
			table[i] = null;
			size--;
			return value;
		} else
			return null;
	}

	private Integer getIndex(Object key) {
		Integer i = codeGetHash(key);
		while (i < table.length || table[i] != null) {
			if (table[i].getKey().equals(key))
				return i;
			else
				i++;
		}		
		return null;
	}

	public void clear() {
		table = new Item[DEFAULT_LENGTH];
	}

	private int codeGetHash(Object value) {
		if (value == null)
			throw new NullPointerException();
		int code = value.hashCode();

		if (code < 0)
			code = -code;
		code = code % table.length;
		return code;
	}

	public String toString() {
		String text = "";
		for (int i = 0; i < table.length ; i++) {
			if(table[i] == null)
				text += "null\n";
			else
				text += table[i] + "\n";
		}
		return text;
	}

}
