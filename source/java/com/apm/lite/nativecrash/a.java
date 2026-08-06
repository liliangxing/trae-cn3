package com.apm.lite.nativecrash;

import android.text.TextUtils;
import com.apm.lite.k.o;
import com.bytedance.crash.entity.CrashBody;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class a {
    private Map<String, String> a;

    public a(File file) {
        String nativeCrashHeader;
        File c = o.c(file);
        if (!c.exists() || c.length() == 0 || (nativeCrashHeader = NativeImpl.getNativeCrashHeader(c.getAbsolutePath())) == null) {
            return;
        }
        String[] split = nativeCrashHeader.split(UpdateDialogNewBase.TYPE);
        this.a = new HashMap();
        for (String str : split) {
            String[] split2 = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                this.a.put(split2[0], split2[1]);
            }
        }
    }

    public boolean a() {
        Map<String, String> map = this.a;
        return (map == null || map.isEmpty() || TextUtils.isEmpty(this.a.get("process_name")) || TextUtils.isEmpty(this.a.get(CrashBody.CRASH_THREAD_NAME)) || TextUtils.isEmpty(this.a.get("pid")) || TextUtils.isEmpty(this.a.get(CrashBody.TID)) || TextUtils.isEmpty(this.a.get("start_time")) || TextUtils.isEmpty(this.a.get("crash_time")) || TextUtils.isEmpty(this.a.get("signal_line"))) ? false : true;
    }

    public String b() {
        return this.a.get("signal_line");
    }

    public Map<String, String> c() {
        return this.a;
    }
}
