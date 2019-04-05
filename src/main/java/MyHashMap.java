public class MyHashMap {
    private static final float LOAD_FACTOR = 0.75f;
    private static final int CAPACITY = 16;
    private Entry[] table = new Entry[CAPACITY];
    private int size;


    public void put(Integer key, long value) {
        Entry entry = new Entry(key, value);
        changeTableCapacity();

        if (table[indexFor(key.hashCode(), table.length)] != null) {
            for (int j = 0; j < table.length; j++) {
                if (table[j] == null) {
                    table[j] = entry;
                    break;
                }
            }
        } else {
            table[indexFor(key.hashCode(), table.length)] = entry;
        }
        size++;
    }

    public long get(Integer key) {
        for (int i = 0; i < size; i++) {
            if (table[i] != null & table[i].getKey().equals(key)) {
                return table[i].getValue();
            }
        }
        return 0;
    }

    public int size() {
        return size;
    }

    private int indexFor(int hash, int tableLength) {
        return hash % tableLength;
    }

    private void changeTableCapacity() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                break;
            }
            if (i == table.length - 1) {
                changeCapacity();
                break;
            }
        }
    }

    private void changeCapacity() {
        Entry[] table = new Entry[CAPACITY * 2];
        System.arraycopy(this.table, 0, table, 0, this.table.length);
        this.table = table.clone();
    }
}
