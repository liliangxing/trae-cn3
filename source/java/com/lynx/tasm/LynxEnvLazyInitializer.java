package com.lynx.tasm;

/* loaded from: classes6.dex */
public class LynxEnvLazyInitializer {
    static Initializer sInitializer;

    /* loaded from: classes6.dex */
    public interface Initializer {
        void init();
    }

    public static void setLazyInitializer(Initializer initializer) {
        sInitializer = initializer;
    }

    public static Initializer getsInitializer() {
        return sInitializer;
    }
}
