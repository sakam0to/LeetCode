import java.util.Arrays;

public class _443StringCompression {
    /**
     *
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int prior = 0;
        int index = 0;
        int count = 0;
        for(int i = 0; i < chars.length; i++){
            if(prior != (int)chars[i]){
                prior=(int)chars[i];

                if(count > 1){
                    char[] countChar = String.valueOf(count).toCharArray();
                    for(int j = 0; j < countChar.length; j++){
                        chars[index++] = countChar[j];
                    }
                }
                count = 1;

                chars[index++] = chars[i];
            }else{
                count++;
            }
        }
        if(count > 1){
            char[] countChar = String.valueOf(count).toCharArray();
            for(int j = 0; j < countChar.length; j++){
                chars[index++] = countChar[j];
            }
        }
        chars = Arrays.copyOfRange(chars, 0 ,index);
        return index;
    }

    public static void main(String[] args){
        _443StringCompression test = new _443StringCompression();
        System.out.println(test.compress(new String("abbbssswwkdoooooo").toCharArray()));

    }
}
