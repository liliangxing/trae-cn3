package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.response.EmailRegisterCodeVerifyResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.database.DBData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class EmailRegisterCodeVerifyJob extends BaseAccountApi<EmailRegisterCodeVerifyResponse> {
    private String mEmailTicket;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public EmailRegisterCodeVerifyJob(Context context, ApiRequest apiRequest, CommonCallBack<EmailRegisterCodeVerifyResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
    }

    public static EmailRegisterCodeVerifyJob emailRegisterCodeVerify(Context context, String str, String str2, int i, int i2, Map<String, String> map, CommonCallBack<EmailRegisterCodeVerifyResponse> commonCallBack) {
        return new EmailRegisterCodeVerifyJob(context, new ApiRequest.Builder().url(ExtraNetConstants.getEmailRegisterCodeVerifyPath()).parameters(getParams(str, str2, i, i2), map).post(), commonCallBack);
    }

    protected static Map<String, String> getParams(String str, String str2, int i, int i2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email", StringUtils.encryptWithXor(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("code", StringUtils.encryptWithXor(str2));
        }
        hashMap.put(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(i)));
        hashMap.put("email_logic_type", String.valueOf(i2));
        hashMap.put("mix_mode", "1");
        hashMap.put("fixed_mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public EmailRegisterCodeVerifyResponse transformResponse(boolean z, ApiResponse apiResponse) {
        EmailRegisterCodeVerifyResponse emailRegisterCodeVerifyResponse = new EmailRegisterCodeVerifyResponse(z, BaseApiResponse.API_EMAIL_REGISTER_CODE_VERIFY);
        if (z) {
            emailRegisterCodeVerifyResponse.setEmailTicket(this.mEmailTicket);
        } else {
            emailRegisterCodeVerifyResponse.error = apiResponse.mError;
            emailRegisterCodeVerifyResponse.errorMsg = apiResponse.mErrorMsg;
            emailRegisterCodeVerifyResponse.mDetailErrorMsg = apiResponse.mDetailErrorMsg;
        }
        return emailRegisterCodeVerifyResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.mEmailTicket = jSONObject2.optString("email_ticket");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(EmailRegisterCodeVerifyResponse emailRegisterCodeVerifyResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.EMAIL_REGISTER_CODE_VERIFY, null, null, emailRegisterCodeVerifyResponse, this.mApiCall);
    }
}
