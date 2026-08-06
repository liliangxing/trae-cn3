package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.SpecialNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.GetQRCodeCallback;
import com.bytedance.sdk.account.api.response.GetQRCodeResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GetQRCodeJob extends BaseAccountApi {
    private GetQRCodeResponse mQRCodeResponse;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public GetQRCodeJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static GetQRCodeJob getQRCode(Context context, String str, int i, String str2, Map<String, String> map, GetQRCodeCallback getQRCodeCallback) {
        return new GetQRCodeJob(context, new ApiRequest.Builder().parameters(getParams(str, i, str2), map).url(SpecialNetConstants.getQRCodePath()).get(), getQRCodeCallback);
    }

    private static Map<String, String> getParams(String str, int i, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(TracingConstants.KEY_TRACE_NAME, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("extra", str2);
        }
        hashMap.put("scene", String.valueOf(i));
        return hashMap;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected BaseApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        GetQRCodeResponse getQRCodeResponse = this.mQRCodeResponse;
        if (getQRCodeResponse == null) {
            getQRCodeResponse = new GetQRCodeResponse(z, BaseApiResponse.API_GET_QR_CODE);
        } else {
            getQRCodeResponse.success = z;
        }
        if (!z) {
            getQRCodeResponse.error = apiResponse.mError;
            getQRCodeResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return getQRCodeResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        GetQRCodeResponse getQRCodeResponse = new GetQRCodeResponse(true, BaseApiResponse.API_GET_QR_CODE);
        this.mQRCodeResponse = getQRCodeResponse;
        getQRCodeResponse.result = jSONObject;
        this.mQRCodeResponse.qrCode = jSONObject2.optString("qrcode");
        this.mQRCodeResponse.qrCodeUrl = jSONObject2.optString("qrcode_index_url");
        this.mQRCodeResponse.token = jSONObject2.optString("token");
        this.mQRCodeResponse.appName = jSONObject2.optString("app_name");
        this.mQRCodeResponse.webName = jSONObject2.optString("web_name");
        this.mQRCodeResponse.expireTime = jSONObject2.optLong("expire_time");
        this.mQRCodeResponse.isFrontier = jSONObject2.optBoolean("is_frontier");
        this.mQRCodeResponse.frontierParams = jSONObject2.optJSONObject("frontier_params");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(BaseApiResponse baseApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.GET_QR_CODE, null, null, baseApiResponse, this.mApiCall);
    }
}
