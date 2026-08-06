package com.bytedance.retrofit2.client;

import java.io.IOException;

/* loaded from: classes4.dex */
public interface Client {

    /* loaded from: classes4.dex */
    public interface Provider {
        Client get();
    }

    SsCall newSsCall(Request request) throws IOException;
}
