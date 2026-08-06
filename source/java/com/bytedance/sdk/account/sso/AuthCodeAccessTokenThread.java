package com.bytedance.sdk.account.sso;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.response.AuthCodeAccessTokenResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AuthCodeAccessTokenThread extends BaseAccountApi<AuthCodeAccessTokenResponse> {
    private AuthCodeAccessTokenResponse mResponse;

    public AuthCodeAccessTokenThread(Context context, ApiRequest apiRequest, CommonCallBack<AuthCodeAccessTokenResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
    }

    public static AuthCodeAccessTokenThread authCodeAccessToken(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map, CommonCallBack<AuthCodeAccessTokenResponse> commonCallBack) {
        ApiRequest.Builder parameters = new ApiRequest.Builder().url(ThirdPartyNetConstants.getAuthCodeAccessToken()).parameter("platform", str).parameter("platform_app_id", str2).parameters(map);
        if (!TextUtils.isEmpty(str5)) {
            parameters.parameter("code", str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            parameters.parameter("auth_token", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            parameters.parameter("profile_key", str4);
        }
        return new AuthCodeAccessTokenThread(context, parameters.get(), commonCallBack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public AuthCodeAccessTokenResponse transformResponse(boolean z, ApiResponse apiResponse) {
        if (apiResponse == null) {
            this.mResponse = new AuthCodeAccessTokenResponse(z);
        }
        this.mResponse.error = apiResponse.mError;
        this.mResponse.errorMsg = apiResponse.mErrorMsg;
        return this.mResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        AuthCodeAccessTokenResponse authCodeAccessTokenResponse = new AuthCodeAccessTokenResponse(false);
        this.mResponse = authCodeAccessTokenResponse;
        authCodeAccessTokenResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        AuthCodeAccessTokenResponse authCodeAccessTokenResponse = new AuthCodeAccessTokenResponse(true);
        this.mResponse = authCodeAccessTokenResponse;
        authCodeAccessTokenResponse.result = jSONObject;
        this.mResponse.accessToken = jSONObject2.optString("access_token");
        this.mResponse.expiresIn = jSONObject2.optLong("expires_in");
        this.mResponse.refreshToken = jSONObject2.optString("refresh_token");
        this.mResponse.refreshExpiresIn = jSONObject2.optLong("refresh_expires_in");
        this.mResponse.openId = jSONObject2.optString("open_id");
        this.mResponse.scopes = jSONObject2.optString("scopes");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(AuthCodeAccessTokenResponse authCodeAccessTokenResponse) {
        AccountMonitorUtil.onEvent(ThirdPartyNetConstants.EventName.AUTH_CODE_ACCESS_TOKEN, null, null, authCodeAccessTokenResponse, this.mApiCall);
    }
}
