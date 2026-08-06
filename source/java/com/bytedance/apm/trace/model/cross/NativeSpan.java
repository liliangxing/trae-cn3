package com.bytedance.apm.trace.model.cross;

import com.bytedance.apm.trace.api.ITracingWindowSpan;
import com.bytedance.apm.trace.model.AbsTracing;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NativeSpan {
    private long finishTime;
    private boolean isErrorSpan;
    private boolean isFinish;
    private String parentId;
    private String referenceId;
    private String spanId;
    private String spanName;
    private long startTime;
    private Map<String, String> tags;
    private String threadName;

    public NativeSpan(String str, String str2, String str3, String str4, long j, long j2, String str5, HashMap<String, String> hashMap, boolean z, boolean z2) {
        this.spanName = str;
        this.spanId = str2;
        this.parentId = str3;
        this.referenceId = str4;
        this.startTime = j;
        this.finishTime = j2;
        this.threadName = str5;
        this.tags = hashMap;
        this.isErrorSpan = z;
        this.isFinish = z2;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public ITracingWindowSpan parseToSpan(AbsTracing absTracing) {
        if (!this.isFinish) {
            return null;
        }
        ITracingWindowSpan createWindowSpan = absTracing.createWindowSpan(this.spanName, Long.parseLong(this.spanId));
        String str = this.parentId;
        if (str != null && !str.isEmpty()) {
            createWindowSpan.setParentId(Long.parseLong(this.parentId));
        }
        String str2 = this.referenceId;
        if (str2 != null && !str2.isEmpty()) {
            createWindowSpan.setReferenceId(Long.parseLong(this.referenceId));
        }
        createWindowSpan.setThreadName(this.threadName);
        for (Map.Entry<String, String> entry : this.tags.entrySet()) {
            createWindowSpan.addTag(entry.getKey(), entry.getValue());
        }
        return createWindowSpan;
    }

    public String toString() {
        return "NativeSpan{, spanName='" + this.spanName + "', spanId=" + this.spanId + ", parentId=" + this.parentId + ", referenceId=" + this.referenceId + ", startTime=" + this.startTime + ", finishTime=" + this.finishTime + ", threadName='" + this.threadName + "', tags=" + this.tags + ", isErrorSpan=" + this.isErrorSpan + ", isFinish=" + this.isFinish + '}';
    }
}
