package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.C0453k;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.e0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0412e0 implements C0453k.f {

    /* renamed from: a */
    public final /* synthetic */ C0549x4 f539a;

    public C0412e0(C0549x4 c0549x4) {
        this.f539a = c0549x4;
    }

    @Override // com.bytedance.tobshadow.bdtracker.C0453k.f
    /* renamed from: a */
    public AbstractC0479n4 mo250a() {
        C0549x4 c0549x4 = (C0549x4) this.f539a.m1094clone();
        JSONObject optJSONObject = c0549x4.m579h().optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        try {
            optJSONObject.put("$page_duration", c0549x4.f1241s);
        } catch (Throwable th) {
            LoggerImpl.global().error("[Navigator] JSON handle failed", th, new Object[0]);
        }
        C0528u4 c0528u4 = new C0528u4("$bav2b_page_leave");
        c0528u4.m573a(0L);
        c0528u4.f884o = optJSONObject;
        return c0528u4;
    }
}
