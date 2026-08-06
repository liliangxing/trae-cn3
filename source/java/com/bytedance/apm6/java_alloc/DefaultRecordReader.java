package com.bytedance.apm6.java_alloc;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.java_alloc.model.ReportInfo;
import com.bytedance.apm6.util.log.Logger;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DefaultRecordReader implements IRecordReader {
    private static final String TAG = "APM-Alloc-RecordReader";
    private JavaAllocConfig config;
    private long duration;
    private String scene;
    public final ArrayList<ReportInfo> result = new ArrayList<>();
    private final DefaultTraceReader traceReader = new DefaultTraceReader();

    @Override // com.bytedance.apm6.java_alloc.IRecordReader
    public boolean onItem(String str, int i, int i2, Trace trace, int i3) {
        this.traceReader.setTrace(trace);
        trace.onTrace(this.traceReader);
        this.result.add(new ReportInfo(str, i, i2, i3, this.scene, new ArrayList(this.traceReader.getResult())));
        this.traceReader.clear();
        return true;
    }

    @Override // com.bytedance.apm6.java_alloc.IRecordReader
    public void onHeadInfo(String str, long j, long j2, int i, JavaAllocConfig javaAllocConfig, long j3, long j4) {
        if (ApmContext.isDebugMode()) {
            Logger.m119d(TAG, "report totalObjectsCount: " + j + ", totalBytes: " + j2 + ", recordCount: " + i);
        }
        this.traceReader.clear();
        this.scene = str;
        this.config = javaAllocConfig;
        this.duration = j4 - j3;
        this.result.ensureCapacity(i);
    }

    public ArrayList<ReportInfo> getResult() {
        return this.result;
    }

    public long getDuration() {
        return this.duration;
    }

    public JSONObject getConfig() {
        JavaAllocConfig javaAllocConfig = this.config;
        if (javaAllocConfig == null) {
            return null;
        }
        return javaAllocConfig.packJson();
    }
}
