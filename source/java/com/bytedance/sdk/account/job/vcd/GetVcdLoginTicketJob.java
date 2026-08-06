package com.bytedance.sdk.account.job.vcd;

import android.content.Context;
import com.bytedance.sdk.account.VcdEventReporter;
import com.bytedance.sdk.account.VcdNetConstants;
import com.bytedance.sdk.account.api.callback.vcd.GetVcdLoginTicketCallback;
import com.bytedance.sdk.account.api.response.vcd.GetVcdLoginTicketResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GetVcdLoginTicketJob extends BaseAccountApi<GetVcdLoginTicketResponse> {
    private GetVcdLoginTicketResponse authTicketResponse;

    private GetVcdLoginTicketJob(Context context, ApiRequest apiRequest, GetVcdLoginTicketCallback getVcdLoginTicketCallback) {
        super(context, apiRequest, getVcdLoginTicketCallback);
    }

    public static GetVcdLoginTicketJob getVcdLoginTicket(Context context, GetVcdLoginTicketCallback getVcdLoginTicketCallback) {
        return new GetVcdLoginTicketJob(context, new ApiRequest.Builder().url(VcdNetConstants.getVcdLoginTicketPath()).get(), getVcdLoginTicketCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public GetVcdLoginTicketResponse transformResponse(boolean z, ApiResponse apiResponse) {
        GetVcdLoginTicketResponse getVcdLoginTicketResponse = this.authTicketResponse;
        if (getVcdLoginTicketResponse == null) {
            getVcdLoginTicketResponse = new GetVcdLoginTicketResponse(z, VcdNetConstants.API_VCD_GET_LOGIN_TICKET);
        } else {
            getVcdLoginTicketResponse.success = z;
        }
        if (!z) {
            getVcdLoginTicketResponse.error = apiResponse.mError;
            getVcdLoginTicketResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return getVcdLoginTicketResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        GetVcdLoginTicketResponse getVcdLoginTicketResponse = new GetVcdLoginTicketResponse(false, VcdNetConstants.API_VCD_GET_LOGIN_TICKET);
        this.authTicketResponse = getVcdLoginTicketResponse;
        getVcdLoginTicketResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        GetVcdLoginTicketResponse getVcdLoginTicketResponse = new GetVcdLoginTicketResponse(true, VcdNetConstants.API_VCD_GET_LOGIN_TICKET);
        this.authTicketResponse = getVcdLoginTicketResponse;
        getVcdLoginTicketResponse.result = jSONObject;
        this.authTicketResponse.loginTicket = jSONObject2.optString("login_ticket");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(GetVcdLoginTicketResponse getVcdLoginTicketResponse) {
        AccountMonitorUtil.onEvent(VcdEventReporter.EventPlatform.VCD_GET_LOGIN_TICKET, null, null, getVcdLoginTicketResponse, this.mApiCall);
    }
}
