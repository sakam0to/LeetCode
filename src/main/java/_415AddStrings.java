public class _415AddStrings {
    public static void main(String[] args){
        _415AddStrings test = new _415AddStrings();
        System.out.println(test.addStrings("123456789", "987654321"));
    }
    public String addStrings(String num1, String num2) {
        char[] numschar1 = num1.toCharArray();
        char[] numschar2 = num2.toCharArray();
        char[] result = new char[Math.max(numschar1.length, numschar2.length)+1];
        int addon = 0;
        int i = 0;
        while(i < Math.min(numschar1.length, numschar2.length)){
            int sum = numschar1[numschar1.length - 1 - i] - 48 + numschar2[numschar2.length - 1 - i] -48 + addon;
            addon = sum / 10;
            result[result.length - i - 1] = (char) ((sum % 10) + 48);
            i++;
        }
        while(i < numschar1.length){
            int sum = numschar1[numschar1.length - 1 - i] - 48 + addon;
            addon = sum / 10;
            result[result.length - i - 1] = (char) ((sum % 10) + 48);
            i++;
        }
        while(i < numschar2.length){
            int sum = numschar2[numschar2.length - 1 - i] - 48 + addon;
            addon = sum / 10;
            result[result.length - i - 1] = (char) ((sum % 10) + 48);
            i++;
        }

        result[result.length - i - 1] = (char) (addon  + 48);

        if(result[0] == '0'){
            return new String(result, 1, result.length - 1);
        }
        else{
            return new String(result);
        }
    }
}
