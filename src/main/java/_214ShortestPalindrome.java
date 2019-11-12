import com.sun.deploy.util.StringUtils;

public class _214ShortestPalindrome {
    public static void main(String[] args){
        _214ShortestPalindrome test = new _214ShortestPalindrome();
        System.out.println(test.shortestPalindrome("abcd"));
    }
    public String shortestPalindrome(String s) {
        /**
         * 使用KMP算法，找到String s在翻转后的字符串reverse中匹配的位置（不用全部匹配，只需要一直匹配到翻转字符串结束就可以）。
         * 匹配的位置即回文的枢轴。eg. s: 32101234 -> reverse: 43210123 -> pos: 1
         * 因为题目限定了只能在s之前添加字符，所以要在reverse中s的匹配位置，匹配位置之前的字符，即需要添加的字符
         * 这种限定条件下,只有枢轴在前半段才有意义，不然就无法构成回文。 eg. s: 43210123，如果枢轴是0，则无法在s之前添加字符构成回文，所以枢轴只能是4
         *
         * 反之，如果是限定在s之后添加字符，则枢轴需要在后半段，然后在s中找reverse匹配的位置： eg. s: 43210123 -> reverse: 32101234 -> pos: 1
         */
        String reverse = reverse(s);
        int result = strStr(reverse, s);
        StringBuffer stringBuffer = new StringBuffer();

        return stringBuffer.append(reverse.substring(0, result)).append(s).toString();
    }
    public int strStr(String haystack, String needle) {
        /**
         * KMP算法改-needle不要求匹配完，只要haystack匹配完就可以
         * 统计重复模式，这样当匹配失败时，可以平移到最近最有可能重新匹配的位置再次检查，而不用从头开始重新匹配。
         *  eg.pattern[5] = 2; 说明needle[0] = needle[3], needle[1]=needle[4].这样即使在needle[5]的位置匹配失败，needle[3]和needle[4]也依然匹配成功了，
         *  这样需要检查的位置只需要从5退回2，而不是退回0重新开始。
         */
        int[] pattern = new int[needle.length()];
        char[] needleChar = needle.toCharArray();

        //计算pattern[]的方法就是从第三个元素开始，检查前一个元素是否和它的pattern中的值匹配
        for(int i = 0; i < needle.length(); i++){
            if(i == 0){
                pattern[i] = -1;//-1表示在当前位置没有匹配，必须移动到下一位置
            }else if(i == 1){
                pattern[i] = 0;
            }else {
                if(needleChar[i - 1] == needleChar[pattern[i-1]]){//前一个字符匹配它pattern中指向的位置，递增pattern的值
                    pattern[i] = pattern[i-1] + 1;
                }else{
                    //前一个字符不！匹配它在pattern中指向的位置，继续尝试找到最大重复模式
                    pattern[i] = pattern[i-1];
                    while(pattern[i] > 0){//逐次递减，直到找到匹配位置：第i个元素的前k个元素，和模式的前k个元素匹配，令pattern[i] = k+1
                        boolean isOK = true;
                        for(int j = 0; j < pattern[i]; j++){
                            if(needleChar[j] != needleChar[i - pattern[i] + j]){
                                isOK = false;
                                break;
                            }
                        }
                        if(isOK){
                            break;
                        }else{
                            pattern[i] = pattern[i] - 1;
                        }
                    }
                }
            }
        }
        char[] hayChar = haystack.toCharArray();
        int hIndex = 0;
        int nIndex = 0;
        while(hIndex < hayChar.length && nIndex < needleChar.length){
            if(hayChar[hIndex] == needleChar[nIndex]){//匹配
                hIndex++;
                nIndex++;
            }else{
                if(pattern[nIndex] == -1){//当前位置不匹配，必须移动到下一个位置重新开始
                    hIndex++;
                }else{
                    nIndex = pattern[nIndex];//hIndex停留在原地，下一次循环检查是否和pattern[nIndex]所指向的元素相匹配。
                }
            }
        }
        return hIndex - nIndex;
    }

    private String reverse(String s){
        StringBuffer stringBuffer = new StringBuffer();
        for(char c: s.toCharArray()){
            stringBuffer.insert(0, c);
        }
        return stringBuffer.toString();
    }
}
