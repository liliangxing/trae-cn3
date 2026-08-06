package com.bytedance.sdk.account.job.vcd;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.VcdEventReporter;
import com.bytedance.sdk.account.VcdNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.vcd.VcdAuthorizeCallback;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class VcdAuthorizeJob extends BaseAccountApi<BaseApiResponse> {
    private JSONObject rawResult;

    public VcdAuthorizeJob(Context context, ApiRequest apiRequest, VcdAuthorizeCallback vcdAuthorizeCallback) {
        super(context, apiRequest, vcdAuthorizeCallback);
    }

    public static VcdAuthorizeJob vcdAuthorize(Context context, Long l, Boolean bool, String str, VcdAuthorizeCallback vcdAuthorizeCallback) {
        return new VcdAuthorizeJob(context, new ApiRequest.Builder().url(VcdNetConstants.getVcdAuthorizePath()).parameters(getParams(l, bool, str)).post(), vcdAuthorizeCallback);
    }

    private static Map<String, String> getParams(Long l, Boolean bool, String str) {
        HashMap hashMap = new HashMap();
        if (l != null) {
            hashMap.put("secondary_user_id", String.valueOf(l));
        }
        if (bool != null) {
            hashMap.put(SettingsTracker.BINDING_ACTION_UNBIND, String.valueOf(bool));
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("scope", str);
        }
        return hashMap;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected BaseApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        BaseApiResponse baseApiResponse = new BaseApiResponse(z, VcdNetConstants.API_VCD_AUTHORIZE);
        if (!z) {
            baseApiResponse.error = apiResponse.mError;
            baseApiResponse.errorMsg = apiResponse.mErrorMsg;
        }
        baseApiResponse.result = this.rawResult;
        return baseApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.rawResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(BaseApiResponse baseApiResponse) {
        AccountMonitorUtil.onEvent(VcdEventReporter.EventPlatform.VCD_AUTHORIZE, null, null, baseApiResponse, this.mApiCall);
    }
}
