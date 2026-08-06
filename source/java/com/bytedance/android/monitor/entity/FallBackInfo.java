package com.bytedance.android.monitor.entity;

/* loaded from: classes3.dex */
public class FallBackInfo {
    public String fallbackType = "schemaError";
    public String sourceContainer;
    public String sourceUrl;
    public String targetContainer;
    public String targetUrl;

    public String toString() {
        return "FallBackInfo{fallbackType='" + this.fallbackType + "', sourceContainer='" + this.sourceContainer + "', sourceUrl='" + this.sourceUrl + "', targetContainer='" + this.targetContainer + "', targetUrl='" + this.targetUrl + "'}";
    }
}
