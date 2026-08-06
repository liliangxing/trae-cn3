package com.bytedance.sdk.open.aweme.core.net;

/* loaded from: classes5.dex */
public interface IOpenHostNetCall {
    void cancel();

    OpenHostResponse execute();

    OpenHostRequest getRequest();
}
