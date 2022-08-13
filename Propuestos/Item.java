package Propuestos;

public class Item {
    private Object value;
    private Object key;

    public Item() {
    }

    public Item(Object value, Object key) {
        this.key = key;
        this.value = value;
    }
    public Object getKey() {
        return key;
    }
    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }

    public String toString() {
        return "key: " + key + ", value: " + value;
    }
}
