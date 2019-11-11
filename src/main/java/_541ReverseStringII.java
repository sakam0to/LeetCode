public class _541ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] input = s.toCharArray();
        char[] reverse = new char[k];
        char[] result = new char[input.length];

        int revIndex = 0;
        int resIndex = 0;

        int count = 0;
        boolean gkl2k = false;
        for(int i = 0; i < input.length; i++){
            if(!gkl2k){
                reverse[revIndex++] = input[i];

                if(revIndex == k){
                    while(revIndex > 0){
                        result[resIndex++] = reverse[--revIndex];
                    }
                }

            }else{
                result[resIndex++] = input[i];
            }

            count++;

            if(count >= k){
                gkl2k = !gkl2k;
                count = 0;
            }
        }

        while(revIndex > 0){
            result[resIndex++] = reverse[--revIndex];
        }

        return new String(result);
    }

    public static void main(String[] args){
        _541ReverseStringII test = new _541ReverseStringII();
        System.out.println(test.reverseStr("abcdefg", 2));
    }

}
