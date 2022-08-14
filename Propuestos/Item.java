package Propuestos;

public class Item {
    //Atributos
    private Object value;
    private Object key;
    //Contructores
    public Item() {
    }

    public Item(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    //Getters y setters
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
    //tostring
    public String toString() {
        return "key: " + this.key + ", value: " + this.value;
    }
}
