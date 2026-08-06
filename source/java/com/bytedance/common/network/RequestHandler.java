package com.bytedance.common.network;

import java.net.URI;

/* loaded from: classes3.dex */
public interface RequestHandler {
    void abort();

    URI getURI();
}
