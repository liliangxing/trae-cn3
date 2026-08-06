package com.huawei.hms.framework.network.grs.p023g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1108a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1103e {

    /* renamed from: com.huawei.hms.framework.network.grs.g.e$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f1346a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f1347b;

        /* renamed from: c */
        final /* synthetic */ JSONArray f1348c;

        a(long j, ArrayList arrayList, JSONArray jSONArray) {
            this.f1346a = j;
            this.f1347b = arrayList;
            this.f1348c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            C1108a c1108a = new C1108a();
            c1108a.put("total_time", this.f1346a);
            Iterator it = this.f1347b.iterator();
            while (it.hasNext()) {
                C1102d c1102d = (C1102d) it.next();
                if (c1102d.m1333o() || c1102d.m1331m()) {
                    c1108a.put(C1103e.m1336b(c1102d));
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z && this.f1347b.size() > 0) {
                ArrayList arrayList = this.f1347b;
                C1102d c1102d2 = (C1102d) arrayList.get(arrayList.size() - 1);
                c1108a.put(C1103e.m1336b(c1102d2));
                this.f1347b.remove(c1102d2);
            }
            if (this.f1347b.size() > 0) {
                Iterator it2 = this.f1347b.iterator();
                while (it2.hasNext()) {
                    this.f1348c.put(new JSONObject(C1103e.m1336b((C1102d) it2.next())));
                }
            }
            if (this.f1348c.length() > 0) {
                c1108a.put("failed_info", this.f1348c.toString());
            }
            Logger.m1181d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(c1108a.get()));
            HianalyticsHelper.getInstance().onEvent(c1108a.get(), "grs_request");
        }
    }

    /* renamed from: a */
    public static void m1335a(ArrayList<C1102d> arrayList, long j, JSONArray jSONArray, Context context) {
        if (context == null || arrayList == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReport(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j, arrayList, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static LinkedHashMap<String, String> m1336b(C1102d c1102d) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception m1322d = c1102d.m1322d();
        if (m1322d != null) {
            linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(m1322d));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, m1322d.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(m1322d.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", c1102d.m1318b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, c1102d.m1321c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(c1102d.m1330l()).getHost());
        } catch (MalformedURLException e) {
            Logger.m1190w("HaReportHelper", "report host MalformedURLException", e);
        }
        linkedHashMapPack.put("req_start_time", c1102d.m1326h());
        linkedHashMapPack.put("req_end_time", c1102d.m1325g());
        linkedHashMapPack.put("req_total_time", c1102d.m1327i());
        return linkedHashMapPack.getAll();
    }
}
