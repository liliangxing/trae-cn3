package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.CheckMobileRegisterResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CheckMobileRegisterApiThread extends BaseAccountApi<CheckMobileRegisterResponse> {
    private boolean isRegistered;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public CheckMobileRegisterApiThread(Context context, ApiRequest apiRequest, AbsApiCall<CheckMobileRegisterResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static CheckMobileRegisterApiThread checkMobileRegister(Context context, String str, AbsApiCall<CheckMobileRegisterResponse> absApiCall) {
        return new CheckMobileRegisterApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getCheckMobileRegisteredPath()).parameters(getParams(str)).post(), absApiCall);
    }

    protected static Map<String, String> getParams(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("mobile", StringUtils.encryptWithXor(str));
        }
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CheckMobileRegisterResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CheckMobileRegisterResponse checkMobileRegisterResponse = new CheckMobileRegisterResponse(z, BaseApiResponse.API_CHECK_MOBILE_REGISTER);
        if (z) {
            checkMobileRegisterResponse.isRegistered = this.isRegistered;
        } else {
            checkMobileRegisterResponse.error = apiResponse.mError;
            checkMobileRegisterResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return checkMobileRegisterResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.isRegistered = jSONObject2.optBoolean("is_registered");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CheckMobileRegisterResponse checkMobileRegisterResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.CHECK_MOBILE_REGISTERED, null, null, checkMobileRegisterResponse, this.mApiCall);
    }
}
