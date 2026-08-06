package com.cmic.sso.sdk.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.SubscriptionManager;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.m;

/* compiled from: UMCTelephonyManagement.java */
/* loaded from: classes6.dex */
public class a {
    private static a a;
    private static long b;
    private C0133a c = null;

    /* compiled from: UMCTelephonyManagement.java */
    /* renamed from: com.cmic.sso.sdk.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0133a {
        private int a = -1;
        private int b = -1;

        public int a() {
            return this.b;
        }
    }

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public C0133a b() {
        C0133a c0133a = this.c;
        return c0133a == null ? new C0133a() : c0133a;
    }

    public void a(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis() - b;
        if (currentTimeMillis >= 5000 || currentTimeMillis <= 0) {
            this.c = new C0133a();
            if (z) {
                a(context);
                if (m.e() && m.d()) {
                    c.b("UMCTelephonyManagement", "华为手机兼容性处理");
                    if (this.c.b == 0 || this.c.b == 1) {
                        if (this.c.a == -1) {
                            C0133a c0133a = this.c;
                            c0133a.a = c0133a.b;
                        }
                        this.c.b = -1;
                    }
                    if (this.c.a != -1 || this.c.b != -1) {
                        b(context);
                    }
                }
                b = System.currentTimeMillis();
            }
        }
    }

    private void a(Context context) {
        SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
        if (from != null) {
            try {
                if (this.c.a == -1) {
                    this.c.b = SubscriptionManager.getDefaultDataSubscriptionId();
                    c.b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + this.c.b);
                    return;
                }
            } catch (Exception unused) {
                c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
            }
            try {
                Object invoke = from.getClass().getMethod("getDefaultDataSubId", new Class[0]).invoke(from, new Object[0]);
                if ((invoke instanceof Integer) || (invoke instanceof Long)) {
                    this.c.b = ((Integer) invoke).intValue();
                    c.b("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + this.c.b);
                    return;
                }
            } catch (Exception unused2) {
                c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
            }
            try {
                Object invoke2 = from.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(from, new Object[0]);
                if ((invoke2 instanceof Integer) || (invoke2 instanceof Long)) {
                    this.c.b = ((Integer) invoke2).intValue();
                    c.b("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + this.c.b);
                }
            } catch (Exception unused3) {
                c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        if (r11 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
    
        com.cmic.sso.sdk.e.c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
    
        if (r11 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Context context) {
        c.b("UMCTelephonyManagement", "readSimInfoDbStart");
        Uri parse = Uri.parse("content://telephony/siminfo");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(parse, new String[]{"_id", "sim_id"}, "sim_id>=?", new String[]{"0"}, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        int i = cursor.getInt(cursor.getColumnIndex("sim_id"));
                        int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
                        if (this.c.a == -1 && this.c.b != -1 && this.c.b == i2) {
                            this.c.a = i;
                            c.b("UMCTelephonyManagement", "通过读取sim db获取数据流量卡的卡槽值：" + i);
                        }
                        if (this.c.a == i) {
                            this.c.b = i2;
                        }
                    }
                }
            } catch (Exception unused) {
                c.a("UMCTelephonyManagement", "readSimInfoDb error");
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
