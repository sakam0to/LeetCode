public class _825FriendsOfAppropriateAges {

    /**
     *
     * conditions for NOT satisfying:
    a. age[B] <= 0.5 * age[A] + 7
    b. age[B] > age[A]
    c. age[B] > 100 && age[A] < 100 (c. is redundant from b.)

     A will request B if
     ==>  0.5 * age[A] + 7 < age[B] <= age[A]

     int[] age = new int[maxAge]; store number of persons of 0 ~ maxAge year's old
     for each age[i]:
     request += age[i] * (age[ floor(0.5*age[i]+7+1) ] +...+age[i] - 1);  -1 = remove himself
     */
    public int numFriendRequests(int[] ages) {
        int maxAge = 0;
        for(int i = 0; i < ages.length; i++){
            if(ages[i] > maxAge){
                maxAge = ages[i];
            }
        }

        int[] numberOfAgePeople = new int[maxAge + 1];
        for(int i = 0; i < ages.length; i++){
            numberOfAgePeople[ages[i]]++;
        }

        int requestNumber = 0;
        for(int i = 0; i < numberOfAgePeople.length; i++){//i = age
            if(numberOfAgePeople[i] > 0){
                int start = (int) (0.5 * i + 8);// + 1 then round down
                int end = i;
                int sum = 0;
                for(int j = start; j <= end; j++){
                    sum += numberOfAgePeople[j];
                }
                if(sum > 0){
                    requestNumber += numberOfAgePeople[i] * (sum - 1);
                }
            }
        }
        return requestNumber;
    }

    public static void main(String[] args){
        _825FriendsOfAppropriateAges test = new _825FriendsOfAppropriateAges();
        System.out.println(test.numFriendRequests(new int[]{16,16}));
    }
}
