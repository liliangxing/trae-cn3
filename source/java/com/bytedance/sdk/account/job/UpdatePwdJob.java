package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.UpdatePwdCallback;
import com.bytedance.sdk.account.api.response.UpdatePwdResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UpdatePwdJob extends BaseAccountApi<UpdatePwdResponse> {
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
    }

    private UpdatePwdJob(Context context, ApiRequest apiRequest, UpdatePwdCallback updatePwdCallback) {
        super(context, apiRequest, updatePwdCallback);
    }

    public static UpdatePwdJob updatePwd(Context context, String str, String str2, UpdatePwdCallback updatePwdCallback) {
        return new UpdatePwdJob(context, new ApiRequest.Builder().url(CommonNetConstants.getUpdatePwdPath()).parameters(getParams(str, str2)).post(), updatePwdCallback);
    }

    public static UpdatePwdJob updatePwd(Context context, String str, String str2, Map<String, String> map, UpdatePwdCallback updatePwdCallback) {
        return new UpdatePwdJob(context, new ApiRequest.Builder().url(CommonNetConstants.getUpdatePwdPath()).parameters(getParams(str, str2), map).post(), updatePwdCallback);
    }

    protected static Map<String, String> getParams(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("current_password", StringUtils.encryptWithXor(str));
        hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(str2));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UpdatePwdResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UpdatePwdResponse updatePwdResponse = new UpdatePwdResponse(z, BaseApiResponse.API_UPDATE_PWD);
        if (!z) {
            updatePwdResponse.error = apiResponse.mError;
            updatePwdResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return updatePwdResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UpdatePwdResponse updatePwdResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.UPDATE_PWD, null, null, updatePwdResponse, this.mApiCall);
    }
}
