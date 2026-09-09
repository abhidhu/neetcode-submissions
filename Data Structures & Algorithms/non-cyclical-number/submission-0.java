class Solution {
    public boolean isHappy(int n) {
        Set<Long> set = new HashSet<>();
        long l = (long) n;
        while(l >1){
            if(set.contains(l)){
                return false;
            }
            set.add(l);
            l=helper(l);
        }
        return true;
    }

    private long helper(long n){
        long  sum =0;
        while(n>0){
            long d = n%10;
            n=n/10;
            sum=sum + (d*d);
        }
        return sum;
    }
}