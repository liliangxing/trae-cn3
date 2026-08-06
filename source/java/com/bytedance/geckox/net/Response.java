package com.bytedance.geckox.net;

import java.util.Map;

/* loaded from: classes3.dex */
public class Response {
    public final String body;
    public final int code;
    public final Map<String, String> headers;
    public final String msg;

    public Response(Map<String, String> map, String str, int i, String str2) {
        this.headers = map;
        this.body = str;
        this.code = i;
        this.msg = str2;
    }
}
