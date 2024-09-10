
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

class SwapPairs {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode finalHead = null; // it will be the 2nd element
        if (head.next != null) {
            finalHead = head.next;
        }

        ListNode curr = head;
        ListNode prev = new ListNode(-1);
        while (curr != null && curr.next != null) {
            ListNode nextNode = curr.next; // store 2nd
            prev.next = nextNode;
            prev = curr;
            curr.next = nextNode.next; // connect 1st with 3rd
            nextNode.next = curr; // make it 1st
            curr = curr.next;
        }

        return finalHead;
    }
}