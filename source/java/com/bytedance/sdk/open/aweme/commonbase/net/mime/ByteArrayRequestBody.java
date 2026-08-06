package com.bytedance.sdk.open.aweme.commonbase.net.mime;

import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.net.OpenRequestBody;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public class ByteArrayRequestBody extends OpenRequestBody {
    private byte[] bytes;
    private String contentType;
    private String fileName;
    private String realContentType;

    public ByteArrayRequestBody(String str, byte[] bArr, String str2) {
        this.contentType = str;
        this.bytes = bArr;
        this.fileName = str2;
        this.realContentType = TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) ? "application/unknown" : "application/octet-stream" : str;
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public String contentType() {
        return this.realContentType;
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public String fileName() {
        return this.fileName;
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public long length() {
        return this.bytes.length;
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.bytes);
    }
}
