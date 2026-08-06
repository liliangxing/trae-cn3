package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* compiled from: OkHttp3RequestLog.java */
/* loaded from: classes2.dex */
enum TTNetDnsCacheSource {
    UNKNOWN(-1),
    SOURCE_HTTPDNS(3),
    SOURCE_PROC(6),
    SOURCE_PRELOAD_BATCH_HTTPDNS(7),
    SOURCE_ASYNC_BATCH_HTTPDNS(8);

    final int mValue;

    TTNetDnsCacheSource(int i) {
        this.mValue = i;
    }
}
