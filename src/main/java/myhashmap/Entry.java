package myhashmap;

public class Entry {
    private final Integer key;
    private Long value;

    public Entry(Integer key, Long value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }
}
