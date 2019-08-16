class Solution3 {
    public ListNode removeElements(ListNode head, int val, int depth) {
//       进入函数的时候打印一次
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove  " + val + " in " + head);

        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }
        //在缩小的链表中删除指定元素之后把链表返回给res
        ListNode res = removeElements(head.next,val,depth+1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " +res);

        ListNode ret;
//        判断头结点的值是否是特定的元素，如果不是则返回头结点，如果是则返回头结点的下一个结点
        if(head.val == val){
            ret = res;
        }else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);

        return ret;
    }

    public String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3().removeElements(head,6,0));
        System.out.println(res);
    }
}
