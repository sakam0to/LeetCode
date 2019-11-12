public class _58LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if(words.length > 0){
            return words[words.length - 1].length();
        }else{
            return 0;
        }
    }
}
