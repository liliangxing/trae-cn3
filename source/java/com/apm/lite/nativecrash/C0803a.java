package com.apm.lite.nativecrash;

import android.text.TextUtils;
import com.apm.lite.p023k.C0792o;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.apm.lite.nativecrash.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0803a {

    /* renamed from: a */
    private Map<String, String> f605a;

    public C0803a(File file) {
        String nativeCrashHeader;
        File m857c = C0792o.m857c(file);
        if (!m857c.exists() || m857c.length() == 0 || (nativeCrashHeader = NativeImpl.getNativeCrashHeader(m857c.getAbsolutePath())) == null) {
            return;
        }
        String[] split = nativeCrashHeader.split("\n");
        this.f605a = new HashMap();
        for (String str : split) {
            String[] split2 = str.split("=");
            if (split2.length == 2) {
                this.f605a.put(split2[0], split2[1]);
            }
        }
    }

    /* renamed from: a */
    public boolean m952a() {
        Map<String, String> map = this.f605a;
        return (map == null || map.isEmpty() || TextUtils.isEmpty(this.f605a.get("process_name")) || TextUtils.isEmpty(this.f605a.get("crash_thread_name")) || TextUtils.isEmpty(this.f605a.get("pid")) || TextUtils.isEmpty(this.f605a.get("tid")) || TextUtils.isEmpty(this.f605a.get(StrategyConstants.START_TIME)) || TextUtils.isEmpty(this.f605a.get("crash_time")) || TextUtils.isEmpty(this.f605a.get("signal_line"))) ? false : true;
    }

    /* renamed from: b */
    public String m953b() {
        return this.f605a.get("signal_line");
    }

    /* renamed from: c */
    public Map<String, String> m954c() {
        return this.f605a;
    }
}
