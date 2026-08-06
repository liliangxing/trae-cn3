package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.a2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0383a2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final C0467m f434e;

    public C0383a2(C0467m c0467m) {
        super(true, false);
        this.f434e = c0467m;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "business_conversion_id";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        try {
            m254a("com.bytedance.tobshadow.applog.convert.ClickIdProvider", jSONObject);
        } catch (Throwable th) {
            this.f434e.f764D.debug("ClickId find error", th);
        }
        try {
            m254a("com.bytedance.tobshadow.applog.convert.IPIDProvider", jSONObject);
        } catch (Throwable th2) {
            this.f434e.f764D.debug("IPID find error", th2);
        }
        return true;
    }

    /* renamed from: a */
    public final void m254a(String str, JSONObject jSONObject) {
        Class<?> m367b = C0411e.m367b(str);
        if (m367b == null) {
            this.f434e.f764D.debug("No " + str + " class, get id error", new Object[0]);
            return;
        }
        try {
            Method declaredMethod = m367b.getDeclaredMethod("getIdAndSetIntoJson", JSONObject.class, Context.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(m367b.newInstance(), jSONObject, this.f434e.f785n);
        } catch (Throwable unused) {
        }
    }
}
