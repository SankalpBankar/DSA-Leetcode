class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;

        ListNode prev = start;
        ListNode current = head;

        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                int dup = current.val;

                while (current != null && current.val == dup) {
                    current = current.next;
                }
                prev.next = current;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return start.next;
    }
}