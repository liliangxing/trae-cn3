package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ContainerStrategyConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "", "strategyName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStrategyName", "()Ljava/lang/String;", "WebUrlListVerify", "JSBAuth", "CSRF_PROTECT", "LynxSignVerify", "PrefetchWhiteList", "TTMACHINE", "LynxLoadWhiteList", "MotionVerify", "HttpsDomain", "LynxSSRUrlVerify", "WebViewCSRFUA", "UploadFileVerify", "LoginStateSourceVerify", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusStrategyProviderType {
    WebUrlListVerify(ArgusStrategyName.WEB_URL_LIST_VERIFY),
    JSBAuth(ArgusStrategyName.JSB_AUTH),
    CSRF_PROTECT(ArgusStrategyName.CSRF_PROTECT),
    LynxSignVerify(ArgusStrategyName.LYNX_SIGN_VERIFY),
    PrefetchWhiteList(ArgusStrategyName.PREFETCH_WHITE_LIST),
    TTMACHINE(ArgusStrategyName.TTMACHINE),
    LynxLoadWhiteList(ArgusStrategyName.Lynx_LOAD_WHITE_LIST_VERIFY),
    MotionVerify(ArgusStrategyName.MOTION_VERIFY),
    HttpsDomain(ArgusStrategyName.HTTPS_DOMAIN),
    LynxSSRUrlVerify(ArgusStrategyName.LYNX_SSR_URL_VERIFY),
    WebViewCSRFUA(ArgusStrategyName.WEBVIEW_CSRF_UA),
    UploadFileVerify(ArgusStrategyName.UPLOAD_FILE_VERIFY),
    LoginStateSourceVerify(ArgusStrategyName.LOGIN_STATE_SOURCE_VERIFY);

    private final String strategyName;

    ArgusStrategyProviderType(String str) {
        this.strategyName = str;
    }

    public final String getStrategyName() {
        return this.strategyName;
    }
}
