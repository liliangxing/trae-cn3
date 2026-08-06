package com.bytedance.applog.sampling;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class AbsSamplingStrategy {
    public static final int MAX_SAMPLING_RATE = 10000;
    public static final int MIN_SAMPLING_RATE = 0;
    private final Map<String, List<Set<String>>> mSamplingEventParamKeyMap;
    private final Map<String, List<Map<String, Object>>> mSamplingEventParamKeyValueMap;
    private final Set<String> mSamplingEventSet;
    final int mSamplingRate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isHitSamplingDrop(AbsSamplingUser absSamplingUser);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsSamplingStrategy(int i, Set<String> set, Map<String, List<Set<String>>> map, Map<String, List<Map<String, Object>>> map2) {
        this.mSamplingRate = i;
        this.mSamplingEventSet = set;
        this.mSamplingEventParamKeyMap = map;
        this.mSamplingEventParamKeyValueMap = map2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int checkSamplingRate() {
        int i = this.mSamplingRate;
        if (i <= 0) {
            return -1;
        }
        return i >= 10000 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isEventMatch(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Set<String> set = this.mSamplingEventSet;
        if (set != null && set.contains(str)) {
            return true;
        }
        if (jSONObject == null) {
            return false;
        }
        return isEventMatchWithJsonParams(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isEventMatchString(String str, String str2) {
        Map<String, List<Map<String, Object>>> map;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Set<String> set = this.mSamplingEventSet;
        if (set != null && set.contains(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        Map<String, List<Set<String>>> map2 = this.mSamplingEventParamKeyMap;
        if ((map2 != null && map2.containsKey(str)) || ((map = this.mSamplingEventParamKeyValueMap) != null && map.containsKey(str))) {
            try {
                return isEventMatchWithJsonParams(str, new JSONObject(str2));
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private boolean isEventMatchWithJsonParams(String str, JSONObject jSONObject) {
        List<Map<String, Object>> list;
        boolean z;
        List<Set<String>> list2;
        Map<String, List<Set<String>>> map = this.mSamplingEventParamKeyMap;
        if (map != null && map.containsKey(str) && (list2 = this.mSamplingEventParamKeyMap.get(str)) != null && !list2.isEmpty()) {
            for (Set<String> set : list2) {
                if (set != null && !set.isEmpty() && jsonContainsAll(jSONObject, set)) {
                    return true;
                }
            }
        }
        Map<String, List<Map<String, Object>>> map2 = this.mSamplingEventParamKeyValueMap;
        if (map2 != null && map2.containsKey(str) && (list = this.mSamplingEventParamKeyValueMap.get(str)) != null && !list.isEmpty()) {
            for (Map<String, Object> map3 : list) {
                if (map3 != null && !map3.isEmpty() && jsonContainsAll(jSONObject, map3.keySet())) {
                    for (Map.Entry<String, Object> entry : map3.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (TextUtils.isEmpty(key) || value == null || !value.equals(jSONObject.opt(key))) {
                            z = false;
                            break;
                        }
                    }
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean jsonContainsAll(JSONObject jSONObject, Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (!jSONObject.has(it.next())) {
                return false;
            }
        }
        return true;
    }
}
