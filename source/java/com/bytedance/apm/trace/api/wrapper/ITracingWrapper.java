package com.bytedance.apm.trace.api.wrapper;

import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingWindowSpan;

/* loaded from: classes3.dex */
public interface ITracingWrapper {
    void addTracingTag(String str, String str2);

    void cancel();

    void createAndEndWindowSpan(String str, long j, long j2);

    ITracingWindowSpan createWindowSpan(String str);

    void end();

    void end(long j);

    void endSpan(String str);

    void endWindowSpan(String str, long j, long j2);

    void start();

    ITracingSpan startSpan(String str);

    void startWithCross();
}
