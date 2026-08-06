package com.bytedance.sdk.account.sso;

import android.content.Context;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SsoApiOnlyLoginThread extends BaseAccountApi<UserApiResponse> {
    private ApiLoginObj queryObj;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class ApiLoginObj extends UserApiObj {
        JSONObject result;
    }

    public SsoApiOnlyLoginThread(Context context, ApiRequest apiRequest, AbsApiCall<UserApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
        this.queryObj = new ApiLoginObj();
    }

    public static SsoApiOnlyLoginThread withAccessTokenOnlyLogin(Context context, String str, String str2, String str3, String str4, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiOnlyLoginThread(context, ApiHelper.createSsoBuilder(str2, str3, str4, null, null, str, map).url(ThirdPartyNetConstants.getSsoOnlyLoginUrl()).post(), absApiCall);
    }

    public static SsoApiOnlyLoginThread withAuthCodeOnlyLogin(Context context, String str, String str2, String str3, String str4, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiOnlyLoginThread(context, ApiHelper.createSsoBuilder(str2, null, str4, str3, null, str, map).url(ThirdPartyNetConstants.getSsoOnlyLoginUrl()).post(), absApiCall);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, 1);
        if (z) {
            userApiResponse.userInfo = this.queryObj.info;
        } else {
            userApiResponse.setProfileKey(this.queryObj.mProfileKey);
            userApiResponse.error = this.queryObj.mError;
            userApiResponse.errorMsg = this.queryObj.mErrorMsg;
            userApiResponse.mSharkTicket = this.queryObj.mSharkTicket;
            if (this.queryObj.mError == 1075) {
                userApiResponse.mCancelApplyTime = this.queryObj.mCancelApplyTime;
                userApiResponse.mCancelAvatarUrl = this.queryObj.mCancelAvatarUrl;
                userApiResponse.mCancelNickName = this.queryObj.mCancelNickName;
                userApiResponse.mCancelTime = this.queryObj.mCancelTime;
                userApiResponse.mCancelToken = this.queryObj.mCancelToken;
            }
        }
        userApiResponse.result = this.queryObj.result;
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.UserApiHelper.onStatusError(this.queryObj, jSONObject);
        this.queryObj.result = jSONObject2;
        if (jSONObject != null) {
            this.queryObj.mProfileKey = jSONObject.optString("profile_key");
            this.queryObj.mSharkTicket = jSONObject.optString("shark_ticket");
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        ApiHelper.UserApiHelper.extractUserInfo(jSONObject, jSONObject2, this.queryObj);
        this.queryObj.result = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.SSO_API_ONLY_LOGIN, this.apiRequest.parameter("platform"), null, userApiResponse, this.mApiCall);
    }
}
