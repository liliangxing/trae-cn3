package com.bytedance.sdk.account.job.vcd;

import android.content.Context;
import com.bytedance.sdk.account.VcdEventReporter;
import com.bytedance.sdk.account.VcdNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.api.callback.vcd.VcdLoginByTicketCallback;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class VcdLoginByTicketJob extends BaseAccountApi<UserApiResponse> {
    UserApiResponse userApiResponse;

    public VcdLoginByTicketJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static VcdLoginByTicketJob loginByTicket(Context context, String str, Map map, VcdLoginByTicketCallback vcdLoginByTicketCallback) {
        return new VcdLoginByTicketJob(context, new ApiRequest.Builder().url(VcdNetConstants.getVcdLoginByTicketPath()).parameter("login_ticket", str).parameters(map).post(), vcdLoginByTicketCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = this.userApiResponse;
        if (userApiResponse == null) {
            userApiResponse = new UserApiResponse(z, 2004);
        }
        if (!z) {
            userApiResponse.error = apiResponse.mError;
            userApiResponse.errorMsg = apiResponse.mErrorMsg;
            userApiResponse.mDetailErrorMsg = apiResponse.mDetailErrorMsg;
        }
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        UserApiResponse userApiResponse = new UserApiResponse(false, 2004);
        this.userApiResponse = userApiResponse;
        userApiResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        UserApiResponse userApiResponse = new UserApiResponse(true, 2004);
        this.userApiResponse = userApiResponse;
        userApiResponse.result = jSONObject;
        this.userApiResponse.userInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(VcdEventReporter.EventPlatform.VCD_LOGIN_BY_TICKET, null, null, userApiResponse, this.mApiCall);
    }
}
