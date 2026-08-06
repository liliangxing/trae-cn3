package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.callback.CancelDoCallback;
import com.bytedance.sdk.account.api.response.CancelDoResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.database.DBData;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CancelDoJob extends BaseAccountApi<CancelDoResponse> {
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
    }

    private CancelDoJob(Context context, ApiRequest apiRequest, CancelDoCallback cancelDoCallback) {
        super(context, apiRequest, cancelDoCallback);
    }

    public static CancelDoJob cancelDo(Context context, boolean z, CancelDoCallback cancelDoCallback) {
        return new CancelDoJob(context, new ApiRequest.Builder().url(CommonNetConstants.getCancelDo()).parameter(DBData.FIELD_TYPE, z ? "1" : "0").post(), cancelDoCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CancelDoResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CancelDoResponse cancelDoResponse = new CancelDoResponse(z, 10008);
        if (!z) {
            cancelDoResponse.error = apiResponse.mError;
            cancelDoResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return cancelDoResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CancelDoResponse cancelDoResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.CANCEL_DO, null, null, cancelDoResponse, this.mApiCall);
    }
}
