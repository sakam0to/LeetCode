import java.util.*;

public class _380InsertDeleteGetRandomO1 {
    public static void main(String[] args){
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();
        boolean result1 = randomSet.insert(0);

        // Returns false as 2 does not exist in the set.
        boolean result2 = randomSet.insert(1);

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        boolean result3 = randomSet.insert(2);

        // getRandom should return either 1 or 2 randomly.
        boolean result4 = randomSet.insert(3);


        // getRandom should return either 1 or 2 randomly.
       // boolean result9 = randomSet.insert(4);

        // Removes 1 from the set, returns true. Set now contains [2].
        boolean result5 = randomSet.remove(0);

        // 2 was already in the set, so return false.
        boolean result6 = randomSet.remove(1);

        // Since 2 is the only number in the set, getRandom always return 2.
        boolean result7 = randomSet.remove(2);

        // Since 2 is the only number in the set, getRandom always return 2.
        boolean result8 = randomSet.remove(3);
        // Since 2 is the only number in the set, getRandom always return 2.
        boolean result10 = randomSet.remove(4);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
       // System.out.println(result9);
        System.out.println(result10);
    }
}

class RandomizedSet {
    Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    int[] array = new int[3];
    int capacity = 0;

    Random random = new Random(System.currentTimeMillis());

    /** Initialize your data structure here. */
    public RandomizedSet() {


    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            if(array.length == capacity){
                int[] temp = new int[10 * capacity];
                for(int i = 0; i < capacity; i++){
                    temp[i] = array[i];
                }
                array = temp;
            }

            array[capacity] = val;
            map.put(val, capacity);
            capacity++;
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    /**
     * change the content of the deleted element to the last element then remove the last element of array,
     */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{
            int index = map.get(val);
            array[index] = array[--capacity];
            map.put(array[capacity], index);
            map.remove(val);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(capacity == 0){
            return 0;
        }
        return array[random.nextInt(capacity)];
    }
}
