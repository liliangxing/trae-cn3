package com.lynx.tasm.behavior.utils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PropsHolderAutoRegister {
    public static boolean sHasRegistered;

    public static void registerLynxUISetter(LynxUISetter lynxUISetter) {
        PropsUpdater.registerSetter(lynxUISetter);
    }

    public static void registerShadowNodeSetter(ShadowNodeSetter shadowNodeSetter) {
        PropsUpdater.registerSetter(shadowNodeSetter);
    }

    public static void init() {
        if (sHasRegistered) {
            return;
        }
        sHasRegistered = true;
    }
}
