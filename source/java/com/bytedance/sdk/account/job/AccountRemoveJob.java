package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.AccountRemoveCallback;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AccountRemoveJob extends BaseAccountApi<BaseApiResponse> {
    private JSONObject rawResult;

    public AccountRemoveJob(Context context, ApiRequest apiRequest, AccountRemoveCallback accountRemoveCallback) {
        super(context, apiRequest, accountRemoveCallback);
    }

    public static AccountRemoveJob removeAccount(Context context, String str, AccountRemoveCallback accountRemoveCallback) {
        return new AccountRemoveJob(context, new ApiRequest.Builder().url(ExtraNetConstants.getAccountRemovePath()).parameter("removed_user_id", str).post(), accountRemoveCallback);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected BaseApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        BaseApiResponse baseApiResponse = new BaseApiResponse(z, BaseApiResponse.API_ACCOUNT_REMOVE);
        if (!z) {
            baseApiResponse.error = apiResponse.mError;
            baseApiResponse.errorMsg = apiResponse.mErrorMsg;
        }
        baseApiResponse.result = this.rawResult;
        return baseApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.rawResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(BaseApiResponse baseApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.ACCOUNT_REMOVE, null, null, baseApiResponse, this.mApiCall);
    }
}
