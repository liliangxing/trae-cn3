package com.bytedance.sdk.account.sso;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SsoApiLoginThread extends BaseAccountApi<UserApiResponse> {
    private ApiLoginObj mQueryObj;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class ApiLoginObj extends UserApiObj {
        JSONObject response;
    }

    private SsoApiLoginThread(Context context, ApiRequest apiRequest, AbsApiCall<UserApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
        this.mQueryObj = new ApiLoginObj();
    }

    public static SsoApiLoginThread withProfileKeyLogin(Context context, String str, String str2, String str3, String str4, Map<String, String> map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiLoginThread(context, ApiHelper.createSsoBuilder(str2, null, str4, null, str3, str, map).url(ThirdPartyNetConstants.getSsoCallbackUrl()).checkSupportMultiLogin().post(), absApiCall);
    }

    public static SsoApiLoginThread withAccessTokenLogin(Context context, String str, String str2, String str3, String str4, Map<String, String> map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiLoginThread(context, ApiHelper.createSsoBuilder(str2, str3, str4, null, null, str, map).url(ThirdPartyNetConstants.getSsoCallbackUrl()).checkSupportMultiLogin().post(), absApiCall);
    }

    public static SsoApiLoginThread withAccessTokenLogin(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map, AbsApiCall<UserApiResponse> absApiCall) {
        ApiRequest.Builder createSsoBuilder = ApiHelper.createSsoBuilder(str2, str3, str5, null, null, str, map);
        if (!TextUtils.isEmpty(str4)) {
            createSsoBuilder.parameter("access_token_secret", str4);
        }
        createSsoBuilder.url(ThirdPartyNetConstants.getSsoCallbackUrl()).checkSupportMultiLogin();
        return new SsoApiLoginThread(context, createSsoBuilder.post(), absApiCall);
    }

    public static SsoApiLoginThread withAuthCodeLogin(Context context, String str, String str2, String str3, String str4, Map<String, String> map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiLoginThread(context, ApiHelper.createSsoBuilder(str2, null, str4, str3, null, str, map).url(ThirdPartyNetConstants.getSsoCallbackUrl()).checkSupportMultiLogin().post(), absApiCall);
    }

    public static SsoApiLoginThread withAuthCodeBindMobileLogin(Context context, String str, String str2, String str3, String str4, boolean z, boolean z2, Map<String, String> map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiLoginThread(context, new ApiRequest.Builder().url(ThirdPartyNetConstants.getAuthBindWithMobileLogin()).parameters(getParams(str, str2, str3, str4, z, z2, map)).post(), absApiCall);
    }

    public static SsoApiLoginThread shareLogin(Context context, String str, String str2, String str3, Map<String, String> map, AbsApiCall<UserApiResponse> absApiCall) {
        return new SsoApiLoginThread(context, ApiHelper.createSsoBuilder(str3, null, null, str, null, str2, map).url(ThirdPartyNetConstants.getShareLoginPath()).post(), absApiCall);
    }

    protected static Map<String, String> getParams(String str, String str2, String str3, String str4, boolean z, boolean z2, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("platform_app_id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("platform", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("code", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("profile_key", str4);
        }
        hashMap.put("need_mobile", z ? "1" : "0");
        hashMap.put(AccountMonitorConstants.Scene.SCENE_AUTH_CHANGE_BIND, z2 ? "1" : "0");
        if (map != null && !map.isEmpty()) {
            for (String str5 : map.keySet()) {
                if (!TextUtils.isEmpty(str5)) {
                    hashMap.put(str5, map.get(str5));
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, 1);
        if (z) {
            userApiResponse.userInfo = this.mQueryObj.info;
        } else {
            userApiResponse.error = this.mQueryObj.mError;
            userApiResponse.errorMsg = this.mQueryObj.mErrorMsg;
            userApiResponse.mSharkTicket = this.mQueryObj.mSharkTicket;
            userApiResponse.setProfileKey(this.mQueryObj.mProfileKey);
            if (this.mQueryObj.mError == 1075) {
                userApiResponse.mCancelApplyTime = this.mQueryObj.mCancelApplyTime;
                userApiResponse.mCancelAvatarUrl = this.mQueryObj.mCancelAvatarUrl;
                userApiResponse.mCancelNickName = this.mQueryObj.mCancelNickName;
                userApiResponse.mCancelTime = this.mQueryObj.mCancelTime;
                userApiResponse.mCancelToken = this.mQueryObj.mCancelToken;
            }
            userApiResponse.mConflictUser = this.mQueryObj.mConflictUser;
        }
        userApiResponse.result = this.mQueryObj.response;
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        String str;
        if (TextUtils.isEmpty(userApiResponse.mRequestUrl)) {
            return;
        }
        if (userApiResponse.mRequestUrl.contains(ThirdPartyNetConstants.getAuthBindWithMobileLogin())) {
            str = AccountMonitorConstants.EventPlatform.AUTH_BIND_WITH_MOBILE_LOGIN;
        } else {
            str = userApiResponse.mRequestUrl.contains(ThirdPartyNetConstants.getShareLoginPath()) ? AccountMonitorConstants.EventPlatform.SHARE_LOGIN : AccountMonitorConstants.EventPlatform.OAUTH_LOGIN_CLICK;
        }
        AccountMonitorUtil.onEvent(str, this.apiRequest.parameter("platform"), "login", userApiResponse, this.mApiCall);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.UserApiHelper.onStatusError(this.mQueryObj, jSONObject);
        this.mQueryObj.response = jSONObject2;
        if (jSONObject != null) {
            this.mQueryObj.mProfileKey = jSONObject.optString("profile_key");
            this.mQueryObj.mSharkTicket = jSONObject.optString("shark_ticket");
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        ApiHelper.UserApiHelper.extractUserInfo(jSONObject, jSONObject2, this.mQueryObj);
        this.mQueryObj.response = jSONObject;
    }
}
