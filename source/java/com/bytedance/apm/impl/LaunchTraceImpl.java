package com.bytedance.apm.impl;

import com.bytedance.apm.trace.LaunchTrace;
import com.bytedance.services.apm.api.ILaunchTrace;

/* loaded from: classes3.dex */
public class LaunchTraceImpl implements ILaunchTrace {
    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        LaunchTrace.startTrace();
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String str, String str2) {
        LaunchTrace.startSpan(str, str2);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String str, String str2) {
        LaunchTrace.endSpan(str, str2);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int i, String str, long j) {
        LaunchTrace.endTrace(i, str, j);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        LaunchTrace.cancelTrace();
    }
}
