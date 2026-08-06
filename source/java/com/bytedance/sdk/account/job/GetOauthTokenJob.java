package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.response.GetOauthTokenResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.ss.android.LogHelper;
import com.ss.android.TTHeader;
import com.ss.android.account.TTAccountInit;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GetOauthTokenJob extends BaseAccountApi<GetOauthTokenResponse> {
    private static final String TAG = "GetOauthTokenJob";
    private GetOauthTokenResponse getOauthTokenResponse;
    private int mPlatformAppId;
    private final String mPlatformName;

    public GetOauthTokenJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall, String str, String str2) {
        super(context, apiRequest, absApiCall);
        this.mPlatformAppId = -1;
        this.mContext = context.getApplicationContext();
        this.mPlatformName = str;
        try {
            this.mPlatformAppId = Integer.parseInt(str2);
        } catch (Throwable unused) {
        }
    }

    public static GetOauthTokenJob getOauthToken(Context context, String str, String str2, Map<String, String> map, CommonCallBack<GetOauthTokenResponse> commonCallBack) {
        TTHeader tTHeader;
        LogHelper.d(TAG, "real getOauthToken");
        if (TTAccountInit.getRequestTagHeaderProvider() != null) {
            String str3 = map.get(ThirdPartyNetConstants.KEY_TRIGGER_SCENE);
            tTHeader = TTAccountInit.getRequestTagHeaderProvider().getRequestTagHeader(OauthTokenTriggerScene.FOREGROUND_SWITCH.equals(str3) || "cold_start".equals(str3) || OauthTokenTriggerScene.PRELOAD.equals(str3));
        } else {
            tTHeader = null;
        }
        return new GetOauthTokenJob(context, new ApiRequest.Builder().url(ThirdPartyNetConstants.getGetOauthTokenUrl()).parameter("platform_app_id", str).parameters(map).addHeader(tTHeader).get(), commonCallBack, str2, str);
    }

    public static GetOauthTokenJob getOauthTokenV2(Context context, String str, String str2, String str3, Map<String, String> map, CommonCallBack<GetOauthTokenResponse> commonCallBack) {
        TTHeader tTHeader;
        LogHelper.d(TAG, "real getOauthToken v2");
        if (TTAccountInit.getRequestTagHeaderProvider() != null) {
            String str4 = map.get(ThirdPartyNetConstants.KEY_TRIGGER_SCENE);
            tTHeader = TTAccountInit.getRequestTagHeaderProvider().getRequestTagHeader(OauthTokenTriggerScene.FOREGROUND_SWITCH.equals(str4) || "cold_start".equals(str4) || OauthTokenTriggerScene.PRELOAD.equals(str4));
        } else {
            tTHeader = null;
        }
        return new GetOauthTokenJob(context, new ApiRequest.Builder().url(ThirdPartyNetConstants.getGetOauthTokenUrlV2()).parameter("platform_app_id", str).parameter("access_token", str3).parameters(map).addHeader(tTHeader).post(), commonCallBack, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public GetOauthTokenResponse transformResponse(boolean z, ApiResponse apiResponse) {
        GetOauthTokenResponse getOauthTokenResponse = this.getOauthTokenResponse;
        if (getOauthTokenResponse == null) {
            getOauthTokenResponse = new GetOauthTokenResponse(z, this.mPlatformName, this.mPlatformAppId);
        } else {
            getOauthTokenResponse.success = z;
        }
        if (!z) {
            getOauthTokenResponse.error = apiResponse.mError;
            getOauthTokenResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return getOauthTokenResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        GetOauthTokenResponse getOauthTokenResponse = new GetOauthTokenResponse(false, this.mPlatformName, this.mPlatformAppId);
        this.getOauthTokenResponse = getOauthTokenResponse;
        getOauthTokenResponse.parseErrorResponse(jSONObject2, jSONObject);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        GetOauthTokenResponse getOauthTokenResponse = new GetOauthTokenResponse(true, this.mPlatformName, this.mPlatformAppId);
        this.getOauthTokenResponse = getOauthTokenResponse;
        getOauthTokenResponse.parseSuccessResponse(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(GetOauthTokenResponse getOauthTokenResponse) {
        AccountMonitorUtil.onEvent(ThirdPartyNetConstants.EventName.GET_OAUTH_TOKEN, this.mPlatformName, null, getOauthTokenResponse, this.mApiCall);
    }
}
