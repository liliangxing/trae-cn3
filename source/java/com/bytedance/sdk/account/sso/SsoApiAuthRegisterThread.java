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
public class SsoApiAuthRegisterThread extends BaseAccountApi<UserApiResponse> {
    private ApiLoginObj queryObj;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class ApiLoginObj extends UserApiObj {
    }

    public SsoApiAuthRegisterThread(Context context, ApiRequest apiRequest, AbsApiCall<UserApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
        this.queryObj = new ApiLoginObj();
    }

    public static SsoApiAuthRegisterThread withProfileKey(Context context, String str, String str2, String str3, String str4, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiAuthRegisterThread(context, ApiHelper.createSsoBuilder(str2, null, str4, null, str3, str, map).url(ThirdPartyNetConstants.getSsoAuthRegister()).post(), absApiCall);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, 1);
        if (z) {
            userApiResponse.userInfo = this.queryObj.info;
        } else {
            userApiResponse.error = this.queryObj.mError;
            userApiResponse.errorMsg = this.queryObj.mErrorMsg;
            if (this.queryObj.mError == 1075) {
                userApiResponse.mCancelApplyTime = this.queryObj.mCancelApplyTime;
                userApiResponse.mCancelAvatarUrl = this.queryObj.mCancelAvatarUrl;
                userApiResponse.mCancelNickName = this.queryObj.mCancelNickName;
                userApiResponse.mCancelTime = this.queryObj.mCancelTime;
                userApiResponse.mCancelToken = this.queryObj.mCancelToken;
            }
        }
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.UserApiHelper.onStatusError(this.queryObj, jSONObject);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        ApiHelper.UserApiHelper.extractUserInfo(jSONObject, jSONObject2, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.SSO_API_AUTH_REGISTER, this.apiRequest.parameter("platform"), null, userApiResponse, this.mApiCall);
    }
}
