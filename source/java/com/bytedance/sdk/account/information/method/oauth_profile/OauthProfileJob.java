package com.bytedance.sdk.account.information.method.oauth_profile;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OauthProfileJob extends BaseAccountApi<OauthProfileResponse> {
    private String avatarUrl;
    private JSONObject extraInfo;
    private String name;
    private JSONObject resultPackObj;

    public OauthProfileJob(Context context, ApiRequest apiRequest, OauthProfileCallback oauthProfileCallback) {
        super(context, apiRequest, oauthProfileCallback);
    }

    public static OauthProfileJob getOauthProfile(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, OauthProfileCallback oauthProfileCallback) {
        return new OauthProfileJob(context, new ApiRequest.Builder().url(ThirdPartyNetConstants.getOauthProfilePath()).parameters(getParams(str, str2, str3, str4, str5, str6), map).get(), oauthProfileCallback);
    }

    private static Map<String, String> getParams(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("platform_app_id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("platform", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("code", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("access_token", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("access_token_secret", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("expires_in", str6);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public OauthProfileResponse transformResponse(boolean z, ApiResponse apiResponse) {
        OauthProfileResponse oauthProfileResponse = new OauthProfileResponse(z, BaseApiResponse.API_OAUTH_PROFILE);
        oauthProfileResponse.result = this.resultPackObj;
        if (z) {
            oauthProfileResponse.name = this.name;
            oauthProfileResponse.avatarUrl = this.avatarUrl;
            oauthProfileResponse.extraInfo = this.extraInfo;
        } else {
            oauthProfileResponse.error = apiResponse.mError;
            oauthProfileResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return oauthProfileResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.resultPackObj = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.name = jSONObject2.optString("name");
        this.avatarUrl = jSONObject2.optString("avatar_url");
        this.extraInfo = jSONObject2.optJSONObject("extraInfo");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(OauthProfileResponse oauthProfileResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventPlatform.OAUTH_PROFILE, null, null, oauthProfileResponse, this.mApiCall);
    }
}
