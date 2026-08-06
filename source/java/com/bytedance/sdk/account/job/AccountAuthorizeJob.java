package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.SpecialNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.AccountAuthorizeCallback;
import com.bytedance.sdk.account.api.response.AccountAuthorizeResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AccountAuthorizeJob extends BaseAccountApi<AccountAuthorizeResponse> {
    private AccountAuthorizeResponse accountAuthorizeResponse;

    public AccountAuthorizeJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static AccountAuthorizeJob accountAuthorize(Context context, String str, String str2, String str3, String str4, String str5, AccountAuthorizeCallback accountAuthorizeCallback) {
        return new AccountAuthorizeJob(context, new ApiRequest.Builder().url(SpecialNetConstants.getAccountAuthorizePath()).parameters(getParams(str, str2, str3, str4, str5)).post(), accountAuthorizeCallback);
    }

    private static Map<String, String> getParams(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("mix_mode", "1");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("mobile", StringUtils.encryptWithXor(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("username", StringUtils.encryptWithXor(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("email", StringUtils.encryptWithXor(str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("verify_user_id", str5);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public AccountAuthorizeResponse transformResponse(boolean z, ApiResponse apiResponse) {
        if (!z) {
            this.accountAuthorizeResponse.error = apiResponse.mError;
            this.accountAuthorizeResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return this.accountAuthorizeResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        AccountAuthorizeResponse accountAuthorizeResponse = new AccountAuthorizeResponse(false, BaseApiResponse.API_ACCOUNT_AUTHORIZE);
        this.accountAuthorizeResponse = accountAuthorizeResponse;
        accountAuthorizeResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        AccountAuthorizeResponse accountAuthorizeResponse = new AccountAuthorizeResponse(true, BaseApiResponse.API_ACCOUNT_AUTHORIZE);
        this.accountAuthorizeResponse = accountAuthorizeResponse;
        accountAuthorizeResponse.token = jSONObject2.optString("token");
        JSONObject optJSONObject = jSONObject2.optJSONObject("user_info");
        if (optJSONObject != null) {
            this.accountAuthorizeResponse.userInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, optJSONObject);
        }
        this.accountAuthorizeResponse.result = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(AccountAuthorizeResponse accountAuthorizeResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.ACCOUNT_AUTHORIZE, null, null, accountAuthorizeResponse, this.mApiCall);
    }
}
