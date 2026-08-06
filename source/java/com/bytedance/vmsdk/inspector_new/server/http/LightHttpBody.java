package com.bytedance.vmsdk.inspector_new.server.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes6.dex */
public abstract class LightHttpBody {
    public abstract int contentLength();

    public abstract String contentType();

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static LightHttpBody create(String str, String str2) {
        try {
            return create(str.getBytes("UTF-8"), str2);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static LightHttpBody create(final byte[] bArr, final String str) {
        return new LightHttpBody() { // from class: com.bytedance.vmsdk.inspector_new.server.http.LightHttpBody.1
            @Override // com.bytedance.vmsdk.inspector_new.server.http.LightHttpBody
            public String contentType() {
                return str;
            }

            @Override // com.bytedance.vmsdk.inspector_new.server.http.LightHttpBody
            public int contentLength() {
                return bArr.length;
            }

            @Override // com.bytedance.vmsdk.inspector_new.server.http.LightHttpBody
            public void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write(bArr);
            }
        };
    }
}
