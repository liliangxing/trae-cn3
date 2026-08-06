package com.bytedance.common.wschannel;

/* loaded from: classes3.dex */
public enum TransportMode {
    TUDP(0),
    TLS(1),
    HTTP2(2),
    TUDP_PROXY(3),
    TLS_PROXY(4);

    final int mTypeValue;

    public static TransportMode convertToMode() {
        return null;
    }

    TransportMode(int i) {
        this.mTypeValue = i;
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }
}
