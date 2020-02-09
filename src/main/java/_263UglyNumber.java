public class _263UglyNumber {
    public static void main(String[] args){
        _263UglyNumber solution = new _263UglyNumber();
        System.out.println(solution.isUgly(1));
    }


    public boolean isUgly(int num) {
        //丑数只包含2，3，5 == 丑数必被2，3，5整除且除尽
        //prime tree: num -> 2, 3, 5 三叉树，每一个节点代表一个因数，叶子为1就是丑数。 深度遍历一遍知道找到第一个为的叶子节点

        if(num == 1){
            return true;
        }
        if(num == 0){
            return false;
        }
        if(num % 2 == 0 && isUgly(num/2)){//第一个节点
            return true;
        }

        if(num % 3 == 0 && isUgly(num/3)){//第二个节点
            return true;
        }

        if(num % 5 == 0 && isUgly(num/5)){//第三个节点
            return true;
        }

        return false;
    }
}