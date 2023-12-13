package LinkedList;
// A linked list of length n is given such that each SpecialNode contains an additional random pointer, which could point to any SpecialNode in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new SpecialNodes, where each new SpecialNode has its value set to the value of its corresponding original SpecialNode. Both the next and random pointer of the new SpecialNodes should point to new SpecialNodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to SpecialNodes in the original list.

// For example, if there are two SpecialNodes X and Y in the original list, where X.random --> Y, then for the corresponding two SpecialNodes x and y in the copied list, x.random --> y.

// Return the head of the copied linked list.

// The linked list is represented in the input/output as a list of n SpecialNodes. Each SpecialNode is represented as a pair of [val, random_index] where:

// val: an integer representing SpecialNode.val
// random_index: the index of the SpecialNode (range from 0 to n-1) that the random pointer points to, or null if it does not point to any SpecialNode.
// Your code will only be given the head of the original linked list.

// Example 1:

// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Example 2:

// Input: head = [[1,1],[2,1]]
// Output: [[1,1],[2,1]]
// Example 3:

// Input: head = [[3,null],[3,0],[3,null]]
// Output: [[3,null],[3,0],[3,null]]

// Constraints:

// 0 <= n <= 1000
// -104 <= SpecialNode.val <= 104
// SpecialNode.random is null or is pointing to some SpecialNode in the linked list.
class SpecialNode {
    int val;
    SpecialNode next;
    SpecialNode random;

    public SpecialNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public SpecialNode copyRandomList(SpecialNode head) {
        if (head == null) {
            return head;
        }
        SpecialNode newList = new SpecialNode(head.val), tempNewList = newList, tempHead = head;
        head = head.next;
        while (head != null) {
            newList.next = new SpecialNode(head.val);
            newList = newList.next;
            head = head.next;
        }
        head = tempHead;
        newList = tempNewList;

        while (head != null) {
            if (head.random != null) {
                newList.random = setRandom(tempHead, head.random, tempNewList);
            }
            head = head.next;
            newList = newList.next;
        }
        return tempNewList;
    }

    public SpecialNode setRandom(SpecialNode head, SpecialNode targetNode, SpecialNode newTarget) {
        while (head != null) {
            if (head == targetNode) {
                return newTarget;
            }
            head = head.next;
            newTarget = newTarget.next;
        }
        return null;
    }
}
