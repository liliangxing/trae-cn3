package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.UpdateTokenCallback;
import com.bytedance.sdk.account.api.response.UpdateTokenResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.ss.android.TTHeader;
import com.ss.android.account.TTAccountInit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UpdateTokenJob extends BaseAccountApi<UpdateTokenResponse> {
    private UpdateTokenResponse updateTokenResponse;

    private UpdateTokenJob(Context context, ApiRequest apiRequest, UpdateTokenCallback updateTokenCallback) {
        super(context, apiRequest, updateTokenCallback);
    }

    public static UpdateTokenJob updateToken(Context context, String str, UpdateTokenCallback updateTokenCallback) {
        TTHeader tTHeader;
        if (TTAccountInit.getRequestTagHeaderProvider() != null) {
            tTHeader = TTAccountInit.getRequestTagHeaderProvider().getRequestTagHeader((str.contains("scene=frontier") || str.contains("scene=wap_login")) ? false : true);
        } else {
            tTHeader = null;
        }
        return new UpdateTokenJob(context, new ApiRequest.Builder().url(str).addHeader(tTHeader).get(), updateTokenCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UpdateTokenResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UpdateTokenResponse updateTokenResponse = this.updateTokenResponse;
        if (updateTokenResponse == null) {
            updateTokenResponse = new UpdateTokenResponse(z, BaseApiResponse.API_UPDATE_TOKEN);
        } else {
            updateTokenResponse.success = z;
        }
        if (!z) {
            updateTokenResponse.error = apiResponse.mError;
            updateTokenResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return updateTokenResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        UpdateTokenResponse updateTokenResponse = new UpdateTokenResponse(false, BaseApiResponse.API_UPDATE_TOKEN);
        this.updateTokenResponse = updateTokenResponse;
        updateTokenResponse.result = jSONObject2;
        this.updateTokenResponse.errorName = jSONObject.optString("error_name");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        UpdateTokenResponse updateTokenResponse = new UpdateTokenResponse(true, BaseApiResponse.API_UPDATE_TOKEN);
        this.updateTokenResponse = updateTokenResponse;
        updateTokenResponse.result = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UpdateTokenResponse updateTokenResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.UPDATE_TOKEN, null, null, updateTokenResponse, this.mApiCall);
    }
}
