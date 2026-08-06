package com.lynx.canvas;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonModule;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxKryptonUtils {
    private static final String TAG = "LynxKryptonUtils";

    public static LynxKryptonHelper getLynxKryptonHelper(LynxView lynxView) {
        LynxContext lynxContext = lynxView.getLynxContext();
        if (lynxContext == null) {
            LLog.m2577e(TAG, "context is null");
            return null;
        }
        LynxKryptonModule extensionModuleByKey = lynxContext.getExtensionModuleByKey("LynxKryptonModule");
        if (extensionModuleByKey == null) {
            LLog.m2577e(TAG, "krypton module is null");
            return null;
        }
        return extensionModuleByKey.getLynxKryptonHelper();
    }
}
