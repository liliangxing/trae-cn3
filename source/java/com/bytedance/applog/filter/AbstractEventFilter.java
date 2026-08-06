package com.bytedance.applog.filter;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.log.AbsSingleton;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.keva.Keva;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbstractEventFilter implements IEventFilter {
    private static final String KEY_EVENTS = "events";
    protected static final String KEY_EVENT_LIST = "event_list";
    private static final String KEY_IS_BLOCK = "is_block";
    private static final String KEY_PARAMS = "params";
    public static final String SP_FILTER_NAME = "sp_filter_name";
    private static AbsSingleton<Keva> kevaRepo = new AbsSingleton<Keva>() { // from class: com.bytedance.applog.filter.AbstractEventFilter.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.applog.log.AbsSingleton
        public Keva create(Object... objArr) {
            return Keva.getRepo("applog_server_filter.keva");
        }
    };
    protected final AppLogInstance appLogInstance;
    protected final HashSet<String> mEventSet;
    protected final HashMap<String, HashSet<String>> mParamMap;

    protected abstract boolean interceptEventName(String str);

    protected abstract boolean interceptEventParam(HashSet<String> hashSet, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractEventFilter(AppLogInstance appLogInstance, HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        this.appLogInstance = appLogInstance;
        this.mEventSet = hashSet;
        this.mParamMap = hashMap;
    }

    @Override // com.bytedance.applog.filter.IEventFilter
    public boolean filterAndDiscardEvent(MonitorKey monitorKey, String str, String str2) {
        if (MonitorKey.event_v3.equals(monitorKey)) {
            return !filter(str, str2);
        }
        return false;
    }

    boolean filter(String str, String str2) {
        HashMap<String, HashSet<String>> hashMap;
        HashSet<String> hashSet;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashSet<String> hashSet2 = this.mEventSet;
        if (hashSet2 != null && !hashSet2.isEmpty()) {
            if (interceptEventName(str)) {
                return false;
            }
            if (!TextUtils.isEmpty(str2) && (hashMap = this.mParamMap) != null && !hashMap.isEmpty() && this.mParamMap.containsKey(str) && (hashSet = this.mParamMap.get(str)) != null && !hashSet.isEmpty()) {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (Throwable unused) {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    return true;
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    if (interceptEventParam(hashSet, keys.next())) {
                        try {
                            keys.remove();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        }
        return true;
    }

    public static AbstractEventFilter parseFilterFromServer(AppLogInstance appLogInstance, String str, JSONObject jSONObject) {
        SharedPreferences.Editor edit;
        JSONObject optJSONObject;
        AbstractEventFilter allowEventFilter;
        try {
            boolean isServerFilterSaveToKevaEnabled = appLogInstance.isServerFilterSaveToKevaEnabled();
            if (isServerFilterSaveToKevaEnabled) {
                kevaRepo.get(new Object[0]).clear();
                edit = null;
            } else {
                edit = appLogInstance.getContext().getSharedPreferences(str, 0).edit();
                edit.clear().apply();
            }
            if (jSONObject == null || !jSONObject.has(KEY_EVENT_LIST) || (optJSONObject = jSONObject.optJSONObject(KEY_EVENT_LIST)) == null) {
                return null;
            }
            int optInt = optJSONObject.optInt(KEY_IS_BLOCK, 0);
            if (isServerFilterSaveToKevaEnabled) {
                kevaRepo.get(new Object[0]).storeInt(KEY_IS_BLOCK, optInt);
            } else {
                edit.putInt(KEY_IS_BLOCK, optInt);
            }
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
                if (isServerFilterSaveToKevaEnabled) {
                    kevaRepo.get(new Object[0]).storeStringSetJustDisk("events", hashSet);
                } else {
                    edit.putStringSet("events", hashSet);
                }
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
                    if (isServerFilterSaveToKevaEnabled) {
                        kevaRepo.get(new Object[0]).storeStringSetJustDisk((String) entry.getKey(), (Set) entry.getValue());
                    } else {
                        edit.putStringSet((String) entry.getKey(), (Set) entry.getValue());
                    }
                }
            }
            if (edit != null) {
                edit.apply();
            }
            if (optInt > 0) {
                allowEventFilter = new BlockEventFilter(appLogInstance, hashSet, hashMap);
            } else {
                allowEventFilter = new AllowEventFilter(appLogInstance, hashSet, hashMap);
            }
            return allowEventFilter;
        } catch (Throwable th) {
            appLogInstance.getLogger().error("parseFilterFromServer error: ", th, new Object[0]);
            return null;
        }
    }

    public static NativeFilter parseNativeFilterFromServer(AppLogInstance appLogInstance, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || !jSONObject.has(KEY_EVENT_LIST) || (optJSONObject = jSONObject.optJSONObject(KEY_EVENT_LIST)) == null) {
            return null;
        }
        return new NativeFilter(appLogInstance, optJSONObject, null, null);
    }

    public static void clearNativeServerFilterCache(AppLogInstance appLogInstance) {
        new NativeFilter(appLogInstance, null, null, null).clearCache();
    }

    public static AbstractEventFilter parseFilterFromLocal(AppLogInstance appLogInstance, String str) {
        Map<String, ?> map;
        AbstractEventFilter allowEventFilter;
        Set set;
        Set set2;
        try {
            boolean isServerFilterSaveToKevaEnabled = appLogInstance.isServerFilterSaveToKevaEnabled();
            SharedPreferences sharedPreferences = !isServerFilterSaveToKevaEnabled ? appLogInstance.getContext().getSharedPreferences(str, 0) : null;
            HashSet hashSet = new HashSet();
            HashMap hashMap = new HashMap();
            try {
                if (isServerFilterSaveToKevaEnabled) {
                    map = new HashMap<>();
                    kevaRepo.get(new Object[0]).buildNewMap(map);
                } else {
                    map = sharedPreferences.getAll();
                }
            } catch (Throwable th) {
                appLogInstance.getLogger().error("parseFilterFromLocal getAll error: ", th, new Object[0]);
                map = null;
            }
            if (map != null && map.size() > 0) {
                int i = 0;
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    if (entry != null) {
                        String key = entry.getKey();
                        if (KEY_IS_BLOCK.equals(key)) {
                            if (isServerFilterSaveToKevaEnabled) {
                                i = kevaRepo.get(new Object[0]).getInt(KEY_IS_BLOCK, 0);
                            } else {
                                i = sharedPreferences.getInt(KEY_IS_BLOCK, 0);
                            }
                        } else if ("events".equals(key)) {
                            try {
                                set2 = (Set) entry.getValue();
                            } catch (Throwable unused) {
                                set2 = null;
                            }
                            if (set2 != null && set2.size() > 0) {
                                hashSet.addAll(set2);
                            }
                        } else if (!TextUtils.isEmpty(key)) {
                            HashSet hashSet2 = new HashSet();
                            try {
                                set = (Set) entry.getValue();
                            } catch (Throwable unused2) {
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
                    allowEventFilter = new BlockEventFilter(appLogInstance, hashSet, hashMap);
                } else {
                    allowEventFilter = new AllowEventFilter(appLogInstance, hashSet, hashMap);
                }
                return allowEventFilter;
            }
            return null;
        } catch (Throwable th2) {
            appLogInstance.getLogger().error("parseFilterFromLocal error: ", th2, new Object[0]);
            return null;
        }
    }

    public static AbstractEventFilter parseFilterFromClient(AppLogInstance appLogInstance, List<String> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                if (z) {
                    return new BlockEventFilter(appLogInstance, hashSet, null);
                }
                return new AllowEventFilter(appLogInstance, hashSet, null);
            }
        }
        return null;
    }

    public static NativeFilter parseNativeFilterFromLocal(AppLogInstance appLogInstance) {
        return new NativeFilter(appLogInstance, null, null, null);
    }
}
