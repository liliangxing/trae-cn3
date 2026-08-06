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
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class WebAuthUserThread extends BaseAccountApi<UserApiResponse> {
    private ApiWebAuthObj queryObj;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class ApiWebAuthObj extends UserApiObj {
    }

    private WebAuthUserThread(Context context, ApiRequest apiRequest, AbsApiCall<UserApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
        this.queryObj = new ApiWebAuthObj();
    }

    public static WebAuthUserThread withAuthUser(Context context, String str, AbsApiCall<UserApiResponse> absApiCall) {
        return new WebAuthUserThread(context, ApiHelper.createSsoBuilder(str, null, null, null, null, null, null).url(ThirdPartyNetConstants.getUserinfoUrl()).get(), absApiCall);
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
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.WEB_AUTH_USER, this.apiRequest.parameter("platform"), null, userApiResponse, this.mApiCall);
    }
}
