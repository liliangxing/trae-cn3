package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.AuthTicketCallback;
import com.bytedance.sdk.account.api.response.AuthTicketResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GetAuthTicketJob extends BaseAccountApi<AuthTicketResponse> {
    private AuthTicketResponse authTicketResponse;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    private GetAuthTicketJob(Context context, ApiRequest apiRequest, AuthTicketCallback authTicketCallback) {
        super(context, apiRequest, authTicketCallback);
    }

    public static GetAuthTicketJob getAuthTicket(Context context, String str, String str2, AuthTicketCallback authTicketCallback) {
        return new GetAuthTicketJob(context, new ApiRequest.Builder().url(CommonNetConstants.getAuthTicketPath()).parameters(getParams(str, str2)).post(), authTicketCallback);
    }

    protected static Map<String, String> getParams(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", str2);
        hashMap.put("token", str);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public AuthTicketResponse transformResponse(boolean z, ApiResponse apiResponse) {
        AuthTicketResponse authTicketResponse = this.authTicketResponse;
        if (authTicketResponse == null) {
            authTicketResponse = new AuthTicketResponse(z, BaseApiResponse.API_GET_AUTH_TICKET);
        } else {
            authTicketResponse.success = z;
        }
        if (!z) {
            authTicketResponse.error = apiResponse.mError;
            authTicketResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return authTicketResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        AuthTicketResponse authTicketResponse = new AuthTicketResponse(true, BaseApiResponse.API_GET_AUTH_TICKET);
        this.authTicketResponse = authTicketResponse;
        authTicketResponse.rawData = jSONObject2;
        try {
            this.authTicketResponse.ticket = jSONObject2.optString("ticket");
            this.authTicketResponse.mobile = jSONObject2.optString("mobile");
            this.authTicketResponse.ticket_age = jSONObject2.optInt("ticket_age");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(AuthTicketResponse authTicketResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.AUTH_ONE_LOGIN_GET_TICKET, null, null, authTicketResponse, this.mApiCall);
    }
}
