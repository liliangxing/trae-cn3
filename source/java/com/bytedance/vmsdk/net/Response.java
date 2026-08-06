package com.bytedance.vmsdk.net;

import android.util.Log;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class Response {
    private final String TAG = "Response";
    private final byte[] body;
    private ReadableMap headers;
    private final String mimeType;
    private final int status;
    private final String url;

    private static native long nativeCreateResponse(Response response);

    public Response(String str, int i, Map map, InputStream inputStream, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("url == null");
        }
        if (i < 200) {
            throw new IllegalArgumentException("Invalid status code: " + i);
        }
        this.url = str;
        this.status = i;
        this.mimeType = str2;
        this.headers = JavaOnlyMap.from(map);
        if (inputStream == null) {
            this.body = null;
        } else {
            this.body = getBodyBytesInternal(inputStream);
        }
    }

    public int getStatusCode() {
        return this.status;
    }

    public ReadableMap getHeaders() {
        return this.headers;
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] getBodyBytes() {
        return this.body;
    }

    public byte[] getBodyBytesInternal(InputStream inputStream) {
        int read;
        byte[] bArr = new byte[1024];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            do {
                read = inputStream.read(bArr, 0, 1024);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } while (read > 0);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            Log.e("Response", "failed to read response body: " + e.getMessage());
            return null;
        }
    }
}
