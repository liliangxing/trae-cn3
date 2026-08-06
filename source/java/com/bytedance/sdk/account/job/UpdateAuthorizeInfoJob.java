package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.response.UpdateAuthorizeInfoResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UpdateAuthorizeInfoJob extends BaseAccountApi<UpdateAuthorizeInfoResponse> {
    private int mPlatformAppId;
    private final String mPlatformName;
    private UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse;

    public UpdateAuthorizeInfoJob(Context context, ApiRequest apiRequest, String str, String str2, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
        this.mPlatformAppId = -1;
        this.mPlatformName = str;
        try {
            this.mPlatformAppId = Integer.parseInt(str2);
        } catch (Throwable unused) {
        }
    }

    public static UpdateAuthorizeInfoJob updateAuthorizeInfo(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, String> map, CommonCallBack<UpdateAuthorizeInfoResponse> commonCallBack) {
        ApiRequest.Builder url = ApiHelper.createSsoBuilder(str7, str2, str5, str, null, str6, map).url(ThirdPartyNetConstants.getUpdateAuthorizeInfoUrl());
        if (!TextUtils.isEmpty(str3)) {
            url.parameter("openid", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            url.parameter("access_token_secret", str4);
        }
        return new UpdateAuthorizeInfoJob(context, url.get(), str7, str6, commonCallBack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UpdateAuthorizeInfoResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse = this.updateAuthorizeInfoResponse;
        if (updateAuthorizeInfoResponse == null) {
            updateAuthorizeInfoResponse = new UpdateAuthorizeInfoResponse(z, this.mPlatformName, this.mPlatformAppId);
        } else {
            updateAuthorizeInfoResponse.success = z;
        }
        if (!z) {
            updateAuthorizeInfoResponse.error = apiResponse.mError;
            updateAuthorizeInfoResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return updateAuthorizeInfoResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse = new UpdateAuthorizeInfoResponse(false, this.mPlatformName, this.mPlatformAppId);
        this.updateAuthorizeInfoResponse = updateAuthorizeInfoResponse;
        updateAuthorizeInfoResponse.parseErrorResponse(jSONObject2, jSONObject);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse = new UpdateAuthorizeInfoResponse(true, this.mPlatformName, this.mPlatformAppId);
        this.updateAuthorizeInfoResponse = updateAuthorizeInfoResponse;
        updateAuthorizeInfoResponse.parseSuccessResponse(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse) {
        AccountMonitorUtil.onEvent(ThirdPartyNetConstants.EventName.UPDATE_AUTHORIZE_INFO, this.mPlatformName, null, updateAuthorizeInfoResponse, this.mApiCall);
    }
}
