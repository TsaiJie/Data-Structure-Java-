public class ArrayStack<E> implements Stack<E>{

    Array<E> array;
//    构造函数有参数
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }
//    构造函数无参数
    public ArrayStack(){
        array = new Array<>();
    }
// 得到栈的实际大小
    @Override
    public int getSize(){
        return array.getSize();
    }
// 查看栈是否为空
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }
// 查看栈的容量
    public int getCapacity(){
        return array.getCapacity();
    }
// 入栈
    @Override
    public void push(E e){
        array.addLast(e);
    }
// 出栈
    @Override
    public E pop(){
        return array.removeLast();
    }

//    看一看栈顶元素
    @Override
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for(int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
