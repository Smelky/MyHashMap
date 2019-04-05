package myhashmap;

public class MyHashMap {
    private static final float LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[16];

    public MyHashMap() {
        setAllElementsAsNull(this.table);
    }

    private void setAllElementsAsNull(Entry[] table) {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    public void put(Integer key, long value) {
        Entry entry = new Entry(key, value);
        changeTableCapacity();

        if (table[indexFor(key.hashCode(), table.length)] != null) {
            if (table[indexFor(key.hashCode(), table.length)].getValue()
                    .equals(entry.getValue())) {
                rewrite(key, entry);
            } else {
                compare(key, entry);
            }
        } else {
            rewrite(key, entry);
        }
    }

    public long get(Integer key) {
        for (Entry entry : table) {
            if (entry != null && entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return 0;
    }

    public int size() {
        int size = 0;
        for (Entry entry : table) {
            if (entry != null) {
                size++;
            }
        }
        return size;
    }

    private void rewrite(Integer key, Entry entry) {
        table[indexFor(key.hashCode(), table.length)] = entry;
    }

    public void compare(Integer key, Entry entry) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (entry.getValue().equals(table[i].getValue())) {
                    rewrite(key, entry);
                    return;
                }
            }
        }
        findNewPosition(key, entry);
    }

    private void findNewPosition(Integer key, Entry entry) {
        for (int i = indexFor(key.hashCode(), table.length); i < table.length; i++) {
            if (table[i] == null) {
                table[i] = entry;
                return;
            }
        }
        for (int i = 0; i < indexFor(key.hashCode(), table.length); i++) {
            if (table[i] == null) {
                table[i] = entry;
                return;
            }
        }
    }

    private int indexFor(int hash, int tableLength) {
        return hash % tableLength;
    }

    private void changeTableCapacity() {
        if (size() == (table.length * LOAD_FACTOR)) {
            changeCapacity();
        }
    }

    private void changeCapacity() {
        Entry[] table = new Entry[this.table.length * 2];
        setAllElementsAsNull(table);
        System.arraycopy(this.table, 0, table, 0, this.table.length);
        this.table = table.clone();
        reindexing();
    }

    private void reindexing() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                int newIndex = indexFor(table[i].getKey().hashCode(), table.length);
                this.table[newIndex] = table[i];
            }
        }
    }

    public Entry[] getTable() {
        return table;
    }
}
