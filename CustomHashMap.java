import java.util.*;

class CustomHashMap {
    static class Entry {
        Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    static final int SIZE = 16;
    Entry[] table;

    CustomHashMap() {
        table = new Entry[SIZE];
    }

    int hash(Object key) {
        return key.hashCode() % SIZE;
    }

    void put(Object key, Object value) {
        int index = hash(key);
        Entry newEntry = new Entry(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value; 
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newEntry;
            }
        }
    }

    Object get(Object key) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    void remove(Object key) {
        int index = hash(key);
        Entry current = table[index];
        Entry prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value for 'three': " + map.get("three"));

        map.remove("three");
        System.out.println("Value for 'three' after removal: " + map.get("three"));
    }
}
/*Value for 'three': 3
Value for 'three' after removal: null */