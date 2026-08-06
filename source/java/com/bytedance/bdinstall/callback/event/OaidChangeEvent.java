package com.bytedance.bdinstall.callback.event;

import com.bytedance.bdinstall.IOaidObserver;

/* loaded from: classes3.dex */
public class OaidChangeEvent {
    private final IOaidObserver.Oaid oaid;

    public OaidChangeEvent(IOaidObserver.Oaid oaid) {
        this.oaid = oaid;
    }

    public IOaidObserver.Oaid getOaid() {
        return this.oaid;
    }
}
