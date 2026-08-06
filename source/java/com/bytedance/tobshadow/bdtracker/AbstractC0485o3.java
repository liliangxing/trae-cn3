package com.bytedance.tobshadow.bdtracker;

import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.tracing.log.Fields;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.o3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbstractC0485o3 {

    /* renamed from: a */
    public long f891a;

    /* renamed from: b */
    public long f892b;

    /* renamed from: c */
    public volatile boolean f893c;

    /* renamed from: d */
    public final C0467m f894d;

    public AbstractC0485o3(C0467m c0467m) {
        Intrinsics.checkParameterIsNotNull(c0467m, "applog");
        this.f894d = c0467m;
    }

    /* renamed from: a */
    public abstract String mo588a();

    /* renamed from: a */
    public abstract void mo589a(JSONObject jSONObject);

    /* renamed from: b */
    public void mo590b() {
        this.f892b = System.currentTimeMillis();
    }

    /* renamed from: c */
    public JSONObject m591c() {
        JSONObject jSONObject = new JSONObject();
        if (this.f893c) {
            C0467m c0467m = this.f894d;
            try {
                jSONObject.put(Fields.EVENT, "$finder_sdk_monitor");
                jSONObject.put("local_time_ms", System.currentTimeMillis());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(DBData.FIELD_TYPE, mo588a());
                jSONObject2.put("session_id", this.f894d.getSessionId());
                mo589a(jSONObject2);
                jSONObject.put("params", jSONObject2);
            } catch (Throwable th) {
                c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
            }
        }
        return jSONObject;
    }

    /* renamed from: d */
    public void mo592d() {
        this.f891a = System.currentTimeMillis();
    }
}
