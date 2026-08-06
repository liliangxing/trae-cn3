package com.bytedance.apm6.foundation.trace;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class TraceBean {
    int asyncTag;
    int counterValue;
    JSONObject debugAnnotation;
    float floatCounterValue;
    String name;
    long processId;
    String processName;
    long timeStamp;
    String traceName;
    TraceType traceType;

    /* loaded from: classes3.dex */
    enum TraceType {
        SLICE_BEGIN(0),
        SLICE_END(1),
        ASYNC_SLICE_BEGIN(2),
        ASYNC_SLICE_END(3),
        SLICE_INSTANT(4),
        COUNTER(5),
        FLOAT_COUNTER(6);

        private final int value;

        TraceType(int i) {
            this.value = i;
        }
    }

    public String getProcessName() {
        return this.processName;
    }

    public TraceBean setProcessName(String str) {
        this.processName = str;
        return this;
    }

    public long getProcessId() {
        return this.processId;
    }

    public TraceBean setProcessId(long j) {
        this.processId = j;
        return this;
    }

    public String getTraceName() {
        return this.traceName;
    }

    public TraceBean setTraceName(String str) {
        this.traceName = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public TraceBean setName(String str) {
        this.name = str;
        return this;
    }

    public int getAsyncTag() {
        return this.asyncTag;
    }

    public TraceBean setAsyncTag(int i) {
        this.asyncTag = i;
        return this;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public TraceBean setTimeStamp(long j) {
        this.timeStamp = j;
        return this;
    }

    public float getCounterValue() {
        return this.counterValue;
    }

    public TraceBean setCounterValue(int i) {
        this.counterValue = i;
        return this;
    }

    public float getFloatCounterValue() {
        return this.floatCounterValue;
    }

    public TraceBean setFloatCounterValue(float f) {
        this.floatCounterValue = f;
        return this;
    }

    public TraceType getTraceType() {
        return this.traceType;
    }

    public TraceBean setTraceType(TraceType traceType) {
        this.traceType = traceType;
        return this;
    }

    public JSONObject getDebugAnnotation() {
        return this.debugAnnotation;
    }

    public TraceBean setDebugAnnotation(JSONObject jSONObject) {
        this.debugAnnotation = jSONObject;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("processName", this.processName).putOpt("processId", Long.valueOf(this.processId)).putOpt("traceName", this.traceName).putOpt("timestamp", Long.valueOf(this.timeStamp)).putOpt("traceType", Integer.valueOf(this.traceType.value));
            if (this.traceType == TraceType.COUNTER) {
                jSONObject.putOpt("counterValue", Integer.valueOf(this.counterValue));
            } else if (this.traceType == TraceType.FLOAT_COUNTER) {
                jSONObject.putOpt("floatCounterValue", Float.valueOf(this.floatCounterValue));
            } else if (this.traceType != TraceType.SLICE_END && this.traceType != TraceType.ASYNC_SLICE_END) {
                jSONObject.putOpt("name", this.name);
            }
            if (this.traceType == TraceType.ASYNC_SLICE_BEGIN || this.traceType == TraceType.ASYNC_SLICE_END) {
                jSONObject.putOpt("asyncTag", Integer.valueOf(this.asyncTag));
            }
            JSONObject jSONObject2 = this.debugAnnotation;
            if (jSONObject2 != null) {
                jSONObject.putOpt("debugAnnotation", jSONObject2);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
