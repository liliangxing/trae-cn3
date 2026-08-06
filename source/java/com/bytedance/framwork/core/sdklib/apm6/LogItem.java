package com.bytedance.framwork.core.sdklib.apm6;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LogItem {
    private long aid;
    private byte[] data;
    private long headerId;

    public LogItem(byte[] bArr, long j, long j2) {
        this.data = bArr;
        this.headerId = j2;
        this.aid = j;
    }

    public byte[] getData() {
        return this.data;
    }

    public long getHeaderId() {
        return this.headerId;
    }

    public long getAid() {
        return this.aid;
    }

    public String toString() {
        try {
            return new JSONObject(new String(this.data)).toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
