class MedianFinder {

    PriorityQueue<Integer> firstHalf = new PriorityQueue<>((a,b)-> b-a);//default also a max heap but decalred for clarity
    PriorityQueue<Integer> secHalf  = new PriorityQueue<>((a, b)-> a-b);//min heap

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        Integer first = firstHalf.peek();
        Integer secound = secHalf.peek();
        if(first == null && secound == null){
            firstHalf.offer(num);
            return;
        }
        if(first < num){
            secHalf.offer(num);
        }else{
            firstHalf.offer(num);
        }
        if(firstHalf.size()==secHalf.size())  return;
        if(firstHalf.size()==secHalf.size() + 1) return;
        if(firstHalf.size()<secHalf.size()){
            int temp = secHalf.poll();
            firstHalf.offer(temp);
        }else{
            int temp=firstHalf.poll();
            secHalf.offer(temp);
        }
    }
    
    public double findMedian() {
        if(firstHalf.size()==secHalf.size()){
            return (double)(firstHalf.peek()+secHalf.peek())/2;
        }
        return firstHalf.peek() == null? 0.0 : firstHalf.peek();
    }
}
