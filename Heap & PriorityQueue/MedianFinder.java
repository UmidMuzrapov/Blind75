class MedianFinder {

    PriorityQueue<Integer> sq; 
    PriorityQueue<Integer> lq; 
    int n = Integer.MAX_VALUE;
    int count =0;

    public MedianFinder() {
        sq = new PriorityQueue<Integer>(new ReverseInt());
        lq = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (n>num){
            sq.add(num);
        } else{
            lq.add(num);
        }
        
        if (sq.size() - lq.size()>1){
            n = sq.remove();
            lq.add(n);
        } else if (lq.size() - sq.size()>1){
            n = lq.remove();
            sq.add(n);
        }

        count++;
    }
    
    public double findMedian() {
        if (count%2==0){
            return ((sq.peek() +lq.peek())/2.0);
        } else{
            if (sq.size() >lq.size()){
                return sq.peek();
            } else{
                return lq.peek();
            }
        }
    }
}

class ReverseInt implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return - Integer.compare(o1, o2);
	}	
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
