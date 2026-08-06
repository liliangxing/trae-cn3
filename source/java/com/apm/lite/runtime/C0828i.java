package com.apm.lite.runtime;

import android.content.Context;
import com.apm.lite.C0744d;
import com.apm.lite.ICommonParams;
import com.apm.lite.MonitorCrash;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.apm.lite.runtime.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0828i {
    /* renamed from: a */
    public static C0823d m1149a(Context context) {
        return new C0823d(context, new ICommonParams() { // from class: com.apm.lite.runtime.i.1
            @Override // com.apm.lite.ICommonParams
            public Map<String, Object> getCommonParams() {
                return new HashMap();
            }

            @Override // com.apm.lite.ICommonParams
            public String getDeviceId() {
                MonitorCrash monitorCrash = (MonitorCrash) C0744d.m450a();
                return monitorCrash != null ? monitorCrash.config().getDeviceId() : "";
            }

            @Override // com.apm.lite.ICommonParams
            public List<String> getPatchInfo() {
                return null;
            }

            @Override // com.apm.lite.ICommonParams
            public Map<String, Integer> getPluginInfo() {
                return null;
            }

            @Override // com.apm.lite.ICommonParams
            public String getSessionId() {
                return null;
            }

            @Override // com.apm.lite.ICommonParams
            public long getUserId() {
                return 0L;
            }
        });
    }
}
