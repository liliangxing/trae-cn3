package com.xiaomi.push;

import android.content.Context;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.push.service.C1788q;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.xiaomi.push.co */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1535co {

    /* renamed from: a */
    private final String f1202a = "disconnection_event";

    /* renamed from: b */
    private final String f1203b = "count";

    /* renamed from: c */
    private final String f1204c = "host";

    /* renamed from: d */
    private final String f1205d = "network_state";

    /* renamed from: e */
    private final String f1206e = BaseConstants.DownloadManager.COLUMN_REASON;

    /* renamed from: f */
    private final String f1207f = "ping_interval";

    /* renamed from: g */
    private final String f1208g = "network_type";

    /* renamed from: h */
    private final String f1209h = "wifi_digest";

    /* renamed from: i */
    private final String f1210i = "duration";

    /* renamed from: j */
    private final String f1211j = "disconnect_time";

    /* renamed from: k */
    private final String f1212k = MonitorConstants.CONNECT_TIME;

    /* renamed from: l */
    private final String f1213l = "xmsf_vc";

    /* renamed from: m */
    private final String f1214m = "android_vc";

    /* renamed from: n */
    private final String f1215n = "uuid";

    /* renamed from: a */
    public void m1901a(Context context, List<C1534cn> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        C1533cm.m1871a("upload size = " + list.size());
        String m3957a = C1788q.m3957a(context);
        for (C1534cn c1534cn : list) {
            HashMap hashMap = new HashMap();
            hashMap.put("count", Integer.valueOf(c1534cn.m1875a()));
            hashMap.put("host", c1534cn.m1877a());
            hashMap.put("network_state", Integer.valueOf(c1534cn.m1881b()));
            hashMap.put(BaseConstants.DownloadManager.COLUMN_REASON, Integer.valueOf(c1534cn.m1887c()));
            hashMap.put("ping_interval", Long.valueOf(c1534cn.m1876a()));
            hashMap.put("network_type", Integer.valueOf(c1534cn.m1891d()));
            hashMap.put("wifi_digest", c1534cn.m1883b());
            hashMap.put("connected_network_type", Integer.valueOf(c1534cn.m1895e()));
            hashMap.put("duration", Long.valueOf(c1534cn.m1882b()));
            hashMap.put("disconnect_time", Long.valueOf(c1534cn.m1888c()));
            hashMap.put(MonitorConstants.CONNECT_TIME, Long.valueOf(c1534cn.m1892d()));
            hashMap.put("xmsf_vc", Integer.valueOf(c1534cn.m1897f()));
            hashMap.put("android_vc", Integer.valueOf(c1534cn.m1899g()));
            hashMap.put("uuid", m3957a);
            C1581eg.m2343a().mo2342a("disconnection_event", hashMap);
        }
    }
}
