package com.bytedance.sdk.account.job.vcd;

import android.content.Context;
import com.bytedance.sdk.account.VcdEventReporter;
import com.bytedance.sdk.account.VcdNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.callback.vcd.GetVcdAuthAccountCallback;
import com.bytedance.sdk.account.api.response.vcd.GetVcdAuthAccountResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GetVcdAuthAccountJob extends BaseAccountApi<GetVcdAuthAccountResponse> {
    GetVcdAuthAccountResponse accountResponse;

    public GetVcdAuthAccountJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static GetVcdAuthAccountJob getVcdAuthAccount(Context context, GetVcdAuthAccountCallback getVcdAuthAccountCallback) {
        return new GetVcdAuthAccountJob(context, new ApiRequest.Builder().url(VcdNetConstants.getVcdGetAuthAccountPath()).get(), getVcdAuthAccountCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public GetVcdAuthAccountResponse transformResponse(boolean z, ApiResponse apiResponse) {
        GetVcdAuthAccountResponse getVcdAuthAccountResponse = this.accountResponse;
        if (getVcdAuthAccountResponse == null) {
            getVcdAuthAccountResponse = new GetVcdAuthAccountResponse(z, VcdNetConstants.API_VCD_GET_AUTH_ACCOUNT);
        }
        if (!z) {
            getVcdAuthAccountResponse.error = apiResponse.mError;
            getVcdAuthAccountResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return getVcdAuthAccountResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        GetVcdAuthAccountResponse getVcdAuthAccountResponse = new GetVcdAuthAccountResponse(false, VcdNetConstants.API_VCD_GET_AUTH_ACCOUNT);
        this.accountResponse = getVcdAuthAccountResponse;
        getVcdAuthAccountResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        GetVcdAuthAccountResponse getVcdAuthAccountResponse = new GetVcdAuthAccountResponse(true, VcdNetConstants.API_VCD_GET_AUTH_ACCOUNT);
        this.accountResponse = getVcdAuthAccountResponse;
        getVcdAuthAccountResponse.mCurrentLoginWay = jSONObject2.optString("login_way");
        JSONObject optJSONObject = jSONObject2.optJSONObject("current_user");
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("can_switch_user");
        if (optJSONObject != null) {
            this.accountResponse.mCurrentUserInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, optJSONObject);
        }
        if (optJSONObject2 != null) {
            this.accountResponse.mCanSwitchUserInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, optJSONObject2);
        }
        this.accountResponse.result = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(GetVcdAuthAccountResponse getVcdAuthAccountResponse) {
        AccountMonitorUtil.onEvent(VcdEventReporter.EventPlatform.VCD_GET_AUTH_ACCOUNT, null, null, getVcdAuthAccountResponse, this.mApiCall);
    }
}
