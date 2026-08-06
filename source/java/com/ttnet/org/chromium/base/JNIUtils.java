package com.ttnet.org.chromium.base;

import android.content.Context;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.Map;

@MainDex
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class JNIUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ClassLoader sJniClassLoader;
    private static Boolean sSelectiveJniRegistrationEnabled;

    private static ClassLoader getClassLoader() {
        ClassLoader classLoader = sJniClassLoader;
        return classLoader == null ? JNIUtils.class.getClassLoader() : classLoader;
    }

    public static ClassLoader getSplitClassLoader(String str) {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (!TextUtils.isEmpty(str) && BundleUtils.isIsolatedSplitInstalled(applicationContext, str)) {
            return BundleUtils.createIsolatedSplitContext(applicationContext, str).getClassLoader();
        }
        return getClassLoader();
    }

    public static void setClassLoader(ClassLoader classLoader) {
        sJniClassLoader = classLoader;
    }

    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled == null) {
            sSelectiveJniRegistrationEnabled = false;
        }
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }

    public static void enableSelectiveJniRegistration() {
        sSelectiveJniRegistrationEnabled = true;
    }

    public static <K, V> void splitMap(Map<K, V> map, K[] kArr, V[] vArr) {
        int i = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            kArr[i] = entry.getKey();
            vArr[i] = entry.getValue();
            i++;
        }
    }
}
