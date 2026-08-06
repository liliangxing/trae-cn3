package com.bytedance.memory.common;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public class MemoryWidgetThreadFactory implements ThreadFactory {
    private final String mThreadName;

    public MemoryWidgetThreadFactory(String str) {
        this.mThreadName = "MemoryWidget_" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.mThreadName);
    }
}
