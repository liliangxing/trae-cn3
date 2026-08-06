package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.callback.CheckPwdCallback;
import com.bytedance.sdk.account.api.response.CheckPwdResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CheckPwdJob extends BaseAccountApi<CheckPwdResponse> {
    private CheckPwdResponse checkPwdResponse;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    private CheckPwdJob(Context context, ApiRequest apiRequest, CheckPwdCallback checkPwdCallback) {
        super(context, apiRequest, checkPwdCallback);
    }

    public static CheckPwdJob checkPwd(Context context, String str, CheckPwdCallback checkPwdCallback) {
        return new CheckPwdJob(context, new ApiRequest.Builder().url(CommonNetConstants.getPwdCheckPath()).parameters(getParams(str)).post(), checkPwdCallback);
    }

    public static CheckPwdJob checkPwd(Context context, String str, Map<String, String> map, CheckPwdCallback checkPwdCallback) {
        return new CheckPwdJob(context, new ApiRequest.Builder().url(CommonNetConstants.getPwdCheckPath()).parameters(getParams(str), map).post(), checkPwdCallback);
    }

    protected static Map<String, String> getParams(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(str));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CheckPwdResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CheckPwdResponse checkPwdResponse = this.checkPwdResponse;
        if (checkPwdResponse == null) {
            checkPwdResponse = new CheckPwdResponse(z, 10011);
        } else {
            checkPwdResponse.success = z;
        }
        if (!z) {
            checkPwdResponse.error = apiResponse.mError;
            checkPwdResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return checkPwdResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        CheckPwdResponse checkPwdResponse = new CheckPwdResponse(true, 10011);
        this.checkPwdResponse = checkPwdResponse;
        checkPwdResponse.mErrorCaptcha = jSONObject2.optString("captcha");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CheckPwdResponse checkPwdResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.CHECK_PASSWORD, null, null, checkPwdResponse, this.mApiCall);
    }
}
