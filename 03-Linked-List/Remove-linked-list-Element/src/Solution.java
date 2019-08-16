
class Solution {
    public ListNode removeElements(ListNode head, int val) {
//        如果头结点是需要删除的元素
        while(head !=null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
//            head = head.next;
        }

        if(head == null){
            return null;
        }

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }

        }

        return head;
    }
}