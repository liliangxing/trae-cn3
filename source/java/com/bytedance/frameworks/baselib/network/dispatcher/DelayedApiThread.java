package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;

/* loaded from: classes2.dex */
public class DelayedApiThread extends ApiThread {
    public DelayedApiThread(String str, IRequest.Priority priority, int i) {
        super(str, priority);
        this.mDelayTime = i;
    }
}
