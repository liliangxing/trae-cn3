package com.bytedance.upc;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public class Upc {
    private static IUpc inst = new UpcImpl();

    public static IUpc inst() {
        return inst;
    }

    public static IPrivacy privacy() {
        return (IPrivacy) inst;
    }

    public static IDialog dialog() {
        return (IDialog) inst;
    }

    public static ITeenMode teenMode() {
        return (ITeenMode) inst();
    }

    public static IPopup popup() {
        return (IPopup) inst();
    }
}
