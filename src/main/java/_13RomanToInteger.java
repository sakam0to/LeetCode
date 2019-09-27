/**
 * @author zhujingjie
 * @project LeetCode
 * @description 13 根据 输入的罗马字符输出整型数
 * @date 2019-09-10 16:07
 */

public class _13RomanToInteger{
    public static void main(String[] args){
        _13RomanToInteger test = new _13RomanToInteger();

        String input = "MCMXCIV";
        System.out.println(input+" : "+test.romanToInt(input));
    }


    public int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int total = 0;
        char I = 'I';
        char V = 'V';
        char X = 'X';
        char L = 'L';
        char C = 'C';
        char D = 'D';
        char M = 'M';


        for(int i = 0; i < charArray.length; i++){
            switch(charArray[i]){
                case 'I':
                    if(i+1 < charArray.length && charArray[i+1] == 'V') {total+=4;i++;}
                    else if(i+1 < charArray.length && charArray[i+1] == 'X') {total+=9;i++;}
                    else total+=1;
                    break;
                case 'V': total+=5;break;
                case 'X':
                    if(i+1 < charArray.length && charArray[i+1] == 'L') {total+=40;i++;}
                    else if(i+1 < charArray.length && charArray[i+1] == 'C') {total+=90;i++;}
                    else total+=10;
                    break;
                case 'L': total+=50;break;
                case 'C':
                    if(i+1 < charArray.length && charArray[i+1] == 'D') {total+=400;i++;}
                    else if(i+1 < charArray.length && charArray[i+1] == 'M') {total+=900;i++;}
                    else total+=100;
                    break;
                case 'D': total+=500;break;
                case 'M': total+=1000;break;
            }
        }

        return total;
    }

}