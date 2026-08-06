package com.bytedance.frameworks.baselib.network.http;

import java.net.URI;

/* loaded from: classes2.dex */
public interface RequestHandler {
    void abort();

    URI getURI();
}
