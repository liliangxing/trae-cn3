package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.PlatformBindAdapter;
import com.bytedance.sdk.account.platform.PlatformDelegate;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.bytedance.sdk.account.platform.PlatformProfileAdapter;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TiktokPlatformDelegate extends PlatformDelegate {
    private String authCode;
    private String codeVerifier;
    private Bundle extras;
    private String grantedFields;
    private String grantedPermission;
    private boolean isBindMobileApi;
    private boolean isChangeBind;
    private boolean isNeedMobile;
    private PlatformBindAdapter.BindCallback mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private String redirectUrl;
    private String state;
    private String ttopVersion;

    TiktokPlatformDelegate(PlatformBindAdapter platformBindAdapter) {
        super(platformBindAdapter);
        this.isBindMobileApi = platformBindAdapter.isBindPlatformAndThirdMobileMode;
    }

    TiktokPlatformDelegate(PlatformLoginAdapter platformLoginAdapter) {
        super(platformLoginAdapter);
        this.isBindMobileApi = platformLoginAdapter.isLoginAndBindThirdMobileMode;
        this.isNeedMobile = platformLoginAdapter.isRegisterNeedThirdMobile;
        this.isChangeBind = platformLoginAdapter.isChangeBind;
    }

    TiktokPlatformDelegate(PlatformProfileAdapter platformProfileAdapter) {
        super(platformProfileAdapter);
    }

    private void parseData(Bundle bundle) {
        this.authCode = bundle.getString("auth_code");
        this.state = bundle.getString("state");
        this.grantedPermission = bundle.getString("granted_permission");
        this.grantedFields = bundle.getString(ITiktokService.ResponseConstants.GRANTED_FIELDS);
        this.extras = bundle.getBundle("extras");
        this.ttopVersion = bundle.getString(ITiktokService.ResponseConstants.TTOP_VERSION);
        this.codeVerifier = bundle.getString(ITiktokService.ResponseConstants.CODE_VERIFIER);
        this.redirectUrl = bundle.getString(ITiktokService.ResponseConstants.REDIRECT_URL);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestLogin(Bundle bundle) {
        if (this.loginDelegate != null) {
            parseData(bundle);
            Map<String, String> commonRequestParams = getCommonRequestParams();
            if (this.loginDelegate.mExtendParam != null) {
                commonRequestParams.putAll(this.loginDelegate.mExtendParam);
            }
            PlatformLoginAdapter platformLoginAdapter = this.loginDelegate;
            platformLoginAdapter.getClass();
            this.mLoginCallback = new PlatformLoginAdapter.LoginCallback();
            if (this.isBindMobileApi) {
                this.loginDelegate.api.ssoWithAuthCodeBindMobileLogin(this.loginDelegate.platformId, this.loginDelegate.platform, this.authCode, null, this.isNeedMobile, this.isChangeBind, commonRequestParams, this.mLoginCallback);
            } else {
                this.loginDelegate.api.ssoWithAuthCodeLogin(this.loginDelegate.platformId, this.loginDelegate.platform, this.authCode, 0L, commonRequestParams, this.mLoginCallback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestBind(Bundle bundle) {
        if (this.bindDelegate != null) {
            parseData(bundle);
            Map<String, String> commonRequestParams = getCommonRequestParams();
            if (this.bindDelegate.mExtendParam != null) {
                commonRequestParams.putAll(this.bindDelegate.mExtendParam);
            }
            PlatformBindAdapter platformBindAdapter = this.bindDelegate;
            platformBindAdapter.getClass();
            this.mBindCallback = new PlatformBindAdapter.BindCallback();
            if (this.isBindMobileApi) {
                this.bindDelegate.api.bindWithMobile(this.bindDelegate.platformId, this.bindDelegate.platform, this.authCode, null, null, null, null, 0L, null, null, commonRequestParams, this.mBindCallback);
            } else {
                this.bindDelegate.api.ssoWithAuthCodeBind(this.bindDelegate.platformId, this.bindDelegate.platform, this.authCode, 0L, commonRequestParams, this.mBindCallback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestProfile(Bundle bundle) {
        if (this.profileAdapter != null) {
            parseData(bundle);
            Map<String, String> commonRequestParams = getCommonRequestParams();
            if (this.profileAdapter.mExtendParam != null) {
                commonRequestParams.putAll(this.profileAdapter.mExtendParam);
            }
            PlatformProfileAdapter platformProfileAdapter = this.profileAdapter;
            platformProfileAdapter.getClass();
            this.mProfileCallback = new PlatformProfileAdapter.ProfileCallback();
            this.profileAdapter.api.getOauthProfileByCode(this.profileAdapter.platformId, this.profileAdapter.platform, this.authCode, 0L, commonRequestParams, this.mProfileCallback);
        }
    }

    private Map<String, String> getCommonRequestParams() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.ttopVersion)) {
            hashMap.put("ttop_v", this.ttopVersion);
        }
        if (!TextUtils.isEmpty(this.redirectUrl)) {
            hashMap.put("redirect_uri", this.redirectUrl);
        }
        if (!TextUtils.isEmpty(this.codeVerifier)) {
            hashMap.put(ITiktokService.ResponseConstants.CODE_VERIFIER, this.codeVerifier);
        }
        if (!TextUtils.isEmpty(this.grantedFields)) {
            hashMap.put(TracingConstants.KEY_FIELDS, this.grantedFields);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void cancelLogin() {
        PlatformLoginAdapter.LoginCallback loginCallback = this.mLoginCallback;
        if (loginCallback != null) {
            loginCallback.cancel();
            this.mLoginCallback = null;
        }
        this.loginDelegate = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void cancelBind() {
        PlatformBindAdapter.BindCallback bindCallback = this.mBindCallback;
        if (bindCallback != null) {
            bindCallback.cancel();
            this.mBindCallback = null;
        }
        this.bindDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    void cancelProfile() {
        PlatformProfileAdapter.ProfileCallback profileCallback = this.mProfileCallback;
        if (profileCallback != null) {
            profileCallback.cancel();
            this.mProfileCallback = null;
        }
        this.profileAdapter = null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    static class Factory implements PlatformDelegate.IFactory {
        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createLogin(PlatformLoginAdapter platformLoginAdapter) {
            return new TiktokPlatformDelegate(platformLoginAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createBind(PlatformBindAdapter platformBindAdapter) {
            return new TiktokPlatformDelegate(platformBindAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createProfile(PlatformProfileAdapter platformProfileAdapter) {
            return new TiktokPlatformDelegate(platformProfileAdapter);
        }
    }
}
