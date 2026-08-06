package com.bytedance.sdk.account.sso;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AuthChangeBindThread extends BaseAccountApi<UserApiResponse> {
    String mPlatform;
    UserApiResponse mResponse;

    public AuthChangeBindThread(Context context, ApiRequest apiRequest, CommonCallBack<UserApiResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
    }

    public static AuthChangeBindThread authChangeBind(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        ApiRequest.Builder parameters = new ApiRequest.Builder().url(ThirdPartyNetConstants.getAuthChangeBindPath()).parameter("platform", str).parameter("platform_app_id", str2).parameters(map);
        if (!TextUtils.isEmpty(str3)) {
            parameters.parameter("code", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            parameters.parameter("access_token", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            parameters.parameter("auth_token", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            parameters.parameter("profile_key", str6);
        }
        if (z) {
            parameters.parameter("verify_type", "1");
        }
        if (z2) {
            parameters.parameter("verified_ticket", "1");
        }
        AuthChangeBindThread authChangeBindThread = new AuthChangeBindThread(context, parameters.post(), commonCallBack);
        authChangeBindThread.mPlatform = str;
        return authChangeBindThread;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        if (this.mResponse == null) {
            this.mResponse = new UserApiResponse(z, ThirdPartyNetConstants.API_AUTH_CHANGE_BIND);
        }
        this.mResponse.error = apiResponse.mError;
        this.mResponse.errorMsg = apiResponse.mErrorMsg;
        return this.mResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        UserApiResponse userApiResponse = new UserApiResponse(false, ThirdPartyNetConstants.API_AUTH_CHANGE_BIND);
        this.mResponse = userApiResponse;
        userApiResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        UserApiResponse userApiResponse = new UserApiResponse(true, ThirdPartyNetConstants.API_AUTH_CHANGE_BIND);
        this.mResponse = userApiResponse;
        userApiResponse.result = jSONObject;
        this.mResponse.userInfo = ApiHelper.UserApiHelper.parseUserInfo(jSONObject);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(ThirdPartyNetConstants.EventName.AUTH_CHANGE_BIND, this.mPlatform, null, userApiResponse, this.mApiCall);
    }
}
