package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.PlatformBindAdapter;
import com.bytedance.sdk.account.platform.PlatformDelegate;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.bytedance.sdk.account.platform.PlatformProfileAdapter;
import com.bytedance.sdk.account.platform.api.IVKService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class VKPlatformDelegate extends PlatformDelegate {
    String ACCESS_TOKEN;
    String CREATED;
    String EMAIL;
    String PHONE;
    String PHONE_ACCESS_KEY;
    String SECRET;
    String USER_ID;
    private String accessToken;
    private long created;
    private String email;
    private PlatformBindAdapter.BindCallback mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private String phone;
    private String phoneAccessKey;
    private String secret;
    private int userId;

    VKPlatformDelegate(PlatformBindAdapter platformBindAdapter) {
        super(platformBindAdapter);
        this.ACCESS_TOKEN = "access_token";
        this.USER_ID = "user_id";
        this.SECRET = "secret";
        this.CREATED = IVKService.ResponseConstants.CREATED;
        this.EMAIL = "email";
        this.PHONE = "phone";
        this.PHONE_ACCESS_KEY = IVKService.ResponseConstants.PHONE_ACCESS_KEY;
    }

    VKPlatformDelegate(PlatformLoginAdapter platformLoginAdapter) {
        super(platformLoginAdapter);
        this.ACCESS_TOKEN = "access_token";
        this.USER_ID = "user_id";
        this.SECRET = "secret";
        this.CREATED = IVKService.ResponseConstants.CREATED;
        this.EMAIL = "email";
        this.PHONE = "phone";
        this.PHONE_ACCESS_KEY = IVKService.ResponseConstants.PHONE_ACCESS_KEY;
    }

    VKPlatformDelegate(PlatformProfileAdapter platformProfileAdapter) {
        super(platformProfileAdapter);
        this.ACCESS_TOKEN = "access_token";
        this.USER_ID = "user_id";
        this.SECRET = "secret";
        this.CREATED = IVKService.ResponseConstants.CREATED;
        this.EMAIL = "email";
        this.PHONE = "phone";
        this.PHONE_ACCESS_KEY = IVKService.ResponseConstants.PHONE_ACCESS_KEY;
    }

    private void parseData(Bundle bundle) {
        this.accessToken = bundle.getString("access_token");
        this.userId = bundle.getInt("user_id");
        this.secret = bundle.getString("secret");
        this.created = bundle.getLong(IVKService.ResponseConstants.CREATED);
        this.email = bundle.getString("email");
        this.phone = bundle.getString("phone");
        this.phoneAccessKey = bundle.getString(IVKService.ResponseConstants.PHONE_ACCESS_KEY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestLogin(Bundle bundle) {
        if (this.loginDelegate != null) {
            parseData(bundle);
            PlatformLoginAdapter platformLoginAdapter = this.loginDelegate;
            platformLoginAdapter.getClass();
            this.mLoginCallback = new PlatformLoginAdapter.LoginCallback();
            this.loginDelegate.api.ssoWithAccessTokenLogin(this.loginDelegate.platformId, this.loginDelegate.platform, this.accessToken, this.secret, 0L, this.loginDelegate.mExtendParam, this.mLoginCallback);
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
            this.bindDelegate.api.ssoWithAccessTokenBind(this.bindDelegate.platformId, this.bindDelegate.platform, this.accessToken, this.secret, 0L, this.bindDelegate.mExtendParam, this.mBindCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestProfile(Bundle bundle) {
        if (this.profileAdapter != null) {
            parseData(bundle);
            this.profileAdapter.api.getOauthProfileByAccessToken(this.profileAdapter.platformId, this.profileAdapter.platform, this.accessToken, this.secret, 0L, this.profileAdapter.mExtendParam, this.mProfileCallback);
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
            return new VKPlatformDelegate(platformLoginAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createBind(PlatformBindAdapter platformBindAdapter) {
            return new VKPlatformDelegate(platformBindAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createProfile(PlatformProfileAdapter platformProfileAdapter) {
            return new VKPlatformDelegate(platformProfileAdapter);
        }
    }
}
