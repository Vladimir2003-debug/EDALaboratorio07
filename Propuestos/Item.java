package Propuestos;

public class Item {
    private Object value;
    private Object key;

    public Item() {
    }

    public Item(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    public Object getKey() {
        return this.key;
    }
    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return this.value;
    }
    public void setValue(Object value) {
        this.value = value;
    }

    public String toString() {
        return "key: " + this.key + ", value: " + this.value;
    }
}
