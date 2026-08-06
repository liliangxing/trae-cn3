package com.bytedance.platform.godzilla.common;

/* loaded from: classes4.dex */
public interface UncaughtExceptionConsumer {
    boolean consumeUncaughtException(Thread thread, Throwable th) throws Throwable;
}
