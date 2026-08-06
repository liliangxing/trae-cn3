package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.SpecialNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.BindVisitorAccountCallback;
import com.bytedance.sdk.account.api.response.BindVisitorAccountResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BindVisitorAccountJob extends BaseAccountApi<BindVisitorAccountResponse> {
    private JSONObject rawData;

    public BindVisitorAccountJob(Context context, ApiRequest apiRequest, BindVisitorAccountCallback bindVisitorAccountCallback) {
        super(context, apiRequest, bindVisitorAccountCallback);
    }

    public static BindVisitorAccountJob bindVisitorAccount(Context context, BindVisitorAccountCallback bindVisitorAccountCallback) {
        return new BindVisitorAccountJob(context, new ApiRequest.Builder().url(SpecialNetConstants.getBindVisitorAccount()).post(), bindVisitorAccountCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public BindVisitorAccountResponse transformResponse(boolean z, ApiResponse apiResponse) {
        BindVisitorAccountResponse bindVisitorAccountResponse = new BindVisitorAccountResponse(z, BaseApiResponse.API_BIND_VISITOR_ACCOUNT);
        if (!z) {
            bindVisitorAccountResponse.error = apiResponse.mError;
            bindVisitorAccountResponse.errorMsg = apiResponse.mErrorMsg;
        }
        bindVisitorAccountResponse.result = this.rawData;
        return bindVisitorAccountResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawData = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.rawData = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(BindVisitorAccountResponse bindVisitorAccountResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.BIND_VISITOR_ACCOUNT, null, null, bindVisitorAccountResponse, this.mApiCall);
    }
}
