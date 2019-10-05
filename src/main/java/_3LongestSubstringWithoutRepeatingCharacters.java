/**
 * @author zhujingjie
 * @project LeetCode
 * @description 3
 * @date 2019-02-14 15:15
 */
public class _3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 简化版模式匹配
         */
        char[] input = s.toCharArray();
        int length = 0;

        /**
         * pattern 存储当前的模式(使用List存储模式性能会急剧恶化)
         */
        String pattern = new String ();

        /**
         * 遍历输入的字符串（已转为字符数组）
         */
        for(int i = 0; i < input.length; i++){
            /**
             * 找到字符在模式中第一次出现的位置
             */
            int index = pattern.indexOf(input[i]);

            /**
             * 当前模式增加一个字符，即使之后移除也是移除第一个出现的元素
             */
            pattern += input[i];

            /**
             * 判重
             */
            if(index < 0){
                if(pattern.length() > length){
                    length = pattern.length();
                }
            }else {
                /**
                 * 从第一次出现的位置处截断
                 */
                pattern = pattern.substring(index + 1);
            }
        }
        return length;
    }

    public static void main(String[] args){
        _3LongestSubstringWithoutRepeatingCharacters test = new _3LongestSubstringWithoutRepeatingCharacters();
        System.out.println(test.lengthOfLongestSubstring("aabaab!bb"));
    }

    public int betterLengthOfLongestSubstring(String s) {
        //简化数据结构开销,String改成char[],使用自己实现的indexOf()算法，性能更好
        char[] input = s.toCharArray();
        char[] pattern = new char[input.length];
        int startPointer = 0;
        int maxLength = 0;

        for(int i = 0; i < input.length; i++ ){
            pattern[i] = input[i];

            for(int j = startPointer; j < i; j++){
                if(pattern[j] == pattern[i]){
                    startPointer = j + 1;
                    break;
                }
            }

            int patternLength = i - startPointer + 1;
            if(patternLength > maxLength){
                maxLength = patternLength;
            }
        }
        return maxLength;
    }
}
