package LinkedList;
// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:

// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:

// Input: head = [0,1,2], k = 4
// Output: [2,0,1]

// Constraints:

// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode headTemp = head, temp = head, previous = null;
        if (head == null) {
            return head;
        }
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }
        k = k % i;
        if (k == 0) {
            return headTemp;
        }
        i = 0;
        head = headTemp;
        while (i < k) {
            head = head.next;
            i++;
        }
        while (head != null) {
            head = head.next;
            previous = temp;
            temp = temp.next;
        }
        ListNode tempTemp = temp;
        while (tempTemp.next != null) {
            tempTemp = tempTemp.next;
        }
        tempTemp.next = headTemp;
        previous.next = null;
        return temp;

    }
}
