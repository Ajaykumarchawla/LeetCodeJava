package Extra;

// 1290. Convert Binary Number in a Linked List to Integer
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

// Return the decimal value of the number in the linked list.

// The most significant bit is at the head of the linked list.

// Example 1:

// Input: head = [1,0,1]
// Output: 5
// Explanation: (101) in base 2 = (5) in base 10
// Example 2:

// Input: head = [0]
// Output: 0

// Constraints:

// The Linked List is not empty.
// Number of nodes will not exceed 30.
// Each node's value is either 0 or 1.

public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {
        int i = 0;
        while (head != null) {
            i = i << 1;
            i = i | head.val;
            head = head.next;
        }
        return i;
    }
}

// Test cases:
// [1,0,1]
// [0]
// [1,0,1,0]
// [1,0,1,1,1]
// [1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,1,1,1,0,0,0,1,1,1]