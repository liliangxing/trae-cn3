package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.PlatformBindAdapter;
import com.bytedance.sdk.account.platform.PlatformDelegate;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.bytedance.sdk.account.platform.PlatformProfileAdapter;
import com.bytedance.sdk.account.platform.api.ITaptapService;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TaptapPlatformDelegate extends PlatformDelegate {
    String accessToken;
    HashMap<String, String> extraInfo;
    private PlatformBindAdapter.BindCallback mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    String macKey;
    String version;

    TaptapPlatformDelegate(PlatformBindAdapter platformBindAdapter) {
        super(platformBindAdapter);
    }

    TaptapPlatformDelegate(PlatformLoginAdapter platformLoginAdapter) {
        super(platformLoginAdapter);
    }

    TaptapPlatformDelegate(PlatformProfileAdapter platformProfileAdapter) {
        super(platformProfileAdapter);
    }

    private void parseData(Bundle bundle, Map<String, String> map) {
        this.accessToken = bundle.getString("access_token");
        this.macKey = bundle.getString(ITaptapService.ResponseConstants.MAC_KEY);
        String string = bundle.getString(ITaptapService.TAPTAP_VERSION);
        this.version = string;
        if (TextUtils.isEmpty(string)) {
            this.version = ITaptapService.TAPTAP_VERSION_V2;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        this.extraInfo = hashMap;
        hashMap.put(ITaptapService.ResponseConstants.MAC_KEY, this.macKey);
        if (map != null) {
            this.extraInfo.putAll(map);
        }
        this.extraInfo.put(ITaptapService.TAPTAP_VERSION, this.version);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestLogin(Bundle bundle) {
        if (this.loginDelegate != null) {
            parseData(bundle, this.loginDelegate.mExtendParam);
            PlatformLoginAdapter platformLoginAdapter = this.loginDelegate;
            platformLoginAdapter.getClass();
            this.mLoginCallback = new PlatformLoginAdapter.LoginCallback();
            this.loginDelegate.api.ssoWithAccessTokenLogin(this.loginDelegate.platformId, null, this.accessToken, 0L, this.extraInfo, this.mLoginCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestBind(Bundle bundle) {
        if (this.bindDelegate != null) {
            parseData(bundle, this.bindDelegate.mExtendParam);
            PlatformBindAdapter platformBindAdapter = this.bindDelegate;
            platformBindAdapter.getClass();
            this.mBindCallback = new PlatformBindAdapter.BindCallback();
            this.bindDelegate.api.ssoWithAccessTokenBind(this.bindDelegate.platformId, null, this.accessToken, 0L, this.extraInfo, this.mBindCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.account.platform.PlatformDelegate
    public void requestProfile(Bundle bundle) {
        if (this.profileAdapter != null) {
            parseData(bundle, this.profileAdapter.mExtendParam);
            PlatformProfileAdapter platformProfileAdapter = this.profileAdapter;
            platformProfileAdapter.getClass();
            this.mProfileCallback = new PlatformProfileAdapter.ProfileCallback();
            this.profileAdapter.api.getOauthProfileByAccessToken(this.profileAdapter.platformId, null, this.accessToken, 0L, this.extraInfo, this.mProfileCallback);
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
            return new TaptapPlatformDelegate(platformLoginAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createBind(PlatformBindAdapter platformBindAdapter) {
            return new TaptapPlatformDelegate(platformBindAdapter);
        }

        @Override // com.bytedance.sdk.account.platform.PlatformDelegate.IFactory
        public PlatformDelegate createProfile(PlatformProfileAdapter platformProfileAdapter) {
            return new TaptapPlatformDelegate(platformProfileAdapter);
        }
    }
}
