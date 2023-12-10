package LinkedList;
// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

// Example 1:

// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: list1 = [], list2 = []
// Output: []
// Example 3:

// Input: list1 = [], list2 = [0]
// Output: [0]

// Constraints:

// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both list1 and list2 are sorted in non-decreasing order.
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listhead = null, head2 = null;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            head2 = list2;
            listhead = list2;
            list2 = list2.next;

        } else {
            head2 = list1;
            listhead = list1;
            list1 = list1.next;
        }

        while (list2 != null && list1 != null) {
            if (list1.val > list2.val) {
                listhead.next = list2;
                list2 = list2.next;

            } else {
                listhead.next = list1;
                list1 = list1.next;
            }
            listhead = listhead.next;
        }
        if (list1 == null) {
            listhead.next = list2;
        } else {
            listhead.next = list1;
        }
        return head2;
    }
}
