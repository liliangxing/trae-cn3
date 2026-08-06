package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class EmailChangePasswordJob extends BaseAccountApi<UserApiResponse> {
    private JSONObject mResult;
    private IBDAccountUserEntity mUserEntity;

    public EmailChangePasswordJob(Context context, ApiRequest apiRequest, AbsApiCall<UserApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static EmailChangePasswordJob emailChangePassword(Context context, String str, String str2, String str3, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        return new EmailChangePasswordJob(context, new ApiRequest.Builder().url(ExtraNetConstants.getEmailChangePasswordUrl()).parameters(getParams(str, str2, str3), map).post(), commonCallBack);
    }

    private static Map<String, String> getParams(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("mix_mode", "1");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("code", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("ticket", str3);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, ExtraNetConstants.API_EMAIL_CHANGE_PASSWORD);
        if (z) {
            userApiResponse.userInfo = this.mUserEntity;
        } else {
            userApiResponse.error = apiResponse.mError;
            userApiResponse.errorMsg = apiResponse.mErrorMsg;
            userApiResponse.mDetailErrorMsg = apiResponse.mDetailErrorMsg;
        }
        userApiResponse.result = this.mResult;
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.mResult = jSONObject;
        this.mUserEntity = ApiHelper.UserApiHelper.parseUserInfo(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(ExtraNetConstants.EventName.EMAIL_CHANGE_PASSWORD, null, null, userApiResponse, this.mApiCall);
    }
}
