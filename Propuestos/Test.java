package Propuestos;
public class Test {
    public static void main(String[] args) {
        
        HashLinearProbing hash = new HashLinearProbing();
        hash.put("a", 11);
        hash.put("b", 145);
        hash.put("c", 12);
        hash.put("d", 14);
        hash.put("e", 164);
        hash.put("f", 112164);
        hash.put("g", 163234);
        hash.put("h", 16444);
        hash.put("i", 142424);
        hash.put("j", 4234);
        hash.put("k", 15364);
        hash.put("l", 111144);
        hash.put("b", 15564);
        hash.put("a", 111434);

        System.out.println(hash);
        System.out.println(hash.size());
        System.out.println(hash.get("i"));
        System.out.println(hash);
        System.out.println(hash.size());
        System.out.println(hash.containsKey("i"));
        System.out.println(hash.containsValue(111434));
    }

}
