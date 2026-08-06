package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.CanDeviceOneLoginCallback;
import com.bytedance.sdk.account.api.response.CanDeviceOneLoginResponse;
import com.bytedance.sdk.account.constants.AccountConstants;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CanDeviceOneLoginJob extends BaseAccountApi<CanDeviceOneLoginResponse> {
    private String oneLoginTicket;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public CanDeviceOneLoginJob(Context context, ApiRequest apiRequest, CanDeviceOneLoginCallback canDeviceOneLoginCallback) {
        super(context, apiRequest, canDeviceOneLoginCallback);
    }

    public static CanDeviceOneLoginJob canDeviceOneLogin(Context context, String str, boolean z, String str2, Integer num, Long l, String str3, CanDeviceOneLoginCallback canDeviceOneLoginCallback) {
        return new CanDeviceOneLoginJob(context, new ApiRequest.Builder().url(CommonNetConstants.getCanDeviceOneLoginPath()).parameters(getParams(str, z, str2, num, l, str3)).post(), canDeviceOneLoginCallback);
    }

    private static Map<String, String> getParams(String str, boolean z, String str2, Integer num, Long l, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("encrypted", z ? "1" : "0");
        hashMap.put("mix_mode", "1");
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                hashMap.put(AccountConstants.AccountShareCols.SEC_USER_ID, str);
            } else {
                hashMap.put("user_id", str);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("d_ticket", StringUtils.encryptWithXor(str2));
        }
        if (num != null) {
            hashMap.put("last_login_way", String.valueOf(num));
        }
        if (l != null) {
            hashMap.put("last_login_time", String.valueOf(l));
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("last_login_platform", str3);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CanDeviceOneLoginResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CanDeviceOneLoginResponse canDeviceOneLoginResponse = new CanDeviceOneLoginResponse(z, BaseApiResponse.API_CAN_DEVICE_ONE_LOGIN);
        if (z) {
            canDeviceOneLoginResponse.oneLoginTicket = this.oneLoginTicket;
        } else {
            canDeviceOneLoginResponse.error = apiResponse.mError;
            canDeviceOneLoginResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return canDeviceOneLoginResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.oneLoginTicket = jSONObject2.optString("one_login_ticket");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CanDeviceOneLoginResponse canDeviceOneLoginResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.CAN_DEVICE_ONE_LOGIN, null, null, canDeviceOneLoginResponse, this.mApiCall);
    }
}
