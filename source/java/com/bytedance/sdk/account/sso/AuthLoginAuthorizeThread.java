package com.bytedance.sdk.account.sso;

import android.content.Context;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.response.AuthLoginAuthorizeResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AuthLoginAuthorizeThread extends BaseAccountApi<AuthLoginAuthorizeResponse> {
    AuthLoginAuthorizeResponse mResponse;

    public AuthLoginAuthorizeThread(Context context, ApiRequest apiRequest, CommonCallBack<AuthLoginAuthorizeResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
    }

    public static AuthLoginAuthorizeThread authLoginAuthorize(Context context, Map<String, String> map, CommonCallBack<AuthLoginAuthorizeResponse> commonCallBack) {
        return new AuthLoginAuthorizeThread(context, new ApiRequest.Builder().url(ThirdPartyNetConstants.getAuthLoginAuthorizePath()).parameters(map).post(), commonCallBack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public AuthLoginAuthorizeResponse transformResponse(boolean z, ApiResponse apiResponse) {
        if (this.mResponse == null) {
            this.mResponse = new AuthLoginAuthorizeResponse(z);
        }
        this.mResponse.error = apiResponse.mError;
        this.mResponse.errorMsg = apiResponse.mErrorMsg;
        return this.mResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        AuthLoginAuthorizeResponse authLoginAuthorizeResponse = new AuthLoginAuthorizeResponse(false);
        this.mResponse = authLoginAuthorizeResponse;
        authLoginAuthorizeResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        AuthLoginAuthorizeResponse authLoginAuthorizeResponse = new AuthLoginAuthorizeResponse(true);
        this.mResponse = authLoginAuthorizeResponse;
        authLoginAuthorizeResponse.result = jSONObject;
        this.mResponse.token = jSONObject2.optString("token");
        this.mResponse.userId = jSONObject2.optString("user_id_str");
        this.mResponse.userInfo = jSONObject2.optJSONObject("user_info");
        this.mResponse.tokenCreateTime = jSONObject2.optLong("token_create_time");
        this.mResponse.tokenExpireTime = jSONObject2.optLong("token_expire_time");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(AuthLoginAuthorizeResponse authLoginAuthorizeResponse) {
        AccountMonitorUtil.onEvent(ThirdPartyNetConstants.EventName.AUTH_LOGIN_AUTHORIZE, null, null, authLoginAuthorizeResponse, this.mApiCall);
    }
}
