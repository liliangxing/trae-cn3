package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.PlatformBindAdapter;
import com.bytedance.sdk.account.platform.PlatformDelegate;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.bytedance.sdk.account.platform.PlatformProfileAdapter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class WeiboPlatformDelegate extends PlatformDelegate {
    private String accessToken;
    private Long expiresIn;
    private PlatformBindAdapter.BindCallback mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private String refreshToken;
    private String uid;

    WeiboPlatformDelegate(PlatformBindAdapter platformBindAdapter) {
        super(platformBindAdapter);
    }

    WeiboPlatformDelegate(PlatformLoginAdapter platformLoginAdapter) {
        super(platformLoginAdapter);
    }

    WeiboPlatformDelegate(PlatformProfileAdapter platformProfileAdapter) {
        super(platformProfileAdapter);
    }

    private void parseData(Bundle bundle) {
        this.accessToken = bundle.getString("access_token");
        this.expiresIn = Long.valueOf(bundle.getLong("expires_in"));
        this.uid = bundle.getString("uid");
        this.refreshToken = bundle.getString("refresh_token");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestLogin(Bundle bundle) {
        if (this.loginDelegate != null) {
            parseData(bundle);
            PlatformLoginAdapter platformLoginAdapter = this.loginDelegate;
            platformLoginAdapter.getClass();
            this.mLoginCallback = new PlatformLoginAdapter.LoginCallback();
            this.loginDelegate.api.ssoWithAccessTokenLogin(this.loginDelegate.platformId, this.loginDelegate.platform, this.accessToken, this.expiresIn.longValue(), this.loginDelegate.mExtendParam, this.mLoginCallback);
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
            this.bindDelegate.api.ssoWithAccessTokenBind(this.bindDelegate.platformId, this.bindDelegate.platform, this.accessToken, this.expiresIn.longValue(), this.bindDelegate.mExtendParam, this.mBindCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestProfile(Bundle bundle) {
        if (this.profileAdapter != null) {
            parseData(bundle);
            this.profileAdapter.api.getOauthProfileByAccessToken(this.profileAdapter.platformId, this.profileAdapter.platform, this.accessToken, this.expiresIn.longValue(), this.profileAdapter.mExtendParam, this.mProfileCallback);
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
            return new WeiboPlatformDelegate(platformLoginAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createBind(PlatformBindAdapter platformBindAdapter) {
            return new WeiboPlatformDelegate(platformBindAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createProfile(PlatformProfileAdapter platformProfileAdapter) {
            return new WeiboPlatformDelegate(platformProfileAdapter);
        }
    }
}
