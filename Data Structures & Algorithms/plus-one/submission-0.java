class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i]!=9){
                flag=false;
                break;
            }
        }
        int size = digits.length;
        if(flag) size++;
        int carry = 0;
        int[] ans = new int[size];
        ans[ans.length-1]= digits[digits.length-1] == 9 ? 0 : digits[digits.length-1] +1;
        if(digits[digits.length-1]==9){
            carry=1;
        }
        for(int i=digits.length-2; i>=0; i--){
            int sum = digits[i] + carry;
            if(sum>9){
                ans[i]=0;
            }else{
                ans[i]=sum;
                carry=0;
            }
        }
        if(carry==1){
            ans[0]=carry;
        }
        return ans;
    }
}