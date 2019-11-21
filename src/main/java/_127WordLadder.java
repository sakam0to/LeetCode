import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class _127WordLadder {
    public static void main(String[] args){
        _127WordLadder test = new _127WordLadder();
        String beginWord = "hot";
        String endWord = "dog";
        String[] words = new String[]{"hot","cog","dog","tot","hog","hop","pot","dot"};
        System.out.println(test.ladderLength(beginWord, endWord, Arrays.asList(words)));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new LinkedHashSet<>();//字典快查表
        for(String s: wordList){
            dictionary.add(s);
        }
        if(!dictionary.contains(endWord)){
            return 0;
        }
        Queue<String> BFS = new LinkedBlockingQueue<>();//用队列实现BFS，endWord是根结点，层树表示修改了几个字母，BFS遍历完，还不能match startWord，返回0
        Map<String, Integer> wordLevel = new LinkedHashMap<>();//记录每个单词所在的层数，实际就是需要变动的字母数。
        BFS.add(endWord);
        wordLevel.put(endWord,1);
        dictionary.remove(endWord);
        while(!BFS.isEmpty()){
            String currWord = BFS.remove();
            Integer level = wordLevel.get(currWord);
            Integer num = checkWord(currWord, beginWord);
            if(num == 1){
                return level+1;
            }else{
                for(String word : dictionary.toArray(new String[]{})){
                    if(checkWord(currWord, word) == 1){
                        BFS.add(word);
                        wordLevel.put(word,level+1);
                        dictionary.remove(word);
                    }
                }
            }
        }
        return 0;
    }

    private Integer checkWord(String currWord, String beginWord) {
        if(currWord.length() != beginWord.length()){
            return -1;
        }
        int count = 0;
        for(int i = 0; i < beginWord.length(); i++){
            if(currWord.charAt(i) != beginWord.charAt(i)){
                count++;
            }
            if(count > 1){
                return -1;
            }
        }
        return count;
    }
}
