package com.bytedance.sdk.account.sso;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import com.ss.android.account.UserBindCallback;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AuthBindLoginThread extends BaseAccountApi<UserApiResponse> {
    private IBDAccountUserEntity mUserEntity;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public AuthBindLoginThread(Context context, ApiRequest apiRequest, UserBindCallback userBindCallback) {
        super(context, apiRequest, userBindCallback);
    }

    public static AuthBindLoginThread authBindLoginWithProfileKey(Context context, String str, String str2, String str3, String str4, Map<String, String> map, UserBindCallback userBindCallback) {
        return new AuthBindLoginThread(context, new ApiRequest.Builder().parameters(getParams(str, str2, str3, str4), map).url(ThirdPartyNetConstants.getAuthBindLoginUrl()).post(), userBindCallback);
    }

    private static Map<String, String> getParams(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("platform_app_id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("mobile", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("sms_code", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("profile_key", str4);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, ThirdPartyNetConstants.API_AUTH_BIND_LOGIN);
        if (z) {
            userApiResponse.userInfo = this.mUserEntity;
        } else {
            userApiResponse.error = apiResponse.mError;
            userApiResponse.errorMsg = apiResponse.mErrorMsg;
            userApiResponse.mDetailErrorMsg = apiResponse.mDetailErrorMsg;
        }
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.mUserEntity = ApiHelper.UserApiHelper.parseUserInfo(jSONObject);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(ThirdPartyNetConstants.EventName.AUTH_BIND_LOGIN, null, null, userApiResponse, this.mApiCall);
    }
}
