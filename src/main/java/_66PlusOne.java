public class _66PlusOne {
    public static void main(String[] args){

        Solution solution = new Solution();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.plusOne(input);
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int addon = 1;

        while(index >= 0 && addon > 0){
            digits[index] = digits[index] + addon;
            addon = digits[index] / 10;
            digits[index] = digits[index] % 10;
            index--;
        }
        if(addon > 0){
            int[] newdigits = new int[digits.length + 1];
            newdigits[0] = addon;
            return newdigits;
        }else{
            return digits;
        }
    }
}
