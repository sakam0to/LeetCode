public class _38CountandSay {
    public static void main(String[] args){
        _38CountandSay test = new _38CountandSay();
        System.out.println(test.countAndSay(10));
    }

    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            char[] chars = s.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            char num = chars[0];
            int count = 1;
            for(int j = 1; j < chars.length; j++){
                if(chars[j] == num){
                    count++;
                }else{
                    stringBuilder.append(count).append(num);
                    num = chars[j];
                    count = 1;
                }
            }
            stringBuilder.append(count).append(num);
            s = stringBuilder.toString();
        }
        return s;
    }
}
