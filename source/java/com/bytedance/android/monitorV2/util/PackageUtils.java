package com.bytedance.android.monitorV2.util;

import com.bytedance.apm.ApmContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PackageUtils {
    public static String getVersionName() {
        try {
            return JsonUtils.safeOptStr(ApmContext.getHeader(), "version_name");
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return "";
        }
    }

    public static int getVersionCode() {
        try {
            return JsonUtils.safeOptInt(ApmContext.getHeader(), "version_code");
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return 0;
        }
    }
}
