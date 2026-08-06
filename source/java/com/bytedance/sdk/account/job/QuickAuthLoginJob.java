package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.LoginByTicketCallback;
import com.bytedance.sdk.account.api.response.LoginByTicketResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.sso.ApiObj;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class QuickAuthLoginJob extends BaseAccountApi<LoginByTicketResponse> {
    private LoginByTicketResponse loginResponse;
    private ApiObj mQueryObj;

    private QuickAuthLoginJob(Context context, ApiRequest apiRequest, LoginByTicketCallback loginByTicketCallback) {
        super(context, apiRequest, loginByTicketCallback);
        this.mQueryObj = new ApiObj();
    }

    public static QuickAuthLoginJob quickAuthlogin(Context context, String str, String str2, Integer num, String str3, Map<String, String> map, LoginByTicketCallback loginByTicketCallback) {
        return new QuickAuthLoginJob(context, new ApiRequest.Builder().url(CommonNetConstants.getQuickAuthLoginPath()).parameters(getParams(str, str2, num, str3), map).post(), loginByTicketCallback);
    }

    public static QuickAuthLoginJob quickAuthloginContinue(Context context, String str, int i, Map map, LoginByTicketCallback loginByTicketCallback) {
        return new QuickAuthLoginJob(context, new ApiRequest.Builder().url(CommonNetConstants.getQuickAuthLoginContinuePath()).parameters(getContinueParams(str, i), map).post(), loginByTicketCallback);
    }

    public static QuickAuthLoginJob quickAuthloginOnly(Context context, String str, String str2, Map map, LoginByTicketCallback loginByTicketCallback) {
        return new QuickAuthLoginJob(context, new ApiRequest.Builder().url(CommonNetConstants.getQuickAuthLoginOnlyPath()).parameters(getParams(str, str2, null, null), map).post(), loginByTicketCallback);
    }

    protected static Map<String, String> getParams(String str, String str2, Integer num, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", str2);
        hashMap.put("token", str);
        if (num != null) {
            hashMap.put("auth_opposite", String.valueOf(num));
        }
        hashMap.put("provider_app_id", str3);
        return hashMap;
    }

    protected static Map<String, String> getContinueParams(String str, int i) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("sms_code_key", StringUtils.encryptWithXor(str));
        }
        if (i > 0) {
            hashMap.put("vcd_auth", String.valueOf(i));
        }
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public LoginByTicketResponse transformResponse(boolean z, ApiResponse apiResponse) {
        LoginByTicketResponse loginByTicketResponse = this.loginResponse;
        if (loginByTicketResponse == null) {
            loginByTicketResponse = new LoginByTicketResponse(z, BaseApiResponse.API_LOGIN_BY_TICKET);
        } else {
            loginByTicketResponse.success = z;
        }
        if (!z) {
            loginByTicketResponse.error = apiResponse.mError;
            loginByTicketResponse.errorMsg = apiResponse.mErrorMsg;
            if (this.mQueryObj.mError == 1075) {
                loginByTicketResponse.mCancelApplyTime = this.mQueryObj.mCancelApplyTime;
                loginByTicketResponse.mCancelAvatarUrl = this.mQueryObj.mCancelAvatarUrl;
                loginByTicketResponse.mCancelNickName = this.mQueryObj.mCancelNickName;
                loginByTicketResponse.mCancelTime = this.mQueryObj.mCancelTime;
                loginByTicketResponse.mCancelToken = this.mQueryObj.mCancelToken;
            }
        }
        return loginByTicketResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        LoginByTicketResponse loginByTicketResponse = new LoginByTicketResponse(false, BaseApiResponse.API_LOGIN_BY_TICKET);
        this.loginResponse = loginByTicketResponse;
        loginByTicketResponse.rawData = jSONObject;
        this.loginResponse.result = jSONObject2;
        this.loginResponse.mErrorCaptcha = jSONObject.optString("captcha");
        this.loginResponse.mSmsCodeKey = jSONObject.optString("sms_code_key");
        ApiHelper.apiError(this.mQueryObj, jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        LoginByTicketResponse loginByTicketResponse = new LoginByTicketResponse(true, BaseApiResponse.API_LOGIN_BY_TICKET);
        this.loginResponse = loginByTicketResponse;
        loginByTicketResponse.rawData = jSONObject2;
        this.loginResponse.result = jSONObject;
        this.loginResponse.mUserInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        this.loginResponse.mErrorCaptcha = jSONObject2.optString("captcha");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(LoginByTicketResponse loginByTicketResponse) {
        String str = AccountMonitorConstants.EventAccount.AUTH_ONE_LOGIN;
        if (loginByTicketResponse != null && !TextUtils.isEmpty(loginByTicketResponse.mRequestUrl)) {
            if (loginByTicketResponse.mRequestUrl.contains(CommonNetConstants.QUICK_AUTH_LOGIN_CONTINUE_PATH)) {
                str = AccountMonitorConstants.EventAccount.AUTH_ONE_LOGIN_CONTINUE;
            } else if (loginByTicketResponse.mRequestUrl.contains(CommonNetConstants.QUICK_AUTH_LOGIN_ONLY_PATH)) {
                str = "passport_auth_one_login_only";
            } else {
                loginByTicketResponse.mRequestUrl.contains(CommonNetConstants.QUICK_AUTH_LOGIN_PATH);
            }
        }
        AccountMonitorUtil.onEvent(str, null, null, loginByTicketResponse, this.mApiCall);
    }
}
