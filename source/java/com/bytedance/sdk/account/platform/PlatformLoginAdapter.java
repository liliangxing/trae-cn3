package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.PlatformDelegate;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class PlatformLoginAdapter extends BaseAccountAdapter implements IPlatformLoginAdapter {
    boolean isChangeBind;
    boolean isLoginAndBindThirdMobileMode;
    boolean isLoginNeedBindMobile;
    boolean isRegisterNeedThirdMobile;
    boolean isShareLogin;
    private PlatformDelegate mPlatformDelegate;

    public PlatformLoginAdapter(Context context, String str, String str2) {
        super(context, str, str2);
        this.isLoginAndBindThirdMobileMode = false;
    }

    public PlatformLoginAdapter(Context context, String str, String str2, Map<String, String> map) {
        this(context, str, str2);
        this.mExtendParam = map;
    }

    public PlatformLoginAdapter(Context context, String str, String str2, boolean z, boolean z2) {
        super(context, str, str2);
        this.isLoginAndBindThirdMobileMode = true;
        this.isRegisterNeedThirdMobile = z;
        this.isChangeBind = z2;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle bundle) {
        AccountMonitorUtil.platformAuthEvent(this.platform, "login", 1, null, null, false, null);
        PlatformDelegate.IFactory iFactory = delegateMap.get(this.platform);
        if (iFactory != null) {
            PlatformDelegate createLogin = iFactory.createLogin(this);
            this.mPlatformDelegate = createLogin;
            createLogin.requestLogin(bundle);
        }
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse authorizeErrorResponse) {
        AccountMonitorUtil.platformAuthEvent(this.platform, "login", 0, authorizeErrorResponse.platformErrorCode, authorizeErrorResponse.platformErrorMsg, authorizeErrorResponse.isCancel, null);
        onLoginError(getErrorResponse(authorizeErrorResponse));
    }

    public void cancelLogin() {
        PlatformDelegate platformDelegate = this.mPlatformDelegate;
        if (platformDelegate != null) {
            platformDelegate.cancelLogin();
            this.mPlatformDelegate = null;
        }
    }

    public PlatformLoginAdapter setLoginAndBindThirdMobileMode(boolean z) {
        this.isLoginAndBindThirdMobileMode = z;
        return this;
    }

    public PlatformLoginAdapter setRegisterNeedThirdMobile(boolean z) {
        this.isRegisterNeedThirdMobile = z;
        return this;
    }

    public PlatformLoginAdapter setLoginNeedBindMobile(boolean z) {
        this.isLoginNeedBindMobile = z;
        return this;
    }

    public PlatformLoginAdapter setLoginMustBindMobile(boolean z) {
        if (z) {
            this.isRegisterNeedThirdMobile = true;
            this.isLoginNeedBindMobile = true;
        }
        return this;
    }

    public PlatformLoginAdapter setChangeBind(boolean z) {
        this.isChangeBind = z;
        return this;
    }

    public PlatformLoginAdapter setShareLogin(boolean z) {
        this.isShareLogin = z;
        return this;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    protected class LoginCallback extends CommonCallBack<UserApiResponse> {
        /* JADX INFO: Access modifiers changed from: protected */
        public LoginCallback() {
        }

        @Override // com.bytedance.sdk.account.CommonCallBack
        public void onSuccess(UserApiResponse userApiResponse) {
            PlatformLoginAdapter.this.onLoginSuccess(userApiResponse);
        }

        @Override // com.bytedance.sdk.account.CommonCallBack
        public void onError(UserApiResponse userApiResponse, int i) {
            PlatformLoginAdapter.this.onLoginError(userApiResponse);
        }
    }
}
