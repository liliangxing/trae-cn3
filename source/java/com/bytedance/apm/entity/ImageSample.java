package com.bytedance.apm.entity;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ImageSample {
    public int count = 1;
    public long last_duration;
    public JSONObject last_extra;
    public String last_ip;
    public long last_timestamp;
    public String last_uri;
    public int status;

    public ImageSample(String str, int i, String str2, long j, long j2, JSONObject jSONObject) {
        this.last_ip = str2;
        this.last_uri = str;
        this.status = i;
        this.last_timestamp = j;
        this.last_duration = j2;
        this.last_extra = jSONObject;
    }
}
