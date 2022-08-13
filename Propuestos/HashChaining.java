package Propuestos;

import java.util.LinkedList;

public class HashChaining implements HashTable {
	private final int DEFAULT_LENGTH = 10;
	private LinkedList<Integer>[] table;
	private int size;

	public HashChaining() {
		table = new LinkedList[DEFAULT_LENGTH];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return table[0] == null;
	}

	public boolean containsKey(Object key) {
		if (key == null)
			throw new NullPointerException();
		int code = key.hashCode();
		if(code > 0)
			code = (-1) * code;
		code = code % table.length;
		if (table[key.hashCode()] != null)
			return true;
		return false;
	}

	public boolean containsValue(Object value) {
		LinkedList<Integer> tmp = null;
		for (int i = 0; i < table.length; i++) {
			tmp = table[i];
			if(tmp.contains(value))
				return true;
		}
		return false;
	}

	public Integer get(String key) {
		if (key == null)
			throw new NullPointerException();

		int code = key.hashCode();

		if(code < 0)
			code = code*(-1);
		code = code % table.length;

		if (table[code] == null)
			return null;
		Integer value = (Integer) table[code].get(0);
		return value;
	}

	public Integer put(String key, Integer value) {
		if (key == null || value == null)
			throw new NullPointerException();
		int code = key.hashCode();
		
		if(code < 0) 
			code = code*(-1); 
		
		code = code % table.length;
		if (table[code] == null) {
			table[code] = new LinkedList<Integer>();
		}
		table[code].add(value);
		size ++;
		return value;
	}

	public Integer remove(Object key) {
		if(key == null)
			throw new NullPointerException();
		int code = key.hashCode();

		if(code < 0)
			code = -code;
		code= code % table.length;

		Integer value = table[code].get(0);
		table[code] = null;
		return value;
	}

	public void clear() {
		table = new LinkedList[DEFAULT_LENGTH];
	}

	public String toString() {
		String text = "[\n";
		int length = table.length;
		for (int i = 0; i < length; i++) {
			if (table[i] == null) continue;
			text += printList(table[i]) + "\n";
		}
		text += "]";
		return text;
	}

	public String printList(LinkedList<Integer> list) {
		String text = "( ";
		for (int i = 0; i < list.size(); i++) {
			text += list.get(i) + " , ";
		}
		text += ")";
		return text;
	}

}
