package com.bytedance.apm.agent.instrumentation.transaction;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TransactionData {
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private int errorCode;
    private JSONObject extraData;
    private String httpMethod;
    private long requestEnd;
    private int statusCode;
    private long totalTime;
    private String url;
    private String wanType;
    private long requestStart = System.currentTimeMillis();
    private Object lock = new Object();

    public TransactionData(String str, String str2, long j, int i, int i2, long j2, long j3, String str3, String str4, JSONObject jSONObject) {
        this.url = str;
        this.carrier = str2;
        this.totalTime = j;
        this.statusCode = i;
        this.errorCode = i2;
        this.bytesSent = j2;
        this.bytesReceived = j3;
        this.wanType = str3;
        this.httpMethod = str4;
        this.extraData = jSONObject;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        synchronized (this.lock) {
            this.errorCode = i;
        }
    }

    public long getBytesSent() {
        return this.bytesSent;
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public String getWanType() {
        return this.wanType;
    }

    public long getRequestStart() {
        return this.requestStart;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public JSONObject getExtraData() {
        return this.extraData;
    }

    public long getRequestEnd() {
        return this.requestEnd;
    }

    public void setRequestEnd(long j) {
        this.requestEnd = j;
    }

    public String toString() {
        return "TransactionData{requestStart=" + this.requestStart + ", url='" + this.url + "', carrier='" + this.carrier + "', totalTime=" + this.totalTime + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", wanType='" + this.wanType + "', httpMethod='" + this.httpMethod + "', extraData=" + this.extraData + AbstractJsonLexerKt.END_OBJ;
    }
}
