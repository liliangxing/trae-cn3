package com.bytedance.sdk.xbridge.cn.protocol.auth;

import kotlin.Metadata;

/* compiled from: ISafeAuthWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/auth/ISafeAuthWebView;", "", "getAuthUrlSourceType", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthUrlSourceType;", "getXSafeUrl", "", "isEnableSafeAuth", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface ISafeAuthWebView {
    AuthUrlSourceType getAuthUrlSourceType();

    String getXSafeUrl();

    boolean isEnableSafeAuth();

    /* compiled from: ISafeAuthWebView.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static String getXSafeUrl(ISafeAuthWebView iSafeAuthWebView) {
            return null;
        }

        public static AuthUrlSourceType getAuthUrlSourceType(ISafeAuthWebView iSafeAuthWebView) {
            return AuthUrlSourceType.Unset;
        }
    }
}
