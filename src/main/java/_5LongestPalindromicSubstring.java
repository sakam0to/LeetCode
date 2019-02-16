/**
 * @author zhujingjie
 * @project LeetCode
 * @description 5
 * @date 2019-02-15 13:34
 */
public class _5LongestPalindromicSubstring {
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
        _5LongestPalindromicSubstring test = new _5LongestPalindromicSubstring();
        System.out.println(test.secondAlgo800ms("abbbba"));
    }

    public String secondAlgo800ms(String s) {
        /**
         * 定义一个字符串数组pivotal[]，长度和input数组一致，保存以当前位置为枢轴（pivotal）的最大回文
         * 定义指针index，指向pivotal[]中正在寻找回文的位置
         * 外层循环遍历pivotal，找到所有的回文
         * 内层循环遍历input，寻找以当前位置为枢轴的最大回文：
         * 在内层循环中，假设当前已找到的回文为s，每次向右增加一个字符，检查能否组成新的回文
         * 因为回文只有两种：ABA型和AA型，所以每次循环共有四种成功找到新回文的可能场景：
         * ________________________________________
         * |循环前 |      ABA型    |       AA型   |
         * |循环后 | ABA型 | AA型  |  ABA型 | AA型|
         * ---
         * 文则内层循环结束，外层循环index++；
         *
         * 算法演示如下：
         * input = [a,b,c,b,a,b,b]
         * expected = abcba
         *
         * index = 0:
         *      pivotal[]=[a,,,,,,];
         * index = 1:
         *      pivotal[]=[a,b,,,,,];
         * index = 2:
         *      pivotal[]=[a,b,abcba,,,,];
         * index = 3:
         *      pivotal[]=[a,b,abcba,b,,,];
         * index = 4:
         *      pivotal[]=[a,b,abcba,b,bab,,];
         * index = 5:
         *      pivotal[]=[a,b,abcba,b,bab,bb,];
         * index = 6:
         *      pivotal[]=[a,b,abcba,b,bab,bb,b];
         */
        char[] input = s.toCharArray();
        String[] pivotal = new String[input.length];
        String result = "";
        /**
         * input[i] = input[2*index - i](ABA型回文) || （AA型回文）)
         */
        for(int index = 0; index < pivotal.length; index++){
            pivotal[index] = input[index] + "";
            for(int i = index + 1; i < input.length; i++){
                if((pivotal[index].length()%2 == 1) &&2 * index - i >= 0 && input[i] == input[2 * index - i]){
                    /**
                     * ABA型回文
                    */
                    pivotal[index] = input[2 * index - i] + pivotal[index] + input[i];
                }else if((pivotal[index].length()%2 == 0) && 2 * index - i + 1 >= 0 && input[i] == input[2*index - i + 1]){
                    /**
                     * AA型回文
                     */
                    pivotal[index] = input[2 * index - i + 1] + pivotal[index] + input[i];
                }else if(pivotal[index].length()%2 == 1 && pivotal[index].matches( input[i]+"+")){
                    /**
                     * ABA型回文变AA型回文
                     */
                    pivotal[index] = pivotal[index] + input[i];
                }else{
                    break;
                }
            }
            if(result.length() < pivotal[index].length()){
                result = pivotal[index];
            }
        }
        return result;
    }
}