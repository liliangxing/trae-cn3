package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.VerifyEmailCallback;
import com.bytedance.sdk.account.api.response.VerifyEmailResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.database.DBData;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class VerifyEmailJob extends BaseAccountApi<VerifyEmailResponse> {
    private JSONObject rawResult;
    private String ticket;

    public VerifyEmailJob(Context context, ApiRequest apiRequest, VerifyEmailCallback verifyEmailCallback) {
        super(context, apiRequest, verifyEmailCallback);
    }

    public static VerifyEmailJob verifyEmail(Context context, int i, String str, VerifyEmailCallback verifyEmailCallback) {
        return new VerifyEmailJob(context, new ApiRequest.Builder().url(ExtraNetConstants.getEmailVerifyPath()).parameter("mix_mode", "1").parameter(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(i))).parameter("code", StringUtils.encryptWithXor(str)).post(), verifyEmailCallback);
    }

    public static VerifyEmailJob verifyEmail(Context context, int i, String str, Map<String, String> map, VerifyEmailCallback verifyEmailCallback) {
        return new VerifyEmailJob(context, new ApiRequest.Builder().url(ExtraNetConstants.getEmailVerifyPath()).parameter("mix_mode", "1").parameter(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(i))).parameter("code", StringUtils.encryptWithXor(str)).parameters(map).post(), verifyEmailCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public VerifyEmailResponse transformResponse(boolean z, ApiResponse apiResponse) {
        VerifyEmailResponse verifyEmailResponse = new VerifyEmailResponse(z, BaseApiResponse.API_VERIFY_EMAIL);
        if (z) {
            verifyEmailResponse.ticket = this.ticket;
        } else {
            verifyEmailResponse.error = apiResponse.mError;
            verifyEmailResponse.errorMsg = apiResponse.mErrorMsg;
        }
        verifyEmailResponse.result = this.rawResult;
        return verifyEmailResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.rawResult = jSONObject;
        this.ticket = jSONObject2.optString("ticket");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(VerifyEmailResponse verifyEmailResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.VERIFY_EMAIL, null, null, verifyEmailResponse, this.mApiCall);
    }
}
