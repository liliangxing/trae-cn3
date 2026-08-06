package com.vivo.push.p015f;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.ServiceInfo;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1393t;

/* compiled from: ConfigSecureUtil.java */
/* renamed from: com.vivo.push.f.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1258a {

    /* renamed from: a */
    private volatile Boolean f439a = null;

    /* renamed from: b */
    private volatile Boolean f440b = null;

    /* renamed from: c */
    private synchronized boolean m685c(Context context) {
        if (this.f440b != null) {
            return this.f440b.booleanValue();
        }
        boolean z = true;
        if (context == null) {
            return true;
        }
        boolean m932d = C1366aa.m932d(context, context.getPackageName());
        if (!C1366aa.m931c(context, context.getPackageName()) && !m932d) {
            z = false;
        }
        this.f440b = Boolean.valueOf(z);
        return this.f440b.booleanValue();
    }

    /* renamed from: d */
    private synchronized boolean m686d(Context context) {
        if (this.f439a != null) {
            return this.f439a.booleanValue();
        }
        if (context == null) {
            C1393t.m1046c("ConfigSecureUtil", "checkHasService paramContext is empty ");
            return true;
        }
        try {
            String str = C1366aa.m931c(context, context.getPackageName()) ? "com.vivo.push.sdk.service.CommandClientService" : "com.vivo.push.sdk.service.CommandService";
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                C1393t.m1046c("ConfigSecureUtil", "checkHasService serviceInfos is empty ");
                this.f439a = Boolean.TRUE;
            }
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (str.equals(((ComponentInfo) serviceInfo).name)) {
                    this.f439a = Boolean.TRUE;
                    return this.f439a.booleanValue();
                }
            }
            this.f439a = Boolean.FALSE;
        } catch (Exception e) {
            C1393t.m1034a("ConfigSecureUtil", "checkHasService error " + e.getMessage());
            this.f439a = Boolean.TRUE;
        }
        return this.f439a.booleanValue();
    }

    /* renamed from: a */
    public final synchronized byte[] m687a(Context context) {
        byte[] bArr;
        bArr = new byte[16];
        bArr[0] = 34;
        bArr[1] = 32;
        bArr[2] = 33;
        bArr[3] = 37;
        if (m686d(context)) {
            bArr[4] = 33;
            bArr[5] = 34;
            bArr[6] = 32;
            bArr[7] = 33;
        }
        bArr[8] = 33;
        bArr[9] = 33;
        bArr[10] = 34;
        bArr[11] = 41;
        if (m685c(context)) {
            bArr[12] = 35;
            bArr[13] = 32;
            bArr[14] = 32;
            bArr[15] = 32;
        }
        return bArr;
    }

    /* renamed from: b */
    public final synchronized byte[] m688b(Context context) {
        byte[] bArr;
        bArr = new byte[16];
        bArr[0] = 33;
        bArr[1] = 34;
        bArr[2] = 35;
        bArr[3] = 36;
        if (m686d(context)) {
            bArr[4] = 37;
            bArr[5] = 38;
            bArr[6] = 39;
            bArr[7] = 40;
        }
        bArr[8] = 41;
        bArr[9] = 32;
        bArr[10] = 38;
        bArr[11] = 37;
        if (m685c(context)) {
            bArr[12] = 36;
            bArr[13] = 35;
            bArr[14] = 34;
            bArr[15] = 33;
        }
        return bArr;
    }
}
