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
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class VerifyTickerLoginJob extends BaseAccountApi<UserApiResponse> {
    private JSONObject rawResult;
    private IBDAccountUserEntity userEntity;

    public VerifyTickerLoginJob(Context context, ApiRequest apiRequest, CommonCallBack<UserApiResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
    }

    public static VerifyTickerLoginJob loginByVerifyTicket(Context context, String str, String str2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        return new VerifyTickerLoginJob(context, new ApiRequest.Builder().url(CommonNetConstants.getVerifyLoginPath()).parameters(getParams(str, str2)).parameters(map).post(), commonCallBack);
    }

    private static Map<String, String> getParams(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("verify_ticket", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("scene", str2);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, BaseApiResponse.API_VERIFY_TICKET_LOGIN);
        if (z) {
            userApiResponse.userInfo = this.userEntity;
        } else {
            userApiResponse.error = apiResponse.mError;
            userApiResponse.errorMsg = apiResponse.mErrorMsg;
            userApiResponse.mDetailErrorMsg = apiResponse.mDetailErrorMsg;
        }
        userApiResponse.result = this.rawResult;
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.rawResult = jSONObject;
        this.userEntity = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.LOGIN_BY_VERIFY_TICKET, null, null, userApiResponse, this.mApiCall);
    }
}
