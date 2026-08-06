package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.CancelCloseAccountCallback;
import com.bytedance.sdk.account.api.response.CancelCloseAccountResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CancelCloseAccountJob extends BaseAccountApi<CancelCloseAccountResponse> {
    private JSONObject rawResponse;
    IBDAccountUserEntity userEntity;

    public CancelCloseAccountJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static CancelCloseAccountJob cancelCloseAccountWithToken(Context context, String str, CancelCloseAccountCallback cancelCloseAccountCallback) {
        return new CancelCloseAccountJob(context, new ApiRequest.Builder().url(CommonNetConstants.getCancelCLoseAccountPath()).parameter("token", str).post(), cancelCloseAccountCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CancelCloseAccountResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CancelCloseAccountResponse cancelCloseAccountResponse = new CancelCloseAccountResponse(z, BaseApiResponse.API_CANCEL_CLOSE_ACCOUNT);
        if (z) {
            cancelCloseAccountResponse.userInfo = this.userEntity;
        } else {
            cancelCloseAccountResponse.error = apiResponse.mError;
            cancelCloseAccountResponse.errorMsg = apiResponse.mErrorMsg;
        }
        cancelCloseAccountResponse.result = this.rawResponse;
        return cancelCloseAccountResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawResponse = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.userEntity = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        this.rawResponse = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CancelCloseAccountResponse cancelCloseAccountResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.CANCEL_LOGIN, null, null, cancelCloseAccountResponse, this.mApiCall);
    }
}
