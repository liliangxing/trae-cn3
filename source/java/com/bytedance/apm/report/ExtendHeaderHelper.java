package com.bytedance.apm.report;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ExtendHeaderHelper {
    public static final String TEST_RUNTIME_KEY = "test_runtime";
    private static String sTestInfoPropPath;

    public static String getTestInfoPropPath() {
        if (TextUtils.isEmpty(sTestInfoPropPath)) {
            try {
                sTestInfoPropPath = ApmContext.getContext().getExternalFilesDir(null).getParentFile().getAbsolutePath() + "/AutomationTestInfo.json";
            } catch (Throwable unused) {
            }
        }
        return sTestInfoPropPath;
    }

    public static void setTestInfoPropPath(String str) {
        sTestInfoPropPath = str;
    }
}
