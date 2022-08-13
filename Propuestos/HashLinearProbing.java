package Propuestos;

public class HashLinearProbing implements HashTable {
	class Item {
		private Object value;
		private Comparable key;

		public Item() {
		}

		public Item(Object value, Comparable key) {
			this.value = value;
			this.key = key;
		}
	}

	private Item[] table;
	private int DEFAULT_LENGTH = 10;
	private int size;

	public HashLinearProbing() {
		table = new Item[DEFAULT_LENGTH];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(Object key) {
		int i = codeGetHash(key);

		while (i < table.length || table[i] != null) {
			if (table[i].key.equals(key))
				return true;
			i++;
		}
		return false;
	}

	public boolean containsValue(Object value) {
		int i = 0;
		while (table[i] != null) {
			if (table[i].value.equals(value))
				return true;
			i++;
		}
		return false;
	}

	public Integer get(String key) {
		Integer value = getIndex(key);
		return (value != null) ? (Integer)table[value].value: null;
	}

	public Integer put(String key, Integer value) {
		int i = codeGetHash(key);

		while (i < table.length) {
			if (table[i] == null)
				table[i] = new Item(key, value);
			else
				i++;
		}
		return value;
	}

	public Integer remove(Object key) {
		Integer i = getIndex(key);
		if(i != null) {		
			Integer value = (Integer)table[i].value;
			table[i] = null;
			return value;
		}
		return null;

	}

	private Integer getIndex(Object key) {
		Integer i = codeGetHash(key);

		while (i < table.length || table[i] != null) {
			if (table[i].key.equals(key))
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
		for (int i = 0; i < table.length; i++) {
			text += "key: " + table[i].key + " value: " +table[i].value + "\n";
		}
		return text;
	}

}
