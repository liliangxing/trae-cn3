package com.cmic.sso.sdk.p002b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.SubscriptionManager;
import com.bytedance.webx.addr.AddressParam;
import com.cmic.sso.sdk.p009e.C0133c;
import com.cmic.sso.sdk.p009e.C0143m;
import com.heytap.mcssdk.constant.C0878a;

/* compiled from: UMCTelephonyManagement.java */
/* renamed from: com.cmic.sso.sdk.b.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0105a {

    /* renamed from: a */
    private static C0105a f164a;

    /* renamed from: b */
    private static long f165b;

    /* renamed from: c */
    private a f166c = null;

    /* compiled from: UMCTelephonyManagement.java */
    /* renamed from: com.cmic.sso.sdk.b.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class a {

        /* renamed from: a */
        private int f167a = -1;

        /* renamed from: b */
        private int f168b = -1;

        /* renamed from: a */
        public int m179a() {
            return this.f168b;
        }
    }

    private C0105a() {
    }

    /* renamed from: a */
    public static C0105a m170a() {
        if (f164a == null) {
            f164a = new C0105a();
        }
        return f164a;
    }

    /* renamed from: b */
    public a m174b() {
        a aVar = this.f166c;
        return aVar == null ? new a() : aVar;
    }

    /* renamed from: a */
    public void m173a(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis() - f165b;
        if (currentTimeMillis >= C0878a.f532r || currentTimeMillis <= 0) {
            this.f166c = new a();
            if (z) {
                m171a(context);
                if (C0143m.m390e() && C0143m.m389d()) {
                    C0133c.m328b("UMCTelephonyManagement", "华为手机兼容性处理");
                    if (this.f166c.f168b == 0 || this.f166c.f168b == 1) {
                        if (this.f166c.f167a == -1) {
                            a aVar = this.f166c;
                            aVar.f167a = aVar.f168b;
                        }
                        this.f166c.f168b = -1;
                    }
                    if (this.f166c.f167a != -1 || this.f166c.f168b != -1) {
                        m172b(context);
                    }
                }
                f165b = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: a */
    private void m171a(Context context) {
        SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
        if (from != null) {
            try {
                if (this.f166c.f167a == -1) {
                    this.f166c.f168b = SubscriptionManager.getDefaultDataSubscriptionId();
                    C0133c.m328b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + this.f166c.f168b);
                    return;
                }
            } catch (Exception unused) {
                C0133c.m326a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
            }
            try {
                Object invoke = from.getClass().getMethod("getDefaultDataSubId", new Class[0]).invoke(from, new Object[0]);
                if ((invoke instanceof Integer) || (invoke instanceof Long)) {
                    this.f166c.f168b = ((Integer) invoke).intValue();
                    C0133c.m328b("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + this.f166c.f168b);
                    return;
                }
            } catch (Exception unused2) {
                C0133c.m326a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
            }
            try {
                Object invoke2 = from.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(from, new Object[0]);
                if ((invoke2 instanceof Integer) || (invoke2 instanceof Long)) {
                    this.f166c.f168b = ((Integer) invoke2).intValue();
                    C0133c.m328b("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + this.f166c.f168b);
                }
            } catch (Exception unused3) {
                C0133c.m326a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        if (r11 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
    
        com.cmic.sso.sdk.p009e.C0133c.m328b("UMCTelephonyManagement", "readSimInfoDbEnd");
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
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m172b(Context context) {
        C0133c.m328b("UMCTelephonyManagement", "readSimInfoDbStart");
        Uri parse = Uri.parse("content://telephony/siminfo");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(parse, new String[]{"_id", "sim_id"}, "sim_id>=?", new String[]{AddressParam.TYPE_DISAPPROVE}, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        int i = cursor.getInt(cursor.getColumnIndex("sim_id"));
                        int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
                        if (this.f166c.f167a == -1 && this.f166c.f168b != -1 && this.f166c.f168b == i2) {
                            this.f166c.f167a = i;
                            C0133c.m328b("UMCTelephonyManagement", "通过读取sim db获取数据流量卡的卡槽值：" + i);
                        }
                        if (this.f166c.f167a == i) {
                            this.f166c.f168b = i2;
                        }
                    }
                }
            } catch (Exception unused) {
                C0133c.m326a("UMCTelephonyManagement", "readSimInfoDb error");
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
