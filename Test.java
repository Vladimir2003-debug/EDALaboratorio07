import Propuestos.*;
public class Test {
    public static void main(String[] args) {
        HashChaining users = new HashChaining();

        User alfred = new User(34,"alfred","alfred@unsa.edu.pe");
        User esteban = new User(33,"esteban","esteban@unsa.edu.pe");
        User margareth = new User(14,"margareth","margareth@unsa.edu.pe");
        User fiorella = new User(54,"fiorella","fiorella@unsa.edu.pe");
        User olga = new User(99,"olga","olga@unsa.edu.pe");

        HashLinearProbing personas = new HashLinearProbing();

        users.put(alfred.getName(),alfred.getId());
        users.put(esteban.getName(),esteban.getId());
        users.put(margareth.getName(),margareth.getId());
        users.put(fiorella.getName(),fiorella.getId());
        users.put(olga.getName(),olga.getId());

        personas.put(alfred.getName(),alfred.getId());
        personas.put(esteban.getName(),esteban.getId());
        personas.put(margareth.getName(),margareth.getId());
        personas.put(fiorella.getName(),fiorella.getId());
        personas.put(olga.getName(),olga.getId());

        System.out.println(users);
        System.out.println(users.get("margareth")+"(Estos valores corresponden a la clave margareth)");
        System.out.println(users.remove("margareth")+"(Este valor corresponde al valor de la clave margareth)");
        
        System.out.println(personas);
        System.out.println(personas.get("margareth")+"(Estos valores corresponden a la clave margareth)");
        System.out.println(personas.remove("margareth")+"(Este valor corresponde al valor de la clave margareth)");
        
    }
}
