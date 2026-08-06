package com.bytedance.apm.agent.instrumentation.io;

/* loaded from: classes3.dex */
public interface StreamCompleteListenerSource {
    void addStreamCompleteListener(StreamCompleteListener streamCompleteListener);

    void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener);
}
