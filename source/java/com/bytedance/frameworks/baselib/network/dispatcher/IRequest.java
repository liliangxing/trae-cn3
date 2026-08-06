package com.bytedance.frameworks.baselib.network.dispatcher;

/* loaded from: classes2.dex */
public interface IRequest {

    /* loaded from: classes2.dex */
    public enum Priority {
        LOWEST,
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    Priority getPriority();

    int getSequence();
}
