package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.SpecialNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.VerifyAccountPasswordCallback;
import com.bytedance.sdk.account.api.response.VerifyAccountPasswordResponse;
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
public class VerifyAccountPasswordJob extends BaseAccountApi<VerifyAccountPasswordResponse> {
    private String captcha;
    private JSONObject jsonResult;
    private String ticket;
    private String verifyTicket;

    public VerifyAccountPasswordJob(Context context, ApiRequest apiRequest, VerifyAccountPasswordCallback verifyAccountPasswordCallback) {
        super(context, apiRequest, verifyAccountPasswordCallback);
    }

    public static VerifyAccountPasswordJob verifyAccountPassword(Context context, String str, String str2, String str3, String str4, String str5, VerifyAccountPasswordCallback verifyAccountPasswordCallback) {
        return verifyAccountPassword(context, str, str2, str3, str4, str5, null, verifyAccountPasswordCallback);
    }

    public static VerifyAccountPasswordJob verifyAccountPassword(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map, VerifyAccountPasswordCallback verifyAccountPasswordCallback) {
        return new VerifyAccountPasswordJob(context, new ApiRequest.Builder().url(SpecialNetConstants.getVerifyAccountPasswordPath()).parameters(getParams(str, str2, str3, str4, str5), map).post(), verifyAccountPasswordCallback);
    }

    protected static Map<String, String> getParams(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("mix_mode", "1");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("username", StringUtils.encryptWithXor(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("mobile", StringUtils.encryptWithXor(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("email", StringUtils.encryptWithXor(str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("verify_ticket", str5);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public VerifyAccountPasswordResponse transformResponse(boolean z, ApiResponse apiResponse) {
        VerifyAccountPasswordResponse verifyAccountPasswordResponse = new VerifyAccountPasswordResponse(z, BaseApiResponse.API_VERIFY_ACCOUNT_PASSWORD);
        if (z) {
            verifyAccountPasswordResponse.setTicket(this.ticket);
            verifyAccountPasswordResponse.setVerifyTicket(this.verifyTicket);
        } else {
            verifyAccountPasswordResponse.setCaptcha(this.captcha);
            verifyAccountPasswordResponse.error = apiResponse.mError;
            verifyAccountPasswordResponse.errorMsg = apiResponse.mErrorMsg;
        }
        verifyAccountPasswordResponse.result = this.jsonResult;
        return verifyAccountPasswordResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.captcha = jSONObject.optString("captcha");
        this.jsonResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.ticket = jSONObject2.optString("ticket");
        this.verifyTicket = jSONObject2.optString("verify_ticket");
        this.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(VerifyAccountPasswordResponse verifyAccountPasswordResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.VERIFY_ACCOUNT_PASSWORD, null, null, verifyAccountPasswordResponse, this.mApiCall);
    }
}
