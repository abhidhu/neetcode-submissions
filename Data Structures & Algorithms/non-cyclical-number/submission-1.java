class Solution {
    public boolean isHappy(int n) {
        Set<Long> set = new HashSet<>();
        long l1 = (long) n;
        long l2 = l1;

       do{
        l1 = helper(helper(l1));
        if(l1==1){
            return true;
        }
        l2=helper(l2);
       }while(l1 != l2);
        return false;
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