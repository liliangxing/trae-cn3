package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import com.bytedance.tobshadow.applog.util.HardwareUtils;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.s2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0512s2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final Context f1015e;

    /* renamed from: f */
    public final C0407d2 f1016f;

    public C0512s2(C0407d2 c0407d2, Context context) {
        super(true, false);
        this.f1015e = context;
        this.f1016f = c0407d2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "SimCountry";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        if (!this.f1016f.m326m()) {
            return true;
        }
        C0421f2.m398a(jSONObject, "sim_region", HardwareUtils.getSimCountryIso(this.f1015e));
        return true;
    }
}
