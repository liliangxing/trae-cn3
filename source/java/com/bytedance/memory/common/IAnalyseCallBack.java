package com.bytedance.memory.common;

/* loaded from: classes4.dex */
public interface IAnalyseCallBack {
    boolean canAnalyse();

    boolean debugMode();

    void dumpHeap();

    boolean lessThanThreshold();
}
