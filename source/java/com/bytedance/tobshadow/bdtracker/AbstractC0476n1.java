package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.n1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbstractC0476n1 {

    /* renamed from: a */
    public HashSet<String> f863a;

    /* renamed from: b */
    public HashMap<String, HashSet<String>> f864b;

    public AbstractC0476n1(HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        this.f863a = hashSet;
        this.f864b = hashMap;
    }

    /* renamed from: a */
    public static AbstractC0476n1 m562a(Context context, String str, JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            IKVStore m438a = C0424f5.m438a(context, str);
            m438a.clear();
            if (jSONObject == null || !jSONObject.has("event_list") || (optJSONObject = jSONObject.optJSONObject("event_list")) == null) {
                return null;
            }
            int optInt = optJSONObject.optInt("is_block", 0);
            m438a.putInt("is_block", optInt);
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
                m438a.putStringSet("events", hashSet);
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
                    m438a.putStringSet((String) entry.getKey(), (Set) entry.getValue());
                }
            }
            return optInt > 0 ? new C0490p1(hashSet, hashMap) : new C0483o1(hashSet, hashMap);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public abstract boolean mo563a(String str);

    /* renamed from: a */
    public final boolean m564a(String str, String str2) {
        JSONObject jSONObject;
        HashMap<String, HashSet<String>> hashMap;
        HashSet<String> hashSet;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashSet<String> hashSet2 = this.f863a;
        if (hashSet2 != null && hashSet2.size() > 0) {
            if (mo563a(str)) {
                return false;
            }
            if (TextUtils.isEmpty(str2)) {
                return true;
            }
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            if (jSONObject != null && (hashMap = this.f864b) != null && hashMap.size() > 0 && this.f864b.containsKey(str) && (hashSet = this.f864b.get(str)) != null && hashSet.size() > 0) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    if (mo565a(hashSet, keys.next())) {
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

    /* renamed from: a */
    public abstract boolean mo565a(HashSet<String> hashSet, String str);
}
