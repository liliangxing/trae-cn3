package com.bytedance.apm6.consumer.slardar.persistent;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LogItem {
    private byte[] data;

    public LogItem(byte[] bArr) {
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public String toString() {
        try {
            return new JSONObject(new String(this.data)).toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
