package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.C1768az;
import com.xiaomi.push.service.C1770ba;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.gc */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1631gc {

    /* renamed from: a */
    private static volatile C1631gc f1889a;

    /* renamed from: a */
    private final Context f1890a;

    /* renamed from: a */
    private Map<String, InterfaceC1632gd> f1891a = new HashMap();

    /* renamed from: a */
    public static C1631gc m2707a(Context context) {
        if (context == null) {
            AbstractC1417b.m1103d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f1889a == null) {
            synchronized (C1631gc.class) {
                if (f1889a == null) {
                    f1889a = new C1631gc(context);
                }
            }
        }
        return f1889a;
    }

    private C1631gc(Context context) {
        this.f1890a = context;
    }

    /* renamed from: a */
    public void m2710a(InterfaceC1632gd interfaceC1632gd, String str) {
        if (interfaceC1632gd == null) {
            AbstractC1417b.m1103d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            AbstractC1417b.m1103d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m2709a().put(str, interfaceC1632gd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public InterfaceC1632gd m2708a() {
        InterfaceC1632gd interfaceC1632gd = this.f1891a.get("UPLOADER_PUSH_CHANNEL");
        if (interfaceC1632gd != null) {
            return interfaceC1632gd;
        }
        InterfaceC1632gd interfaceC1632gd2 = this.f1891a.get("UPLOADER_HTTP");
        if (interfaceC1632gd2 != null) {
            return interfaceC1632gd2;
        }
        return null;
    }

    /* renamed from: a */
    Map<String, InterfaceC1632gd> m2709a() {
        return this.f1891a;
    }

    /* renamed from: a */
    public boolean m2711a(C1637gi c1637gi, String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC1417b.m1089a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (C1768az.m3794a(c1637gi, false)) {
            return false;
        }
        if (TextUtils.isEmpty(c1637gi.m2747d())) {
            c1637gi.m2752f(C1768az.m3791a());
        }
        c1637gi.m2754g(str);
        C1770ba.m3803a(this.f1890a, c1637gi);
        return true;
    }
}
