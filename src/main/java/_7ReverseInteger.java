/**
 * @author zhujingjie
 * @project zhujingjie
 * @description 7
 * @date 2019-03-01 16:33
 */
public class _7ReverseInteger {
    public int reverse(int x) {
        try{
            char[] input = (new Integer(x)).toString().toCharArray();
            char[] output = new char[input.length - 1];

            /**
             * 从后往前遍历输入的数，到首位之后紧挨着的位置
             */
            for(int i = input.length - 1; i > 0; i--){
                output[input.length - i - 1] = input[i];
            }

            /**
             * 在首位额外判断一下是否为负
             */
            if(input[0] != '-'){
                return Integer.valueOf(new String(output) + input[0]);
            }else{
                return Integer.valueOf(input[0] + new String(output));
            }
        }catch (Exception ex){
            return 0;
        }
    }

    public static void main(String[] args){
        _7ReverseInteger test = new _7ReverseInteger();
        System.out.println(test.reverse(123));
        System.out.println(test.reverse(-123));
        System.out.println(test.reverse(120));
    }
}
