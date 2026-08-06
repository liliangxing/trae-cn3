package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GetLoginGuideStrategyJob extends BaseAccountApi<BaseApiResponse> {
    private JSONObject mResult;

    public GetLoginGuideStrategyJob(Context context, ApiRequest apiRequest, AbsApiCall<BaseApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static GetLoginGuideStrategyJob getLoginGuideStrategy(Context context, Map<String, String> map, AbsApiCall<BaseApiResponse> absApiCall) {
        return new GetLoginGuideStrategyJob(context, new ApiRequest.Builder().url(ExtraNetConstants.getLoginGuideStrategyUrl()).parameters(map).get(), absApiCall);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected BaseApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        BaseApiResponse baseApiResponse = new BaseApiResponse(z, ExtraNetConstants.API_LOGIN_GUIDE_STRATEGY);
        baseApiResponse.result = this.mResult;
        if (!z) {
            baseApiResponse.error = apiResponse.mError;
            baseApiResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return baseApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.mResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(BaseApiResponse baseApiResponse) {
        AccountMonitorUtil.onEvent(ExtraNetConstants.EventName.LOGIN_GUIDE_STRATEGY, null, null, baseApiResponse, this.mApiCall);
    }
}
