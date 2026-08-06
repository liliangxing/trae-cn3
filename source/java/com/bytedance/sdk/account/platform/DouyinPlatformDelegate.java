package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.PlatformBindAdapter;
import com.bytedance.sdk.account.platform.PlatformDelegate;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.bytedance.sdk.account.platform.PlatformProfileAdapter;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DouyinPlatformDelegate extends PlatformDelegate {
    private String authCode;
    private boolean isBindThirdMobile;
    private boolean isChangeBind;
    private boolean isLoginNeedBindMobile;
    private boolean isRegisterNeedThirdMobile;
    private PlatformBindAdapter.BindCallback mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;

    DouyinPlatformDelegate(PlatformBindAdapter platformBindAdapter) {
        super(platformBindAdapter);
        this.isBindThirdMobile = platformBindAdapter.isBindPlatformAndThirdMobileMode;
    }

    DouyinPlatformDelegate(PlatformLoginAdapter platformLoginAdapter) {
        super(platformLoginAdapter);
        this.isBindThirdMobile = platformLoginAdapter.isLoginAndBindThirdMobileMode;
        this.isRegisterNeedThirdMobile = platformLoginAdapter.isRegisterNeedThirdMobile;
        this.isLoginNeedBindMobile = platformLoginAdapter.isLoginNeedBindMobile;
        this.isChangeBind = platformLoginAdapter.isChangeBind;
    }

    DouyinPlatformDelegate(PlatformProfileAdapter platformProfileAdapter) {
        super(platformProfileAdapter);
    }

    private void parseData(Bundle bundle) {
        this.authCode = bundle.getString("auth_code");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestLogin(Bundle bundle) {
        if (this.loginDelegate != null) {
            parseData(bundle);
            PlatformLoginAdapter platformLoginAdapter = this.loginDelegate;
            platformLoginAdapter.getClass();
            this.mLoginCallback = new PlatformLoginAdapter.LoginCallback();
            if (this.loginDelegate.isShareLogin) {
                this.loginDelegate.api.shareLogin(this.authCode, this.loginDelegate.platformId, this.loginDelegate.platform, this.loginDelegate.mExtendParam, this.mLoginCallback);
                return;
            }
            if (this.isBindThirdMobile) {
                if (this.isLoginNeedBindMobile) {
                    if (this.loginDelegate.mExtendParam == null) {
                        this.loginDelegate.mExtendParam = new HashMap();
                    }
                    this.loginDelegate.mExtendParam.put("check_mobile", "1");
                }
                this.loginDelegate.api.ssoWithAuthCodeBindMobileLogin(this.loginDelegate.platformId, this.loginDelegate.platform, this.authCode, null, this.isRegisterNeedThirdMobile, this.isChangeBind, this.loginDelegate.mExtendParam, this.mLoginCallback);
                return;
            }
            this.loginDelegate.api.ssoWithAuthCodeLogin(this.loginDelegate.platformId, this.loginDelegate.platform, this.authCode, 0L, this.loginDelegate.mExtendParam, this.mLoginCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestBind(Bundle bundle) {
        if (this.bindDelegate != null) {
            parseData(bundle);
            PlatformBindAdapter platformBindAdapter = this.bindDelegate;
            platformBindAdapter.getClass();
            this.mBindCallback = new PlatformBindAdapter.BindCallback();
            if (this.isBindThirdMobile) {
                this.bindDelegate.api.bindWithMobile(this.bindDelegate.platformId, this.bindDelegate.platform, this.authCode, null, null, null, null, 0L, null, null, this.bindDelegate.mExtendParam, this.mBindCallback);
            } else {
                this.bindDelegate.api.ssoWithAuthCodeBind(this.bindDelegate.platformId, this.bindDelegate.platform, this.authCode, 0L, this.bindDelegate.mExtendParam, this.mBindCallback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestProfile(Bundle bundle) {
        if (this.profileAdapter != null) {
            parseData(bundle);
            PlatformProfileAdapter platformProfileAdapter = this.profileAdapter;
            platformProfileAdapter.getClass();
            this.mProfileCallback = new PlatformProfileAdapter.ProfileCallback();
            this.profileAdapter.api.getOauthProfileByCode(this.profileAdapter.platformId, this.profileAdapter.platform, this.authCode, 0L, this.profileAdapter.mExtendParam, this.mProfileCallback);
        }
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
    public static class Factory implements PlatformDelegate.IFactory {
        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createLogin(PlatformLoginAdapter platformLoginAdapter) {
            return new DouyinPlatformDelegate(platformLoginAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createBind(PlatformBindAdapter platformBindAdapter) {
            return new DouyinPlatformDelegate(platformBindAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createProfile(PlatformProfileAdapter platformProfileAdapter) {
            return new DouyinPlatformDelegate(platformProfileAdapter);
        }
    }
}
