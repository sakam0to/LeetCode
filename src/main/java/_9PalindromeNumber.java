import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujingjie
 * @project LeetCode
 * @description 9 判断一个数字是否是回文，不用转字符串的方法
 * @date 2019-05-09 16:27
 */
public class _9PalindromeNumber {
    //用除10取余的方法依次获取每位数，存入一个列表中，然后在比较对应位置是否相等
    public boolean isPalindrome(int x) {
        if(x < 0)
            //负数不是回文
            return false;

        List<Integer> arrayList = new ArrayList<Integer>();
        do{
            int residue = x % 10;
            arrayList.add(residue);
            x = x / 10;
        }while(x != 0);

        for(int i = 0; i < arrayList.size()/2 ; i++){
            int j = arrayList.size() - 1 - i;
            if(!arrayList.get(i).equals(arrayList.get(j)))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        _9PalindromeNumber test = new _9PalindromeNumber();
        System.out.println(test.isPalindrome(123));
        System.out.println(test.isPalindrome(-123));
        System.out.println(test.isPalindrome(121));
        System.out.println(test.isPalindrome(-121));
        System.out.println(test.isPalindrome(10));
    }
}
