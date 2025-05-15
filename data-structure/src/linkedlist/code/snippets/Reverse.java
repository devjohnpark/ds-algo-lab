package linkedlist.code.snippets;

public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            // 1. 다음 노드를 이전 노드로 연결
            // 2. 이전 노드 저장
            // 3. 다음 노드 이동
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        return reverseRecursive(null, head);
    }

    private ListNode reverseRecursive(ListNode prev, ListNode cur) {
        if (cur == null) { // 종료 조건: 마지막 노드에 도달
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;
        return reverseRecursive(cur, next);
    }
}
