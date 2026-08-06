package com.bytedance.vmsdk.net;

import com.bytedance.android.monitorV2.constant.ReportConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class Request {
    static final String defaultMethod = "GET";
    InputStream body;
    Map<String, String> headers;
    String method;
    String url;

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e A[Catch: JSONException -> 0x0068, TryCatch #0 {JSONException -> 0x0068, blocks: (B:3:0x0007, B:5:0x000f, B:6:0x0016, B:8:0x001a, B:11:0x001e, B:12:0x003d, B:14:0x004e, B:15:0x0052, B:17:0x0058, B:23:0x0026, B:25:0x002c, B:26:0x003b), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Request(String str, JSONObject jSONObject, byte[] bArr) {
        JSONObject jSONObject2;
        try {
            this.url = str;
            this.method = jSONObject.has("method") ? jSONObject.getString("method") : "GET";
            if (bArr != null && bArr.length != 0) {
                this.body = new ByteArrayInputStream(bArr);
                jSONObject2 = (JSONObject) jSONObject.opt("headers");
                this.headers = new HashMap();
                if (jSONObject2 == null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.headers.put(next, jSONObject2.getString(next));
                    }
                    return;
                }
                return;
            }
            this.body = jSONObject.has(ReportConst.ValidationReport.BODY) ? new ByteArrayInputStream(jSONObject.getString(ReportConst.ValidationReport.BODY).getBytes()) : null;
            jSONObject2 = (JSONObject) jSONObject.opt("headers");
            this.headers = new HashMap();
            if (jSONObject2 == null) {
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return this.url;
    }

    public String getMethod() {
        return this.method;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public InputStream getBody() {
        return this.body;
    }

    public String getBodyString() {
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        do {
            try {
                read = this.body.read(bArr, 0, 4096);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        } while (read > 0);
        return byteArrayOutputStream.toString();
    }
}
