package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.SafeVerifyCallback;
import com.bytedance.sdk.account.api.response.SafeVerifyResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SafeVerifyJob extends BaseAccountApi<SafeVerifyResponse> {
    private JSONObject rawResult;
    private boolean safe;
    private String ticket;

    public SafeVerifyJob(Context context, ApiRequest apiRequest, SafeVerifyCallback safeVerifyCallback) {
        super(context, apiRequest, safeVerifyCallback);
    }

    public static SafeVerifyJob safeVerify(Context context, String str, String str2, String str3, String str4, Map<String, String> map, SafeVerifyCallback safeVerifyCallback) {
        return new SafeVerifyJob(context, new ApiRequest.Builder().url(CommonNetConstants.getSharkSafeVerifyPath()).parameters(getParams(str, str2, str3, str4), map).post(), safeVerifyCallback);
    }

    private static Map<String, String> getParams(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("not_login_ticket", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("target", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("scene", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("old_mobile", StringUtils.encryptWithXor(str4));
        }
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public SafeVerifyResponse transformResponse(boolean z, ApiResponse apiResponse) {
        SafeVerifyResponse safeVerifyResponse = new SafeVerifyResponse(z, BaseApiResponse.API_SAFE_VERIFY);
        if (z) {
            safeVerifyResponse.ticket = this.ticket;
            safeVerifyResponse.safe = this.safe;
        } else {
            safeVerifyResponse.error = apiResponse.mError;
            safeVerifyResponse.errorMsg = apiResponse.mErrorMsg;
        }
        safeVerifyResponse.result = this.rawResult;
        return safeVerifyResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.rawResult = jSONObject;
        this.ticket = jSONObject2.optString("ticket");
        this.safe = jSONObject2.optBoolean("safe");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(SafeVerifyResponse safeVerifyResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.SAFE_VERIFY, null, null, safeVerifyResponse, this.mApiCall);
    }
}
