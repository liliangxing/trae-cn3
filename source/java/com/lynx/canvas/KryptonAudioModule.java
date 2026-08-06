package com.lynx.canvas;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class KryptonAudioModule extends KryptonModule {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum AudioStatus {
        INIT,
        PAUSE,
        RESUME,
        DESTROY
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface StatusListener {
        void onStatusChange(AudioStatus audioStatus);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String moduleName() {
        return "audio";
    }

    public abstract String engineType();

    public abstract boolean loadAudioEffectModule(String str);

    public abstract boolean loadAudioModule();

    public abstract void setStatusListener(StatusListener statusListener);

    public abstract boolean startAudioEngine(KryptonApp kryptonApp);
}
