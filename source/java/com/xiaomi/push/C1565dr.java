package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.ttm.player.UnifiedCodec.codec.CodecError;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.service.C1750ah;
import com.xiaomi.push.service.C1768az;
import com.xiaomi.push.service.C1770ba;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.dr */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1565dr {

    /* renamed from: a */
    private static a f1473a;

    /* renamed from: a */
    private static Map<String, EnumC1643go> f1474a;

    /* renamed from: com.xiaomi.push.dr$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        void uploader(Context context, C1637gi c1637gi);
    }

    /* renamed from: a */
    public static int m2259a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    /* renamed from: a */
    public static String m2268a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    /* renamed from: a */
    public static void m2273a(a aVar) {
        f1473a = aVar;
    }

    /* renamed from: a */
    private static void m2271a(Context context, C1637gi c1637gi) {
        if (m2274a(context.getApplicationContext())) {
            C1770ba.m3803a(context.getApplicationContext(), c1637gi);
            return;
        }
        a aVar = f1473a;
        if (aVar != null) {
            aVar.uploader(context, c1637gi);
        }
    }

    /* renamed from: a */
    public static EventClientReport m2263a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    /* renamed from: a */
    public static PerfClientReport m2264a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    /* renamed from: a */
    public static EventClientReport m2262a(Context context, String str, String str2, int i, long j, String str3) {
        EventClientReport m2263a = m2263a(str);
        m2263a.eventId = str2;
        m2263a.eventType = i;
        m2263a.eventTime = j;
        m2263a.eventContent = str3;
        return m2263a;
    }

    /* renamed from: a */
    public static PerfClientReport m2265a(Context context, int i, long j, long j2) {
        PerfClientReport m2264a = m2264a();
        m2264a.code = i;
        m2264a.perfCounts = j;
        m2264a.perfLatencies = j2;
        return m2264a;
    }

    /* renamed from: a */
    public static boolean m2274a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }

    /* renamed from: a */
    public static void m2272a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                C1637gi m2266a = m2266a(context, it.next());
                if (!C1768az.m3794a(m2266a, false)) {
                    m2271a(context, m2266a);
                }
            }
        } catch (Throwable th) {
            AbstractC1417b.m1103d(th.getMessage());
        }
    }

    /* renamed from: a */
    public static C1637gi m2266a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1637gi c1637gi = new C1637gi();
        c1637gi.m2746d("category_client_report_data");
        c1637gi.m2727a("push_sdk_channel");
        c1637gi.m2726a(1L);
        c1637gi.m2738b(str);
        c1637gi.m2729a(true);
        c1637gi.m2737b(System.currentTimeMillis());
        c1637gi.m2754g(context.getPackageName());
        c1637gi.m2749e("com.xiaomi.xmsf");
        c1637gi.m2752f(C1768az.m3791a());
        c1637gi.m2742c("quality_support");
        return c1637gi;
    }

    /* renamed from: a */
    public static void m2270a(Context context, Config config) {
        ClientReportClient.init(context, config, new C1563dp(context), new C1564dq(context));
    }

    /* renamed from: a */
    public static void m2269a(Context context) {
        ClientReportClient.updateConfig(context, m2261a(context));
    }

    /* renamed from: a */
    public static Config m2261a(Context context) {
        boolean m3686a = C1750ah.m3674a(context).m3686a(EnumC1638gj.PerfUploadSwitch.m2760a(), false);
        boolean m3686a2 = C1750ah.m3674a(context).m3686a(EnumC1638gj.EventUploadNewSwitch.m2760a(), false);
        return Config.getBuilder().setEventUploadSwitchOpen(m3686a2).setEventUploadFrequency(C1750ah.m3674a(context).m3678a(EnumC1638gj.EventUploadFrequency.m2760a(), Constants.MAX_RETRY_AFTER)).setPerfUploadSwitchOpen(m3686a).setPerfUploadFrequency(C1750ah.m3674a(context).m3678a(EnumC1638gj.PerfUploadFrequency.m2760a(), Constants.MAX_RETRY_AFTER)).build(context);
    }

    /* renamed from: a */
    public static int m2260a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof EnumC1633ge) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof EnumC1643go) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof EnumC1577ec) {
                return r1.ordinal() + CodecError.DEQUEUE_OUTPUT_CODEC_EXCEPTION;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static EnumC1643go m2267a(String str) {
        if (f1474a == null) {
            synchronized (EnumC1643go.class) {
                if (f1474a == null) {
                    f1474a = new HashMap();
                    for (EnumC1643go enumC1643go : EnumC1643go.values()) {
                        f1474a.put(enumC1643go.f2208a.toLowerCase(), enumC1643go);
                    }
                }
            }
        }
        EnumC1643go enumC1643go2 = f1474a.get(str.toLowerCase());
        return enumC1643go2 != null ? enumC1643go2 : EnumC1643go.Invalid;
    }
}
