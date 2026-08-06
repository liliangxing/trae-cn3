package com.bytedance.apm6.service.lifecycle;

/* loaded from: classes3.dex */
public interface ActivityLifecycleService {
    String getTopActivityClassName();

    boolean isForeground();

    void register(IActivityLifecycleObserver iActivityLifecycleObserver);

    void unregister(IActivityLifecycleObserver iActivityLifecycleObserver);
}
