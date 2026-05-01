class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String s: strs){
            str.append(s.length()).append("#").append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
       
       for(int i=0;i<str.length();){
        Integer temp = getInteger(str.substring(i));
        i=i+temp.toString().length()+1;
        list.add(str.substring(i, i+temp));
        i=i+temp;
       }
       return list;
    }
    private int getInteger(String str){
         int i=0;
        String size="";
        for(i=0;i<str.length();i++){
            if(str.charAt(i) == '#'){
                break;
            }
            size = size+str.charAt(i);
        }
        try{
            return Integer.parseInt(size);
        }catch(NumberFormatException e){

        }
        return 0;
    }
}
