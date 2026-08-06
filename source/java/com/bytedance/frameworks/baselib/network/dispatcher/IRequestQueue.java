package com.bytedance.frameworks.baselib.network.dispatcher;

/* loaded from: classes2.dex */
public interface IRequestQueue {
    void add(ApiThread apiThread);

    void add(IApiTask iApiTask);

    void addDownload(ApiThread apiThread);

    void addDownload(IApiTask iApiTask);
}
