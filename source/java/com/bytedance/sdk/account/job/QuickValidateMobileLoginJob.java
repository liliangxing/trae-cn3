package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.sso.UserApiObj;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class QuickValidateMobileLoginJob extends BaseAccountApi<UserApiResponse> {
    private JSONObject mResult;
    private final UserApiObj mUserApiObj;

    public QuickValidateMobileLoginJob(Context context, ApiRequest apiRequest, CommonCallBack<UserApiResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
        this.mUserApiObj = new UserApiObj();
    }

    public static QuickValidateMobileLoginJob quickValidateMobileLogin(Context context, String str, String str2, String str3, String str4, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        return new QuickValidateMobileLoginJob(context, new ApiRequest.Builder().url(CommonNetConstants.getValidateMobileLoginUrl()).parameters(getParams(str, str2, str3, str4), map).post(), commonCallBack);
    }

    private static Map<String, String> getParams(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", str4);
        hashMap.put("token", str3);
        hashMap.put("mobile", StringUtils.encryptWithXor(str2));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("mask_mobile", StringUtils.encryptWithXor(str));
        }
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse fromUserApiObj = ApiHelper.UserApiHelper.fromUserApiObj(this.mUserApiObj, z, 40001);
        if (!z && this.mUserApiObj.mError == 1075) {
            fromUserApiObj.mCancelApplyTime = this.mUserApiObj.mCancelApplyTime;
            fromUserApiObj.mCancelAvatarUrl = this.mUserApiObj.mCancelAvatarUrl;
            fromUserApiObj.mCancelNickName = this.mUserApiObj.mCancelNickName;
            fromUserApiObj.mCancelTime = this.mUserApiObj.mCancelTime;
            fromUserApiObj.mCancelToken = this.mUserApiObj.mCancelToken;
        }
        fromUserApiObj.result = this.mResult;
        return fromUserApiObj;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mResult = jSONObject2;
        ApiHelper.UserApiHelper.onStatusError(this.mUserApiObj, jSONObject);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.mResult = jSONObject;
        ApiHelper.UserApiHelper.extractUserInfo(jSONObject, jSONObject2, this.mUserApiObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(CommonNetConstants.EventName.VALIDATE_MOBILE_LOGIN, null, null, userApiResponse, this.mApiCall);
    }
}
