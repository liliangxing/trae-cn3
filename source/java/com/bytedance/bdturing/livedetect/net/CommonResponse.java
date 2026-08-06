package com.bytedance.bdturing.livedetect.net;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CommonResponse {
    public int code;
    public JSONObject data;
    public String message;
    public String sec_message;

    public String toString() {
        return "CommonResponse{code=" + this.code + ", data=" + this.data + ", message='" + this.message + "', sec_message='" + this.sec_message + "'}";
    }
}
