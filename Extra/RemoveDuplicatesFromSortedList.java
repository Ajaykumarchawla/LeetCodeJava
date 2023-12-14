package Extra;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        int value = head.val;
        ListNode tempHead = head;
        while (head.next != null) {
            if (head.next.val == value) {
                head.next = head.next.next;
            } else {
                value = head.next.val;
                head = head.next;
            }
        }
        return tempHead;

    }
}
