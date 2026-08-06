package com.bytedance.sdk.account.job.vcd;

import android.content.Context;
import com.bytedance.sdk.account.VcdEventReporter;
import com.bytedance.sdk.account.VcdNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.api.callback.vcd.SwitchVcdAccountCallback;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SwitchVcdAccountJob extends BaseAccountApi<UserApiResponse> {
    UserApiResponse userApiResponse;

    public SwitchVcdAccountJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static SwitchVcdAccountJob switchVcdAccountJob(Context context, long j, Map map, SwitchVcdAccountCallback switchVcdAccountCallback) {
        return new SwitchVcdAccountJob(context, new ApiRequest.Builder().url(VcdNetConstants.getVcdSwitchAccountPath()).parameter("switch_user_aid", String.valueOf(j)).parameters(map).post(), switchVcdAccountCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = this.userApiResponse;
        if (userApiResponse == null) {
            userApiResponse = new UserApiResponse(z, 2000);
        }
        if (!z) {
            userApiResponse.error = apiResponse.mError;
            userApiResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        UserApiResponse userApiResponse = new UserApiResponse(false, 2000);
        this.userApiResponse = userApiResponse;
        userApiResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        UserApiResponse userApiResponse = new UserApiResponse(true, 2000);
        this.userApiResponse = userApiResponse;
        userApiResponse.result = jSONObject;
        this.userApiResponse.userInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(VcdEventReporter.EventPlatform.VCD_SWITCH_ACCOUNT, null, null, userApiResponse, this.mApiCall);
    }
}
