package com.bytedance.pia.core.api.bridge;

import com.bytedance.pia.core.api.context.IPiaContext;

/* loaded from: classes4.dex */
public interface IPiaBridge {
    IPiaContext getContext();

    void send(String str, Object obj);
}
