package com.bytedance.tobshadow.applog.event;

import com.bytedance.tobshadow.bdtracker.C0380a;
import com.bytedance.tobshadow.bdtracker.C0467m;
import com.bytedance.tobshadow.bdtracker.C0528u4;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class EventBuilder {

    /* renamed from: a */
    public final C0467m f385a;

    /* renamed from: b */
    public String f386b;

    /* renamed from: c */
    public String f387c;

    /* renamed from: d */
    public JSONObject f388d;

    public EventBuilder(C0467m c0467m) {
        this.f385a = c0467m;
    }

    public EventBuilder addParam(String str, Object obj) {
        if (this.f388d == null) {
            this.f388d = new JSONObject();
        }
        try {
            this.f388d.put(str, obj);
        } catch (JSONException unused) {
        }
        return this;
    }

    public C0528u4 build() {
        String str = this.f385a.f784m;
        String str2 = this.f386b;
        JSONObject jSONObject = this.f388d;
        C0528u4 c0528u4 = new C0528u4(str, str2, false, jSONObject != null ? jSONObject.toString() : null, 0);
        c0528u4.f879j = this.f387c;
        this.f385a.f764D.debug(4, "EventBuilder build: {}", c0528u4);
        return c0528u4;
    }

    public EventBuilder setAbSdkVersion(String str) {
        this.f387c = str;
        return this;
    }

    public EventBuilder setEvent(String str) {
        this.f386b = str;
        return this;
    }

    public void track() {
        C0528u4 build = build();
        this.f385a.f764D.debug(4, C0380a.m252a("EventBuilder track: ").append(this.f386b).toString(), new Object[0]);
        this.f385a.receive(build);
    }
}
