public class _937ReorderDatainLogFiles {
    public static void main(String[] args){
        _937ReorderDatainLogFiles test = new _937ReorderDatainLogFiles();
        String[] logs = new String[]{"g1 act car","a8 act zoo","a2 act car"};
        for(String each : test.reorderLogFiles(logs)){
            System.out.println(each);
        }
    }
    public String[] reorderLogFiles(String[] logs) {
        //Bubble Sorting
        for(int i = 0; i < logs.length;i++){
            for(int j = logs.length - 1; j > i; j--){
                String a = logs[j - 1];
                String b = logs[j];
                if(compare(a, b) < 0){ //a > b
                    logs[j - 1] = b;
                    logs[j] = a;
                }
            }
        }
        return logs;
    }

    private int compare(String a, String b){
        String[] inputA = a.split(" ");
        String[] inputB = b.split(" ");

        //compare for each word
        for(int i = 1; i < Math.min(inputA.length, inputB.length); i++){
            char[] inA = inputA[i].toCharArray();
            char[] inB = inputB[i].toCharArray();

            //compare for each character
            for(int j = 0; j < Math.min(inA.length, inB.length); j++){
                //letter-logs come before any digit-log
                if(inA[j] < 58 && inB[j] > 58){
                    return -1; //b < a
                }
                if(inA[j] > 58 && inB[j] < 58){
                    return 1; //a < b
                }
                if(inA[j] < 58 && inB[j] < 58){
                    return 0; //a == b
                }

                if(inA[j] > inB[j]){
                    return -1; // a > b
                }
                if(inA[j] < inB[j]){
                    return 1; //a < b
                }
            }

            //Enter here only if inA and inB have the common prefix
            if(inA.length < inB.length){
                return 1; //a < b
            }
            if(inB.length < inA.length){
                return -1;//a > b
            }
        }

        //Enter here only if inputA and inputB have the common prefix
        if(inputA.length < inputB.length){
            return 1;//a < b
        }
        if(inputB.length < inputA.length){
            return -1;//a > b
        }

        //in case of ties
        char[] identifierA = inputA[0].toCharArray();
        char[] identifierB = inputB[0].toCharArray();
        for(int i = 0; i < Math.min(identifierA.length, identifierB.length); i++){
            if(identifierA[i] > 58 && identifierB[i] > 58){
                if(identifierA[i] > identifierB[i]){
                    return -1; // a > b
                }
                if(identifierA[i] < identifierB[i]){
                    return 1; //a < b
                }
            }else if(identifierA[i] > 58){
                return -1; //a > b
            }else if(identifierB[i] > 58){
                return 1; //a < b
            }
        }
        //Enter here only if identifierA and identifierB have the common prefix
        if(identifierA.length < identifierB.length){
            return 1;//a < b
        }
        if(identifierB.length < identifierA.length){
            return -1;//a > b
        }
        return 0;//a == b;
    }
}
