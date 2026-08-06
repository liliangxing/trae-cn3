package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.api.callback.BindEmailCallback;
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
public class BindEmailJob extends BaseAccountApi<UserApiResponse> {
    private JSONObject rawResult;
    private IBDAccountUserEntity userEntity;

    public BindEmailJob(Context context, ApiRequest apiRequest, BindEmailCallback bindEmailCallback) {
        super(context, apiRequest, bindEmailCallback);
    }

    public static BindEmailJob bindEmail(Context context, String str, String str2, BindEmailCallback bindEmailCallback) {
        return new BindEmailJob(context, new ApiRequest.Builder().url(ExtraNetConstants.getEmailBindPath()).parameters(getParams(str, str2)).post(), bindEmailCallback);
    }

    private static Map<String, String> getParams(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("mix_mode", "1");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email", StringUtils.encryptWithXor(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("code", StringUtils.encryptWithXor(str2));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, BaseApiResponse.API_EMAIL_BIND);
        if (z) {
            userApiResponse.userInfo = this.userEntity;
        } else {
            userApiResponse.error = apiResponse.mError;
            userApiResponse.errorMsg = apiResponse.mErrorMsg;
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
        this.userEntity = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        this.rawResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.BIND_EMAIL, null, null, userApiResponse, this.mApiCall);
    }
}
