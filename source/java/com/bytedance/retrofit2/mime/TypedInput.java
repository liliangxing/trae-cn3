package com.bytedance.retrofit2.mime;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public interface TypedInput {
    InputStream in() throws IOException;

    long length() throws IOException;

    String mimeType();
}
