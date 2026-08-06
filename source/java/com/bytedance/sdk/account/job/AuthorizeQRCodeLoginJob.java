package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.CsrfTokenManager;
import com.bytedance.sdk.account.SpecialNetConstants;
import com.bytedance.sdk.account.api.BDAccountNetApi;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.AuthorizeQRCodeLoginCallback;
import com.bytedance.sdk.account.api.response.AuthorizeQRCodeLoginResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AuthorizeQRCodeLoginJob extends BaseAccountApi<AuthorizeQRCodeLoginResponse> {
    private AuthorizeQRCodeLoginResponse mAuthorizeQRCodeLoginResponse;
    private JSONObject mResult;

    public AuthorizeQRCodeLoginJob(Context context, ApiRequest apiRequest, AbsApiCall<AuthorizeQRCodeLoginResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static AuthorizeQRCodeLoginJob authorizeLogin(Context context, String str, String str2, String str3, Map<String, String> map, AuthorizeQRCodeLoginCallback authorizeQRCodeLoginCallback) {
        return new AuthorizeQRCodeLoginJob(context, new ApiRequest.Builder().parameter("token", str).parameter("decision", str2).parameter(CsrfTokenManager.SP_KEY_CSRF_TOKEN, str3).parameters(map).url(SpecialNetConstants.getAuthorizeQRCodeToLoginPath()).post(), authorizeQRCodeLoginCallback);
    }

    public static AuthorizeQRCodeLoginJob authorizeLoginWithConfirmedUrl(Context context, String str, String str2, String str3, String str4, Map<String, String> map, AuthorizeQRCodeLoginCallback authorizeQRCodeLoginCallback) {
        if (!TextUtils.isEmpty(str4)) {
            if (!str4.startsWith("http") && !str4.startsWith("https")) {
                str4 = BDAccountNetApi.getUrl(str4);
            }
            return new AuthorizeQRCodeLoginJob(context, new ApiRequest.Builder().parameter("token", str).parameter("decision", str2).parameters(map).url(str4).post(), authorizeQRCodeLoginCallback);
        }
        return authorizeLogin(context, str, str2, str3, map, authorizeQRCodeLoginCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public AuthorizeQRCodeLoginResponse transformResponse(boolean z, ApiResponse apiResponse) {
        AuthorizeQRCodeLoginResponse authorizeQRCodeLoginResponse = this.mAuthorizeQRCodeLoginResponse;
        if (authorizeQRCodeLoginResponse == null) {
            authorizeQRCodeLoginResponse = new AuthorizeQRCodeLoginResponse(z, BaseApiResponse.API_AUTHORIZE_QR_CODE_LOGIN);
        } else {
            authorizeQRCodeLoginResponse.success = z;
        }
        if (!z) {
            authorizeQRCodeLoginResponse.error = apiResponse.mError;
            authorizeQRCodeLoginResponse.errorMsg = apiResponse.mErrorMsg;
        }
        authorizeQRCodeLoginResponse.result = this.mResult;
        return authorizeQRCodeLoginResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.mAuthorizeQRCodeLoginResponse = new AuthorizeQRCodeLoginResponse(true, BaseApiResponse.API_AUTHORIZE_QR_CODE_LOGIN);
        this.mResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(AuthorizeQRCodeLoginResponse authorizeQRCodeLoginResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.AUTHORIZE_QR_CODE_LOGIN, null, null, authorizeQRCodeLoginResponse, this.mApiCall);
    }
}
