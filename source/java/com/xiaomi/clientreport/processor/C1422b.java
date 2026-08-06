package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.C1419a;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.C1504bk;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.clientreport.processor.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1422b implements IPerfProcessor {

    /* renamed from: a */
    protected Context f778a;

    /* renamed from: a */
    private HashMap<String, HashMap<String, C1419a>> f779a;

    public C1422b(Context context) {
        this.f778a = context;
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC1423c
    /* renamed from: a */
    public void mo1140a() {
        C1504bk.m1666a(this.f778a, "perf", "perfUploading");
        File[] m1671a = C1504bk.m1671a(this.f778a, "perfUploading");
        if (m1671a == null || m1671a.length <= 0) {
            return;
        }
        for (File file : m1671a) {
            if (file != null) {
                List<String> m1155a = C1425e.m1155a(this.f778a, file.getAbsolutePath());
                file.delete();
                mo1149a(m1155a);
            }
        }
    }

    /* renamed from: a */
    public void mo1149a(List<String> list) {
        C1504bk.m1667a(this.f778a, list);
    }

    /* renamed from: a */
    public void m1150a(C1419a[] c1419aArr) {
        String m1148c = m1148c(c1419aArr[0]);
        if (TextUtils.isEmpty(m1148c)) {
            return;
        }
        C1425e.m1157a(m1148c, c1419aArr);
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC1424d
    /* renamed from: b */
    public void mo1145b() {
        HashMap<String, HashMap<String, C1419a>> hashMap = this.f779a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it = this.f779a.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, C1419a> hashMap2 = this.f779a.get(it.next());
                if (hashMap2 != null && hashMap2.size() > 0) {
                    C1419a[] c1419aArr = new C1419a[hashMap2.size()];
                    hashMap2.values().toArray(c1419aArr);
                    m1150a(c1419aArr);
                }
            }
        }
        this.f779a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC1424d
    /* renamed from: a */
    public void mo1142a(C1419a c1419a) {
        if ((c1419a instanceof PerfClientReport) && this.f779a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) c1419a;
            String m1146a = m1146a((C1419a) perfClientReport);
            String m1153a = C1425e.m1153a(perfClientReport);
            HashMap<String, C1419a> hashMap = this.f779a.get(m1146a);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(m1153a);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap.put(m1153a, perfClientReport);
            this.f779a.put(m1146a, hashMap);
        }
    }

    /* renamed from: b */
    private String m1147b(C1419a c1419a) {
        int i = c1419a.production;
        String str = c1419a.clientInterfaceId;
        String str2 = (i <= 0 || TextUtils.isEmpty(str)) ? "" : String.valueOf(i) + "#" + str;
        File file = new File(this.f778a.getFilesDir(), "perf");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2).getAbsolutePath();
    }

    /* renamed from: c */
    private String m1148c(C1419a c1419a) {
        String m1147b = m1147b(c1419a);
        if (TextUtils.isEmpty(m1147b)) {
            return null;
        }
        for (int i = 0; i < 20; i++) {
            String str = m1147b + i;
            if (C1504bk.m1669a(this.f778a, str)) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m1146a(C1419a c1419a) {
        return String.valueOf(c1419a.production) + "#" + c1419a.clientInterfaceId;
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, C1419a>> hashMap) {
        this.f779a = hashMap;
    }
}
