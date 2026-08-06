package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.information.method.oauth_profile.OauthProfileCallback;
import com.bytedance.sdk.account.information.method.oauth_profile.OauthProfileResponse;
import com.bytedance.sdk.account.platform.PlatformDelegate;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class PlatformProfileAdapter extends BaseAccountAdapter implements IPlatformProfileAdapter {
    PlatformProfileAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle bundle) {
        PlatformDelegate.IFactory iFactory = delegateMap.get(this.platform);
        if (iFactory != null) {
            iFactory.createProfile(this).requestProfile(bundle);
        }
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse authorizeErrorResponse) {
        OauthProfileResponse oauthProfileResponse = new OauthProfileResponse(false, BaseApiResponse.API_OAUTH_PROFILE);
        oauthProfileResponse.error = Integer.parseInt(authorizeErrorResponse.platformErrorCode);
        oauthProfileResponse.errorMsg = authorizeErrorResponse.platformErrorMsg;
        oauthProfileResponse.mDetailErrorMsg = authorizeErrorResponse.platformErrorMsg;
        onProfileError(oauthProfileResponse);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    protected class ProfileCallback extends OauthProfileCallback {
        /* JADX INFO: Access modifiers changed from: protected */
        public ProfileCallback() {
        }

        @Override // com.bytedance.sdk.account.CommonCallBack
        public void onSuccess(OauthProfileResponse oauthProfileResponse) {
            PlatformProfileAdapter.this.onProfileSuccess(oauthProfileResponse);
        }

        @Override // com.bytedance.sdk.account.CommonCallBack
        public void onError(OauthProfileResponse oauthProfileResponse, int i) {
            PlatformProfileAdapter.this.onProfileError(oauthProfileResponse);
        }
    }
}
