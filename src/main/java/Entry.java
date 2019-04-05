public class Entry {
    private final Integer key;
    private Long value;
    private Entry next;
    private int hash;

    public Entry(Integer key, Long value) {
        this.key = key;
        this.value = value;
    }

    public Entry getNext() {
        return next;
    }

    public Integer getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
}
