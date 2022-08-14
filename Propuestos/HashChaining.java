package Propuestos;

import java.util.LinkedList;

public class HashChaining implements HashTable {
	private final int DEFAULT_LENGTH = 10;
	private LinkedList<Item>[] table;
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
		int index = codeGetHash(key);

		if (table[index] != null)
			return true;
		return false;
	}

	public boolean containsValue(Object value) {
		LinkedList tmp = null;
		for (int i = 0; i < table.length; i++) {
			tmp = table[i];
			for(Item item: table[i]) {
				if(item.getValue().equals(value)) 
					return true;
			}
		}
		return false;
	}

	public Integer get(String key) {

		int code = codeGetHash(key); 

		for(Item item : table[code]) {
			if(item.getKey().equals(key))
				return (Integer)item.getValue();
		}
		return null;
	}

	public Integer put(String key, Integer value) {
		int code = codeGetHash(key);

		if (table[code] == null) {
			table[code] = new LinkedList<Item>();
		}
		table[code].add(new Item(key,value));
		size++;
		return value;
	}

	public Integer remove(Object key) {
		int code = codeGetHash(key);

		if(table[code] == null)
			return null;
		int size = table[code].size();

		Object value = null;
		for (int i = 0; i < size ; i++) {
			if(table[code].get(i).getKey().equals(key)){
				value = table[code].get(i).getValue();
				table[code].remove(i);
				if(table[code].size()==0) 
					table[code] = null;
				break;
			}
		}			
		return (Integer)value;
	}

	public void clear() {
		table = new LinkedList[DEFAULT_LENGTH];
	}

	public String toString() {
		String text = "[\n";
		int length = table.length;
		for (int i = 0; i < length; i++) {
			if (table[i] == null)
				continue;
			text += printList(table[i]) + "\n";
		}
		text += "]";
		return text;
	}

	public String printList(LinkedList<Item> list) {
		String text = "( ";
		for (int i = 0; i < list.size(); i++) {
			text += list.get(i) + " , ";
		}
		text += ")";
		return text;
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

}
