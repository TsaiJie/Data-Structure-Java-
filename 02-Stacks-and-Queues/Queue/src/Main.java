import java.util.Random;

public class Main {
//  测试使用q运行opCount 个enqueue和dequeue操作所需要的时间：单位：秒
    private static double testQueue(Queue<Integer>q, int opCount){
//        获取当前时间
        long startTime = System.nanoTime();
//进队
        Random random = new Random();
        for (int i = 0; i < opCount ; i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
//出队
        for (int i = 0; i < opCount ; i++){
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue, time: " + time1 + "s");


        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue, time: " + time2 + "s");

    }
}
