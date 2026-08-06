package com.bytedance.applog.priority;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.applog.throttle.BackoffController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventPriorityLoader {
    public static final String KEY_APPLOG_PRIORITY = "applog_priority";
    public static final String KEY_EVENT_PRIORITY_LIST = "priority_list";
    private static final String KEY_ITEM_EVENTS = "events";
    private static final String KEY_ITEM_INTERVAL_MULTIPLE = "interval_multiple";
    private static final String KEY_ITEM_PARAM_KEYS = "param_keys";
    private static final String KEY_ITEM_PARAM_KEY_VALUES = "param_key_values";
    public static final String KEY_ITEM_PRIORITY = "priority";
    private static final String KEY_ITEM_REPORT_HOST = "report_host";
    private static final String KEY_ITEM_REPORT_PATH = "report_path";
    public static final String KEY_PACK_PRIORITY_ENABLE = "enable";
    public static final String KEY_PACK_PRIORITY_VALUE = "value";
    public static final String KEY_PACK_PRIORITY_VERSION = "version";
    public static final String KEY_PREFER_BATCH_EVENT_INTERVAL = "prefer_batch_event_interval";
    private static final String KEY_PRIORITY_ARRAY = "priorities";
    private static final String KEY_PRIORITY_BASE_INTERVAL = "base_interval";
    private static final String KEY_PRIORITY_REQUEST_CONFIG = "priority_request_config";
    public static final String KEY_PRIORITY_VERSION = "priority_version";
    private static final List<String> logTags = Collections.singletonList("EventPriorityLoader");

    public static void parseEventPriorityFromServer(AppLogInstance appLogInstance, ConfigManager configManager, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(KEY_EVENT_PRIORITY_LIST);
        if (optJSONObject != null) {
            try {
                EventPriority eventPriority = new EventPriority();
                boolean z = true;
                if (optJSONObject.optInt(KEY_PREFER_BATCH_EVENT_INTERVAL, 0) != 1) {
                    z = false;
                }
                eventPriority.preferBatchEventInterval = z;
                eventPriority.mPriorityVersion = optJSONObject.optInt(KEY_PRIORITY_VERSION, 0);
                eventPriority.mBaseInterval = optJSONObject.optInt(KEY_PRIORITY_BASE_INTERVAL, 5);
                JSONArray optJSONArray = optJSONObject.optJSONArray(KEY_PRIORITY_ARRAY);
                parsePriorityMapFromJsonArray(appLogInstance, configManager, eventPriority, optJSONArray);
                if (eventPriority.isValid()) {
                    configManager.setEventPriority(eventPriority);
                    SharedPreferences.Editor edit = configManager.getContext().getSharedPreferences(getPrioritySpName(appLogInstance), 0).edit();
                    edit.putInt(KEY_PRIORITY_VERSION, eventPriority.mPriorityVersion);
                    edit.putInt(KEY_PRIORITY_BASE_INTERVAL, eventPriority.mBaseInterval);
                    edit.putString(KEY_PRIORITY_ARRAY, optJSONArray.toString());
                    edit.apply();
                }
            } catch (Throwable th) {
                appLogInstance.getLogger().error(logTags, "parseEventPriorityFromServer", th, new Object[0]);
            }
        }
    }

    public static EventPriority parseEventPriorityFromLocal(AppLogInstance appLogInstance, ConfigManager configManager) {
        SharedPreferences sharedPreferences = configManager.getContext().getSharedPreferences(getPrioritySpName(appLogInstance), 0);
        int i = sharedPreferences.getInt(KEY_PRIORITY_VERSION, -1);
        if (i == -1) {
            return null;
        }
        EventPriority eventPriority = new EventPriority();
        eventPriority.mPriorityVersion = i;
        eventPriority.mBaseInterval = sharedPreferences.getInt(KEY_PRIORITY_BASE_INTERVAL, 5);
        String string = sharedPreferences.getString(KEY_PRIORITY_ARRAY, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                parsePriorityMapFromJsonArray(appLogInstance, configManager, eventPriority, new JSONArray(string));
            } catch (JSONException e) {
                appLogInstance.getLogger().error(logTags, "parseEventPriorityFromLocal failed", e, new Object[0]);
            }
        }
        return eventPriority;
    }

    private static void parsePriorityMapFromJsonArray(AppLogInstance appLogInstance, ConfigManager configManager, EventPriority eventPriority, JSONArray jSONArray) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONArray jSONArray2 = jSONArray;
        HashMap hashMap = new HashMap();
        eventPriority.mEventIndex = new HashMap();
        if (jSONArray2 == null || jSONArray.length() <= 0) {
            return;
        }
        eventPriority.setPriorityJson(jSONArray);
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                if (optJSONObject != null) {
                    EventPriorityItem eventPriorityItem = new EventPriorityItem();
                    eventPriorityItem.mPriority = optJSONObject.optInt("priority");
                    if (eventPriorityItem.mPriority > eventPriority.mMaxPriority) {
                        eventPriority.mMaxPriority = eventPriorityItem.mPriority;
                    }
                    eventPriorityItem.mPriorityVersion = eventPriority.mPriorityVersion;
                    eventPriorityItem.mIntervalMultiple = optJSONObject.optInt(KEY_ITEM_INTERVAL_MULTIPLE);
                    if (eventPriorityItem.mIntervalMultiple <= 0) {
                        eventPriorityItem.mIntervalMultiple = 1;
                    }
                    eventPriorityItem.mEventInterval = eventPriority.mBaseInterval * eventPriorityItem.mIntervalMultiple * 1000;
                    try {
                        eventPriorityItem.mBackoffController = new BackoffController(appLogInstance, configManager, eventPriorityItem.mEventInterval);
                        eventPriorityItem.mReportHost = optJSONObject.optString(KEY_ITEM_REPORT_HOST);
                        eventPriorityItem.mReportPath = optJSONObject.optString(KEY_ITEM_REPORT_PATH);
                        JSONArray optJSONArray = optJSONObject.optJSONArray("events");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                String optString = optJSONArray.optString(i2);
                                if (!TextUtils.isEmpty(optString)) {
                                    eventPriority.mEventIndex.put(optString, Integer.valueOf(eventPriorityItem.mPriority));
                                }
                            }
                        }
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(KEY_ITEM_PARAM_KEYS);
                        if (optJSONObject2 != null) {
                            eventPriorityItem.mEventParamKeyMap = new HashMap();
                            Iterator<String> keys = optJSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                if (!TextUtils.isEmpty(next)) {
                                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray(next);
                                    if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                                        jSONObject4 = optJSONObject2;
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        int i3 = 0;
                                        while (i3 < optJSONArray2.length()) {
                                            JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i3);
                                            if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                                                jSONObject5 = optJSONObject2;
                                            } else {
                                                HashSet hashSet = new HashSet();
                                                jSONObject5 = optJSONObject2;
                                                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                                    String optString2 = optJSONArray3.optString(i4);
                                                    if (!TextUtils.isEmpty(optString2)) {
                                                        hashSet.add(optString2);
                                                    }
                                                }
                                                arrayList.add(hashSet);
                                            }
                                            i3++;
                                            optJSONObject2 = jSONObject5;
                                        }
                                        jSONObject4 = optJSONObject2;
                                        eventPriorityItem.mEventParamKeyMap.put(next, arrayList);
                                    }
                                    optJSONObject2 = jSONObject4;
                                }
                            }
                        }
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject(KEY_ITEM_PARAM_KEY_VALUES);
                        if (optJSONObject3 != null) {
                            eventPriorityItem.mEventParamKeyValueMap = new HashMap();
                            Iterator<String> keys2 = optJSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                if (!TextUtils.isEmpty(next2)) {
                                    JSONArray optJSONArray4 = optJSONObject3.optJSONArray(next2);
                                    if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                                        jSONObject = optJSONObject3;
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        int i5 = 0;
                                        while (i5 < optJSONArray4.length()) {
                                            JSONObject optJSONObject4 = optJSONArray4.optJSONObject(i5);
                                            if (optJSONObject4 != null) {
                                                HashMap hashMap2 = new HashMap();
                                                Iterator<String> keys3 = optJSONObject4.keys();
                                                while (keys3.hasNext()) {
                                                    String next3 = keys3.next();
                                                    if (TextUtils.isEmpty(next3)) {
                                                        jSONObject3 = optJSONObject3;
                                                    } else {
                                                        jSONObject3 = optJSONObject3;
                                                        Object opt = optJSONObject4.opt(next3);
                                                        if (opt != null) {
                                                            hashMap2.put(next3, opt);
                                                        }
                                                    }
                                                    optJSONObject3 = jSONObject3;
                                                }
                                                jSONObject2 = optJSONObject3;
                                                arrayList2.add(hashMap2);
                                            } else {
                                                jSONObject2 = optJSONObject3;
                                            }
                                            i5++;
                                            optJSONObject3 = jSONObject2;
                                        }
                                        jSONObject = optJSONObject3;
                                        eventPriorityItem.mEventParamKeyValueMap.put(next2, arrayList2);
                                    }
                                    optJSONObject3 = jSONObject;
                                }
                            }
                        }
                        hashMap.put(Integer.valueOf(eventPriorityItem.mPriority), eventPriorityItem);
                    } catch (Throwable th) {
                        th = th;
                        appLogInstance.getLogger().error(logTags, "parsePriorityMapFromJsonArray failed", th, new Object[0]);
                        return;
                    }
                }
                i++;
                jSONArray2 = jSONArray;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        Iterator<EventPriorityItem> it = hashMap.values().iterator();
        while (it.hasNext()) {
            it.next().mMaxPriority = eventPriority.mMaxPriority;
        }
        eventPriority.setEventPriorityMap(hashMap);
    }

    public static void parsePriorityRequestConfigFromResp(JSONObject jSONObject, EventPriority eventPriority) {
        JSONArray optJSONArray;
        EventPriorityItem eventPriorityItem;
        if (eventPriority == null || (optJSONArray = jSONObject.optJSONArray(KEY_PRIORITY_REQUEST_CONFIG)) == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null && (eventPriorityItem = eventPriority.getEventPriorityItem(optJSONObject.optInt("priority"))) != null) {
                eventPriorityItem.mBackoffController.parseBackoffControllerFromResp(optJSONObject, eventPriorityItem.getEventInterval(), eventPriorityItem);
            }
        }
    }

    private static String getPrioritySpName(AppLogInstance appLogInstance) {
        return AppLogHelper.getInstanceSpName(appLogInstance, KEY_EVENT_PRIORITY_LIST);
    }
}
