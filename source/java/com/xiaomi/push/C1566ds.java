package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.ttm.player.MediaPlayer;
import com.xiaomi.clientreport.data.C1419a;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;

/* renamed from: com.xiaomi.push.ds */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1566ds {

    /* renamed from: a */
    private static volatile C1566ds f1475a;

    /* renamed from: a */
    private Context f1476a;

    private C1566ds(Context context) {
        this.f1476a = context;
    }

    /* renamed from: a */
    public static C1566ds m2275a(Context context) {
        if (f1475a == null) {
            synchronized (C1566ds.class) {
                if (f1475a == null) {
                    f1475a = new C1566ds(context);
                }
            }
        }
        return f1475a;
    }

    /* renamed from: a */
    public void m2280a(String str, String str2, String str3, int i, long j, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        EventClientReport m2262a = C1565dr.m2262a(this.f1476a, str2, str3, i, j, str4);
        m2262a.setAppPackageName(str);
        m2262a.setSdkVersion(BuildConfig.VERSION_NAME);
        m2276a(m2262a);
    }

    /* renamed from: a */
    public void m2281a(String str, String str2, String str3, int i, String str4) {
        m2280a(str, str2, str3, i, System.currentTimeMillis(), str4);
    }

    /* renamed from: a */
    public void m2278a(String str, Intent intent, int i, String str2) {
        if (intent == null) {
            return;
        }
        m2280a(str, C1565dr.m2268a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i, System.currentTimeMillis(), str2);
    }

    /* renamed from: a */
    public void m2282a(String str, String str2, String str3, String str4) {
        m2280a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    /* renamed from: b */
    public void m2283b(String str, String str2, String str3, String str4) {
        m2280a(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    /* renamed from: a */
    public void m2279a(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        m2280a(str, C1565dr.m2268a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str2);
    }

    /* renamed from: c */
    public void m2284c(String str, String str2, String str3, String str4) {
        m2280a(str, str2, str3, MediaPlayer.MEDIA_PLAYER_OPTION_DECODERRENDER_CONTINUE_RETRY, System.currentTimeMillis(), str4);
    }

    /* renamed from: a */
    public void m2277a(String str, int i, long j, long j2) {
        if (i < 0 || j2 < 0 || j <= 0) {
            return;
        }
        PerfClientReport m2265a = C1565dr.m2265a(this.f1476a, i, j, j2);
        m2265a.setAppPackageName(str);
        m2265a.setSdkVersion(BuildConfig.VERSION_NAME);
        m2276a(m2265a);
    }

    /* renamed from: a */
    private void m2276a(C1419a c1419a) {
        if (c1419a instanceof PerfClientReport) {
            ClientReportClient.reportPerf(this.f1476a, (PerfClientReport) c1419a);
        } else if (c1419a instanceof EventClientReport) {
            ClientReportClient.reportEvent(this.f1476a, (EventClientReport) c1419a);
        }
    }
}
