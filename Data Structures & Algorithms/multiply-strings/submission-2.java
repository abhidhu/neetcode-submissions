class Solution {
    public String multiply(String num1, String num2) {
        int len = num1.length() + num2.length();
        int[] arr = new int[len];
        
        for(int i=num1.length()-1; i>=0; i--){
            int n1 = Character.getNumericValue(num1.charAt(i));
            for(int j=num2.length()-1; j>=0; j--){
                int n2 = Character.getNumericValue(num2.charAt(j));
                int p = n1*n2;
                int k=i+j+1;
                do{
                    p=p+arr[k];
                    arr[k]= p %10;
                    p=p/10;
                    k--;
                }while(p>0);
            }
        }
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while(i<len && arr[i]==0 ){
            i++;
        }
        if(i==len) return "0";
        while(i<len){
            sb.append(arr[i++]);
        }
        return sb.toString();
    }
}