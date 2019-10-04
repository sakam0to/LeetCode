
/**
 * @author zhujingjie
 * @project LeetCode
 * @description 10 根据 输入的模式和字符串，判断是否匹配，支持.和*
 * @date 2019-05-09 17:18
 */
public class _10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        //模式p可以匹配许多可能的字符串，所以应该检查字符串s，判断它是否在模式p的可能性维度内
        return match(s.toCharArray(), 0, p.toCharArray());
    }

    //在input内，从start位置开始，判断匹配pattern的结果并返回
    //pattern和input不为空
    boolean match(char[] input, int start, char[] pattern){

        //pattern为空，返回false
        if(pattern.length == 0 && input.length > 0) return false;

        //从start开始
        int i = start;

        //在模式pattern的匹配位置index
        int index = 0;


        for(; i < input.length; i++){

            //匹配的模式已经结束，但是待匹配的字符串还没有结束，返回失败
            if(index >= pattern.length){
                return false;
            }

            //当前匹配的模式
            char currentpattern = pattern[index];

            //获得当前模式的量词， -1 = ∞
            int count;
            if(index + 1 == pattern.length){
                count = 1;
            } else if(pattern[index + 1] == '*'){
                count = -1;
                index++;
            } else {
                count = 1;
            }

            //量词为1
            if(count == 1){
                //在当前位置匹配成功，继续匹配
                if(currentpattern == '.' || currentpattern == input[i]){
                    index++;
                    continue;
                }else{
                    //匹配失败
                    return false;
                }
            }

            //量词为*时
            if(count == -1){

                //.*匹配任意字符的情况
                if(currentpattern == '.'){

                    //已经匹配到pattern的末尾，返回true
                    if(index + 1 == pattern.length){
                        return true;
                    }

                    //否则，不断寻找下一个模式nextpattern匹配的位置，再递归调用匹配方法判断是否匹配。
                    char nextpattern = pattern[++index];
                    int next = i;
                    //获得下一模式的量词， -1 = ∞
                    int nextcount;
                    if(index + 1 == pattern.length){
                        nextcount = 1;
                    } else if(pattern[index + 1] == '*'){
                        nextcount = -1;
                    } else {
                        nextcount = 1;
                    }

                    //截断pattern字符串，剩余的字符串只要匹配截断后的newpattern就可以
                    char[] newpattern = new char[pattern.length - index];
                    System.arraycopy(pattern, index, newpattern, 0, newpattern.length);
                    do {
                        next = findNextMatch(input, next, nextpattern, nextcount);
                        if (next >= input.length) {
                            return false;
                        }
                    }while(!match(input, next++, newpattern));
                    return true;
                }
                //匹配某个字符任意次的情况
                else{

                    //已经匹配到pattern的末尾，判断剩余待匹配字符是否都匹配
                    if(index + 1 == pattern.length){
                        for(int j = i; j < input.length; j++){
                            //有一个不匹配就返回失败
                            if(input[j] != currentpattern){
                                return false;
                            }
                        }
                        return true;
                    }

                    //否则，不断寻找下一个模式nextpattern匹配的位置，再递归调用匹配方法判断是否匹配。
                    char nextpattern = pattern[++index];
                    int next = i;
                    //获得下一模式的量词， -1 = ∞
                    int nextcount;
                    if(index + 1 == pattern.length){
                        nextcount = 1;
                    } else if(pattern[index + 1] == '*'){
                        nextcount = -1;
                    } else {
                        nextcount = 1;
                    }
                    char[] newpattern = new char[pattern.length - index];
                    System.arraycopy(pattern, index, newpattern, 0, newpattern.length);
                    do {
                        next = findNextMatch(input, next, nextpattern, nextcount);
                        if (next >= input.length) {
                            //待匹配的字符串已经遍历完，但是模式还有剩余未匹配，判断剩余的模式是否匹配空字符串（即模式必须都是a*或者.*这种量词）
                            if(match(input, next, newpattern))
                                break;
                            else
                                return false;
                        }

                        //判断下一个模式匹配的位置和当前位置之间的字符是否都匹配模式currentpattern
                        for(int j = i; j < next; j++){
                            //有一个不匹配就返回失败
                            if(input[j] != currentpattern){
                                return false;
                            }
                        }
                    }while(!match(input, next++, newpattern));
                    return true;
                }
            }


        }

        //能执行到这里是input遍历结束，判断pattern有没有结束
        if(index == pattern.length){
            return  true;
        }else{
            //pattern没有结束，判断后面的模式量词
            do{
                char nextpattern = pattern[index++];
                //获得下一模式的量词， -1 = ∞
                int nextcount;
                if(index == pattern.length){
                    nextcount = 1;
                } else if(pattern[index] == '*'){
                    nextcount = -1;
                    index++;
                } else {
                    nextcount = 1;
                }

                if(nextcount != -1)
                    return false;
            }while(index < pattern.length);
            return true;
        }
    }

    //在input内，从start位置开始(不含start)，找到下一个匹配pattern的位置并返回,非贪婪量词模式，总是寻找最短匹配
    int findNextMatch(char[] input, int start, char pattern, int nextcount){
        if(nextcount == -1)
            return start;

        int i = start;
        for(; i < input.length; i++){
            if(input[i] == pattern || pattern == '.'){
                break;
            }
        }

        return i;
    }
    public static void main(String[] args){
        _10RegularExpressionMatching test = new _10RegularExpressionMatching();
        System.out.println(test.match("abc".toCharArray(),3,"a*b*c".toCharArray()));
        System.out.println(test.isMatch("acaabbaccbbacaabbbb",".*b*.*a*a"));
        System.out.println(test.isMatch("aa","b*a*c*"));
        System.out.println(test.isMatch("caa","c*b*a*c*"));
        System.out.println(test.isMatch("abbabaaaaaaacaa","a*.*b.a.*c*b*a*c*"));
        System.out.println(test.isMatch("",""));
        System.out.println(test.isMatch("a",".*..a*"));
        System.out.println(test.isMatch("a","ab*"));
        System.out.println(test.isMatch("aaa","ab*a*c*a"));
        System.out.println(test.isMatch("mississippi","mis*is*ip*."));
        System.out.println(test.isMatch("aa","a"));
        System.out.println(test.isMatch("abc","a*c"));
        System.out.println(test.isMatch("abc",".*c"));
        System.out.println(test.isMatch("abc",".*abc"));
        System.out.println(test.isMatch("aab","a*b"));
        System.out.println(test.isMatch("aab",".*b"));
        System.out.println(test.isMatch("aa","a*"));
        System.out.println(test.isMatch("ab",".*"));
        System.out.println(test.isMatch("aab","c*a*b"));
    }
}
