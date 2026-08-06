package com.bytedance.sdk.account.sso;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.constants.AccountConstants;
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
public class ChainLoginThread extends BaseAccountApi<UserApiResponse> {
    private ApiLoginObj mQueryObj;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class ApiLoginObj extends UserApiObj {
        JSONObject response;
    }

    private ChainLoginThread(Context context, ApiRequest apiRequest, AbsApiCall<UserApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
        this.mQueryObj = new ApiLoginObj();
    }

    public static ChainLoginThread chainLogin(Context context, String str, String str2, Map<String, String> map, AbsApiCall<UserApiResponse> absApiCall) {
        return new ChainLoginThread(context, new ApiRequest.Builder().url(CommonNetConstants.getChainLoginPath()).parameters(getParams(str, str2, map)).post(), absApiCall);
    }

    protected static Map<String, String> getParams(String str, String str2, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("from_session_key", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(AccountConstants.AccountShareCols.FROM_INSTALL_ID, str2);
        }
        if (map != null && !map.isEmpty()) {
            for (String str3 : map.keySet()) {
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put(str3, map.get(str3));
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, BaseApiResponse.API_CHAIN_LOGIN);
        if (z) {
            userApiResponse.userInfo = this.mQueryObj.info;
        } else {
            userApiResponse.error = this.mQueryObj.mError;
            userApiResponse.errorMsg = this.mQueryObj.mErrorMsg;
        }
        userApiResponse.result = this.mQueryObj.response;
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.CHAIN_LOGIN, null, null, userApiResponse, this.mApiCall);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.UserApiHelper.onStatusError(this.mQueryObj, jSONObject);
        this.mQueryObj.response = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        ApiHelper.UserApiHelper.extractUserInfo(jSONObject, jSONObject2, this.mQueryObj);
        this.mQueryObj.response = jSONObject;
    }
}
