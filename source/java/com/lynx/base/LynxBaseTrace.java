package com.lynx.base;

import com.larus.business.markdown.api.depend.ICustomDataHandlerKt;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.service.ILynxTraceService;
import com.lynx.tasm.service.LynxServiceCenter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxBaseTrace {
    private static final String TAG = "LynxBaseTrace";
    private static boolean sIsNativeLibLoad;

    private static native void nativeInitBaseTrace(long j);

    public static void init() {
        try {
            if (!sIsNativeLibLoad) {
                sIsNativeLibLoad = LynxBaseEnv.inst().isNativeLibraryLoaded();
            }
            if (sIsNativeLibLoad) {
                initNativeBaseTrace();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            LynxLog.m2550e(ICustomDataHandlerKt.TYPE_LYNX, "init LynxBaseTrace exception [ " + e.getMessage() + " ]");
        }
    }

    private static boolean initNativeBaseTrace() {
        ILynxTraceService service = LynxServiceCenter.inst().getService(ILynxTraceService.class);
        if (service == null) {
            nativeInitBaseTrace(0L);
            LynxLog.m2551i(TAG, "LynxBaseTrace init successfully by itself.");
            return true;
        }
        long defaultTraceFunction = service.getDefaultTraceFunction();
        if (defaultTraceFunction != 0) {
            nativeInitBaseTrace(defaultTraceFunction);
            LynxLog.m2551i(TAG, "LynxBaseTrace init successfully by custom LynxBaseTraceService. function native address is " + defaultTraceFunction);
            return true;
        }
        LynxLog.m2551i(TAG, "failed to init LynxBaseTrace dependency");
        return false;
    }
}
