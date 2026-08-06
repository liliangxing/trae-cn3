package com.bytedance.apm.block;

import android.os.Message;

/* loaded from: classes3.dex */
public interface ILooperObserver {
    void messageDispatchStarting(String str);

    void messageDispatched(String str, Message message);
}
