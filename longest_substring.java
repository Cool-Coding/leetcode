public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();//字符串长度
        int start;//相应长度对应的起始标志
        int end;//相应长度对应的结束标志
        int index;//长度内字符指针
        boolean replicated=false;

        //字符集合
        Set<Character> charSet=new HashSet<Character>();
        for(int i=len;i>0;i--){
            start=0;//取每一个长度时，都从0位置开始
            while(true){
                end = start + i;//结束标志
                if(end > len){
                    break;
                }

                index = start;
                charSet.clear();
                replicated=false;
                while(index < end ){
                    char c=s.charAt(index);
                    if(charSet.contains(c)){
                        replicated=true;
                        break;
                    }else{
                        charSet.add(c);
                    }
                    index++;
                }
                //集合中所有字符不相同，则说明长到了
                if(!replicated){
                    return i;
                }

                start++;//起始标志加1
            }
        }
        return 0;
    }
}
