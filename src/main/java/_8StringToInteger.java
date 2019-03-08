/**
 * @author zhujingjie
 * @project LeetCode
 * @description 8 Perl就是使用这种方式把字符串转换成Int型数的
 * @date 2019-03-06 11:27
 */
public class _8StringToInteger {
    public int myAtoi(String str) {
        /**
         * 去除whitespace
         */
        str = str.trim();
        /**
         * 转成char[]
         */
        char[] input = str.toCharArray();

        StringBuffer result = new StringBuffer();

        /**
         * 判断首位是否为正负号
         */
        int i = 0;
        if(input.length > 0 && (input[i] == '-' || input[i] == '+')){
            result.append(input[i++]);
        }
        /**
         * 遍历直到遇见非数字字符
         */
        for(; i < input.length; i++){
            int each = Character.digit(input[i], 10);
            if(each < 0){
                break;
            }
            result.append(each);
        }

        /**
         * 转换，异常只有两种情况：越界、空字符串或正负号。
         */
        try{
            return Integer.valueOf(result.toString());
        } catch (Exception ex){
            if(result.toString().equals("")|| result.toString().equals("+") || result.toString().equals("-")) {
                return 0;
            }else if(result.toString().startsWith("-")){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args){
        _8StringToInteger test = new _8StringToInteger();
        System.out.println(test.myAtoi("+02c9"));
        System.out.println(test.myAtoi(""));
        System.out.println(test.myAtoi("42"));
        System.out.println(test.myAtoi("   -42"));
        System.out.println(test.myAtoi("4193 with words"));
        System.out.println(test.myAtoi("words and 987"));
        System.out.println(test.myAtoi("       "));
        System.out.println(test.myAtoi("       +"));
        System.out.println(test.myAtoi("    -   "));
    }
}
