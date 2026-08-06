package com.bytedance.apm.block.trace;

import com.bytedance.services.apm.api.IActivityLifeObserver;

/* loaded from: classes3.dex */
public interface ITracer extends IActivityLifeObserver {
    boolean isAlive();

    void onCloseTrace();

    void onStartTrace();
}
