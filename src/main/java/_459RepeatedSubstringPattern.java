public class _459RepeatedSubstringPattern {
    public static void main(String[] args){
        _459RepeatedSubstringPattern test = new _459RepeatedSubstringPattern();
        System.out.println(test.repeatedSubstringPattern("ababababababab"));
    }
    public boolean repeatedSubstringPattern(String s) {
        //利用KMP算法，获取模式的oattern数组
        int[] pattern = KMP(s);
        int num = pattern[pattern.length - 1] + 1;
        if(s.length() <= 1){
            return false;
        }else if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)){
                return true;
            }else{
                return false;
            }
        }else{
            /**
             * 判据1:检查最后一个元素和pattern的位置是否匹配
             */
            if(s.charAt(pattern[s.length() - 1]) != s.charAt(s.length() - 1)){
                return false;
            }

            /**
             * 判据2：重复模式为从第一个元素到第n-pattern[last_num]个元素，检查总长是否能整除模式的长度。
             * eg. ab ab ab ab ab -> [-1 0 0 1 2 3 4 5 6 7] 重复模式ab，长度：2，
             */

            int pattern_length = pattern.length - pattern[pattern.length - 1] - 1;
            if(pattern.length%pattern_length != 0){
                return false;
            }
            return true;
        }
    }

    public int[] KMP(String s){
        int[] pattern = new int[s.length()];
        char[] sChar = s.toCharArray();

        //计算pattern[]的方法就是从第三个元素开始，检查前一个元素是否和它的pattern中的值匹配
        for(int i = 0; i < s.length(); i++){
            if(i == 0){
                pattern[i] = -1;//-1表示在当前位置没有匹配，必须移动到下一位置
            }else if(i == 1){
                pattern[i] = 0;
            }else {
                if(sChar[i - 1] == sChar[pattern[i-1]]){//前一个字符匹配它pattern中指向的位置，递增pattern的值
                    pattern[i] = pattern[i-1] + 1;
                }else{
                    //前一个字符不！匹配它在pattern中指向的位置，继续尝试找到最大重复模式
                    pattern[i] = pattern[i-1];
                    while(pattern[i] > 0){//逐次递减，直到找到匹配位置：第i个元素的前k个元素，和模式的前k个元素匹配，令pattern[i] = k+1
                        boolean isOK = true;
                        for(int j = 0; j < pattern[i]; j++){
                            if(sChar[j] != sChar[i - pattern[i] + j]){
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

        return pattern;
    }
}
