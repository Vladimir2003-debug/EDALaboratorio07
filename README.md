
<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">DEPARTAMENTO ACADÉMICO DE INGENIERÍA DE SISTEMAS E INFORMÁTICA</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: Informe de Laboratorio</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLD-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>

<div align="center">
<span style="font-weight:bold;">INFORME DE LABORATORIO</span><br />
</div>


<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5">Estructura de Datos y Algoritmos</td></tr>
<tr><td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5">Hashing</td></tr>
<tr>
<td>NÚMERO DE PRÁCTICA:</td><td>07</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
</tr>
<tr>
<td>FECHA INICIO::</td><td>16-May-2022</td><td>FECHA FIN:</td><td>20-May-2022</td><td>DURACIÓN:</td><td>02 horas</td>
</tr>
<tr><td colspan="6">RECURSOS:
    <ul>
        <li>https://www.w3schools.com/java/</li>
        <li>https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-enterprise-java-and-web-developers</li>
        <li>Weiss M., Data Structures & Problem Solving Using Java, 2010, Addison-Wesley.</li>
        <li>https://www.cpp.edu/~ftang/courses/CS240/lectures/hashing.htm</li>
    </ul>
</td>
</<tr>

<tr><td colspan="6">INTEGRANTES:
<ul>
<li>Vladimir Arturo Sulla Quispe - vsullaq@unsa.edu.pe</li>
</ul>
</td>
</<tr>
<tr><td colspan="6">DOCENTES:
<ul>
<li>Richart Smith Escobedo Quispe - rescobedoq@unsa.edu.pe</li>
</ul>
</td>
</<tr>
</tdbody>
</table>

# SOLUCION Y RESULTADOS

### Organizacion
La tabla 
``` 
./
├───propuestos
│   ├───HashChaining.java
│   ├───HashLinearProbing.java
|   ├───HashTable.java
|   ├───Item.java
│   └───Test.java
├───.gitignore
├───HashDemo.java
├───README.md.java
└───User.md
```
Donde :

- HashChaining corresponde a una tabla hash solucionando las colisiones con listas enlazadas.
- HashLinearProbing corresponde a una tabla hash solucionando las colisiones con saltos lineales.
## I SOLUCION DE EJERCICIOS/PROBLEMAS

Para ala resolucion se dara detalle de las clases
### Item
```java
public class Item {
    // Cada objeto Item guarda en sus atributos 
    // una clave y un valor 
    private Object value;
    private Object key;
    
    //constructors
    public Item() {
    }

    public Item(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

//getters y setters
    
    // toString imprime la llave y el valor de Item
    // indicando cual es la llave y cual es el valor 
    public String toString() {
        return "key: " + this.key + ", value: " + this.value;
    }
}
```
### HashChaining

#### Atributos
```java
    //El valor por defecto con la que se crea la tabla
	private final int DEFAULT_LENGTH = 10;
    //La table es un arreglo estandar de linkedlist, y 
    // a su vez linkedList es una lista de items
	private LinkedList<Item>[] table;
    //El numero de elementos no nulos en la table
	private int size;
``` 
#### Metodos adicionales que no estan el la interfaz:

```java
	private int codeGetHash(Object value) {
        //Si Value es null lanzara una excepcion
		if (value == null)
			throw new NullPointerException();
		//Obtencion del valor hash,
        int code = value.hashCode();

        //Esta parte analiza si el valor hash es negativo 
		if (code < 0)
			code = -code;
        // A veces el valor hash es demasiado alto por lo que se modifica 
        // de acuerdo al tamaño actual de la tabla
		code = code % table.length;
		return code;
	}
//Este metodo sirve para imprimir un LinkedList de la table
    public String printList(LinkedList<Item> list) {
		String text = "( ";
		for (int i = 0; i < list.size(); i++) {
			text += list.get(i) + " , ";
		}
		text += ")";
		return text;
	}
```
#### Contructor
```java
    // Usando el valor por defecto(normalmente es 10)
	public HashChaining() {
		table = new LinkedList[DEFAULT_LENGTH];
	}
    // Usando un valor ingresado manualmente
	public HashChaining(int lenght) {
		table = new LinkedList[lenght];
	}
```
#### Metodos secundarios
```java
    //Como el size ya esta como atributo simplemente se retorna size
    public int size() {
		return size;
	}

    //Si size esta en 0 entonces la tabla esta vacia
	public boolean isEmpty() {
		return size == 0;
	}
    /*Comprobar si la llave esta en la tabla
    */
    public boolean containsKey(Object key) {
		//Obtencion del hashCode
        int index = codeGetHash(key);
        /* Si la ubicacion del hashcode no esta vacia la llave existe 
        dentro de la tabla no es necesario comprobar cada elemento
        */
		if (table[index] != null)
			return true;
		return false;
	}

    /*Comprovar si la tabla contiene a value
    */
	public boolean containsValue(Object value) {
		/*A diferencia de containsKey no sabemos exactamente donde se ubica value
        Por lo que se buscara en cada elemento de la tabla
        */
        for (int i = 0; i < table.length; i++) {
			//Si la ubicacion en la tabla no esta vacia se hara una busqueda
            if(tmp != null)
            //Comprueba cada elemento de la tabla si encuentra value
				for(Item item: table[i]) {
					if(item.getValue().equals(value)) 
                    //Al encontrarlo retorna true
						return true;
			}
		}
		return false;
	}

    public void clear() {
        // Simplemente se crea una nueva tabla como en el constructor y size se iguala a 0 
		table = new LinkedList[DEFAULT_LENGTH];
        size = 0;
	}
```

#### ToString
```java
	/*El metodo to String imprime de la forma[()()()] donde
    donde los elementos entre parentesisi corresponden a cada lista del arreglo
    */
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

```

#### Metodos principales
```java
//Obtencion de un valor de la table mediante su clave
    public Integer get(String key) {
        //obtencion del hashcode
		int code = codeGetHash(key); 
        /*En este caso a diferencia de containskey si es necesario rebuscar 
        en la lista si la llave esta dentro
        */
		for(Item item : table[code]) {
            //Cuando la encuentra retorna el valor asociado a la llave
			if(item.getKey().equals(key))
				return (Integer)item.getValue();
		}
        //Si no retorna null
		return null;
	}

//Insertar un item clave/valor
	public Integer put(String key, Integer value) {
		//Obtencion del hashcode
        int code = codeGetHash(key);
        //Comprueba si la ubicacion esta vacio caso contrario se crea un nuevo objeto 
		if (table[code] == null) {
			table[code] = new LinkedList<Item>();
		}
        //Entonces a ese objeto se le inserta la clave/valor
		table[code].add(new Item(key,value));
		//Incremento del tamaño
        size++;
        //Retorno del valor de la clave
		return value;
	}

//Eliminacion de una clave/valor
	public Integer remove(Object key) {
		//Obtencion del hashcode
        int code = codeGetHash(key);
        //Si la ubicaion correspondiente a la clave es null retorna null
		if(table[code] == null)
			return null;

        int size = table[code].size();

		Object value = null;
        //Busqueda de la clave en la lista del hashcode obtenido
		for (int i = 0; i < size ; i++) {
            //Comprobacion
			if(table[code].get(i).getKey().equals(key)){
                //Entonces cuando la encuentra guarda el valor que se va a eliminar
				value = table[code].get(i).getValue();
                //Lo elimina
				table[code].remove(i);
                //Si la Lista en la ubicaion queda vacia entonces la ubicaion se igual
                //a null
				if(table[code].size()==0) 
					table[code] = null;
                //Reduccion del tamaño
				size--;
				break;
			}
		}
        //Entonces retorna el valor eliminado			
		return (Integer)value;
	}
```

### HashLinearprobing
#### Atributos

```java
//La tabla que almacena los datos clave/valor
	private Item[] table;
    //El valor por defecto con la que se creara el arreglo estandar
	private int DEFAULT_LENGTH = 10;
    //El numero de datos no nulos en la tabla
	private int size;
```

#### Contructor

```java
// En este constructor se usa el valor por defecto
	public HashLinearProbing() {
		table = new Item[DEFAULT_LENGTH];
	}
// Usando un valor ingresado en el constructor
	public HashLinearProbing(int length) {
		table = new Item[length];
	}
```
#### Metodos Adicionales

```java
//Este metodo obtiene el valor hash de acuerdo a un valor en el parametro
	private int codeGetHash(Object value,int length) {
		//Identifica si value es null sino lanza una excepcion
        if (value == null)
			throw new NullPointerException();
        //Obtencion del hashCode
        int code = value.hashCode();
        //Si el valor es negativo lo vuelve positivo
		if (code < 0)
			code = -code;
        //Obtencion del valor con respecto al tamaño de la tabla
		code = code % length;
		return code;
	}
    // Cuando get y remove necesitan el index para funcionar,
    //este metodo obtiene el lugar de donde esta el valor deseado
    private Integer getIndex(Object key) {
        //obtencion de hashCode
		Integer i = codeGetHash(key,table.length);
        //Valor inicial con el que se inicara el loop 
        int length = table.length;
        //loop que navega hasta encontrar el valor
        while(length != 0) {
			while (i < size || table[i] != null) {
            //Cunado encuentra el valor retorna el index i
				if (table[i].getKey().equals(key))
					return i;
				else
					i++;
			}
            //Si no entcuentra el valor va hasta el anteior valor hash
			length = length/2;
			i = codeGetHash(key,length);
		}
		
        //Si no lo encuentra retorna null
		return null;
	}
    //En linearProbing cuando los valores alcanzar el tamaño maximo de  la tabla es necesario
    // redimensionar la tabla guardando todos los valores anteriores en una  nueva tabla de tamaño 
    //doble  
    private void reSize() {
        //Creacion de nueva tabla de tamaño doble
		Item[] tmp = new Item[this.table.length*2];
		for (int i = 0; i < table.length; i++)
        //Guardado de los datos en la nueva tabla
			tmp[i] = this.table[i];
        //La vieja tabla es reeeplazada por la nueva tabla
		this.table = tmp;
	}


```
#### Metodos Secundarios

```java
//Como el numero de elementos es size simplemente se devuelve el valor
	public int size() {
		return size;
	}
//Si size es cero entonces la tabla esta vacia
	public boolean isEmpty() {
		return size == 0;
	}
//Al igual que chaining si la ubicacion del hash de la llave
// no esta vacia entonces la llave existe en la tabla
    public boolean containsKey(Object key) {
		int i = codeGetHash(key);

		if(table[i] != null){
			return true;
		}
		return false;
	}
// Como en chainign value se busca en cada pocicion de la tabla
	public boolean containsValue(Object value) {
		int i = 0;
        //Este loop buscara en cada ubicacion hasta encontrar el valor
		while (i < table.length) {
			if(table[i] != null)
            //Al momento de encontrar el valor retorna true
				if (table[i].getValue().equals(value))
					return true;
			i++;
		}
		return false;
	}
//Actua como el constructor para vacuar la tabla
    public void clear() {
		table = new Item[DEFAULT_LENGTH];
		size = 0;
	}

```

#### Metodos Principales
```java
    public Integer get(String key) {
        //Al obtener el index comprueba si la ubicacion es null retorna null
        //En todo caso obtiene el value del item almacenado y retorna
		Integer value = getIndex(key);
		return (value != null) ? (Integer)table[value].getValue(): null;
    }
```
```java
// Insertar datos clave/valor
    public Integer put(String key, Integer value) {
		int i = codeGetHash(key,table.length);
        //El caso de que el el 80% de la tabla este llena se hace un resize
		if(size > (table.length*80)/100)
			reSize();
        //Si el lugar en la tabla ya esta ocupado se empieza a buscar otro sitio         
		while (i < table.length) {
			if (table[i] == null){
				break;
			}else
				i++;
		}
        //Si la tabla esta llena se hace un resize
		if(i == table.length)
			reSize();
		//Lyego de comprob
		table[i] = new Item(key, value);
        //Se incrementa el size
		size++;
        //Y retorna el valor asociado a la clave insertado
		return value;
	} 
```
```java
//Eliminacion de una clave/ valor
    public Integer remove(Object key) {
		//Obtencion del index de la clave
        Integer i = getIndex(key);
        //Comprobacion si el lugar 
		if(i != null) {	
            //Obtener el valor que se va a remover	
			Integer value = (Integer)table[i].getValue();
			//Borramos el valor
            table[i] = null;
            //El tamaño se reduce  
			size--;
			return value;
		} else // Si no lo encuentra retorna null
			return null;
	}
```

## III CONCLUSIONES
La velocidad para la obtencion de los datos supone un O(1) en todos los casos, sin embargo hay que
 tener pesar de esto la valocidad puede ser demasiado alta si es que existen multiples claves con
valores similares en el peor caso el valor hash obtenido sera el mismo para todos los casos tanto para
 linearProbing(que seria recorrer toda la tabla) y Chaining(una lista que guarada todos los valores no
  es un hash es un linkedList)
# RETROALIMENTACION GENERAL






# REFERENCIAS Y BIBLIOGRAFIA
```
https://www.w3schools.com/java/
https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-enterprise-java-and-web-developers
Weiss M., Data Structures & Problem Solving Using Java, 2010, Addison-Wesley.
https://www.cpp.edu/~ftang/courses/CS240/lectures/hashing.htm
```