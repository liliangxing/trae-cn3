package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum LocalProxyType {
    SOCKS5(1),
    HTTP_TUNNEL(2);

    private int value;

    LocalProxyType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static LocalProxyType fromId(int id) {
        for (LocalProxyType localProxyType : values()) {
            if (localProxyType.value() == id) {
                return localProxyType;
            }
        }
        return null;
    }
}
