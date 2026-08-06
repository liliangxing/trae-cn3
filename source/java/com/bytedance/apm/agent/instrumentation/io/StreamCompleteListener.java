package com.bytedance.apm.agent.instrumentation.io;

/* loaded from: classes3.dex */
public interface StreamCompleteListener {
    void streamComplete(StreamCompleteEvent streamCompleteEvent);

    void streamError(StreamCompleteEvent streamCompleteEvent);
}
