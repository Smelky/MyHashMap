import myhashmap.MyHashMap;

public class MyHashMapApplication {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 2L);
        myHashMap.put(2, 13L);
        myHashMap.put(2, 13L);
        myHashMap.put(2, 22L);
        myHashMap.put(3, 15L);
        myHashMap.put(3, 15L);
        myHashMap.put(3, 22L);
        myHashMap.put(5, 6L);
        myHashMap.put(6, 12L);

        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.size());
    }
}
