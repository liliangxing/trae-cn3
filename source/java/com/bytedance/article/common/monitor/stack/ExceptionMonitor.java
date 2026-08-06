package com.bytedance.article.common.monitor.stack;

import com.bytedance.services.apm.api.EnsureManager;
import java.util.Collection;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public class ExceptionMonitor {
    private static boolean sDebug;

    public static void setUploadUrl(String str) {
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static boolean ensureTrue(boolean z) {
        return EnsureManager.getEnsureImpl() != null ? EnsureManager.ensureTrue(z) : z;
    }

    public static boolean ensureFalse(boolean z) {
        return EnsureManager.getEnsureImpl() != null ? EnsureManager.ensureFalse(z) : z;
    }

    public static boolean ensureTrue(boolean z, String str) {
        return EnsureManager.getEnsureImpl() != null ? EnsureManager.ensureTrue(z, str) : z;
    }

    public static boolean ensureTrue(boolean z, String str, Map<String, String> map) {
        return EnsureManager.getEnsureImpl() != null ? EnsureManager.ensureTrue(z, str, map) : z;
    }

    public static boolean ensureFalse(boolean z, String str) {
        return EnsureManager.getEnsureImpl() != null ? EnsureManager.ensureFalse(z, str) : z;
    }

    public static boolean ensureFalse(boolean z, String str, Map<String, String> map) {
        return EnsureManager.getEnsureImpl() != null ? EnsureManager.ensureFalse(z, str, map) : z;
    }

    public static void ensureNotReachHere() {
        if (EnsureManager.getEnsureImpl() != null) {
            EnsureManager.ensureNotReachHere();
        }
    }

    public static void ensureNotReachHere(String str) {
        if (EnsureManager.getEnsureImpl() != null) {
            EnsureManager.ensureNotReachHere(str);
        }
    }

    public static void ensureNotReachHere(Throwable th) {
        if (EnsureManager.getEnsureImpl() != null) {
            EnsureManager.ensureNotReachHere(th);
        }
    }

    public static void ensureNotReachHere(String str, Map<String, String> map) {
        if (EnsureManager.getEnsureImpl() != null) {
            EnsureManager.ensureNotReachHere(str, map);
        }
    }

    public static void reportLogEException(int i, Throwable th, String str, boolean z) {
        if (EnsureManager.getEnsureImpl() != null) {
            EnsureManager.reportLogEException(i, th, str, z);
        }
    }

    public static void ensureNotReachHere(Throwable th, String str) {
        if (EnsureManager.getEnsureImpl() != null) {
            EnsureManager.ensureNotReachHere(th, str);
        }
    }

    public static void ensureNotReachHere(Throwable th, String str, Map<String, String> map) {
        if (EnsureManager.getEnsureImpl() != null) {
            EnsureManager.ensureNotReachHere(th, str, map);
        }
    }

    public static boolean ensureNotEmpty(Collection collection) {
        if (EnsureManager.getEnsureImpl() != null) {
            return EnsureManager.ensureNotEmpty(collection);
        }
        return false;
    }

    public static boolean ensureNotNull(Object obj) {
        if (EnsureManager.getEnsureImpl() != null) {
            return EnsureManager.ensureNotNull(obj);
        }
        return false;
    }

    public static boolean ensureNotNull(Object obj, String str) {
        if (EnsureManager.getEnsureImpl() != null) {
            return EnsureManager.ensureNotNull(obj, str);
        }
        return false;
    }
}
