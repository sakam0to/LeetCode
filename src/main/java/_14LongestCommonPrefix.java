//divide and conquer
public class _14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int minimum = Integer.MAX_VALUE;
        String minString = "";

        for(String each: strs){
            if(each.length() < minimum){
                minimum = each.length();
                minString = each;
            }
        }

        int min = 0;
        int max = minString.length();
        int tryIndex = max;

        while(!isLargestCommonPrefix(strs, minString, min)){//Check if min is common prefix and min+1 is NOT common prefix
            while(!isCommonPrefix(strs, minString.substring(0, tryIndex))){// try=min + (max-min)/2, if tryIndex is NOT common prefix, max = try;
                max = tryIndex;
                tryIndex = min + (max - min ) / 2;
                if(max - min <= 1){ //max == min +1 or max == min which is hard to update min and max
                    break;
                }
            }

            min = tryIndex;
            tryIndex = min + (max - min ) / 2;
            while(isCommonPrefix(strs, minString.substring(0, tryIndex)))// try=min + (max-min)/2, if try is common prefix, min = try;
            {
                min = tryIndex;
                tryIndex = min + (max - min ) / 2;
                if(max - min <= 1){ //max == min +1 or max == min which is hard to update min and max
                    break;
                }
            }
        }
        return minString.substring(0, min);
    }

    //minPossiblePosition is largest common prefix means minPossiblePosition + 1 is not common prefix
    //Check it!
    private boolean isLargestCommonPrefix(String[] strs, String minString, int minPossiblePosition) {
        if(minPossiblePosition == minString.length()){
            return true;
        }
        int position = minPossiblePosition + 1;
        String prefix = minString.substring(0, position);
        for(String each : strs){
            if(!each.substring(0, prefix.length()).equals(prefix)){//min+1 is NOT common prefix, TRUE!!
                return true;
            }
        }
        return false;
    }

    //Check prefix is common prefix
    private boolean isCommonPrefix(String[] strs, String prefix) {
        for(String each : strs){
            if(!each.substring(0, prefix.length()).equals(prefix)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        _14LongestCommonPrefix test = new _14LongestCommonPrefix();
        System.out.println(test.longestCommonPrefix(new String[]{"o"}));
        System.out.println(test.longestCommonPrefix(new String[]{"flower","flow","flight"}));

        System.out.println(test.longestCommonPrefix(new String[]{"flower"}));

        System.out.println(test.longestCommonPrefix(new String[]{"dog","dog","dog"}));
        System.out.println(test.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
