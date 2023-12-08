package LinkedList;
// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

// Example 1:

// Input: head = [1,2,2,1]
// Output: true
// Example 2:

// Input: head = [1,2]
// Output: false

// Constraints:

// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9

// Follow up: Could you do it in O(n) time and O(1) space?

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode tempHead = head, secondHead = head;

        while (secondHead != null && secondHead.next != null) {
            head = head.next;
            secondHead = secondHead.next.next;
        }
        head = reverseList(head);
        while (head != null) {
            System.out.println(tempHead.val + " " + head.val);
            if (tempHead.val != head.val) {
                return false;
            }
            tempHead = tempHead.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode previous = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }
}
