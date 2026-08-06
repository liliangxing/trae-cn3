package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;

/* loaded from: classes3.dex */
public interface ICpuExceptionState {
    void onEnterThisState(CpuExceptionConfig cpuExceptionConfig, boolean z);

    void onLifeCycleChange(boolean z);

    void onStopDetect();

    StateType provideType();
}
