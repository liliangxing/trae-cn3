package com.bytedance.sdk.account.network.dispatcher;

/* loaded from: classes5.dex */
public interface IRequest {

    /* loaded from: classes5.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    Priority getPriority();

    int getSequence();
}
