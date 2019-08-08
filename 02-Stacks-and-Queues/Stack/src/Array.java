//<E>使用泛型
public class Array<E> {
    private E[] data;
    //数组实际大小
    private int size;

    //构造函数，传入数组的容量capacity构造Array
    public  Array(int capacity){
//        data = new int[capacity];
        data = (E[])new Object[capacity];//转换为泛型数组     Object[]类型的数组=>为E[]类型的数组
        size = 0;
    }

    //无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    //获取数组的元素个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向所有元素后添加一个新元素
    public void addLast(E e){
//       判断数组是否满了
//        if (size == data.length){
//            throw new IllegalArgumentException("Addlast failed. Array is full.");
//        }
//        data[size] = e;
//        size++;
        add(size,e);
    }

    //向所有元素前添加一个新元素
    public void addFirst(E e){
        add(0,e);
    }

    //在第index位置插入一个新元素e
    public void add(int index, E e){
        if (size == data.length){
           resize(2 * data.length);
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Addlast failed. Require index < 0 || index > size.");
        }
        for (int i = size - 1; i>=index; i--){
//            元素后挪
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

// 获取index索引位置的元素
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }
//    获取最后一个元素
    public E getLast(){
        return get(size - 1);
    }
//    获取第一个元素
    public  E getFirst(){
        return get(0);
    }

//    修改index索引位置的元素为e
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

//   查找数组中是否有元素e
    public boolean contains(E e){
        for (int i = 0 ; i < size ; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

//   查找数组中是否有元素e,如果存在e返回其索引，不存在返回-1
    public int find(E e){
        for (int i = 0 ; i < size ; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

//    从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret = data[index];
        for(int i = index + 1; i < size; i ++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;//写不写都可以，释放内存
//        当数组减小到一定程度的时候，把数组的空间减少，这种方式在一定情况下（比如不停地在边界处增删）会导致不停地缩放数组进而导致复杂度震荡
//        此问题出现的原因是我们伸缩的太过于着急了(eager)，我们应该采用个更加Lazy的方式伸缩数组，当size==capacity/4时，才将capacity减半
//        if(size == data.length / 2 ){
//            resize(data.length/2);
//        }
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length/2);
        }
        return ret;
    }

//  从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

//  从数组中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

//    从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if (i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

}
