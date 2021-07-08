public class _278FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}
