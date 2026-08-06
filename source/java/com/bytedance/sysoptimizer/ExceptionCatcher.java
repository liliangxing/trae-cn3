package com.bytedance.sysoptimizer;

/* loaded from: classes5.dex */
public interface ExceptionCatcher {
    boolean analysis(Throwable th);

    boolean registerCondition();
}
