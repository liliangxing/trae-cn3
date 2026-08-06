package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.constants.AccountConstants;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.thread.call.RecentOneLoginCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.sso.ApiObj;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class RecentOneLoginThread extends BaseAccountApi<UserApiResponse> {
    private ApiObj mApiObj;
    private JSONObject rawJson;
    private IBDAccountUserEntity userEntity;

    public RecentOneLoginThread(Context context, ApiRequest apiRequest, RecentOneLoginCallback recentOneLoginCallback) {
        super(context, apiRequest, recentOneLoginCallback);
        this.mApiObj = new ApiObj();
    }

    public static RecentOneLoginThread recentOneLogin(Context context, String str, boolean z, String str2, Integer num, Long l, String str3, Map<String, String> map, RecentOneLoginCallback recentOneLoginCallback) {
        return new RecentOneLoginThread(context, new ApiRequest.Builder().url(CommonNetConstants.getDeviceOneLoginPath()).parameters(getParams(str, z, str2, num, l, str3), map).get(), recentOneLoginCallback);
    }

    private static Map<String, String> getParams(String str, boolean z, String str2, Integer num, Long l, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("encrypted", z ? "1" : "0");
        hashMap.put("mix_mode", "1");
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                hashMap.put(AccountConstants.AccountShareCols.SEC_USER_ID, str);
            } else {
                hashMap.put("user_id", str);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("d_ticket", StringUtils.encryptWithXor(str2));
        }
        if (num != null) {
            hashMap.put("last_login_way", String.valueOf(num));
        }
        if (l != null) {
            hashMap.put("last_login_time", String.valueOf(l));
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("last_login_platform", str3);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, BaseApiResponse.API_DEVICE_ONE_LOGIN);
        if (z) {
            userApiResponse.userInfo = this.userEntity;
        } else {
            userApiResponse.error = this.mApiObj.mError;
            userApiResponse.errorMsg = this.mApiObj.mErrorMsg;
            userApiResponse.mCancelApplyTime = this.mApiObj.mCancelApplyTime;
            userApiResponse.mCancelTime = this.mApiObj.mCancelTime;
            userApiResponse.mCancelAvatarUrl = this.mApiObj.mCancelAvatarUrl;
            userApiResponse.mCancelNickName = this.mApiObj.mCancelNickName;
            userApiResponse.mCancelToken = this.mApiObj.mCancelToken;
            userApiResponse.setProfileKey(this.mApiObj.mProfileKey);
            userApiResponse.mSharkTicket = this.mApiObj.mSharkTicket;
        }
        userApiResponse.result = this.rawJson;
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.apiError(this.mApiObj, jSONObject, jSONObject2);
        this.rawJson = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.userEntity = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        this.rawJson = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onRecentOneLoginEvent(AccountMonitorConstants.EventAccount.DEVICE_ONE_LOGIN, userApiResponse, null);
    }
}
