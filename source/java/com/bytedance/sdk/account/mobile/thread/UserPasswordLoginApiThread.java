package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.api.BDAccountNetApi;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.UserPasswordLoginQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.UserPasswordLoginQueryCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.param.UserLoginParam;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UserPasswordLoginApiThread extends BaseAccountApi<MobileApiResponse<UserPasswordLoginQueryObj>> {
    private UserPasswordLoginQueryObj queryObj;

    private UserPasswordLoginApiThread(Context context, ApiRequest apiRequest, UserPasswordLoginQueryObj userPasswordLoginQueryObj, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        super(context, apiRequest, userPasswordLoginQueryCallback);
        this.queryObj = userPasswordLoginQueryObj;
    }

    public static UserPasswordLoginApiThread userPasswordLogin(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        return userPasswordLogin(context, str, str2, str3, str4, str5, str6, str7, i, null, userPasswordLoginQueryCallback);
    }

    public static UserPasswordLoginApiThread userPasswordLogin(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Map<String, String> map, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        UserPasswordLoginQueryObj userPasswordLoginQueryObj = new UserPasswordLoginQueryObj(str2, str3, str, str4, str5, str6, str7, i);
        return new UserPasswordLoginApiThread(context, new ApiRequest.Builder().url(BDAccountNetApi.getUserPasswordLogin()).parameters(getParams(userPasswordLoginQueryObj)).parameters(map).post(), userPasswordLoginQueryObj, userPasswordLoginQueryCallback);
    }

    public static UserPasswordLoginApiThread userLogin(Context context, UserLoginParam userLoginParam, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        UserPasswordLoginQueryObj userPasswordLoginQueryObj = new UserPasswordLoginQueryObj(userLoginParam);
        return new UserPasswordLoginApiThread(context, new ApiRequest.Builder().url(BDAccountNetApi.getUserPasswordLogin()).parameters(getParams(userPasswordLoginQueryObj)).parameters(userLoginParam.extraInfo).post(), userPasswordLoginQueryObj, userPasswordLoginQueryCallback);
    }

    protected static Map<String, String> getParams(UserPasswordLoginQueryObj userPasswordLoginQueryObj) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(userPasswordLoginQueryObj.mEmail)) {
            hashMap.put("email", StringUtils.encryptWithXor(userPasswordLoginQueryObj.mEmail));
        }
        if (!TextUtils.isEmpty(userPasswordLoginQueryObj.mMobile)) {
            hashMap.put("mobile", StringUtils.encryptWithXor(userPasswordLoginQueryObj.mMobile));
        }
        if (!TextUtils.isEmpty(userPasswordLoginQueryObj.mUserName)) {
            hashMap.put("username", StringUtils.encryptWithXor(userPasswordLoginQueryObj.mUserName));
        }
        if (!TextUtils.isEmpty(userPasswordLoginQueryObj.mAccount)) {
            hashMap.put(SettingsTracker.TYPE_ACCOUNT, StringUtils.encryptWithXor(userPasswordLoginQueryObj.mAccount));
        }
        if (!TextUtils.isEmpty(userPasswordLoginQueryObj.mToken)) {
            hashMap.put("token", userPasswordLoginQueryObj.mToken);
        }
        if (!TextUtils.isEmpty(userPasswordLoginQueryObj.mCaptcha)) {
            hashMap.put("captcha", userPasswordLoginQueryObj.mCaptcha);
        }
        if (userPasswordLoginQueryObj.mScene > 0) {
            hashMap.put("scene", StringUtils.encryptWithXor(String.valueOf(userPasswordLoginQueryObj.mScene)));
        }
        hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(userPasswordLoginQueryObj.mPassword));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<UserPasswordLoginQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, BaseApiResponse.API_USER_PASSWORD_LOGIN, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.queryObj.mUserInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<UserPasswordLoginQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.LOGIN, null, null, mobileApiResponse, this.mApiCall);
    }
}
