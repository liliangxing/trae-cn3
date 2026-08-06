package com.bytedance.apm6.consumer.slardar.weedout;

/* loaded from: classes3.dex */
public interface WeedOutStrategy {
    void doWeedOut(long j);

    void doWeedOutSize(long j);

    String getName();

    long getSize();
}
