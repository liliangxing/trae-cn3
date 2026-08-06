package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.DeviceOneLoginContinueCallback;
import com.bytedance.sdk.account.api.response.DeviceOneLoginContinueResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DeviceOneLoginContinueJob extends BaseAccountApi<DeviceOneLoginContinueResponse> {
    private IBDAccountUserEntity userEntity;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public DeviceOneLoginContinueJob(Context context, ApiRequest apiRequest, DeviceOneLoginContinueCallback deviceOneLoginContinueCallback) {
        super(context, apiRequest, deviceOneLoginContinueCallback);
    }

    public static DeviceOneLoginContinueJob deviceOneLoginContinue(Context context, String str, Map<String, String> map, DeviceOneLoginContinueCallback deviceOneLoginContinueCallback) {
        return new DeviceOneLoginContinueJob(context, new ApiRequest.Builder().url(CommonNetConstants.getDeviceOneLoginContinuePath()).parameter("one_login_ticket", str).parameters(map).post(), deviceOneLoginContinueCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public DeviceOneLoginContinueResponse transformResponse(boolean z, ApiResponse apiResponse) {
        DeviceOneLoginContinueResponse deviceOneLoginContinueResponse = new DeviceOneLoginContinueResponse(z, BaseApiResponse.API_DEVICE_ONE_LOGIN_CONTINUE);
        if (z) {
            deviceOneLoginContinueResponse.userInfo = this.userEntity;
        } else {
            deviceOneLoginContinueResponse.error = apiResponse.mError;
            deviceOneLoginContinueResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return deviceOneLoginContinueResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.userEntity = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(DeviceOneLoginContinueResponse deviceOneLoginContinueResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.DEVICE_ONG_LOGIN_CONTINUE, null, null, deviceOneLoginContinueResponse, this.mApiCall);
    }
}
