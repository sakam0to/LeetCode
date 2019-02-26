/**
 * @author zhujingjie
 * @project resources
 * @description 6
 * @date 2019-02-22 16:04
 */
public class _6ZigZagConversion {
    public String convert(String s, int numRows) {
        /**
         * 算法是把一维数组（下标i)转成二维数组（x,y）再转成一维数组(下标j)
         * 所以核心在于设计i->（x,y）和（x,y）->j的算法
         */

        char[] input = s.toCharArray();
        char[] output = new char[input.length];
        int L  = input.length;

        if(numRows == 1){
            return s;
        }else if(numRows == 2){
            int k;
            for(k = 0; 2*k+1 < L; k++){
                output[k] = input[2*k];
                output[k+ (L+1)/2] = input[2*k+1];
            }
            if(2*k < L){
                output[k] = input[2*k];
            }
            return new String(output);
        }
        int M = L / (2*numRows - 2);
        int N = L % (2*numRows - 2);

        for(int i = 0; i < input.length; i++){
            /**
             * 把输入字符串s的每个字符的下标i转成zigzag二维数组的坐标(x,y)
             * 对于zigzag生成的二维数组，可以视作若干block串成
             * 【】           【】
             * 【】    【】   【】    【】
             * 【】【】       【】【】
             * 【】           【】
             *  a |   a-2
             * 宽度: a  长度：a-2+1=a-1  每个block共有a+a-2=2a-2个元素
             * 所以对于输入的数组中第i个元素：
             *      i / (2a - 2) = m……n
             * 则位于第m+1个block的第n个位置，
             * 若n = 0, 元素位于block中最后一个位置，所以x=m*(a-1)，y=a-n+1 (纵坐标向上为正,二维数组从1开始计数)
             * 若n <= a, 元素位于block中第一列，所以x=m*(a-1) + 1，y=a-n+1 (纵坐标向上为正,二维数组从1开始计数)
             * 若n > a, 元素位于blcok中第n-a+1行，第n-a+1列（对角线上x=y），所以x=m*(a-1)+n-a+1, y=n-a+1
             */
            int m = (i+1) / (2*numRows - 2);
            int n = (i+1) % (2*numRows - 2);

            int x, y;
            if(n == 0){
                x = m * (numRows - 1);
                y = numRows - 1;
            }else if(n <= numRows){
                x = m * (numRows - 1) + 1;
                y = numRows - n + 1;
            } else{
                x = m * (numRows  - 1) + n - numRows + 1;
                y = n - numRows + 1;
            }

            /**
             * 把zigzag二维数组的坐标(x,y)转成输出数组中的下标o
             * 对于zigzag数组中的（x,y）其o的位置是其上所有行（a-y）的元素都输出完毕后，再输出当前行（y）位于x之前的所有元素
             * 【】           【】
             * 【】    【】   【】    【】
             * 【】【】       【】【】<-(x,y)
             * 【】           【】
             *  a |   a-2
             * 宽度: a  长度：a-2+1=a-1  每个block共有a+a-2=2a-2个元素
             *
             * 由于zigzag数组中最后一个block可能不全（输入的数组长度不能整除2a-1)
             * 所以要分析最后一个block的情况：
             * 输入字符串的长度L，
             *      L / (2a - 2) = M……N
             * 则有M个完整的block，最后一个元素在第M+1个block的n位置,
             * 若N <= a, 则最后一个block只有第一列,从a-n+1行到a行
             * 若N > a, 则最后一个block有1列到n-a+1列
             *
             * 对于坐标（x,y），首先输出其上的y+1行到a行所有元素，再输出当前行第1列到第x列之间的元素
             * 对第x列第y行的元素来说：
             *      x / (a - 1) = m……n
             * 当y = a时，元素位于顶行，其上没有其他元素。
             * 当y < a时，其上有a-y行，共有（a-y-1）*2M(非顶行，a-y-1>0)+M(顶行)+ N(while N<=a-y , 最后一个block第一列未填满) OR a-y(while a-y <= N <= a+y-1， 最后一个block第一列填满，但未溢出第y行） OR a-y +N-(a+y-1) (while N >= a+y，最后一个block第一列填满，且溢出第y行).
             * 元素位于第m+1个block，当y = a-1时（顶行），x之前有m个元素，其他情况有2m个元素。
             * 当n<=a时，元素在第m+1个block中的第一列，否则在对角线上
             * 输出的数组下标从0开始，但不需要再减一，因为这里计算的就是输出（x,y）之前需要输出的元素数，刚好是输出数组的下表
             */
            int j;
            m = x / (numRows - 1);
            n = x % (numRows - 1);
            if(y == numRows){
                j = m;
            }else {
                if(N <= numRows - y){
                    j = (((numRows - y -1)>0)?(numRows - y -1):0) * 2 * M + M + N;
                }else if(N <= numRows + y - 1){
                    j = (((numRows - y -1)>0)?(numRows - y -1):0) * 2 * M + M + (numRows - y);
                }else{
                    j = (((numRows - y -1)>0)?(numRows - y -1):0) * 2 * M + M + (numRows - y) + N - (numRows + y - 1);
                }

                if(n > 1){
                    j += 2*m + 1;
                }else if(n > 0){//n = 1
                    if(y == 1){//最底层
                        j += m;
                    }else{
                        j += 2*m;
                    }
                }else{//n = 0，block最后一个元素
                    j += 2*m - 1;
                }
            }
            output[j] = input[i];
        }

        return new String(output);
    }

    public static void main(String[] args){
        _6ZigZagConversion test = new _6ZigZagConversion();
        System.out.println(test.convert("PAYPALISHIRING",3));
        System.out.println(test.convert("ABCDEFGH",2));
    }
}
