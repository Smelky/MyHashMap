import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMyHashMap {
    private MyHashMap myHashMap;

    @Before
    public void setUp() {
        myHashMap = new MyHashMap();
        myHashMap.put(2, 4L);
        myHashMap.put(3, 5L);
    }

    @Test
    public void testPut() {
        myHashMap.put(2, 4L);
        myHashMap.put(3, 5L);
        assertEquals(4, myHashMap.size());
    }

    @Test
    public void testGet() {
        myHashMap.put(2, 4L);
        assertEquals(myHashMap.get(2), (4));
    }

    @Test
    public void testSize() {
        assertEquals(myHashMap.size(), 2);
    }
}
