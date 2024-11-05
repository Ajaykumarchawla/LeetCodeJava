package Extra;

import java.util.HashMap;

class Node {
    int value, key;
    Node next = null, prev = null;

    public Node(int value, int key, Node next, Node prev) {
        this.value = value;
        this.key = key;
        this.next = next;
        this.prev = prev;
    }
}

class LRUCache {
    int capacity;
    Node head = null, tail = null;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        // System.out.println("getting value for :" +key);
        if (this.map.containsKey(key)) {
            Node n = map.get(key);
            removeNode(n);
            n = addNode(n.value, n.key);
            map.put(key, n);

            // printMap();
            return n.value;
        } else {
            // System.out.println("no value found for" +key);
            return -1;
        }
    }

    private Node addNode(int value, int key) {
        if (head == null) {
            this.head = new Node(value, key, null, null);
            this.tail = this.head;
            return this.head;
        } else {
            Node newNode = new Node(value, key, this.head, null);
            this.head.prev = newNode;
            this.head = newNode;
            return this.head;
        }
    }

    private void removeNode(Node n) {
        map.remove(n.key);
        if (n == tail) {
            if (head == tail) {
                head = null;
                tail = null;
                return;
            } else {
                tail = tail.prev;
                tail.next = null;
                return;
            }
        } else if (n == head) {
            this.head = head.next;
            head.prev = null;
            return;

        } else {
            // System.out.print("printing key: "+n.key+" value: "+n.value);
            // if(n.prev != null)
            n.prev.next = n.next;
            // if(n.next != null)
            n.next.prev = n.prev;
            return;
        }
    }

    private void printMap() {
        System.out.println("printing Map: ");
        System.out.println("head at key: " + head.key + " value: " + head.value);
        System.out.println("tail at key: " + tail.key + " value: " + tail.value);

        for (int k : map.keySet()) {
            System.out.println(k + " " + map.get(k).value);
        }
        System.out.println(" ");
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            // remove that node
            removeNode(map.get(key));

            // add new Node at the start
            Node n = addNode(value, key);
            map.put(key, n);

            // System.out.println("key already there");
        } else {
            // check if we have capacity;
            if (this.capacity != 0) {
                // add node directly
                Node n = addNode(value, key);
                map.put(key, n);
                capacity--;
            } else {

                // remove the last node
                // remove this from map;
                removeNode(tail);

                // add this node in the start
                // add this into the map
                Node n = addNode(value, key);
                map.put(key, n);
            }
        }
        // printMap();
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */