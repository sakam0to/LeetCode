/**
 * @author zhujingjie
 * @project LeetCode
 * @description 5
 * @date 2019-02-15 13:34
 */
public class _5LongestPalindromicSubstring_1 {
    public String longestPalindrome(String s) {
        /**
         * 回文：如果一个字符串是回文，那么字符串的子串也是回文
         * 回文分两种：AA型回文和ABA型回文
         * 种子回文：最小的回文，AA或B(ABA型回文的种子)
         * 先找到种子回文，然后再用种子找最长回文
         */

        char[] input = s.toCharArray();
        String result = new String();
        for(int i = 0; i < input.length; i++){
            /**
             * 默认ABA型回文种子
             */
            String palindrome = findPalindromeBySeed(input, i);
            if(palindrome.length() > result.length()){
                result = palindrome;
            }
            if(i + 1 < input.length && input[i] == input[i + 1]){
                /**
                 * AA型回文种子
                 */
                palindrome = findPalindromeBySeed(input, i, i + 1);
                if(palindrome.length() > result.length()){
                    result = palindrome;
                }
            }
        }
        return result;
    }

    /**
     * 根据种子位置，向左右遍历寻找最大回文
     */
    private String findPalindromeBySeed(char[] input, int... seed) {
        StringBuilder stringBuilder = new StringBuilder();
        int left = seed[0], right = seed[seed.length - 1];
        if(seed.length == 2){
            /**
             * AA型种子
             */
            stringBuilder.append(input[left--]).append(input[right++]);
        }else{
            /**
             * ABA型种子
             */
            stringBuilder.append(input[left--]);
            right++;
        }
        while(left >= 0 && right < input.length){
            if(input[left] == input[right]){
                stringBuilder.insert(0, input[left--]).append(input[right++]);
            } else{
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        _5LongestPalindromicSubstring_1 test = new _5LongestPalindromicSubstring_1();
        System.out.println(test.longestPalindrome("abbbba"));
    }
}