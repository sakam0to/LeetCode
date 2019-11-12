import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class _811SubdomainVisitCount {
    public static void main(String[] args){
        _811SubdomainVisitCount test = new _811SubdomainVisitCount();
        String[] input = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> result = test.subdomainVisits(input);
        for(String s: result){
            System.out.println(s);
        }
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countPair = new LinkedHashMap<String, Integer>();
        for(String s : cpdomains){
            String[] strings = s.split(" ");
            Integer count = Integer.valueOf(strings[0]);
            String domain = strings[1];
            while(domain.contains(".")){
                addStringToCount(domain, count, countPair);
                domain = domain.substring(domain.indexOf('.') + 1);
            }
            addStringToCount(domain, count, countPair);
        }
        List<String> result = new ArrayList<String>(countPair.size());
        for(String s : countPair.keySet()){
            result.add(countPair.get(s)+" "+s);
        }
        return result;
    }

    private void addStringToCount(String s, Integer num, Map<String, Integer> counter){
        if(counter.containsKey(s)){
            Integer count = counter.get(s);
            count = count+num;
            counter.put(s, count);
        }else{
            counter.put(s, Integer.valueOf(num));
        }
    }
}
