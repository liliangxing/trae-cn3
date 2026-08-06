package com.bytedance.sdk.account.information.method;

import android.content.Context;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.information.UserInfoNetConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class RemainUpdateTimesJob extends BaseAccountApi<RemainUpdateTimesResponse> {
    String mField;
    RemainUpdateTimesResponse mRemainUpdateTimesResponse;

    public RemainUpdateTimesJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static RemainUpdateTimesJob getRemainUpdateTimes(Context context, String str, String str2, Map<String, String> map, CommonCallBack<RemainUpdateTimesResponse> commonCallBack) {
        RemainUpdateTimesJob remainUpdateTimesJob = new RemainUpdateTimesJob(context, new ApiRequest.Builder().url(UserInfoNetConstants.getRemainUpdateTimesUrl()).parameter("field", str).parameter("field_namespace", str2).parameters(map).get(), commonCallBack);
        remainUpdateTimesJob.mField = str;
        return remainUpdateTimesJob;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public RemainUpdateTimesResponse transformResponse(boolean z, ApiResponse apiResponse) {
        if (this.mRemainUpdateTimesResponse == null) {
            this.mRemainUpdateTimesResponse = new RemainUpdateTimesResponse(z);
        }
        this.mRemainUpdateTimesResponse.error = apiResponse.mError;
        this.mRemainUpdateTimesResponse.errorMsg = apiResponse.mErrorMsg;
        return this.mRemainUpdateTimesResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        RemainUpdateTimesResponse remainUpdateTimesResponse = new RemainUpdateTimesResponse(false);
        this.mRemainUpdateTimesResponse = remainUpdateTimesResponse;
        remainUpdateTimesResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        RemainUpdateTimesResponse remainUpdateTimesResponse = new RemainUpdateTimesResponse(true);
        this.mRemainUpdateTimesResponse = remainUpdateTimesResponse;
        remainUpdateTimesResponse.result = jSONObject;
        JSONObject optJSONObject = jSONObject2.optJSONObject(this.mField);
        if (optJSONObject != null) {
            this.mRemainUpdateTimesResponse.leftUpdateTimes = optJSONObject.optInt("left_update_times");
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(RemainUpdateTimesResponse remainUpdateTimesResponse) {
        AccountMonitorUtil.onEvent(UserInfoNetConstants.EventName.USER_GET_REMAIN_UPDATE_TIMES, null, null, remainUpdateTimesResponse, this.mApiCall);
    }
}
