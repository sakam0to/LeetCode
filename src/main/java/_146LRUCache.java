import java.util.HashMap;

public class _146LRUCache {
    public static void main(String[] args){

        LRUCache cache;
        int i;
        cache = new LRUCache(2);

        cache.put(2, 1);
        cache.put(3, 2);
        i = cache.get(3);
        i = cache.get(2);
        cache.put(4, 3);
        i = cache.get(2);
        i = cache.get(3);
        i = cache.get(4);

        cache = new LRUCache( 3 /* capacity */ );
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        i = cache.get(13);
        cache.put(2, 19);
        i = cache.get(2);
        i = cache.get(3);
        i = cache.get(1);

        cache = new LRUCache( 10 /* capacity */ );
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        i = cache.get(13);
        cache.put(2, 19);
        i = cache.get(2);
        i = cache.get(3);
        i = cache.get(1);
        cache.put(5, 5);
        i = cache.get(1);
        i = cache.get(2);
        i = cache.get(3);
        i = cache.get(4);
        i = cache.get(5);

System.out.println(i);
    }
}


class LRUCache {

    HashMap<Integer, Integer> keyToAddr = new HashMap<Integer, Integer>();
    int[][] cache; //cache[addr][0]:key, cache[addr][1]:value, cahce[addr][2]:the 'addr' of the previous element, cache[addr][3]:the 'addr' of the next element

    int amount = 0;
    int head = 0;//the position of least used element

    public LRUCache(int capacity) {
        cache = new int[capacity][4];
    }

    public int get(int key) {
        Integer addr = keyToAddr.get(key);
        if(null != addr){
            int oldHead = head;
            head = addr.intValue();
            if(head != oldHead && head != cache[oldHead][2]) { //if new head is not the end of the previous link
                cache[cache[head][2]][3] = cache[head][3];
                cache[cache[head][3]][2] = cache[head][2];

                cache[head][2] = cache[oldHead][2];
                cache[head][3] = oldHead;

                cache[cache[oldHead][2]][3] = head;
                cache[oldHead][2] = head;
            }
            return cache[head][1];
        }
        return -1;
    }

    public void put(int key, int value) {
        if(get(key) != -1){
            cache[head][1] = value;
        } else{
            if(amount < cache.length){
                int oldHead = head;
                head = amount;
                amount++;

                cache[head][0] = key;
                cache[head][1] = value;

                cache[head][2] = cache[oldHead][2];
                cache[head][3] = oldHead;
                cache[oldHead][2] = head;
                cache[cache[head][2]][3] = head;

                keyToAddr.put(key, head);
            }else{
                head = cache[head][2];

                keyToAddr.remove(cache[head][0]);
                cache[head][0] = key;
                cache[head][1] = value;
                keyToAddr.put(key, head);
            }
        }
    }
}