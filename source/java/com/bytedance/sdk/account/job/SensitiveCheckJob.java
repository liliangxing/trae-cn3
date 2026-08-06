package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.response.SensitiveCheckResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SensitiveCheckJob extends BaseAccountApi<SensitiveCheckResponse> {
    private JSONObject rawData;
    private JSONObject rawResult;

    public SensitiveCheckJob(Context context, ApiRequest apiRequest, CommonCallBack<SensitiveCheckResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
    }

    public static SensitiveCheckJob sensitiveCheck(Context context, Map<String, String> map, CommonCallBack<SensitiveCheckResponse> commonCallBack) {
        return new SensitiveCheckJob(context, new ApiRequest.Builder().url(ExtraNetConstants.getSensitiveCheckUrl()).parameters(map).get(), commonCallBack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public SensitiveCheckResponse transformResponse(boolean z, ApiResponse apiResponse) {
        JSONObject optJSONObject;
        SensitiveCheckResponse sensitiveCheckResponse = new SensitiveCheckResponse(z);
        if (z) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = this.rawData;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && (optJSONObject = this.rawData.optJSONObject(next)) != null) {
                        hashMap.put(next, optJSONObject);
                    }
                }
            }
            sensitiveCheckResponse.sensitiveInfos = hashMap;
            sensitiveCheckResponse.rawData = this.rawData;
        } else {
            sensitiveCheckResponse.error = apiResponse.mError;
            sensitiveCheckResponse.errorMsg = apiResponse.mErrorMsg;
        }
        sensitiveCheckResponse.result = this.rawResult;
        return sensitiveCheckResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawResult = jSONObject2;
        this.rawData = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.rawResult = jSONObject;
        this.rawData = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(SensitiveCheckResponse sensitiveCheckResponse) {
        AccountMonitorUtil.onEvent("sensitive_check", null, null, sensitiveCheckResponse, this.mApiCall);
    }
}
