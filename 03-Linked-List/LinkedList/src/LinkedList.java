public class LinkedList<E>{

    private class Node{
        public E e;
        public Node next;
//      两个参数的构造函数
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
//      一个参数的构造函数
        public Node(E e){
            this(e,null);
        }
//      没有参数的构造函数
        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
//虚拟头结点
    private  Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

//    获取链表中的元素个数
    public int getSize(){
        return size;
    }

//    返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }


//    在链表的index位置添加新的元素e,索引在链表中不是一个常用的操作，练习用
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for(int i = 0; i < index ; i++){
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;

    }
    //    在链表头添加新的元素e
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = dummyHead.next;
//        dummyHead.next = node;
//        size++;

        add(0,e);
    }

//    在链表的末尾添加新的元素
    public void addLast(E e){
        add(size,e);
    }

//  获得链表的第index个位置的元素   索引在链表中不是一个常用的操作，练习用
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.e;
    }
//    获取第一个元素
    public E getFirst(){
        return get(0);
    }

//    获取链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

//    修改链表的第index个位置的元素   索引在链表中不是一个常用的操作，练习用
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }
    //    删除链表的第index个位置的元素   索引在链表中不是一个常用的操作，练习用
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }
//    从链表中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }
 //    从链表中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }
//    查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
