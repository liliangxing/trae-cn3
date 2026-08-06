package com.bytedance.applog.sampling;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventSamplingLoader {
    public static final String DEFAULT_SP_NAME = "sampling_list";
    public static final String KEY_SAMPLING_ITEM_ARRAY = "samplings";
    private static final String KEY_SAMPLING_ITEM_EVENTS = "events";
    private static final String KEY_SAMPLING_ITEM_METHOD = "sampling_method";
    private static final String KEY_SAMPLING_ITEM_PARAM_KEYS = "param_keys";
    private static final String KEY_SAMPLING_ITEM_PARAM_KEY_VALUES = "param_key_values";
    public static final String KEY_SAMPLING_ITEM_RATE = "sampling_rate";
    public static final String KEY_SAMPLING_LIST = "sampling_list";
    public static final String KEY_SAMPLING_LIST_VERSION = "event_sampling_version";
    private static final String TAG = "EventSamplingLoader";

    public static EventSampling parseEventSamplingFromJson(Context context, String str, JSONObject jSONObject, EventSampling eventSampling) {
        if (jSONObject == null) {
            return eventSampling;
        }
        try {
            EventSampling eventSampling2 = new EventSampling();
            eventSampling2.setSamplingVersion(jSONObject.optInt(KEY_SAMPLING_LIST_VERSION, 0));
            eventSampling2.setCapability(jSONObject.optInt(EventSampling.KEY_SAMPLING_CAPABILITY, 0));
            eventSampling2.setConfigIdArray(jSONObject.optJSONArray(EventSampling.KEY_CONFIG_IDS));
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_SAMPLING_ITEM_ARRAY);
            loadSamplingMapFromJsonArray(eventSampling2, optJSONArray);
            if (TextUtils.isEmpty(str)) {
                str = "sampling_list";
            }
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(EventSampling.KEY_SAMPLING_CAPABILITY, eventSampling2.getCapability());
            edit.putInt("version", eventSampling2.getSamplingVersion());
            if (optJSONArray != null) {
                edit.putString(KEY_SAMPLING_ITEM_ARRAY, optJSONArray.toString());
            }
            if (eventSampling2.getConfigIdArray() != null) {
                edit.putString(EventSampling.KEY_CONFIG_IDS, eventSampling2.getConfigIdArray().toString());
            }
            edit.apply();
            return eventSampling2;
        } catch (Throwable th) {
            LoggerImpl.global().error(12, "parseEventSamplingFromServer", th, new Object[0]);
            return eventSampling;
        }
    }

    public static EventSampling parseEventSamplingFromLocal(Context context, String str) {
        EventSampling eventSampling = new EventSampling();
        if (TextUtils.isEmpty(str)) {
            str = "sampling_list";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        eventSampling.setSamplingVersion(sharedPreferences.getInt("version", 0));
        eventSampling.setCapability(sharedPreferences.getInt(EventSampling.KEY_SAMPLING_CAPABILITY, 0));
        String string = sharedPreferences.getString(EventSampling.KEY_CONFIG_IDS, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                eventSampling.setConfigIdArray(new JSONArray(string));
            } catch (Throwable th) {
                LoggerImpl.global().error(12, "parseEventSamplingFromLocal config ids error", th, new Object[0]);
            }
        }
        String string2 = sharedPreferences.getString(KEY_SAMPLING_ITEM_ARRAY, null);
        if (!TextUtils.isEmpty(string2)) {
            try {
                loadSamplingMapFromJsonArray(eventSampling, new JSONArray(string2));
            } catch (Throwable th2) {
                LoggerImpl.global().error(12, "parseEventSamplingFromLocal sampling config", th2, new Object[0]);
            }
        }
        return eventSampling;
    }

    private static void loadSamplingMapFromJsonArray(EventSampling eventSampling, JSONArray jSONArray) {
        int optInt;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONArray jSONArray2 = jSONArray;
        if (jSONArray2 == null || jSONArray.length() <= 0) {
            return;
        }
        eventSampling.setConfigJson(jSONArray);
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                if (optJSONObject != null && (optInt = optJSONObject.optInt(KEY_SAMPLING_ITEM_RATE)) < 10000) {
                    int optInt2 = optJSONObject.optInt(KEY_SAMPLING_ITEM_METHOD);
                    HashSet hashSet = new HashSet();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("events");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            String optString = optJSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString)) {
                                hashSet.add(optString);
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(KEY_SAMPLING_ITEM_PARAM_KEYS);
                    if (optJSONObject2 != null) {
                        Iterator<String> keys = optJSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray(next);
                                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                        JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i3);
                                        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                            HashSet hashSet2 = new HashSet();
                                            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                                String optString2 = optJSONArray3.optString(i4);
                                                if (!TextUtils.isEmpty(optString2)) {
                                                    hashSet2.add(optString2);
                                                }
                                            }
                                            arrayList.add(hashSet2);
                                        }
                                    }
                                    hashMap.put(next, arrayList);
                                }
                            }
                        }
                    }
                    HashMap hashMap2 = new HashMap();
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject(KEY_SAMPLING_ITEM_PARAM_KEY_VALUES);
                    if (optJSONObject3 != null) {
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
                                            HashMap hashMap3 = new HashMap();
                                            Iterator<String> keys3 = optJSONObject4.keys();
                                            while (keys3.hasNext()) {
                                                String next3 = keys3.next();
                                                if (TextUtils.isEmpty(next3)) {
                                                    jSONObject3 = optJSONObject3;
                                                } else {
                                                    jSONObject3 = optJSONObject3;
                                                    Object opt = optJSONObject4.opt(next3);
                                                    if (opt != null) {
                                                        hashMap3.put(next3, opt);
                                                    }
                                                }
                                                optJSONObject3 = jSONObject3;
                                            }
                                            jSONObject2 = optJSONObject3;
                                            arrayList2.add(hashMap3);
                                        } else {
                                            jSONObject2 = optJSONObject3;
                                        }
                                        i5++;
                                        optJSONObject3 = jSONObject2;
                                    }
                                    jSONObject = optJSONObject3;
                                    hashMap2.put(next2, arrayList2);
                                }
                                optJSONObject3 = jSONObject;
                            }
                        }
                    }
                    eventSampling.addSamplingStrategy(optInt, optInt2, hashSet, hashMap, hashMap2);
                }
                i++;
                jSONArray2 = jSONArray;
            } catch (Throwable th) {
                LoggerImpl.global().error(12, "loadSamplingMapFromJsonArray error", th, new Object[0]);
                return;
            }
        }
    }
}
