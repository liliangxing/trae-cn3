package com.bytedance.applog.priority;

import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.util.JsonUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventPriority {
    public static final int PRIORITY_DEFAULT = -1;
    public static final int PRIORITY_REAL_TIME = 0;
    Map<String, Integer> mEventIndex;
    private Map<Integer, EventPriorityItem> mPriorityMap;
    private JSONArray priorityJson;
    int mPriorityVersion = 0;
    int mBaseInterval = 5;
    int mMaxPriority = -1;
    private final Set<String> priorityEventNames = new HashSet();
    boolean preferBatchEventInterval = false;

    public void setPriorityJson(JSONArray jSONArray) {
        this.priorityJson = jSONArray;
    }

    public JSONArray getPriorityJson() {
        return this.priorityJson;
    }

    public int getVersion() {
        return this.mPriorityVersion;
    }

    public int getBaseInterval() {
        return this.mBaseInterval;
    }

    public boolean isValid() {
        Map<Integer, EventPriorityItem> map;
        EventPriorityItem eventPriorityItem;
        return this.mPriorityVersion >= 0 && this.mBaseInterval > 0 && (map = this.mPriorityMap) != null && !map.isEmpty() && map.containsKey(-1) && (eventPriorityItem = map.get(-1)) != null && eventPriorityItem.mIntervalMultiple > 0;
    }

    public int getPriorityOfEvent(String str, String str2) {
        Map<Integer, EventPriorityItem> map;
        EventPriorityItem value;
        List<Map<String, Object>> list;
        boolean z;
        List<Set<String>> list2;
        if (!isEventNameMatch(str)) {
            return -1;
        }
        Map<String, Integer> map2 = this.mEventIndex;
        if (map2 != null && map2.containsKey(str)) {
            Integer num = this.mEventIndex.get(str);
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }
        if (!TextUtils.isEmpty(str2) && (map = this.mPriorityMap) != null && !map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                for (Map.Entry<Integer, EventPriorityItem> entry : this.mPriorityMap.entrySet()) {
                    int intValue = entry.getKey().intValue();
                    if (-1 != intValue && (value = entry.getValue()) != null) {
                        if (value.mEventParamKeyMap != null && !value.mEventParamKeyMap.isEmpty() && value.mEventParamKeyMap.containsKey(str) && (list2 = value.mEventParamKeyMap.get(str)) != null && !list2.isEmpty()) {
                            for (Set<String> set : list2) {
                                if (set != null && !set.isEmpty() && JsonUtils.jsonContainsAll(jSONObject, set)) {
                                    return intValue;
                                }
                            }
                        }
                        if (value.mEventParamKeyValueMap != null && !value.mEventParamKeyValueMap.isEmpty() && value.mEventParamKeyValueMap.containsKey(str) && (list = value.mEventParamKeyValueMap.get(str)) != null && !list.isEmpty()) {
                            for (Map<String, Object> map3 : list) {
                                if (map3 != null && !map3.isEmpty() && JsonUtils.jsonContainsAll(jSONObject, map3.keySet())) {
                                    for (Map.Entry<String, Object> entry2 : map3.entrySet()) {
                                        String key = entry2.getKey();
                                        Object value2 = entry2.getValue();
                                        if (TextUtils.isEmpty(key) || value2 == null || !value2.equals(jSONObject.opt(key))) {
                                            z = false;
                                            break;
                                        }
                                    }
                                    z = true;
                                    if (z) {
                                        return intValue;
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            } catch (JSONException e) {
                LoggerImpl.global().error("Cannot parse event params", e, new Object[0]);
            }
        }
        return -1;
    }

    public EventPriorityItem getEventPriorityItem(int i) {
        Map<Integer, EventPriorityItem> map = this.mPriorityMap;
        if (map != null) {
            return map.get(Integer.valueOf(i));
        }
        return null;
    }

    public void setEventPriorityMap(Map<Integer, EventPriorityItem> map) {
        EventPriorityItem value;
        this.mPriorityMap = map;
        this.priorityEventNames.clear();
        Map<Integer, EventPriorityItem> map2 = this.mPriorityMap;
        if (map2 == null) {
            return;
        }
        for (Map.Entry<Integer, EventPriorityItem> entry : map2.entrySet()) {
            if (-1 != entry.getKey().intValue() && (value = entry.getValue()) != null) {
                if (value.mEventParamKeyMap != null && !value.mEventParamKeyMap.isEmpty()) {
                    this.priorityEventNames.addAll(value.mEventParamKeyMap.keySet());
                }
                if (value.mEventParamKeyValueMap != null && !value.mEventParamKeyValueMap.isEmpty()) {
                    this.priorityEventNames.addAll(value.mEventParamKeyValueMap.keySet());
                }
            }
        }
    }

    public Map<Integer, EventPriorityItem> getEventPriorityItemMap() {
        return this.mPriorityMap;
    }

    private boolean isEventNameMatch(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, Integer> map = this.mEventIndex;
        if (map == null || !map.containsKey(str)) {
            return this.priorityEventNames.contains(str);
        }
        return true;
    }

    public boolean isPreferBatchEventInterval() {
        return this.preferBatchEventInterval;
    }

    public boolean isIntervalChanged(EventPriority eventPriority) {
        EventPriorityItem eventPriorityItem;
        if (eventPriority == null || eventPriority.mBaseInterval != this.mBaseInterval) {
            return true;
        }
        Map<Integer, EventPriorityItem> eventPriorityItemMap = getEventPriorityItemMap();
        Map<Integer, EventPriorityItem> eventPriorityItemMap2 = eventPriority.getEventPriorityItemMap();
        if (eventPriorityItemMap == null || eventPriorityItemMap2 == null || eventPriorityItemMap.size() != eventPriorityItemMap2.size()) {
            return true;
        }
        for (Map.Entry<Integer, EventPriorityItem> entry : eventPriorityItemMap.entrySet()) {
            Integer key = entry.getKey();
            EventPriorityItem value = entry.getValue();
            if (key == null || value == null || !eventPriorityItemMap2.containsKey(key) || (eventPriorityItem = eventPriorityItemMap2.get(key)) == null || value.getEventInterval() != eventPriorityItem.getEventInterval()) {
                return true;
            }
        }
        return false;
    }
}
