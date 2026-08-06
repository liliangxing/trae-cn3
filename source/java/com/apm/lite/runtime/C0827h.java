package com.apm.lite.runtime;

import android.content.Context;
import com.apm.lite.C0738c;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0789l;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0795r;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.upc.cache.ApiMultiProcessSharedProvider;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: com.apm.lite.runtime.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0827h {

    /* renamed from: a */
    private Context f711a;

    /* renamed from: b */
    private HashMap<String, Long> f712b;

    /* renamed from: c */
    private int f713c = 50;

    /* renamed from: d */
    private int f714d = 100;

    public C0827h(Context context) {
        this.f712b = null;
        this.f711a = context;
        this.f712b = m1146c();
        m1145b();
    }

    /* renamed from: a */
    private void m1144a(File file) {
        File m868g = C0792o.m868g(this.f711a);
        file.renameTo(new File(m868g, String.valueOf(System.currentTimeMillis())));
        String[] list = m868g.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            new File(m868g, list[0]).delete();
        }
    }

    /* renamed from: b */
    private void m1145b() {
        this.f713c = C0810a.m1014a(this.f713c, "custom_event_settings", "npth_simple_setting", "crash_limit_issue");
        this.f714d = C0810a.m1014a(this.f714d, "custom_event_settings", "npth_simple_setting", "crash_limit_all");
    }

    /* renamed from: c */
    private HashMap<String, Long> m1146c() {
        JSONArray m799b;
        File m870h = C0792o.m870h(this.f711a);
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
        try {
            m799b = C0786i.m799b(m870h.getAbsolutePath());
        } catch (IOException unused) {
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
        if (C0789l.m821a(m799b)) {
            return hashMap;
        }
        Long decode = Long.decode(m799b.optString(0, null));
        if (System.currentTimeMillis() - decode.longValue() > 86400000) {
            m1144a(m870h);
            return hashMap;
        }
        hashMap.put("time", decode);
        for (int i = 1; i < m799b.length(); i++) {
            String[] split = m799b.optString(i, "").split(" ");
            if (split.length == 2) {
                hashMap.put(split[0], Long.decode(split[1]));
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public void m1147a() {
        HashMap<String, Long> hashMap = this.f712b;
        Long remove = hashMap.remove("time");
        if (remove == null) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", new RuntimeException("err times, no time"));
            return;
        }
        StringBuilder append = new StringBuilder().append(remove).append('\n');
        for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
            append.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
        }
        try {
            C0786i.m788a(C0792o.m870h(this.f711a), append.toString(), false);
        } catch (IOException unused) {
        }
    }

    /* renamed from: a */
    public boolean m1148a(String str) {
        if (str == null) {
            str = DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE;
        }
        return C0795r.m895a(this.f712b, str, 1L).longValue() < ((long) this.f713c) && C0795r.m895a(this.f712b, ApiMultiProcessSharedProvider.ALL_TYPE, 1L).longValue() < ((long) this.f714d);
    }
}
