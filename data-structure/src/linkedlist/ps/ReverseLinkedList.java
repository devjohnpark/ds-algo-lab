package linkedlist.ps;

public class ReverseLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 다음 노드의 링크를 이전 노드로 변경
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }


    public static void main(String[] args) {

    }
}
