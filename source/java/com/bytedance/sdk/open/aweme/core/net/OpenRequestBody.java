package com.bytedance.sdk.open.aweme.core.net;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public abstract class OpenRequestBody {
    public abstract String contentType();

    public abstract String fileName();

    public abstract long length();

    public abstract void writeTo(OutputStream outputStream) throws IOException;
}
