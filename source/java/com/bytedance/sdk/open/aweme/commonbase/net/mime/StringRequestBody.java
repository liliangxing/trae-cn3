package com.bytedance.sdk.open.aweme.commonbase.net.mime;

import com.bytedance.sdk.open.aweme.commonbase.net.b;

/* loaded from: classes5.dex */
public class StringRequestBody extends ByteArrayRequestBody {
    public StringRequestBody(String str) {
        super("text/plain; charset=UTF-8", b.a(str), null);
    }
}
