package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.b2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0391b2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final C0407d2 f468e;

    public C0391b2(C0407d2 c0407d2) {
        super(true, false);
        this.f468e = c0407d2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "Cdid";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        String m302a = C0404d.m302a(this.f468e.f505f);
        if (TextUtils.isEmpty(m302a)) {
            return false;
        }
        jSONObject.put("cdid", m302a);
        return true;
    }
}
