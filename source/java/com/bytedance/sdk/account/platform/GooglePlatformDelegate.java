package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.PlatformBindAdapter;
import com.bytedance.sdk.account.platform.PlatformDelegate;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.bytedance.sdk.account.platform.PlatformProfileAdapter;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
class GooglePlatformDelegate extends PlatformDelegate {
    private String displayName;
    private long expiresIn;

    /* renamed from: id */
    private String f10id;
    private String idToken;
    private PlatformBindAdapter.BindCallback mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private String nonce;
    private String serverAuthCode;

    GooglePlatformDelegate(PlatformBindAdapter platformBindAdapter) {
        super(platformBindAdapter);
    }

    GooglePlatformDelegate(PlatformLoginAdapter platformLoginAdapter) {
        super(platformLoginAdapter);
    }

    GooglePlatformDelegate(PlatformProfileAdapter platformProfileAdapter) {
        super(platformProfileAdapter);
    }

    private void parseData(Bundle bundle) {
        this.f10id = bundle.getString("id");
        this.idToken = bundle.getString(IGoogleService.ResponseKey.ID_TOKEN);
        this.expiresIn = bundle.getLong("expire_in", 0L);
        this.displayName = bundle.getString(IGoogleService.ResponseKey.DISPLAY_NAME);
        this.serverAuthCode = bundle.getString(IGoogleService.ResponseKey.SERVER_AUTH_CODE);
        this.nonce = bundle.getString("nonce");
    }

    private void parseAppAuthData(Bundle bundle) {
        this.idToken = bundle.getString("id_token");
        this.expiresIn = bundle.getLong(IAppAuthService.ResponseKey.ACCESS_TOKEN_EXPIRATION_TIME);
        this.nonce = bundle.getString("nonce");
    }

    private void parse(Bundle bundle, int i) {
        if (i == 0) {
            parseData(bundle);
            return;
        }
        if (i == 1) {
            IGoogleService iGoogleService = (IGoogleService) AuthorizeFramework.getService(IGoogleService.class);
            if (iGoogleService != null && iGoogleService.isGooglePlayServiceAvailable()) {
                parseData(bundle);
                return;
            } else {
                parseAppAuthData(bundle);
                return;
            }
        }
        parseAppAuthData(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestLogin(Bundle bundle) {
        if (this.loginDelegate != null) {
            parse(bundle, this.loginDelegate.appAuth);
            PlatformLoginAdapter platformLoginAdapter = this.loginDelegate;
            platformLoginAdapter.getClass();
            this.mLoginCallback = new PlatformLoginAdapter.LoginCallback();
            if (this.loginDelegate.mExtendParam == null) {
                this.loginDelegate.mExtendParam = new HashMap();
            }
            if (!TextUtils.isEmpty(this.serverAuthCode)) {
                this.loginDelegate.mExtendParam.put("code", this.serverAuthCode);
            }
            if (!TextUtils.isEmpty(this.nonce)) {
                this.loginDelegate.mExtendParam.put("nonce", this.nonce);
            }
            this.loginDelegate.api.ssoWithAccessTokenLogin(this.loginDelegate.platformId, this.loginDelegate.platform, null, this.idToken, this.expiresIn, this.loginDelegate.mExtendParam, this.mLoginCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestBind(Bundle bundle) {
        if (this.bindDelegate != null) {
            parse(bundle, this.bindDelegate.appAuth);
            PlatformBindAdapter platformBindAdapter = this.bindDelegate;
            platformBindAdapter.getClass();
            this.mBindCallback = new PlatformBindAdapter.BindCallback();
            if (this.bindDelegate.mExtendParam == null) {
                this.bindDelegate.mExtendParam = new HashMap();
            }
            if (!TextUtils.isEmpty(this.serverAuthCode)) {
                this.bindDelegate.mExtendParam.put("code", this.serverAuthCode);
            }
            if (!TextUtils.isEmpty(this.nonce)) {
                this.bindDelegate.mExtendParam.put("nonce", this.nonce);
            }
            this.bindDelegate.api.ssoWithAccessTokenBind(this.bindDelegate.platformId, this.bindDelegate.platform, null, this.idToken, this.expiresIn, this.bindDelegate.mExtendParam, this.mBindCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestProfile(Bundle bundle) {
        if (this.profileAdapter != null) {
            parseData(bundle);
            if (this.profileAdapter.mExtendParam == null) {
                this.profileAdapter.mExtendParam = new HashMap();
            }
            if (!TextUtils.isEmpty(this.serverAuthCode)) {
                this.profileAdapter.mExtendParam.put("code", this.serverAuthCode);
            }
            if (!TextUtils.isEmpty(this.nonce)) {
                this.profileAdapter.mExtendParam.put("nonce", this.nonce);
            }
            this.profileAdapter.api.getOauthProfileByAccessToken(this.profileAdapter.platformId, this.profileAdapter.platform, null, this.idToken, this.expiresIn, this.profileAdapter.mExtendParam, this.mProfileCallback);
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
    static class Factory implements PlatformDelegate.IFactory {
        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createLogin(PlatformLoginAdapter platformLoginAdapter) {
            return new GooglePlatformDelegate(platformLoginAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createBind(PlatformBindAdapter platformBindAdapter) {
            return new GooglePlatformDelegate(platformBindAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createProfile(PlatformProfileAdapter platformProfileAdapter) {
            return new GooglePlatformDelegate(platformProfileAdapter);
        }
    }
}
