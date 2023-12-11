package LinkedList;
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
// Example 2:

// Input: l1 = [0], l2 = [0]
// Output: [0]
// Example 3:

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]

// Constraints:

// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOut = 0;
        int sum = l1.val + l2.val;
        if (sum > 9) {
            carryOut = 1;
            sum = sum % 10;
        }
        l1 = l1.next;
        l2 = l2.next;
        ListNode newList = new ListNode(sum);
        ListNode returnList = newList;
        while (l1 != null && l2 != null) {

            sum = l1.val + l2.val + carryOut;
            carryOut = 0;
            if (sum > 9) {
                carryOut = 1;
                sum = sum % 10;
            }
            System.out.println(sum);
            newList.next = new ListNode(sum);
            newList = newList.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carryOut;
            carryOut = 0;
            if (sum > 9) {
                carryOut = 1;
                sum = sum % 10;
            }
            newList.next = new ListNode(sum);
            newList = newList.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + carryOut;
            carryOut = 0;
            if (sum > 9) {
                carryOut = 1;
                sum = sum % 10;
            }
            newList.next = new ListNode(sum);
            newList = newList.next;
            l2 = l2.next;
        }
        if (carryOut == 1) {
            newList.next = new ListNode(carryOut);
        }
        return returnList;
    }
}
