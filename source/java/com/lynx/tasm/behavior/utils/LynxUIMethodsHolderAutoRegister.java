package com.lynx.tasm.behavior.utils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIMethodsHolderAutoRegister {
    public static boolean sHasRegistered;

    public static void registerLynxUIMethodInvoker(LynxUIMethodInvoker lynxUIMethodInvoker) {
        LynxUIMethodsExecutor.registerMethodInvoker(lynxUIMethodInvoker);
    }

    public static void init() {
        if (sHasRegistered) {
            return;
        }
        sHasRegistered = true;
    }
}
