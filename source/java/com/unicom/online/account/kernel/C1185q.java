package com.unicom.online.account.kernel;

import org.json.JSONObject;

/* renamed from: com.unicom.online.account.kernel.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1185q {

    /* renamed from: a */
    public InterfaceC1173e f305a = null;

    /* renamed from: a */
    public final void m549a(int i, String str) {
        m550a(i, str, "", "");
    }

    /* renamed from: a */
    public final void m550a(int i, String str, String str2, String str3) {
        try {
            if (this.f305a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", str2);
            jSONObject.put("seq", str3);
            this.f305a.onResult(jSONObject.toString());
            this.f305a = null;
            if (i < 0) {
                C1194z.m574a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
