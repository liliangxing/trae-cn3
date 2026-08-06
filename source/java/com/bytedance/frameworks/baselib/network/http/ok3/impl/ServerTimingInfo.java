package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* compiled from: OkHttp3RequestLog.java */
/* loaded from: classes2.dex */
class ServerTimingInfo {
    boolean mPassedCdn = false;
    boolean mCdnHitCache = false;
    long mEdge = -1;
    long mOrigin = -1;
    long mInner = -1;
    long mRtt = -1;
}
