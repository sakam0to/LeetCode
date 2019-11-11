public class _125ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        char[] input = s.toCharArray();
        int start = 0;
        int end = input.length - 1;
        while(start < end){
            char a = input[start];
            char b = input[end];
            if(a < 48 || (a > 57 && a < 97)|| a > 122){
                start++;
                continue;
            }
            if(b < 48 || (b > 57 && b < 97)|| b > 122){
                end--;
                continue;
            }

            if(a != b){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
