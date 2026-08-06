package com.bytedance.sdk.xbridge.cn.auth.utils;

import kotlin.Metadata;

/* compiled from: AuthConfigUtilsForDebug.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/utils/AuthConfigUtilsForDebug;", "", "()V", "JSBAuthMode", "", "getJSBAuthMode", "()I", "setJSBAuthMode", "(I)V", "enableDebug", "", "getEnableDebug", "()Z", "setEnableDebug", "(Z)V", "signVerifyMode", "getSignVerifyMode", "setSignVerifyMode", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthConfigUtilsForDebug {
    private static boolean enableDebug;
    public static final AuthConfigUtilsForDebug INSTANCE = new AuthConfigUtilsForDebug();
    private static int signVerifyMode = -1;
    private static int JSBAuthMode = -1;

    private AuthConfigUtilsForDebug() {
    }

    public final boolean getEnableDebug() {
        return enableDebug;
    }

    public final void setEnableDebug(boolean z) {
        enableDebug = z;
    }

    public final int getSignVerifyMode() {
        return signVerifyMode;
    }

    public final void setSignVerifyMode(int i) {
        signVerifyMode = i;
    }

    public final int getJSBAuthMode() {
        return JSBAuthMode;
    }

    public final void setJSBAuthMode(int i) {
        JSBAuthMode = i;
    }
}
