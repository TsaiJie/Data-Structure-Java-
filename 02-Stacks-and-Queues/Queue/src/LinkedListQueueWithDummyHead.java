public class LinkedListQueueWithDummyHead<E> implements Queue<E>{
//    定义节点类
    private class Node{
       public E e;
       public Node next;

       public Node(E e,Node next){
            this.e = e;
            this.next = next;
       }

       public Node(E e){
           this(e,null);
       }

       public Node(){
           this(null,null);
       }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead,tail;
    private int size;

    public LinkedListQueueWithDummyHead(){
        dummyHead = new Node();
        tail = dummyHead;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("LinkedListQueue is empty");
        }
        return dummyHead.next.e;
    }

    @Override
    public void enqueue(E e) {
//        在当前尾部插入元素
        tail.next = new Node(e);
//       尾指针向后挪一位
        tail = tail.next;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        Node retNode = dummyHead.next;
        dummyHead.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: font ");
        Node cur = dummyHead.next;

        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append(" NUll tail");
        return res.toString();
    }

    public static void main(String[] args) {
        // write your code here
        LinkedListQueueWithDummyHead<Integer> queue = new LinkedListQueueWithDummyHead<>();

        for (int i = 0; i < 10; i++){
            queue.enqueue(i);
            System.out.println(queue);
            System.out.println("size: "+queue.getSize());

            if (i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
                System.out.println("size: "+queue.getSize());
            }
        }

        System.out.println(queue.getFront());
        System.out.println(queue.getSize());

    }
}
