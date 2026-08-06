package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum LocalProxyError {
    OK(0),
    SOCKS5_VERSION_ERROR(1),
    SOCKS5_FORMAT_ERROR(2),
    SOCKS5_INVALID_VALUE(3),
    SOCKS5_USER_PASS_NOT_GIVEN(4),
    SOCKS5_TCP_CLOSED(5),
    HTTP_TUNNEL_FAILED(6);

    private int value;

    LocalProxyError(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static LocalProxyError fromId(int id) {
        for (LocalProxyError localProxyError : values()) {
            if (localProxyError.value() == id) {
                return localProxyError;
            }
        }
        return null;
    }
}
