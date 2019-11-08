import java.sql.Timestamp;
import java.util.*;

public class _981TimeBasedKeyValueStore {
    public static void main(String[] args){
        TimeMap obj = new TimeMap();
        obj.set("foo","bar",1);
        String param = obj.get("foo",1);
        System.out.println(param);
        param = obj.get("foo",3);
        System.out.println(param);
        obj.set("foo","bar2",4);
        param = obj.get("foo",4);
        System.out.println(param);
        param = obj.get("foo",5);
        System.out.println(param);
    }
}

class TimeMap{
    HashMap<String, List<TimestampValue>> records;
    /** Initialize your data structure here. */
    public TimeMap() {
        records = new LinkedHashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<TimestampValue> list;
        if(records.containsKey(key)){
            list = records.get(key);
            TimestampValue timestampValue = new TimestampValue(value, timestamp);
            binaryInsert(list, timestampValue);
        }else{
            list = new ArrayList<>();
            list.add(new TimestampValue(value, timestamp));
            records.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        if(records.containsKey(key)){
            List<TimestampValue> list = records.get(key);
            TimestampValue timestampValue = binarySearch(list, timestamp);
            return (null == timestampValue)? "" : timestampValue.value;
        }else{
            return "";
        }
    }

    private TimestampValue binarySearch(List<TimestampValue> list, int timestamp) {
        //二分查找，比timestamp小，且最接近timestamp的value
        int upBound = list.size() - 1;
        int lowBound = 0;

        //判断边界：最大的时间戳都比timestamp小，则返回最后一个value
        TimestampValue upLimit = list.get(upBound);
        if(upLimit.timestamp < timestamp){
            return upLimit;
        }

        //判断边界：最小的时间戳都比timestamp大，则返回空
        TimestampValue lowLimit = list.get(lowBound);
        if(lowLimit.timestamp > timestamp){
            return null;
        }

        int mid = (upBound - lowBound) / 2 + lowBound;
        do{
            TimestampValue timestampValue = list.get(mid);
            if(timestampValue.timestamp == timestamp){
                return timestampValue;
            }else if(timestampValue.timestamp < timestamp){
                lowBound = mid;
                mid = (int)Math.ceil((upBound - lowBound) / 2.0 + lowBound);
            }else{
                upBound = mid;
                mid = (int)Math.floor((upBound - lowBound) / 2.0 + lowBound);
            }
        }while(upBound - lowBound > 1);
        //跳出循环，此时timestamp在lowBound和upBound之间，且可能就是边界值，即lowBound <= timestamp <= upBound
        //但除了timestamp == upBound这种情况，返回upBound值以外，其他情况都返回lowBound
        if(list.get(upBound).timestamp == timestamp){
            return list.get(upBound);
        }
        return list.get(lowBound);
    }

    private void binaryInsert(List<TimestampValue> list, TimestampValue tv) {
        //二分查找插入位置，是列表增序排列
        int timestamp = tv.timestamp;
        int upBound = list.size() - 1;
        int lowBound = 0;

        //判断边界：最大的时间戳都比timestamp小，则插入到最后一个位置
        TimestampValue upLimit = list.get(upBound);
        if(upLimit.timestamp < timestamp){
            list.add(tv);
            return;
        }
        //判断边界：最小的时间戳都比timestamp大，则插入到第一个位置
        TimestampValue lowLimit = list.get(lowBound);
        if(lowLimit.timestamp > timestamp){
            list.add(0, tv);
            return;
        }

        int mid = (upBound - lowBound) / 2 + lowBound;
        do{
            TimestampValue timestampValue = list.get(mid);
            if(timestampValue.timestamp == timestamp){
                //题目限制应该不会有相同时间戳，但如果有就插入到当前位置
                list.add(mid, tv);
                return;
            }else if(timestampValue.timestamp < timestamp){
                lowBound = mid;
                mid = (int)Math.ceil((upBound - lowBound) / 2.0 + lowBound);
            }else{
                upBound = mid;
                mid = (int)Math.floor((upBound - lowBound) / 2.0 + lowBound);
            }
        }while(upBound - lowBound > 1);

        //跳出循环，此时timestamp在lowBound和upBound之间，且可能就是边界值，即lowBound <= timestamp <= upBound
        //但除了timestamp == lowBound这种情况，插入到lowBound值以外，其他情况都插入在upBound位置
        if(list.get(lowBound).timestamp == timestamp){
            list.add(lowBound, tv);
        }else{
            list.add(upBound, tv);
        }
    }

    class TimestampValue{
        String value;
        Integer timestamp;

        public TimestampValue(String value, Integer timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}