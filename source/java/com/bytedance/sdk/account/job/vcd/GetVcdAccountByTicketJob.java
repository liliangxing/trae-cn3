package com.bytedance.sdk.account.job.vcd;

import android.content.Context;
import com.bytedance.sdk.account.VcdEventReporter;
import com.bytedance.sdk.account.VcdNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.callback.vcd.GetVcdAccountCallback;
import com.bytedance.sdk.account.api.response.vcd.GetVcdAccountResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GetVcdAccountByTicketJob extends BaseAccountApi<GetVcdAccountResponse> {
    GetVcdAccountResponse accountResponse;

    public GetVcdAccountByTicketJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static GetVcdAccountByTicketJob getVcdAccountByTicket(Context context, String str, Map map, GetVcdAccountCallback getVcdAccountCallback) {
        return new GetVcdAccountByTicketJob(context, new ApiRequest.Builder().url(VcdNetConstants.getVcdGetUserInfoByTicketPath()).parameter("login_ticket", str).parameters(map).get(), getVcdAccountCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public GetVcdAccountResponse transformResponse(boolean z, ApiResponse apiResponse) {
        GetVcdAccountResponse getVcdAccountResponse = this.accountResponse;
        if (getVcdAccountResponse == null) {
            getVcdAccountResponse = new GetVcdAccountResponse(z, VcdNetConstants.API_VCD_GET_ACCOUNT_BY_TICKET);
        }
        if (!z) {
            getVcdAccountResponse.error = apiResponse.mError;
            getVcdAccountResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return getVcdAccountResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        GetVcdAccountResponse getVcdAccountResponse = new GetVcdAccountResponse(false, VcdNetConstants.API_VCD_GET_ACCOUNT_BY_TICKET);
        this.accountResponse = getVcdAccountResponse;
        getVcdAccountResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        GetVcdAccountResponse getVcdAccountResponse = new GetVcdAccountResponse(true, VcdNetConstants.API_VCD_GET_ACCOUNT_BY_TICKET);
        this.accountResponse = getVcdAccountResponse;
        getVcdAccountResponse.mIsCurrentUser = jSONObject2.optString("is_current_user");
        JSONObject optJSONObject = jSONObject2.optJSONObject("user_info");
        this.accountResponse.userInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, optJSONObject);
        this.accountResponse.result = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(GetVcdAccountResponse getVcdAccountResponse) {
        AccountMonitorUtil.onEvent(VcdEventReporter.EventPlatform.VCD_GET_ACCOUNT_BY_TICKET, null, null, getVcdAccountResponse, this.mApiCall);
    }
}
