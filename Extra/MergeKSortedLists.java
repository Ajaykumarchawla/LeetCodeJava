package Extra;

public class MergeKSortedLists {
    public void printList(ListNode l1) {
        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
        System.out.println();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode lastTemp = l1;
        if (l1.val > l2.val) {
            lastTemp = l2;
            l2 = l2.next;
        } else {
            l1 = l1.next;
        }
        ListNode temp = lastTemp;
        while (l1 != null && l2 != null) {
            // System.out.println(" ");
            // printList(lastTemp);
            // printList(l1);
            // printList(l2);
            if (l1.val <= l2.val) {
                ListNode tempTemp = l1;
                l1 = l1.next;
                temp.next = tempTemp;
                temp = temp.next;
            } else {
                ListNode tempTemp = l2;
                l2 = l2.next;
                temp.next = tempTemp;
                temp = temp.next;
            }
        }
        if (l1 == null) {
            temp.next = l2;
        }
        if (l2 == null) {
            temp.next = l1;
        }
        return lastTemp;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode l1 = lists[0];
        for (int i = 1; i < lists.length; i++) {
            // printList(l1);
            l1 = mergeTwoLists(l1, lists[i]);
        }
        return l1;
    }
}
