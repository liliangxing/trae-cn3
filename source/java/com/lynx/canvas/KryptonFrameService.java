package com.lynx.canvas;

/* loaded from: classes6.dex */
public abstract class KryptonFrameService extends KryptonService {

    /* loaded from: classes6.dex */
    public interface FrameCallback {
        void doFrame(long j);
    }

    public abstract void registerBeforeVSyncEndListener(FrameCallback frameCallback);

    public abstract void requestVSync(FrameCallback frameCallback);

    public abstract void setPreferredFramesPerSecond(long j);
}
