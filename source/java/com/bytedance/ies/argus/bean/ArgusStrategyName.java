package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ContainerStrategyConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusStrategyName;", "", "()V", "CSRF_PROTECT", "", "HTTPS_DOMAIN", "JSB_AUTH", "LOGIN_STATE_SOURCE_VERIFY", "LYNX_SIGN_VERIFY", "LYNX_SSR_URL_VERIFY", "Lynx_LOAD_WHITE_LIST_VERIFY", "MOTION_VERIFY", "PREFETCH_WHITE_LIST", "TTMACHINE", "UPLOAD_FILE_VERIFY", "WEBVIEW_CSRF_UA", "WEB_URL_LIST_VERIFY", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ArgusStrategyName {
    public static final String CSRF_PROTECT = "csrf_protect";
    public static final String HTTPS_DOMAIN = "force_https";
    public static final ArgusStrategyName INSTANCE = new ArgusStrategyName();
    public static final String JSB_AUTH = "jsb_auth";
    public static final String LOGIN_STATE_SOURCE_VERIFY = "login_state_source_verify";
    public static final String LYNX_SIGN_VERIFY = "lynx_sign_verify";
    public static final String LYNX_SSR_URL_VERIFY = "lynx_ssr_url_verify";
    public static final String Lynx_LOAD_WHITE_LIST_VERIFY = "lynx_load_white_list";
    public static final String MOTION_VERIFY = "motion_verify";
    public static final String PREFETCH_WHITE_LIST = "prefetch_url_list_verify";
    public static final String TTMACHINE = "ttm";
    public static final String UPLOAD_FILE_VERIFY = "upload_file_verify";
    public static final String WEBVIEW_CSRF_UA = "webview_csrf_ua";
    public static final String WEB_URL_LIST_VERIFY = "web_url_list_verify";

    private ArgusStrategyName() {
    }
}
