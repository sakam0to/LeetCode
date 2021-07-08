public class _374GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            int result = guess(mid);
            if(result == 0)
                return mid;
            if(result < 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    private int guess(int mid) {
        return 0;
    }
}
