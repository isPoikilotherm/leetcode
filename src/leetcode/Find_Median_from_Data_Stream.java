package leetcode;


import java.util.PriorityQueue;

public class Find_Median_from_Data_Stream {
    private PriorityQueue<Double> lq;
    private PriorityQueue<Double> rq;
    private int count;


    public Find_Median_from_Data_Stream() {
        lq=new PriorityQueue<Double>((a,b)-> (int) (b-a));
        rq=new PriorityQueue<Double>();
        count=0;

    }
    public void addNum(int num) {
        double num1=(double) num;
        if (count==0){
            lq.add(num1);
            count++;
        }else {
            if (rq.size()==0){
               if (num< lq.peek()){
                   double i=lq.poll();
                   rq.add(i);
                   lq.add(num1);
               }else {
                   rq.add(num1);
               }
                count++;
            }else {
                if (lq.size()>rq.size()){
                    if (num<lq.peek()){
                        double i=lq.poll();
                        lq.add(num1);
                        rq.add(i);
                    }else {
                        rq.add(num1);
                    }
                }else {
                    if (num>rq.peek()){
                        double i=rq.poll();
                        rq.add(num1);
                        lq.add(i);
                    }else {
                        lq.add(num1);
                    }
                }
                count++;
            }
        }
    }

    public double findMedian() {
        if (count==0){
            return 0;
        }
        if (count%2==0){
            return (lq.peek()+ rq.peek())/2;
        }else {
            return lq.peek();
        }

    }
}
