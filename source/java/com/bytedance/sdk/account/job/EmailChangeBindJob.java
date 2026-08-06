package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.IBDAccount;
import com.bytedance.sdk.account.api.response.EmailChangeBindResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class EmailChangeBindJob extends BaseAccountApi<EmailChangeBindResponse> {
    private String mEmail;
    private final IBDAccount mIBDAccount;
    private JSONObject mResult;

    public EmailChangeBindJob(Context context, ApiRequest apiRequest, CommonCallBack<EmailChangeBindResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
        this.mIBDAccount = BDAccountDelegateInner.instance(context);
    }

    public static EmailChangeBindJob emailChangeBind(Context context, String str, String str2, String str3, String str4, Map<String, String> map, CommonCallBack<EmailChangeBindResponse> commonCallBack) {
        return new EmailChangeBindJob(context, new ApiRequest.Builder().url(ExtraNetConstants.getEmailChangeBindUrl()).parameters(getParams(str, str2, str3, str4), map).post(), commonCallBack);
    }

    private static Map<String, String> getParams(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("mix_mode", "1");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email", StringUtils.encryptWithXor(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("code", StringUtils.encryptWithXor(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("ticket", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("not_login_ticket", str4);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public EmailChangeBindResponse transformResponse(boolean z, ApiResponse apiResponse) {
        EmailChangeBindResponse emailChangeBindResponse = new EmailChangeBindResponse(z, ExtraNetConstants.API_EMAIL_CHANGE_BIND);
        emailChangeBindResponse.result = this.mResult;
        if (z) {
            emailChangeBindResponse.setEmail(this.mEmail);
            this.mIBDAccount.setUserEmail(this.mEmail);
        } else {
            emailChangeBindResponse.error = apiResponse.mError;
            emailChangeBindResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return emailChangeBindResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.mResult = jSONObject;
        if (jSONObject2 != null) {
            this.mEmail = jSONObject2.optString("email");
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(EmailChangeBindResponse emailChangeBindResponse) {
        AccountMonitorUtil.onEvent(ExtraNetConstants.EventName.EMAIL_CHANGE_BIND, null, null, emailChangeBindResponse, this.mApiCall);
    }
}
