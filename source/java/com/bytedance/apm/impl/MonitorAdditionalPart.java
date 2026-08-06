package com.bytedance.apm.impl;

import android.text.TextUtils;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class MonitorAdditionalPart implements TypedOutput {
    private final String commonParams;
    private Map<String, String> extraDispositionMap;
    private final String fileName;

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "text/plain";
    }

    public MonitorAdditionalPart(String str, String str2, Map<String, String> map) {
        this.fileName = str;
        this.extraDispositionMap = map;
        if (TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("defaultData", "none commonParams");
            } catch (JSONException unused) {
            }
            this.commonParams = jSONObject.toString();
            return;
        }
        this.commonParams = str2;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return buildFileName(this.fileName, this.extraDispositionMap);
    }

    private String buildFileName(String str, Map<String, String> map) {
        StringBuilder append = new StringBuilder(str).append("\"");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            append.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        append.deleteCharAt(append.length() - 1);
        return append.toString();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.commonParams.getBytes().length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.commonParams.getBytes());
    }
}
