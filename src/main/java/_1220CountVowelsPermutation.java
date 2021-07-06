import java.math.BigInteger;

public class _1220CountVowelsPermutation {
    public static void main(String[] args){
        _1220CountVowelsPermutation solution = new _1220CountVowelsPermutation();
        solution.countVowelPermutation(31);
    }

    public int countVowelPermutation(int n) {
        BigInteger[] vowels = new BigInteger[]{BigInteger.ONE,
                BigInteger.ONE,
                BigInteger.ONE,
                BigInteger.ONE,
                BigInteger.ONE};
        BigInteger[] temp = new BigInteger[5];
        for(int i = 1; i < n; i++){
            temp = new BigInteger[5];
            temp[0] = vowels[1];
            temp[1] = vowels[0].add(vowels[2]);
            temp[2] = vowels[0].add(vowels[1].add(vowels[3].add(vowels[4])));
            temp[3] = vowels[2].add(vowels[4]);
            temp[4] = vowels[0];

            for(int j = 0; j < vowels.length; j++){
                vowels[j] = temp[j];
            }
        }

        BigInteger count = BigInteger.ZERO;
        for(int i = 0; i < vowels.length; i++){
            count = count.add(vowels[i]);
        }
        return count.mod(BigInteger.TEN.pow(9).add(BigInteger.valueOf(7))).intValue();
    }
}
