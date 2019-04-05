public class MyHashMapApplication {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,2L);
        myHashMap.put(2,15L);
        myHashMap.put(2,22L);
        myHashMap.put(3,6L);
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.size());
    }
}
