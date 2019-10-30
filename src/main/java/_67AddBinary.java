public class _67AddBinary {
    public static void main(String[] args){
        _67AddBinary test = new _67AddBinary();
        String a = "1010", b = "1011";
        System.out.println(test.addBinary(a, b));
    }
    public String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] inputA = a.toCharArray();
        char[] inputB = b.toCharArray();
        int addon = 0;
        int indexA = inputA.length;
        int indexB = inputB.length;
        while(indexA > 0 && indexB > 0){
            char charA = inputA[--indexA];
            char charB = inputB[--indexB];

            int intA = (charA == '1')?1:0;
            int intB = (charB == '1')?1:0;

            int sum = intA + intB + addon;
            stringBuffer.insert(0, sum%2);
            addon = sum/2;
        }
        while(indexA > 0){
            char charA = inputA[--indexA];

            int intA = (charA == '1')?1:0;

            int sum = intA + addon;
            stringBuffer.insert(0, sum%2);
            addon = sum/2;
        }
        while(indexB > 0){
            char charB = inputB[--indexB];

            int intB = (charB == '1')?1:0;

            int sum = intB + addon;
            stringBuffer.insert(0, sum%2);
            addon = sum/2;
        }
        while(addon > 0){
            int sum = addon;
            stringBuffer.insert(0, sum%2);
            addon = sum/2;
        }
        return stringBuffer.toString();
    }
}
