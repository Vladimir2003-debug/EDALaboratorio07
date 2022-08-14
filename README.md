
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
Metodos adicionales que no estan el la interfaz:

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
```

```

### HashLinearprobing

## III CONCLUSIONES


# RETROALIMENTACION GENERAL






# REFERENCIAS Y BIBLIOGRAFIA
```
https://www.w3schools.com/java/
https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-enterprise-java-and-web-developers
Weiss M., Data Structures & Problem Solving Using Java, 2010, Addison-Wesley.
https://www.cpp.edu/~ftang/courses/CS240/lectures/hashing.htm
```