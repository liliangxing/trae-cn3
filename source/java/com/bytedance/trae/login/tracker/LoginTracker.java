package com.bytedance.trae.login.tracker;

import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.monitor.fluency.FluencyHelper;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LoginTracker.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\"\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0018\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0012J.\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/login/tracker/LoginTracker;", "", "<init>", "()V", "EVENT_LOGIN_CLICK", "", "EVENT_LOGIN_RESULT", "EVENT_ACCOUNT_BINDING_PAGE_VIEW", "EVENT_ACCOUNT_BINDING_CLICK", "EVENT_ACCOUNT_BINDING_RESULT", "CURRENT_PAGE_DOUYIN_BIND_PHONE", "SOURCE_DOUYIN_LOGIN", "TYPE_PHONE", "ACTION_BIND", "ACTION_SEND_CODE", "RESULT_SUCCESS", "RESULT_FAIL", "trackLoginClick", "", "type", "trackLoginResult", "isSuccess", "", "failReason", "trackDouyinBindPhonePageView", "trackDouyinBindPhoneSendCodeClick", "trackDouyinBindPhoneResult", FluencyHelper.STAGE, "errorCode", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LoginTracker {
    private static final String ACTION_BIND = "bind";
    private static final String ACTION_SEND_CODE = "send_code";
    private static final String CURRENT_PAGE_DOUYIN_BIND_PHONE = "douyin_bind_phone";
    private static final String EVENT_ACCOUNT_BINDING_CLICK = "icube_account_binding_click";
    private static final String EVENT_ACCOUNT_BINDING_PAGE_VIEW = "icube_account_binding_page_view";
    private static final String EVENT_ACCOUNT_BINDING_RESULT = "icube_account_binding_result";
    private static final String EVENT_LOGIN_CLICK = "icube_login_click";
    private static final String EVENT_LOGIN_RESULT = "icube_login_result";
    public static final LoginTracker INSTANCE = new LoginTracker();
    private static final String RESULT_FAIL = "fail";
    private static final String RESULT_SUCCESS = "success";
    private static final String SOURCE_DOUYIN_LOGIN = "douyin_login";
    private static final String TYPE_PHONE = "phone";

    private LoginTracker() {
    }

    public final void trackLoginClick(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", type);
        IApplog.Companion.reportEvent(EVENT_LOGIN_CLICK, jSONObject);
    }

    public static /* synthetic */ void trackLoginResult$default(LoginTracker loginTracker, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        loginTracker.trackLoginResult(z, str, str2);
    }

    public final void trackLoginResult(boolean isSuccess, String type, String failReason) {
        Intrinsics.checkNotNullParameter(type, "type");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("is_success", isSuccess ? 1 : 0);
        jSONObject.put("type", type);
        if (!isSuccess) {
            String str = failReason;
            if (!(str == null || str.length() == 0)) {
                jSONObject.put("fail_reason", failReason);
            }
        }
        IApplog.Companion.reportEvent(EVENT_LOGIN_RESULT, jSONObject);
    }

    public final void trackDouyinBindPhonePageView() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("current_page", CURRENT_PAGE_DOUYIN_BIND_PHONE);
        jSONObject.put(EventConstants.PARAM_SOURCE, SOURCE_DOUYIN_LOGIN);
        jSONObject.put("type", "phone");
        jSONObject.put("action", "bind");
        IApplog.Companion.reportEvent(EVENT_ACCOUNT_BINDING_PAGE_VIEW, jSONObject);
    }

    public final void trackDouyinBindPhoneSendCodeClick() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("current_page", CURRENT_PAGE_DOUYIN_BIND_PHONE);
        jSONObject.put(EventConstants.PARAM_SOURCE, SOURCE_DOUYIN_LOGIN);
        jSONObject.put("type", "phone");
        jSONObject.put("action", ACTION_SEND_CODE);
        IApplog.Companion.reportEvent(EVENT_ACCOUNT_BINDING_CLICK, jSONObject);
    }

    public static /* synthetic */ void trackDouyinBindPhoneResult$default(LoginTracker loginTracker, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        loginTracker.trackDouyinBindPhoneResult(z, str, str2, str3);
    }

    public final void trackDouyinBindPhoneResult(boolean isSuccess, String stage, String errorCode, String failReason) {
        Intrinsics.checkNotNullParameter(stage, FluencyHelper.STAGE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("current_page", CURRENT_PAGE_DOUYIN_BIND_PHONE);
        jSONObject.put(EventConstants.PARAM_SOURCE, SOURCE_DOUYIN_LOGIN);
        jSONObject.put("type", "phone");
        jSONObject.put("action", "bind");
        jSONObject.put("result", isSuccess ? "success" : "fail");
        jSONObject.put(FluencyHelper.STAGE, stage);
        String str = errorCode;
        if (!(str == null || str.length() == 0)) {
            jSONObject.put(CDNLoader.DIAGNOSE_ERROR_CODE, errorCode);
        }
        String str2 = failReason;
        if (!(str2 == null || str2.length() == 0)) {
            jSONObject.put("fail_reason", failReason);
        }
        IApplog.Companion.reportEvent(EVENT_ACCOUNT_BINDING_RESULT, jSONObject);
    }
}
