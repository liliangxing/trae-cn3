package com.bytedance.tobshadow.bdtracker;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tobshadow.bdtracker.C0453k;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.c0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0397c0 implements C0453k.f {

    /* renamed from: a */
    public final /* synthetic */ C0549x4 f477a;

    public C0397c0(C0549x4 c0549x4) {
        this.f477a = c0549x4;
    }

    @Override // com.bytedance.tobshadow.bdtracker.C0453k.f
    /* renamed from: a */
    public AbstractC0479n4 mo250a() {
        JSONObject optJSONObject = ((C0549x4) this.f477a.m1094clone()).m579h().optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        optJSONObject.remove(ReportConstant.COMMON_INIT_DURATION);
        C0528u4 c0528u4 = new C0528u4("bav2b_page");
        c0528u4.m573a(0L);
        c0528u4.f884o = optJSONObject;
        return c0528u4;
    }
}
