package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.vivo.push.p015f.C1258a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SharePreferenceManager.java */
/* renamed from: com.vivo.push.util.ad */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1369ad extends C1376c {

    /* renamed from: b */
    private static C1369ad f652b;

    /* renamed from: d */
    private static C1258a f653d;

    /* renamed from: c */
    private Map<String, byte[]> f654c = new ConcurrentHashMap();

    /* renamed from: c */
    public static synchronized C1369ad m941c() {
        C1369ad c1369ad;
        synchronized (C1369ad.class) {
            if (f652b == null) {
                f652b = new C1369ad();
            }
            if (f653d == null) {
                f653d = new C1258a();
            }
            c1369ad = f652b;
        }
        return c1369ad;
    }

    /* renamed from: a */
    public final synchronized void m944a(Context context) {
        if (this.f682a == null) {
            this.f682a = context;
            m982a(context, "com.vivo.push_preferences");
            List<String> m943e = m943e("local_iv");
            if (m943e != null && m943e.size() >= 4) {
                this.f654c.put("com.vivo.push.a", m942d(m943e.get(1)));
                this.f654c.put("com.vivo.push.b", m942d(m943e.get(2)));
                this.f654c.put("com.vivo.push.c", m942d(m943e.get(3)));
                this.f654c.put("com.vivo.push.d", m942d(m943e.get(0)));
                m940b(this.f682a);
            }
            C1393t.m1034a("SharePreferenceManager", " initSecureCode error list is null ");
            m940b(this.f682a);
        }
    }

    /* renamed from: d */
    public final byte[] m945d() {
        byte[] bArr = this.f654c.get("com.vivo.push.c");
        return (bArr == null || bArr.length <= 0) ? f653d.m687a(this.f682a) : bArr;
    }

    /* renamed from: e */
    public final byte[] m946e() {
        byte[] bArr = this.f654c.get("com.vivo.push.d");
        return (bArr == null || bArr.length <= 0) ? f653d.m688b(this.f682a) : bArr;
    }

    /* renamed from: d */
    private static byte[] m942d(String str) {
        int i;
        byte[] bArr = null;
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length > 0) {
                bArr = new byte[split.length];
                i = split.length;
            } else {
                i = 0;
            }
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = Byte.parseByte(split[i2].trim());
            }
        } catch (Exception e) {
            C1393t.m1034a("SharePreferenceManager", "getCodeBytes error:" + e.getMessage());
        }
        return bArr;
    }

    /* renamed from: e */
    private List<String> m943e(String str) {
        Object m954a;
        String[] split;
        if (this.f682a == null) {
            C1393t.m1046c("SharePreferenceManager", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            m954a = C1373ah.m954a(this.f682a, this.f682a.getPackageName(), str);
        } catch (Exception e) {
            C1393t.m1046c("SharePreferenceManager", " parsLocalIv error e =" + e.getMessage());
        }
        if (m954a == null) {
            return null;
        }
        String str2 = new String(Base64.decode(m954a.toString(), 2));
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",#@")) != null && split.length >= 4) {
            for (String str3 : split) {
                arrayList.add(str3.replace(",#@", ""));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
        }
        return null;
    }

    /* renamed from: b */
    private synchronized void m940b(Context context) {
        if (!m991b(CloudControlInf.DATA_CLEAR) && context != null) {
            Iterator<Map.Entry<String, ?>> it = m981a().getAll().entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!TextUtils.isEmpty(key) && (key.contains("_sub_") || key.contains("_cache_"))) {
                    m992c(key);
                }
            }
            C1393t.m1046c("SharePreferenceManager", " old data clear ");
            m983a(CloudControlInf.DATA_CLEAR);
        }
    }
}
