package com.lynx.canvas;

import java.util.List;

/* loaded from: classes6.dex */
public abstract class KryptonSensorService extends KryptonService {

    /* loaded from: classes6.dex */
    public interface Listener {
        void notifyGyroscopeData(float f, float f2, float f3, long j);

        void notifyOrientationData(float f, float f2, float f3, long j);
    }

    public abstract void setListener(Listener listener);

    public abstract boolean start(List<Integer> list, int i);

    public abstract void stop();
}
