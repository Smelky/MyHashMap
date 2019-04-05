import myhashmap.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMyHashMap {
    private MyHashMap myHashMap;

    @Before
    public void setUp() {
        myHashMap = new MyHashMap();
        myHashMap.put(1, 4L);
        myHashMap.put(2, 5L);
    }

    @Test
    public void testPut() {
        myHashMap.put(1, 4L);
        myHashMap.put(1, 4L);
        myHashMap.put(2, 5L);
        myHashMap.put(2, 5L);
        assertEquals(2, myHashMap.size());
        myHashMap.put(2, 6L);
        assertEquals(3, myHashMap.size());
    }

    @Test
    public void testGet() {
        myHashMap.put(4, 4L);
        assertEquals(4, myHashMap.get(4));
    }

    @Test
    public void testSize() {
        assertEquals(2, myHashMap.size());
    }

    @Test
    public void testCapacityChange(){
        myHashMap.put(3, 2L);
        myHashMap.put(4,13L);
        myHashMap.put(5,15L);
        myHashMap.put(5,15L);
        myHashMap.put(6,22L);
        myHashMap.put(7,6L);
        myHashMap.put(8,6L);
        myHashMap.put(8,6L);
        myHashMap.put(9,6L);
        myHashMap.put(10,6L);
        myHashMap.put(11,6L);
        myHashMap.put(12,6L);
        assertEquals(16, myHashMap.getTable().length);
        myHashMap.put(13, 6L);
        assertEquals(32, myHashMap.getTable().length);
    }
}
