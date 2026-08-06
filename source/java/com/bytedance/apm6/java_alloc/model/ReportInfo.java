package com.bytedance.apm6.java_alloc.model;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.ss.android.update.UpdateDialogNewBase;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ReportInfo {
    private static final int MAX_TRACE_SIZE = 128;
    private static final String TAG = "APM-Alloc-ReportInfo";
    public int bytes;
    public String className;
    public int count;
    public int exceptionType;
    private String scene;
    public List<StackTraceElement> tracebacks;

    public ReportInfo(String str, int i, int i2, int i3, String str2, List<StackTraceElement> list) {
        this.className = str;
        this.count = i;
        this.bytes = i2;
        this.exceptionType = i3;
        this.scene = str2;
        this.tracebacks = list;
    }

    public JSONObject packJson(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("object_class", this.className);
            jSONObject2.put("count", this.count);
            jSONObject2.put("size", this.bytes);
            jSONObject2.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, this.exceptionType);
            String combineStacks = combineStacks(this.tracebacks);
            jSONObject2.put("stack", combineStacks);
            if (ApmContext.isDebugMode()) {
                Logger.i(TAG, "stacks: " + combineStacks);
            }
            jSONObject.put("alloc_scene", this.scene);
            jSONObject2.put("filters", jSONObject);
            return jSONObject2;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static String combineStacks(List<StackTraceElement> list) {
        int i;
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = size / 2;
        if (size > 128) {
            int i3 = (size - 128) / 2;
            int i4 = i2 - i3;
            i = i2 + (size - i3);
            i2 = i4;
        } else {
            i = i2;
        }
        if (ApmContext.isDebugMode()) {
            Logger.i(TAG, "traceSize: " + size);
        }
        for (int i5 = 0; i5 < i2; i5++) {
            sb.append("at ").append(list.get(i5)).append(UpdateDialogNewBase.TYPE);
        }
        if (size > 128) {
            sb.append("... skip ").append(size - 128).append(" lines\n");
        }
        while (i < size) {
            sb.append("at ").append(list.get(i)).append(UpdateDialogNewBase.TYPE);
            i++;
        }
        return sb.toString();
    }
}
