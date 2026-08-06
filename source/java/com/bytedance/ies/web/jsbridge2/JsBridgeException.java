package com.bytedance.ies.web.jsbridge2;

/* loaded from: classes4.dex */
class JsBridgeException extends Exception {
    static final int CODE_FAILED = 0;
    static final int CODE_MALFORMED_DATA = -5;
    static final int CODE_NAMESPACE_NOT_FOUND = -4;
    static final int CODE_NOT_FOUND = -2;
    static final int CODE_PERMISSION_DENIED = -1;
    int code;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsBridgeException(int i) {
        this.code = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsBridgeException(int i, String str) {
        super(str);
        this.code = i;
    }
}
