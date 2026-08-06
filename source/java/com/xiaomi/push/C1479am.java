package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.pushmanager.PushCommonConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.util.Map;

/* renamed from: com.xiaomi.push.am */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1479am implements InterfaceC1474ah {

    /* renamed from: a */
    private static volatile C1479am f982a;

    /* renamed from: a */
    private int f983a = C1478al.f981a;

    /* renamed from: a */
    private InterfaceC1474ah f984a;

    /* renamed from: a */
    private String m1502a(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a */
    public void m1503a() {
    }

    /* renamed from: b */
    public String m1505b() {
        return null;
    }

    /* renamed from: c */
    public String m1506c() {
        return null;
    }

    /* renamed from: d */
    public String m1507d() {
        return null;
    }

    private C1479am(Context context) {
        this.f984a = C1478al.m1500a(context);
        AbstractC1417b.m1089a("create id manager is: " + this.f983a);
    }

    /* renamed from: a */
    public static C1479am m1501a(Context context) {
        if (f982a == null) {
            synchronized (C1479am.class) {
                if (f982a == null) {
                    f982a = new C1479am(context.getApplicationContext());
                }
            }
        }
        return f982a;
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public boolean mo1483a() {
        return this.f984a.mo1483a();
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public String mo1482a() {
        return m1502a(this.f984a.mo1482a());
    }

    /* renamed from: a */
    public void m1504a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String m1505b = m1505b();
        if (!TextUtils.isEmpty(m1505b)) {
            map.put("udid", m1505b);
        }
        String mo1482a = mo1482a();
        if (!TextUtils.isEmpty(mo1482a)) {
            map.put(PushCommonConstants.KEY_OAID, mo1482a);
        }
        String m1506c = m1506c();
        if (!TextUtils.isEmpty(m1506c)) {
            map.put("vaid", m1506c);
        }
        String m1507d = m1507d();
        if (!TextUtils.isEmpty(m1507d)) {
            map.put("aaid", m1507d);
        }
        map.put("oaid_type", String.valueOf(this.f983a));
    }
}
