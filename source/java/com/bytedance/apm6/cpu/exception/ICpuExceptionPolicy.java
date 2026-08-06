package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;

/* loaded from: classes3.dex */
public interface ICpuExceptionPolicy {
    void startDetect(CpuExceptionConfig cpuExceptionConfig);

    void stopDetect();
}
