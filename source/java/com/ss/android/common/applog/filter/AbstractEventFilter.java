package com.ss.android.common.applog.filter;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class AbstractEventFilter {
    private static final String KEY_EVENTS = "events";
    private static final String KEY_EVENT_LIST = "event_list";
    private static final String KEY_IS_BLOCK = "is_block";
    private static final String KEY_PARAMS = "params";
    private static final String SP_FILTER_NAME = "sp_filter_name";
    protected HashSet<String> mEventSet;
    protected HashMap<String, HashSet<String>> mParamMap;

    protected abstract boolean interceptEventName(String str);

    protected abstract boolean interceptEventParam(HashSet<String> hashSet, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractEventFilter(HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        this.mEventSet = hashSet;
        this.mParamMap = hashMap;
    }

    public final boolean filter(String str, JSONObject jSONObject) {
        HashMap<String, HashSet<String>> hashMap;
        HashSet<String> hashSet;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashSet<String> hashSet2 = this.mEventSet;
        if (hashSet2 != null && hashSet2.size() > 0) {
            if (interceptEventName(str)) {
                return false;
            }
            if (jSONObject != null && (hashMap = this.mParamMap) != null && hashMap.size() > 0 && this.mParamMap.containsKey(str) && (hashSet = this.mParamMap.get(str)) != null && hashSet.size() > 0) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    if (interceptEventParam(hashSet, keys.next())) {
                        try {
                            keys.remove();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return true;
    }

    public static final AbstractEventFilter parseFilterFromServer(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject;
        AbstractEventFilter whiteEventFilter;
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("sp_filter_name", 0).edit();
            edit.clear().commit();
            if (jSONObject == null || !jSONObject.has(KEY_EVENT_LIST) || (optJSONObject = jSONObject.optJSONObject(KEY_EVENT_LIST)) == null) {
                return null;
            }
            int optInt = optJSONObject.optInt(KEY_IS_BLOCK, 0);
            edit.putInt(KEY_IS_BLOCK, optInt);
            HashSet hashSet = new HashSet();
            JSONArray optJSONArray = optJSONObject.optJSONArray("events");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        hashSet.add(optString);
                    }
                }
            }
            if (hashSet.size() > 0) {
                edit.putStringSet("events", hashSet);
            }
            HashMap hashMap = new HashMap();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
            if (optJSONObject2 != null) {
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        HashSet hashSet2 = new HashSet();
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray(next);
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                String optString2 = optJSONArray2.optString(i2);
                                if (!TextUtils.isEmpty(optString2)) {
                                    hashSet2.add(optString2);
                                }
                            }
                        }
                        if (hashSet2.size() > 0) {
                            hashMap.put(next, hashSet2);
                        }
                    }
                }
            }
            if (hashMap.size() > 0) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    edit.putStringSet((String) entry.getKey(), (Set) entry.getValue());
                }
            }
            edit.commit();
            if (optInt > 0) {
                whiteEventFilter = new BlockEventFilter(hashSet, hashMap);
            } else {
                whiteEventFilter = new WhiteEventFilter(hashSet, hashMap);
            }
            return whiteEventFilter;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final AbstractEventFilter parseFilterFromLocal(Context context) {
        Map<String, ?> map;
        AbstractEventFilter whiteEventFilter;
        Set set;
        Set set2;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_filter_name", 0);
            HashSet hashSet = new HashSet();
            HashMap hashMap = new HashMap();
            try {
                map = sharedPreferences.getAll();
            } catch (Throwable unused) {
                map = null;
            }
            if (map != null && map.size() > 0) {
                int i = 0;
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    if (entry != null) {
                        String key = entry.getKey();
                        if (KEY_IS_BLOCK.equals(key)) {
                            i = sharedPreferences.getInt(KEY_IS_BLOCK, 0);
                        } else if ("events".equals(key)) {
                            try {
                                set2 = (Set) entry.getValue();
                            } catch (Throwable unused2) {
                                set2 = null;
                            }
                            if (set2 != null && set2.size() > 0) {
                                hashSet.addAll(set2);
                            }
                        } else if (!TextUtils.isEmpty(key)) {
                            HashSet hashSet2 = new HashSet();
                            try {
                                set = (Set) entry.getValue();
                            } catch (Throwable unused3) {
                                set = null;
                            }
                            if (set != null && set.size() > 0) {
                                hashSet2.addAll(set);
                            }
                            if (hashSet2.size() > 0) {
                                hashMap.put(key, hashSet2);
                            }
                        }
                    }
                }
                if (i > 0) {
                    whiteEventFilter = new BlockEventFilter(hashSet, hashMap);
                } else {
                    whiteEventFilter = new WhiteEventFilter(hashSet, hashMap);
                }
                return whiteEventFilter;
            }
            return null;
        } catch (Throwable unused4) {
            return null;
        }
    }

    public static final AbstractEventFilter parseFilterFromClient(List<String> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                if (z) {
                    return new BlockEventFilter(hashSet, null);
                }
                return new WhiteEventFilter(hashSet, null);
            }
        }
        return null;
    }
}
