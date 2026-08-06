package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.ITaptapService;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.x1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0546x1 {

    /* renamed from: a */
    public final Set<String> f1222a;

    /* renamed from: b */
    public final Set<String> f1223b;

    /* renamed from: c */
    public final Set<String> f1224c;

    /* renamed from: d */
    public final Set<String> f1225d;

    /* renamed from: e */
    public final IKVStore f1226e;

    /* renamed from: f */
    public final IAppLogLogger f1227f;

    public C0546x1(IKVStore iKVStore, IAppLogLogger iAppLogLogger) {
        HashSet hashSet = new HashSet();
        this.f1222a = hashSet;
        HashSet hashSet2 = new HashSet();
        this.f1223b = hashSet2;
        HashSet hashSet3 = new HashSet();
        this.f1224c = hashSet3;
        HashSet hashSet4 = new HashSet();
        this.f1225d = hashSet4;
        this.f1226e = iKVStore;
        this.f1227f = iAppLogLogger;
        Set<String> stringSet = iKVStore.getStringSet("block_events_v1", null);
        if (stringSet != null) {
            hashSet.addAll(stringSet);
        }
        Set<String> stringSet2 = iKVStore.getStringSet("block_events_v3", null);
        if (stringSet2 != null) {
            hashSet2.addAll(stringSet2);
        }
        Set<String> stringSet3 = iKVStore.getStringSet("white_events_v1", null);
        if (stringSet3 != null) {
            hashSet3.addAll(stringSet3);
        }
        Set<String> stringSet4 = iKVStore.getStringSet("white_events_v3", null);
        if (stringSet4 != null) {
            hashSet4.addAll(stringSet4);
        }
    }

    /* renamed from: a */
    public void m741a(List<AbstractC0479n4> list, C0475n0 c0475n0) {
        InterfaceC0526u2 interfaceC0526u2;
        if (list != null && list.size() != 0 && (!this.f1222a.isEmpty() || !this.f1223b.isEmpty())) {
            Iterator<AbstractC0479n4> it = list.iterator();
            while (it.hasNext()) {
                AbstractC0479n4 next = it.next();
                if (next instanceof C0528u4) {
                    if (this.f1223b.contains(((C0528u4) next).f1104u)) {
                        it.remove();
                        this.f1227f.debug("[AppLogEventFilterConfig] filterBlock remove v3 -> " + next, new Object[0]);
                        interfaceC0526u2 = c0475n0.f847q;
                        C0547x2.m744a(interfaceC0526u2, 2L, c0475n0.m552d(), 1002);
                    }
                } else if (next instanceof C0500q4) {
                    JSONObject m579h = next.m579h();
                    if (this.f1222a.contains(m579h.optString("tag") + (!TextUtils.isEmpty(m579h.optString("label")) ? m579h.optString("label") : ""))) {
                        it.remove();
                        this.f1227f.debug("[AppLogEventFilterConfig] filterBlock remove b1 -> " + next, new Object[0]);
                        interfaceC0526u2 = c0475n0.f847q;
                        C0547x2.m744a(interfaceC0526u2, 2L, c0475n0.m552d(), 1002);
                    }
                } else if ((next instanceof C0535v4) && this.f1223b.contains("app_launch")) {
                    it.remove();
                    this.f1227f.debug("[AppLogEventFilterConfig] filterBlock remove launch -> " + next, new Object[0]);
                    interfaceC0526u2 = c0475n0.f847q;
                    C0547x2.m744a(interfaceC0526u2, 2L, c0475n0.m552d(), 1002);
                }
            }
        }
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.f1224c.isEmpty() && this.f1225d.isEmpty()) {
            return;
        }
        Iterator<AbstractC0479n4> it2 = list.iterator();
        while (it2.hasNext()) {
            AbstractC0479n4 next2 = it2.next();
            if (next2 instanceof C0528u4) {
                if (!this.f1225d.contains(((C0528u4) next2).f1104u)) {
                    it2.remove();
                    this.f1227f.debug("[AppLogEventFilterConfig] filterWhite remove v3 -> " + next2, new Object[0]);
                }
            } else if (next2 instanceof C0500q4) {
                JSONObject m579h2 = next2.m579h();
                if (!this.f1224c.contains(m579h2.optString("tag") + (!TextUtils.isEmpty(m579h2.optString("label")) ? m579h2.optString("label") : ""))) {
                    it2.remove();
                    this.f1227f.debug("[AppLogEventFilterConfig] filterWhite remove b1 -> " + next2, new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    public void m742a(Set<String> set, Set<String> set2, Set<String> set3, Set<String> set4, String str, String str2) {
        set.clear();
        set3.clear();
        if (set2 != null) {
            set.addAll(set2);
        }
        this.f1226e.putStringSet(str, set);
        if (set4 != null) {
            set3.addAll(set4);
        }
        this.f1226e.putStringSet(str2, set3);
    }

    /* renamed from: a */
    public final void m743a(JSONObject jSONObject, String str) {
        Set<String> set;
        Set<String> set2;
        String str2;
        String str3;
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        this.f1227f.debug(C0380a.m251a("[AppLogEventFilterConfig] parseEventList filedKey -> ", str), new Object[0]);
        if (optJSONObject == null) {
            if ("blocklist".equals(str)) {
                m742a(this.f1222a, null, this.f1223b, null, "block_events_v1", "block_events_v3");
                return;
            } else {
                if ("whitelist".equals(str)) {
                    m742a(this.f1224c, null, this.f1225d, null, "white_events_v1", "white_events_v3");
                    return;
                }
                return;
            }
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("v1");
        this.f1227f.debug("[AppLogEventFilterConfig] parseEventList v1 -> " + optJSONArray, new Object[0]);
        int length = optJSONArray != null ? optJSONArray.length() : 0;
        HashSet hashSet = new HashSet(length);
        for (int i = 0; i < length; i++) {
            String optString = optJSONArray.optString(i, null);
            if (!TextUtils.isEmpty(optString)) {
                hashSet.add(optString);
            }
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray(ITaptapService.TAPTAP_VERSION_V3);
        this.f1227f.debug("[AppLogEventFilterConfig] parseEventList v3 -> " + optJSONArray2, new Object[0]);
        int length2 = optJSONArray2 != null ? optJSONArray2.length() : 0;
        HashSet hashSet2 = new HashSet(length2);
        for (int i2 = 0; i2 < length2; i2++) {
            String optString2 = optJSONArray2.optString(i2, null);
            if (!TextUtils.isEmpty(optString2)) {
                hashSet2.add(optString2);
            }
        }
        if ("blocklist".equals(str)) {
            set = this.f1222a;
            set2 = this.f1223b;
            str2 = "block_events_v1";
            str3 = "block_events_v3";
        } else {
            if (!"whitelist".equals(str)) {
                return;
            }
            set = this.f1224c;
            set2 = this.f1225d;
            str2 = "white_events_v1";
            str3 = "white_events_v3";
        }
        m742a(set, hashSet, set2, hashSet2, str2, str3);
    }
}
