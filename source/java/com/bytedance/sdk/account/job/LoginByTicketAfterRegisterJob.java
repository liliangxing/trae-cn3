package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.SpecialNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.LoginByTicketAfterRegisterCallback;
import com.bytedance.sdk.account.api.response.LoginByTicketAfterRegisterResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class LoginByTicketAfterRegisterJob extends BaseAccountApi<LoginByTicketAfterRegisterResponse> {
    private IBDAccountUserEntity userEntity;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public LoginByTicketAfterRegisterJob(Context context, ApiRequest apiRequest, LoginByTicketAfterRegisterCallback loginByTicketAfterRegisterCallback) {
        super(context, apiRequest, loginByTicketAfterRegisterCallback);
    }

    public static LoginByTicketAfterRegisterJob loginByTicketAfterRegister(Context context, String str, String str2, Map<String, String> map, LoginByTicketAfterRegisterCallback loginByTicketAfterRegisterCallback) {
        return new LoginByTicketAfterRegisterJob(context, new ApiRequest.Builder().url(SpecialNetConstants.getAfterRegisterLoginByTicketPath()).parameters(getParams(str, str2), map).get(), loginByTicketAfterRegisterCallback);
    }

    protected static Map<String, String> getParams(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("ticket", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("mobile", StringUtils.encryptWithXor(str2));
        }
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public LoginByTicketAfterRegisterResponse transformResponse(boolean z, ApiResponse apiResponse) {
        LoginByTicketAfterRegisterResponse loginByTicketAfterRegisterResponse = new LoginByTicketAfterRegisterResponse(z, BaseApiResponse.API_LOGIN_BY_TICKET_AFTER_REGISTER);
        if (z) {
            loginByTicketAfterRegisterResponse.userInfo = this.userEntity;
        } else {
            loginByTicketAfterRegisterResponse.error = apiResponse.mError;
            loginByTicketAfterRegisterResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return loginByTicketAfterRegisterResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.userEntity = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(LoginByTicketAfterRegisterResponse loginByTicketAfterRegisterResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.LOGIN_BY_TICKET_AFTER_REGISTER, null, null, loginByTicketAfterRegisterResponse, this.mApiCall);
    }
}
