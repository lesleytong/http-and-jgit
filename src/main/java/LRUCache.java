import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put(0, 0);
        cache.put(3, 3);
        cache.put(1, 1);
        cache.put(4, 4);
        cache.put(2, 2);

        print(cache);

        int res = cache.get(1);
        System.out.println(res);

        cache.put(8, 8);

        print(cache);

    }

    private static void print(LRUCache cache) {
        Entry tmp = cache.head.next;
        int count = 0;
        while(count < cache.capacity){
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
            count++;
        }
        System.out.println();
    }

    Map<Integer, Entry> map;
    Entry head;
    Entry tail;
    int capacity;
    int size;

    public LRUCache(int capacity){
        map = new HashMap<>(capacity);

        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;

        this.capacity = capacity;
        this.size = 0;
    }

    // 查询
    public int get(int key){
        Entry entry = map.get(key);
        if(entry == null){
            return -1;
        }

        moveToHead(entry);
        return entry.value;
    }

    // 插入
    public void put(int key, int value) {
        // 先检查是否已经存在。
        // 如果已经存在，则更新value值。
        Entry entry = map.get(key);
        if(entry != null){
            entry.value = value;
            moveToHead(entry);
            return;
        }

        // 如果不存在，则先检查容量是否已满。
        // 如果容量已满，则删除尾部节点
        if(size == capacity){
            Entry lastEntry = tail.pre;
            deleteNode(lastEntry);
            map.remove(lastEntry.key);
            size--;
        }

        // 才将新节点插入到头部
        Entry newEntry = new Entry(key, value);
        addNode(newEntry);
        map.put(key, newEntry);
        size++;
    }

    private void moveToHead(Entry entry) {
        // 先删除entry原来的关系
        deleteNode(entry);
        // 再插入到头部
        addNode(entry);
    }

    private void addNode(Entry entry) {
        entry.next = head.next;
        head.next.pre = entry;
        head.next = entry;
        entry.pre = head;
    }

    private void deleteNode(Entry entry) {
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;
    }


}

class Entry{
    int key;
    int value;
    Entry pre;
    Entry next;

    public Entry(int key, int value){
        this.key = key;
        this.value = value;
    }

    public Entry(){

    }
}
