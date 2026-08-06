package com.bytedance.apm.impl;

import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* loaded from: classes3.dex */
final class MonitorFiledPart implements TypedOutput {
    private final TypedFile file;
    private final Map<String, String> params;

    public MonitorFiledPart(Map<String, String> map, TypedFile typedFile) {
        this.params = map;
        this.file = typedFile;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return buildFileName();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return this.file.mimeType();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.file.length();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream outputStream) throws IOException {
        this.file.writeTo(outputStream);
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return this.file.md5Stub();
    }

    private String buildFileName() {
        StringBuilder append = new StringBuilder(this.file.fileName()).append("\"");
        for (Map.Entry<String, String> entry : this.params.entrySet()) {
            append.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        append.deleteCharAt(append.length() - 1);
        return append.toString();
    }
}
