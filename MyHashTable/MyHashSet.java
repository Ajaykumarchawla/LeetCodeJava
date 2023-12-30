package MyHashTable;
// Design a HashSet without using any built-in hash table libraries.

// Implement MyHashSet class:

// void add(key) Inserts the value key into the HashSet.
// bool contains(key) Returns whether the value key exists in the HashSet or not.
// void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

// Example 1:

// Input
// ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
// [[], [1], [2], [1], [3], [2], [2], [2], [2]]
// Output
// [null, null, null, true, false, null, true, null, false]

// Explanation
// MyHashSet myHashSet = new MyHashSet();
// myHashSet.add(1);      // set = [1]
// myHashSet.add(2);      // set = [1, 2]
// myHashSet.contains(1); // return True
// myHashSet.contains(3); // return False, (not found)
// myHashSet.add(2);      // set = [1, 2]
// myHashSet.contains(2); // return True
// myHashSet.remove(2);   // set = [1]
// myHashSet.contains(2); // return False, (already removed)

// Constraints:

// 0 <= key <= 106
// At most 104 calls will be made to add, remove, and contains.
import java.util.ArrayList;
import java.util.List;

public class MyHashSet {

    @SuppressWarnings("unchecked")
    List<Integer>[] hash = new ArrayList[1000];

    public MyHashSet() {

    }

    public void add(int key) {
        int newKey = key % 1000;
        if (hash[newKey] == null) {
            hash[newKey] = new ArrayList<Integer>();
        }
        if (!hash[newKey].contains(key))
            hash[newKey].add(key);
        return;
    }

    public void remove(int key) {
        int newKey = key % 1000;

        if (hash[newKey] == null)
            return;
        hash[newKey].remove((Integer) key);
    }

    public boolean contains(int key) {
        int newKey = key % 1000;
        if (hash[newKey] == null)
            return false;
        if (hash[newKey].contains(key))
            return true;
        else
            return false;
    }
}
