package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import com.bytedance.tobshadow.applog.util.HardwareUtils;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.g2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0428g2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final Context f631e;

    /* renamed from: f */
    public final C0421f2 f632f;

    /* renamed from: g */
    public final C0407d2 f633g;

    public C0428g2(Context context, C0407d2 c0407d2, C0421f2 c0421f2) {
        super(false, false);
        this.f631e = context;
        this.f632f = c0421f2;
        this.f633g = c0407d2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "DeviceParams";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        if (this.f633g.m326m()) {
            String operatorName = HardwareUtils.getOperatorName(this.f631e);
            if (C0411e.m379d(operatorName)) {
                C0421f2.m398a(jSONObject, "carrier", operatorName);
            }
        }
        C0421f2.m398a(jSONObject, "clientudid", this.f632f.f591h.m508a());
        C0421f2.m398a(jSONObject, "openudid", this.f632f.f591h.m514c());
        return true;
    }
}
