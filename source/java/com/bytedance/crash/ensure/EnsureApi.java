package com.bytedance.crash.ensure;

import com.bytedance.crash.Ensure;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.IEnsure;
import java.util.Collection;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EnsureApi {
    private static final int STACKTRACE_NORMAL_DEPTH = 5;
    private static boolean sInited;

    public static void init() {
        if (sInited) {
            return;
        }
        sInited = true;
        try {
            IEnsure iEnsure = new IEnsure() { // from class: com.bytedance.crash.ensure.EnsureApi.1
                public boolean ensureTrue(boolean z) {
                    return Ensure.ensureTrue(z);
                }

                public boolean ensureTrue(boolean z, String str) {
                    return Ensure.ensureTrue(z, str);
                }

                public boolean ensureTrue(boolean z, String str, Map<String, String> map) {
                    return Ensure.ensureTrue(z, str, map);
                }

                public boolean ensureFalse(boolean z) {
                    return Ensure.ensureFalse(z);
                }

                public boolean ensureFalse(boolean z, String str) {
                    return Ensure.ensureFalse(z, str);
                }

                public boolean ensureFalse(boolean z, String str, Map<String, String> map) {
                    return Ensure.ensureFalse(z, str, map);
                }

                public void ensureNotReachHere() {
                    MonitorManager.getAppEnsureManager().reportMessage(5);
                }

                public void ensureNotReachHere(String str) {
                    MonitorManager.getAppEnsureManager().reportMessage(str, 5);
                }

                public void ensureNotReachHere(String str, Map<String, String> map) {
                    MonitorManager.getAppEnsureManager().reportMessage(str, map, 5);
                }

                public void ensureNotReachHere(Throwable th) {
                    Ensure.ensureNotReachHere(th);
                }

                public void ensureNotReachHere(Throwable th, String str) {
                    Ensure.ensureNotReachHere(th, str);
                }

                public void ensureNotReachHere(Throwable th, String str, Map<String, String> map) {
                    Ensure.ensureNotReachHere(th, str, map);
                }

                public boolean ensureNotEmpty(Collection collection) {
                    return Ensure.ensureNotEmpty(collection);
                }

                public boolean ensureNotNull(Object obj) {
                    return Ensure.ensureNotNull(obj);
                }

                public boolean ensureNotNull(Object obj, String str) {
                    return Ensure.ensureNotNull(obj, str);
                }

                public void reportLogException(int i, Throwable th, String str) {
                    ensureNotReachHere(th, str);
                }

                public void reportLogException(Throwable th) {
                    ensureNotReachHere(th);
                }

                public void reportLogException(Throwable th, String str) {
                    ensureNotReachHere(th, str);
                }
            };
            ServiceManager.registerService(IEnsure.class, iEnsure);
            EnsureManager.setEnsureImpl(iEnsure);
        } catch (Throwable unused) {
        }
    }
}
