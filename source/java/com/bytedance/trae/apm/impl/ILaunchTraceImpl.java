package com.bytedance.trae.apm.impl;

import com.bytedance.apm.impl.LaunchTraceImpl;
import com.bytedance.services.apm.api.ILaunchTrace;
import kotlin.Metadata;

/* compiled from: ILaunchTraceImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J.\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b2\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001¢\u0006\u0002\u0010\u000bJ.\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\r2\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0002\u0010\u0010J.\u0010\u0011\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b2\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/apm/impl/ILaunchTraceImpl;", "Lcom/bytedance/services/apm/api/ILaunchTrace;", "<init>", "()V", "cancelTrace", "", "endSpan", "p0", "", "kotlin.jvm.PlatformType", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "endTrace", "", "p2", "", "(ILjava/lang/String;J)V", "startSpan", "startTrace", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ILaunchTraceImpl implements ILaunchTrace {
    private final /* synthetic */ LaunchTraceImpl $$delegate_0 = new LaunchTraceImpl();

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        this.$$delegate_0.cancelTrace();
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String p0, String p1) {
        this.$$delegate_0.endSpan(p0, p1);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int p0, String p1, long p2) {
        this.$$delegate_0.endTrace(p0, p1, p2);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String p0, String p1) {
        this.$$delegate_0.startSpan(p0, p1);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        this.$$delegate_0.startTrace();
    }
}
