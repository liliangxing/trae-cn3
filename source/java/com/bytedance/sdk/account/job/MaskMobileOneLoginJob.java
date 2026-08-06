package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
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
public class MaskMobileOneLoginJob extends BaseAccountApi<UserApiResponse> {
    private UserApiResponse response;

    public MaskMobileOneLoginJob(Context context, ApiRequest apiRequest, CommonCallBack<UserApiResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
    }

    public static MaskMobileOneLoginJob maskQuickLogin(Context context, String str, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        return new MaskMobileOneLoginJob(context, new ApiRequest.Builder().url(CommonNetConstants.getMaskMobileOneLoginPath()).parameters(getParams(str), map).post(), commonCallBack);
    }

    private static Map<String, String> getParams(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("mask_mobile", str);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        if (this.response == null) {
            this.response = new UserApiResponse(z, BaseApiResponse.API_MASK_MOBILE_ONE_LOGIN);
        }
        if (!z) {
            this.response.error = apiResponse.mError;
            this.response.errorMsg = apiResponse.mErrorMsg;
        }
        return this.response;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        UserApiResponse userApiResponse = new UserApiResponse(false, BaseApiResponse.API_MASK_MOBILE_ONE_LOGIN);
        this.response = userApiResponse;
        userApiResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        UserApiResponse userApiResponse = new UserApiResponse(true, BaseApiResponse.API_MASK_MOBILE_ONE_LOGIN);
        this.response = userApiResponse;
        userApiResponse.result = jSONObject;
        this.response.userInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.MASK_MOBILE_ONE_LOGIN, null, null, userApiResponse, this.mApiCall);
    }
}
