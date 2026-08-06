package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.api.BDAccountNetApi;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.CheckCodeCallback;
import com.bytedance.sdk.account.api.response.CheckCodeResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.account.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CheckCodeJob extends BaseAccountApi<CheckCodeResponse> {
    private JSONObject rawResponse;
    private String ticket;

    private CheckCodeJob(Context context, ApiRequest apiRequest, CheckCodeCallback checkCodeCallback) {
        super(context, apiRequest, checkCodeCallback);
    }

    public static CheckCodeJob checkCode(Context context, String str, String str2, int i, CheckCodeCallback checkCodeCallback) {
        return new CheckCodeJob(context, new ApiRequest.Builder().url(BDAccountNetApi.getCheckCode()).parameters(getParams(str, str2, i)).post(), checkCodeCallback);
    }

    public static CheckCodeJob checkCode(Context context, String str, String str2, int i, Map map, CheckCodeCallback checkCodeCallback) {
        return new CheckCodeJob(context, new ApiRequest.Builder().url(BDAccountNetApi.getCheckCode()).parameters(getParams(str, str2, i), map).post(), checkCodeCallback);
    }

    public static CheckCodeJob checkEmailCode(Context context, String str, String str2, int i, Map map, String str3, CheckCodeCallback checkCodeCallback) {
        return new CheckCodeJob(context, new ApiRequest.Builder().url(Utils.getUrl(BDAccountNetApi.getEmailCheckCode(), str3)).parameters(getEmailParams(str, str2, i), map).post(), checkCodeCallback);
    }

    protected static Map<String, String> getParams(String str, String str2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", StringUtils.encryptWithXor(str));
        hashMap.put("code", StringUtils.encryptWithXor(str2));
        hashMap.put(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(i)));
        hashMap.put("mix_mode", "1");
        hashMap.put("fixed_mix_mode", "1");
        return hashMap;
    }

    protected static Map<String, String> getEmailParams(String str, String str2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("email", StringUtils.encryptWithXor(str));
        hashMap.put("code", StringUtils.encryptWithXor(str2));
        hashMap.put(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(i)));
        hashMap.put("mix_mode", "1");
        hashMap.put("fixed_mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CheckCodeResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CheckCodeResponse checkCodeResponse = new CheckCodeResponse(z, BaseApiResponse.API_CHECK_CODE);
        if (z) {
            checkCodeResponse.ticket = this.ticket;
        } else {
            checkCodeResponse.error = apiResponse.mError;
            checkCodeResponse.errorMsg = apiResponse.mErrorMsg;
        }
        checkCodeResponse.result = this.rawResponse;
        return checkCodeResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawResponse = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.ticket = jSONObject2.optString("ticket");
        this.rawResponse = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CheckCodeResponse checkCodeResponse) {
        if (TextUtils.isEmpty(checkCodeResponse.mRequestUrl)) {
            return;
        }
        AccountMonitorUtil.onEvent(checkCodeResponse.mRequestUrl.contains(BDAccountNetApi.getCheckCode()) ? AccountMonitorConstants.EventAccount.MOBILE_CHECK_CODE : AccountMonitorConstants.EventAccount.EMAIL_CHECK_CODE, null, null, checkCodeResponse, this.mApiCall);
    }
}
