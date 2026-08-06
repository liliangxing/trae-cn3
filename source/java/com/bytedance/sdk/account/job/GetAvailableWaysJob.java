package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.GetAvailableWaysCallback;
import com.bytedance.sdk.account.api.response.GetAvailableWaysResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GetAvailableWaysJob extends BaseAccountApi<GetAvailableWaysResponse> {
    private GetAvailableWaysResponse getAvailableWaysResponse;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public GetAvailableWaysJob(Context context, ApiRequest apiRequest, GetAvailableWaysCallback getAvailableWaysCallback) {
        super(context, apiRequest, getAvailableWaysCallback);
    }

    public static GetAvailableWaysJob getAvailableWays(Context context, int i, String str, GetAvailableWaysCallback getAvailableWaysCallback) {
        return new GetAvailableWaysJob(context, new ApiRequest.Builder().url(CommonNetConstants.getAvailableWaysPath()).parameters(getParams(i, str)).post(), getAvailableWaysCallback);
    }

    protected static Map<String, String> getParams(int i, String str) {
        HashMap hashMap = new HashMap();
        if (i == 0) {
            hashMap.put("need_limit_platform", "0");
        } else {
            hashMap.put("need_limit_platform", "1");
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("not_login_ticket", str);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public GetAvailableWaysResponse transformResponse(boolean z, ApiResponse apiResponse) {
        GetAvailableWaysResponse getAvailableWaysResponse = this.getAvailableWaysResponse;
        if (getAvailableWaysResponse != null) {
            getAvailableWaysResponse.success = z;
        } else {
            getAvailableWaysResponse = new GetAvailableWaysResponse(z, BaseApiResponse.API_GET_AVAILABLE_WAYS);
        }
        if (!z) {
            getAvailableWaysResponse.error = apiResponse.mError;
            getAvailableWaysResponse.errorMsg = apiResponse.mErrorMsg;
        }
        this.getAvailableWaysResponse = null;
        return getAvailableWaysResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        GetAvailableWaysResponse getAvailableWaysResponse = new GetAvailableWaysResponse(true, BaseApiResponse.API_GET_AVAILABLE_WAYS);
        this.getAvailableWaysResponse = getAvailableWaysResponse;
        getAvailableWaysResponse.setEmail(jSONObject2.optString("email"));
        getAvailableWaysResponse.setHasEmail(jSONObject2.optBoolean("has_email"));
        getAvailableWaysResponse.setHasMobile(jSONObject2.optBoolean("has_mobile"));
        getAvailableWaysResponse.setHasOauth(jSONObject2.optBoolean("has_oauth"));
        getAvailableWaysResponse.setHasPwd(jSONObject2.optBoolean("has_pwd"));
        getAvailableWaysResponse.setMostDevice(jSONObject2.optBoolean("is_most_device"));
        getAvailableWaysResponse.setMobile(jSONObject2.optString("mobile"));
        getAvailableWaysResponse.setToken(jSONObject2.optString("token"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject2.optJSONArray("oauth_platforms");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(optJSONArray.getString(i));
            }
        }
        getAvailableWaysResponse.setOauthPlatforms(arrayList);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(GetAvailableWaysResponse getAvailableWaysResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.GET_AVAILABLE_WAYS, null, null, getAvailableWaysResponse, this.mApiCall);
    }
}
