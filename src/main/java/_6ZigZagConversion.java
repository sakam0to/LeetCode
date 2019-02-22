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



        /**
         * 把输入字符串s的每个字符的下标i转成zigzag二维数组的坐标(x,y)
         * 对于zigzag生成的二维数组，可以视作若干block串成
         * 【】           【】
         * 【】    【】   【】    【】
         * 【】【】       【】【】
         * 【】           【】
         *  a |   a-2
         * 宽度: a  长度：a-2+1=a-1  每个block共有a+a-1=2a-1个元素
         * 所以对于输入的数组中第i个元素：
         *      i / (2a - 1) = m……n
         * 则位于第m+1个block的第n个位置，
         * 若n <= a, 元素位于block中第一列，所以x=m*(a-1)+1，y=a-n (纵坐标向上为正,二维数组从1开始计数，一维数组从0开始计数)
         * 若n > a, 元素位于blcok中第n-a+1列（对角线上x=y），所以x=m*(a-1)+n-a+1, y=n-a+1         *
         */


        /**
         * 把zigzag二维数组的坐标(x,y)转成输出数组中的下标o
         * 对于zigzag数组中的（x,y）其o的位置是其上所有行（a-y）的元素都输出完毕后，再输出当前行（y）位于x之前的所有元素
         * 【】           【】
         * 【】    【】   【】    【】
         * 【】【】       【】【】<-(x,y)
         * 【】           【】
         *  a |   a-2
         * 宽度: a  长度：a-2+1=a-1  每个block共有a+a-1=2a-1个元素
         *
         * 由于zigzag数组中最后一个block可能不全（输入的数组长度不能整除2a-1)
         * 所以要分析最后一个block的情况：
         * 输入字符串的长度L，
         *      L / (2a - 1) = m……n
         * 则有m个完整的block，最后一个元素在第m+1个block的n位置,
         * 若n <= a, 则最后一个block只有第一列,从a-n+1到a
         * 若n > a, 则最后一个block有n-a+1列
         *
         * 对于坐标（x,y），
         */

    }
}
