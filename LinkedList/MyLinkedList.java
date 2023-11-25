package LinkedList;
// Design your implementation of the linked list. You can choose to use a singly or doubly linked list.

// A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
// If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

// Implement the MyLinkedList class:

// MyLinkedList() Initializes the MyLinkedList object.
// int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
// void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
// void addAtTail(int val) Append a node of value val as the last element of the linked list.
// void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
// void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

// Example 1:

// Input
// ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
// [[], [1], [3], [1, 2], [1], [1], [1]]
// Output
// [null, null, null, null, 2, null, 3]

// Explanation
// MyLinkedList myLinkedList = new MyLinkedList();
// myLinkedList.addAtHead(1);
// myLinkedList.addAtTail(3);
// myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
// myLinkedList.get(1);              // return 2
// myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
// myLinkedList.get(1);              // return 3

// Constraints:

// 0 <= index, val <= 1000
// Please do not use the built-in LinkedList library.
// At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.

class SinglyListNode {
    int val;
    SinglyListNode next;

    SinglyListNode(int x) {
        val = x;
    }
}

public class MyLinkedList {
    SinglyListNode head, tail;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        int i = 0;
        SinglyListNode indexedNode = head;

        while (indexedNode.next != null && i != index) {

            indexedNode = indexedNode.next;
            i++;
        }
        if (i == index) {
            // System.out.println(indexedNode.val);
            return indexedNode.val;
        } else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new SinglyListNode(val);
        } else {
            SinglyListNode newNode = new SinglyListNode(val);
            newNode.next = head;
            head = newNode;
        }
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new SinglyListNode(val);
        } else {
            SinglyListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new SinglyListNode(val);
        }
    }

    public void addAtIndex(int index, int val) {

        if (index == 0) {
            SinglyListNode newNode = new SinglyListNode(val);
            newNode.next = head;
            head = newNode;
            return;
        }
        if (head == null) {
            return;
        }
        index--;
        SinglyListNode indexedNode = head;
        while (index > 0 && indexedNode.next != null) {
            System.out.print(indexedNode.val);
            indexedNode = indexedNode.next;
            index--;
        }
        if (index == 0) {
            if (indexedNode.next == null) {
                indexedNode.next = new SinglyListNode(val);
            } else {
                SinglyListNode newNode = new SinglyListNode(val);
                newNode.next = indexedNode.next;
                indexedNode.next = newNode;
            }
        } else {
            return;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        index--;
        SinglyListNode indexedNode = head;
        while (index > 0 && indexedNode.next != null) {
            System.out.print(indexedNode.val);
            indexedNode = indexedNode.next;
            index--;
        }
        if (index == 0) {
            if (indexedNode.next == null) {
                return;
            } else {
                // SinglyListNode newNode = new SinglyListNode(val);
                indexedNode.next = indexedNode.next.next;
                // indexedNode.next = newNode;
            }
        } else {
            return;
        }

    }

    // public void printList() {
    // SinglyListNode first = head;
    // System.err.println();
    // while (first != null) {
    // System.out.print(first.val + " ");
    // first = first.next;
    // }
    // }
}
