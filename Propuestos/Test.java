package Propuestos;
import java.util.LinkedList;
public class Test {
    public static void main(String[] args) {
        
        HashChaining hash = new HashChaining();
        hash.put("arrecho", 11);
        hash.put("aanatomia", 145);
        hash.put("vibora", 12);
        hash.put("costra", 14);
        hash.put("diente", 164);

        System.out.println(hash);
        System.out.println(hash.size());
        System.out.println(hash.get("aanatomia"));
        System.out.println(hash.remove("vibora"));
        System.out.println(hash);
    }

}
