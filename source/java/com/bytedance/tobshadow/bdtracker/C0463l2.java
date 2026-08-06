package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.l2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0463l2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final Context f737e;

    public C0463l2(Context context) {
        super(true, true);
        this.f737e = context;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "Net";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        C0421f2.m398a(jSONObject, "access", C0501q5.m622a(this.f737e, true));
        return true;
    }
}
