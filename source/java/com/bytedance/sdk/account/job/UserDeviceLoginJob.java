package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.SpecialNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.UserDeviceLoginCallback;
import com.bytedance.sdk.account.api.response.UserDeviceLoginResponse;
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
public class UserDeviceLoginJob extends BaseAccountApi<UserDeviceLoginResponse> {
    JSONObject rawData;
    IBDAccountUserEntity userEntity;

    public UserDeviceLoginJob(Context context, ApiRequest apiRequest, UserDeviceLoginCallback userDeviceLoginCallback) {
        super(context, apiRequest, userDeviceLoginCallback);
    }

    public static UserDeviceLoginJob userDeviceLogin(Context context, Map<String, String> map, UserDeviceLoginCallback userDeviceLoginCallback) {
        return new UserDeviceLoginJob(context, new ApiRequest.Builder().url(SpecialNetConstants.getUserDeviceLogin()).parameters(map).post(), userDeviceLoginCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserDeviceLoginResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserDeviceLoginResponse userDeviceLoginResponse = new UserDeviceLoginResponse(z, BaseApiResponse.API_USER_DEVICE_LOGIN);
        if (z) {
            userDeviceLoginResponse.userInfo = this.userEntity;
        } else {
            userDeviceLoginResponse.error = apiResponse.mError;
            userDeviceLoginResponse.errorMsg = apiResponse.mErrorMsg;
        }
        userDeviceLoginResponse.result = this.rawData;
        return userDeviceLoginResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawData = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.userEntity = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        this.rawData = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserDeviceLoginResponse userDeviceLoginResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.USER_DEVICE_LOGIN, null, null, userDeviceLoginResponse, this.mApiCall);
    }
}
