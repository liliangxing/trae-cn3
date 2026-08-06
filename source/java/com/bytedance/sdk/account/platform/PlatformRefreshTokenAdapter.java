package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.api.response.UpdateAuthorizeInfoResponse;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.timonbase.scene.PageDataManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class PlatformRefreshTokenAdapter extends BaseAccountAdapter implements IPlatformRefreshTokenAdapter {
    private final String mClientKey;
    private RefreshTokenCallback mRefreshTokenCallback;

    public PlatformRefreshTokenAdapter(Context context, String str, String str2, String str3) {
        super(context, str, str3);
        this.mClientKey = str2;
    }

    public void cancelRefreshToken() {
        RefreshTokenCallback refreshTokenCallback = this.mRefreshTokenCallback;
        if (refreshTokenCallback != null) {
            refreshTokenCallback.cancel();
            this.mRefreshTokenCallback = null;
        }
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle bundle) {
        AccountMonitorUtil.platformAuthEvent(this.platform, "refresh_token", 1, null, null, false, null);
        if (bundle == null) {
            onRefreshTokenError(getFailedParseDataResponse());
            return;
        }
        String string = bundle.getString("auth_code");
        if (TextUtils.isEmpty(string)) {
            onRefreshTokenError(getFailedParseDataResponse());
        } else {
            this.mRefreshTokenCallback = new RefreshTokenCallback();
            this.api.updateAuthorizeInfo(string, this.platformId, this.platform, this.mExtendParam, this.mRefreshTokenCallback);
        }
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse authorizeErrorResponse) {
        AccountMonitorUtil.platformAuthEvent(this.platform, "refresh_token", 0, authorizeErrorResponse.platformErrorCode, authorizeErrorResponse.platformErrorMsg, authorizeErrorResponse.isCancel, null);
        UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse = new UpdateAuthorizeInfoResponse(false, this.platform, this.platformId);
        updateAuthorizeInfoResponse.error = Integer.parseInt(authorizeErrorResponse.platformErrorCode);
        updateAuthorizeInfoResponse.errorMsg = authorizeErrorResponse.platformErrorMsg;
        updateAuthorizeInfoResponse.mDetailErrorMsg = authorizeErrorResponse.platformErrorMsg;
        onRefreshTokenError(updateAuthorizeInfoResponse);
    }

    private UpdateAuthorizeInfoResponse getFailedParseDataResponse() {
        UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse = new UpdateAuthorizeInfoResponse(false, this.platform, this.platformId);
        updateAuthorizeInfoResponse.error = AccountErrorCode.CommonError.COMMON_ERROR_PARSE_DATA_ERROR;
        updateAuthorizeInfoResponse.mDetailErrorMsg = "fail to parse data auth_code";
        return updateAuthorizeInfoResponse;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    protected class RefreshTokenCallback extends CommonCallBack<UpdateAuthorizeInfoResponse> {
        protected RefreshTokenCallback() {
        }

        @Override // com.bytedance.sdk.account.CommonCallBack
        public void onSuccess(UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse) {
            PlatformRefreshTokenAdapter.this.onRefreshTokenSuccess(updateAuthorizeInfoResponse);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ThirdPartyNetConstants.KEY_TRIGGER_SCENE, OauthTokenTriggerScene.FOREGROUND_SWITCH);
                jSONObject.put("enter_from", OauthTokenTriggerScene.FOREGROUND_SWITCH);
                jSONObject.put("trigger_path", "refresh_oauth");
                jSONObject.put("client_key", PlatformRefreshTokenAdapter.this.mClientKey);
                jSONObject.put(PageDataManager.EXTRA_STATUS, "success");
            } catch (JSONException unused) {
            }
            AccountMonitorUtil.onEventV3("passport_update_authorize_info_request_response", jSONObject);
            AccountMonitorUtil.onEventV3("passport_update_authorize_result", jSONObject);
        }

        @Override // com.bytedance.sdk.account.CommonCallBack
        public void onError(UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse, int i) {
            PlatformRefreshTokenAdapter.this.onRefreshTokenError(updateAuthorizeInfoResponse);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ThirdPartyNetConstants.KEY_TRIGGER_SCENE, OauthTokenTriggerScene.FOREGROUND_SWITCH);
                jSONObject.put("enter_from", OauthTokenTriggerScene.FOREGROUND_SWITCH);
                jSONObject.put("trigger_path", "refresh_oauth");
                jSONObject.put("client_key", PlatformRefreshTokenAdapter.this.mClientKey);
                jSONObject.put(PageDataManager.EXTRA_STATUS, "fail");
                jSONObject.put("error_code", i);
                jSONObject.put("fail_info", updateAuthorizeInfoResponse.errorMsg);
            } catch (JSONException unused) {
            }
            AccountMonitorUtil.onEventV3("passport_update_authorize_info_request_response", jSONObject);
            AccountMonitorUtil.onEventV3("passport_update_authorize_result", jSONObject);
        }
    }
}
