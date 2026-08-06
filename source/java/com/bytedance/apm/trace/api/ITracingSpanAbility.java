package com.bytedance.apm.trace.api;

import com.bytedance.tracing.internal.LogData;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface ITracingSpanAbility {
    ITracingSpan addLog(String str);

    ITracingSpan addLog(String str, Map<String, String> map);

    ITracingSpan addTag(String str, String str2);

    long getFinishTime();

    List<LogData> getLogs();

    long getParentId();

    long getReferenceId();

    long getSpanId();

    String getSpanName();

    long getStartTime();

    Map<String, String> getTags();

    String getThreadName();

    TracingContext getTracingContext();

    void setErrorTag(String str);

    ITracingSpan setParentId(long j);

    ITracingSpan setReferenceId(long j);

    ITracingSpan setThreadName(String str);
}
