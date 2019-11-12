
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Twitter_OA4_GameEvents {
    public static void main(String[] args){
        String[] events1 = new String[]{"zhang san 45+2 S wang da si","zhang san 45+2 S wang da chui", "zhang san ! 45+2 S wang dachui"};
        String[] events2 = new String[]{"cai hong 45+2 S he chang tuan","rui xing 45+2 S sha du ruanjian", "360 sha 45+2 S du"};


        for(String e: getEventsOrder("ABC", "CBA", Arrays.asList(events1), Arrays.asList(events2))){
            System.out.println(e);
        }
    }
    static class Event{
        Pattern pattern = Pattern.compile("(.+\\s)(\\d+(\\+\\d)?)\\s(\\S)(.*)");
        Integer time = 0;
        Integer extraTime = 0;
        String type;
        String playerName;
        String secondaryName;
        String teamName;
        public Event(String e, String teamName) {
            Matcher matcher = pattern.matcher(e);
            matcher.matches();
            playerName = matcher.group(1).trim();
            type = matcher.group(4);
            this.teamName = teamName;
            if(matcher.group(2).contains("+")){
                time = Integer.valueOf(matcher.group(2).split("\\+")[0]);
                extraTime = Integer.valueOf(matcher.group(2).split("\\+")[1]);
            }else{
                time = Integer.valueOf(matcher.group(2));
            }
            if(type.equals("S")){
                secondaryName = matcher.group(5).trim();
            }
        }

        public String toString(){
            String result = teamName.concat(" ").concat(playerName).concat(" ").concat(time+"");
            if(extraTime > 0){
                result = result.concat("+").concat(extraTime+" ").concat(type);
            }else{
                result = result.concat(" ").concat(type);
            }
            if(type.equals("S")){
                result = result.concat(" ").concat(secondaryName);
            }
            return result;
        }
    }
    public static List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
        // Write your code here
        List<Event> eventList1 = new ArrayList<>();
        List<Event> eventList2 = new ArrayList<>();

        for(String e: events1){
            eventList1.add(new Event(e, team1));
        }
        for(String e: events2){
            eventList2.add(new Event(e, team2));
        }

        Comparator matchComparator = MatchComparator.getInstance();
        Collections.sort(eventList1, matchComparator);
        Collections.sort(eventList2, matchComparator);
        int a =0, b = 0;
        LinkedList<String> result = new LinkedList<>();

        while(a < eventList1.size() && b<eventList2.size()){
            int compareRes = matchComparator.compare(eventList1.get(a), eventList2.get(b));
            if(compareRes < 0){
                result.addLast(eventList1.get(a++).toString());
            }else{
                result.addLast(eventList2.get(b++).toString());
            }
        }
        while(a < eventList1.size()){
            result.addLast(eventList1.get(a++).toString());
        }
        while(b<eventList2.size()){
            result.addLast(eventList2.get(b++).toString());
        }
        return result;
    }

    public static class MatchComparator implements Comparator<Event> {
        public static Comparator<? super Event> getInstance() {
            return new MatchComparator();
        }

        @Override
        public int compare(Event o1, Event o2) {
            Pattern pattern = Pattern.compile("(.+\\s)(\\d+(\\+\\d)?)\\s(\\S)(.*)");
            int compareTime = compareTime(o1, o2);
            if(compareTime != 0){
                return compareTime;
            }else{
                int compareType = compareType(o1, o2);
                if(compareType != 0){
                    return compareType;
                }else{
                    int compareName = compareName(o1, o2);
                    if(compareType != 0){
                        return compareType;
                    }else{
                        return 0;
                    }
                }
            }
        }

        private int compareName(Event o1, Event o2) {
            int compareTeamName = o1.teamName.compareTo(o2.teamName);
            if(compareTeamName != 0){
                return compareTeamName;
            }else{
                int comparePlayerName = o1.playerName.compareTo(o2.playerName);
                if(comparePlayerName != 0){
                    return comparePlayerName;
                }else{
                    int compareSecondName = o1.secondaryName.compareTo(o2.secondaryName);
                    if(compareSecondName != 0){
                        return compareSecondName;
                    }else{
                        return 0;
                    }
                }
            }
        }

        public int compareTime(Event o1, Event o2){
            if(o1.time < o2.time){
                return -1;
            }else if(o1.time > o2.time){
                return 1;
            }else if(o1.extraTime < o2.extraTime){
                return -1;
            }else if(o1.extraTime > o2.extraTime){
                return 1;
            }else{
                return 0;
            }
        }

        public int compareType(Event o1, Event o2){
            List<String> order = Arrays.asList("G","Y","R","S");
            int order1 = order.indexOf(o1.type);
            int order2 = order.indexOf(o2.type);
            if(order1<order2){
                return -1;
            }else if(order1 > order2){
                return 1;
            }else{
                return 0;
            }
        }

    }
}
