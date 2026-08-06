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
public class SsoApiSwitchBindThread extends BaseAccountApi<UserApiResponse> {
    private SwitchObj queryObj;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class SwitchObj extends UserApiObj {
    }

    private SsoApiSwitchBindThread(Context context, ApiRequest apiRequest, AbsApiCall<UserApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
        this.queryObj = new SwitchObj();
    }

    public static SsoApiSwitchBindThread withAuthTokenSwitchBind(Context context, String str, String str2, String str3, String str4, String str5, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiSwitchBindThread(context, ApiHelper.createSsoBuilder(str2, null, str4, null, str5, str, map).parameter("auth_token", str3).url(ThirdPartyNetConstants.getSsoSwitchBind()).post(), absApiCall);
    }

    public static SsoApiSwitchBindThread withAccessTokenSwitchBind(Context context, String str, String str2, String str3, String str4, String str5, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiSwitchBindThread(context, ApiHelper.createSsoBuilder(str2, str3, str4, null, str5, str, map).url(ThirdPartyNetConstants.getSsoSwitchBind()).post(), absApiCall);
    }

    public static SsoApiSwitchBindThread withAuthCodeSwitchBind(Context context, String str, String str2, String str3, String str4, String str5, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiSwitchBindThread(context, ApiHelper.createSsoBuilder(str2, null, str4, str3, str5, str, map).url(ThirdPartyNetConstants.getSsoSwitchBind()).post(), absApiCall);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse fromUserApiObj = ApiHelper.UserApiHelper.fromUserApiObj(this.queryObj, z, 0);
        if (z) {
            fromUserApiObj.userInfo = this.queryObj.info;
        } else {
            fromUserApiObj.error = this.queryObj.mError;
            fromUserApiObj.errorMsg = this.queryObj.mErrorMsg;
            if (this.queryObj.mError == 1075) {
                fromUserApiObj.mCancelApplyTime = this.queryObj.mCancelApplyTime;
                fromUserApiObj.mCancelAvatarUrl = this.queryObj.mCancelAvatarUrl;
                fromUserApiObj.mCancelNickName = this.queryObj.mCancelNickName;
                fromUserApiObj.mCancelTime = this.queryObj.mCancelTime;
                fromUserApiObj.mCancelToken = this.queryObj.mCancelToken;
            }
        }
        return fromUserApiObj;
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
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventPlatform.OAUTH_SWITCH_CLICK, this.apiRequest.parameter("platform"), userApiResponse.success ? "success" : "fail", userApiResponse, this.mApiCall);
    }
}
