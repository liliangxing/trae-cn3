package com.bytedance.sdk.account.sso;

import android.content.Context;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.CanChainQuickLoginCallback;
import com.bytedance.sdk.account.api.response.CanChainLoginResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CheckChainLoginThread extends BaseAccountApi<CanChainLoginResponse> {
    private CanChainLoginResponse mCanChainLoginResponse;

    private CheckChainLoginThread(Context context, ApiRequest apiRequest, CanChainQuickLoginCallback canChainQuickLoginCallback) {
        super(context, apiRequest, canChainQuickLoginCallback);
    }

    public static CheckChainLoginThread canChainLogin(Context context, CanChainQuickLoginCallback canChainQuickLoginCallback) {
        return new CheckChainLoginThread(context, new ApiRequest.Builder().url(CommonNetConstants.getCheckChainLoginPath()).post(), canChainQuickLoginCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CanChainLoginResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CanChainLoginResponse canChainLoginResponse = this.mCanChainLoginResponse;
        if (canChainLoginResponse == null) {
            canChainLoginResponse = new CanChainLoginResponse(z, BaseApiResponse.API_CHECK_CHAIN_LOGIN);
        } else {
            canChainLoginResponse.success = z;
        }
        if (!z) {
            canChainLoginResponse.error = apiResponse.mError;
            canChainLoginResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return canChainLoginResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CanChainLoginResponse canChainLoginResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.CHECK_CHAIN_LOGIN, null, null, canChainLoginResponse, this.mApiCall);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        CanChainLoginResponse canChainLoginResponse = new CanChainLoginResponse(false, BaseApiResponse.API_CHECK_CHAIN_LOGIN);
        this.mCanChainLoginResponse = canChainLoginResponse;
        canChainLoginResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        CanChainLoginResponse canChainLoginResponse = new CanChainLoginResponse(true, BaseApiResponse.API_CHECK_CHAIN_LOGIN);
        this.mCanChainLoginResponse = canChainLoginResponse;
        canChainLoginResponse.mCanChainLogin = jSONObject2.optBoolean("can_chain_login");
        this.mCanChainLoginResponse.result = jSONObject;
    }
}
