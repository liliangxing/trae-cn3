package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class HistoryMobileCardLoginJob extends BaseAccountApi<UserApiResponse> {
    private JSONObject mResult;
    private IBDAccountUserEntity mUserEntity;

    public HistoryMobileCardLoginJob(Context context, ApiRequest apiRequest, AbsApiCall<UserApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static HistoryMobileCardLoginJob mobileCardLogin(Context context, String str, String[] strArr, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        return new HistoryMobileCardLoginJob(context, new ApiRequest.Builder().url(CommonNetConstants.getHistoryMobileCardLoginUrl()).parameters(getParams(str, strArr), map).post(), commonCallBack);
    }

    private static Map<String, String> getParams(String str, String[] strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("mix_mode", "1");
        hashMap.put("mobile", StringUtils.encryptWithXor(str));
        hashMap.put("mobile_card", buildMobileCardInfo(strArr));
        return hashMap;
    }

    private static String buildMobileCardInfo(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(str);
                } else {
                    sb.append(IWeiboService.Scope.EMPTY_SCOPE).append(str);
                }
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return null;
        }
        return StringUtils.encryptWithXor(sb2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, 40002);
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
        this.mUserEntity = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(CommonNetConstants.EventName.HISTORY_MOBILE_CARD_LOGIN, null, null, userApiResponse, this.mApiCall);
    }
}
