package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.log.EventBus;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.e2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0414e2 implements EventBus.DataFetcher {

    /* renamed from: a */
    public final /* synthetic */ JSONObject f554a;

    /* renamed from: b */
    public final /* synthetic */ C0407d2 f555b;

    public C0414e2(C0407d2 c0407d2, JSONObject jSONObject) {
        this.f555b = c0407d2;
        this.f554a = jSONObject;
    }

    @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
    public Object fetch() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        C0411e.m375c(this.f554a, jSONObject2);
        try {
            jSONObject.put("appId", this.f555b.f501b.f784m);
            jSONObject.put("config", jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
