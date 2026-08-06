package com.bytedance.sdk.account.sso;

import android.content.Context;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SsoCheckBindLoginThread extends BaseAccountApi<UserApiResponse> {
    private IBDAccountUserEntity BdAccountUserEntity;
    private String notLoginTicket;
    private String profileKey;
    private JSONObject rawResult;
    private String verifyTicket;

    public SsoCheckBindLoginThread(Context context, ApiRequest apiRequest, AbsApiCall<UserApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static SsoCheckBindLoginThread checkoutBindLogin(Context context, String str, String str2, String str3, Map<String, String> map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoCheckBindLoginThread(context, new ApiRequest.Builder().url(ThirdPartyNetConstants.getAuthCheckBindLoginPath()).parameter("platform_app_id", str).parameter("platform", str2).parameter("profile_key", str3).parameters(map).post(), absApiCall);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, BaseApiResponse.API_SSO_CHECK_BIND_LOGIN);
        if (z) {
            userApiResponse.userInfo = this.BdAccountUserEntity;
        } else {
            userApiResponse.error = apiResponse.mError;
            userApiResponse.errorMsg = apiResponse.mErrorMsg;
            userApiResponse.mDetailErrorMsg = apiResponse.mDetailErrorMsg;
            userApiResponse.setProfileKey(this.profileKey);
            userApiResponse.notLoginTicket = this.notLoginTicket;
            userApiResponse.verifyTicket = this.verifyTicket;
        }
        userApiResponse.result = this.rawResult;
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawResult = jSONObject2;
        this.profileKey = jSONObject.optString("profile_key");
        this.notLoginTicket = jSONObject.optString("not_login_ticket");
        this.verifyTicket = jSONObject.optString("verify_ticket");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.rawResult = jSONObject;
        this.BdAccountUserEntity = ApiHelper.UserApiHelper.parseUserInfo(jSONObject);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventPlatform.OAUTH_CHECK_BIND_LOGIN, this.apiRequest.parameter("platform"), AccountMonitorConstants.EventPlatform.OAUTH_CHECK_BIND_LOGIN, userApiResponse, this.mApiCall);
    }
}
