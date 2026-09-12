class Solution {
    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            int d = x%10;
            if( (ans > Integer.MAX_VALUE/10) || (ans > (Integer.MAX_VALUE/10 + d)) ){
                return 0;
            }
            if( (ans < Integer.MIN_VALUE/10) || (ans < (Integer.MIN_VALUE/10 + d)) ){
                return 0;
            }
            ans=ans*10;
            ans=ans+d;
            x=x/10;
        }
        return ans;
    }
}