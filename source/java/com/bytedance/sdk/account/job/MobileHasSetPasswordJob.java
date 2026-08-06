package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.MobileHasSetPasswordCallback;
import com.bytedance.sdk.account.api.response.MobileHasSetPasswordResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class MobileHasSetPasswordJob extends BaseAccountApi<MobileHasSetPasswordResponse> {
    private boolean hasSet;
    private JSONObject rawResult;

    public MobileHasSetPasswordJob(Context context, ApiRequest apiRequest, MobileHasSetPasswordCallback mobileHasSetPasswordCallback) {
        super(context, apiRequest, mobileHasSetPasswordCallback);
    }

    public static MobileHasSetPasswordJob mobileHasSetPassword(Context context, String str, String str2, MobileHasSetPasswordCallback mobileHasSetPasswordCallback) {
        return new MobileHasSetPasswordJob(context, new ApiRequest.Builder().url(CommonNetConstants.getPasswordHasSetByMobilePath()).parameter("mix_mode", "1").parameter("mobile", StringUtils.encryptWithXor(str)).parameter("target", str2).get(), mobileHasSetPasswordCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileHasSetPasswordResponse transformResponse(boolean z, ApiResponse apiResponse) {
        MobileHasSetPasswordResponse mobileHasSetPasswordResponse = new MobileHasSetPasswordResponse(z, BaseApiResponse.API_PASSWORD_HAS_SET_BY_MOBILE);
        if (z) {
            mobileHasSetPasswordResponse.hasSet = this.hasSet;
        } else {
            mobileHasSetPasswordResponse.error = apiResponse.mError;
            mobileHasSetPasswordResponse.errorMsg = apiResponse.mErrorMsg;
        }
        mobileHasSetPasswordResponse.result = this.rawResult;
        return mobileHasSetPasswordResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.hasSet = jSONObject2.optBoolean("has_set");
        this.rawResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileHasSetPasswordResponse mobileHasSetPasswordResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.PASSWORD_HAS_SET_BY_MOBILE, null, null, mobileHasSetPasswordResponse, this.mApiCall);
    }
}
