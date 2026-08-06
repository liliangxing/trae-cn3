package com.bytedance.apm.agent.p003v2.instrumentation;

import android.text.TextUtils;
import com.bytedance.apm.agent.helper.PageShowCallback;
import com.bytedance.apm.agent.p003v2.InstructOperationSwitch;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ActivityAgent {
    private static final String TAG = "ActivityInstrumentation";

    public static void onTrace(String str, String str2, boolean z) {
        if (z && InstructOperationSwitch.sUiSwitch && TextUtils.equals("onResume", str2)) {
            PageShowCallback.onPageShowHideAction(str, true);
        }
        if (InstructOperationSwitch.sPageLoadSwitch) {
            AutoPageTraceHelper.onTrace(str, str2, z);
        }
    }
}
