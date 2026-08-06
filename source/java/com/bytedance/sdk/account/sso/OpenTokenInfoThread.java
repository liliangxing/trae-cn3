package com.bytedance.sdk.account.sso;

import android.content.Context;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.api.response.OpenTokenInfoResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.ss.android.TTHeader;
import com.ss.android.account.TTAccountInit;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OpenTokenInfoThread extends BaseAccountApi<OpenTokenInfoResponse> {
    private OpenTokenInfoResponse mResponse;

    public OpenTokenInfoThread(Context context, ApiRequest apiRequest, CommonCallBack<OpenTokenInfoResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
    }

    public static OpenTokenInfoThread openTokenInfo(Context context, String str, String str2, Map<String, String> map, CommonCallBack<OpenTokenInfoResponse> commonCallBack) {
        TTHeader tTHeader;
        if (TTAccountInit.getRequestTagHeaderProvider() != null) {
            String str3 = map.get(ThirdPartyNetConstants.KEY_TRIGGER_SCENE);
            tTHeader = TTAccountInit.getRequestTagHeaderProvider().getRequestTagHeader(OauthTokenTriggerScene.FOREGROUND_SWITCH.equals(str3) || "cold_start".equals(str3) || OauthTokenTriggerScene.PRELOAD.equals(str3));
        } else {
            tTHeader = null;
        }
        return new OpenTokenInfoThread(context, new ApiRequest.Builder().url("https://" + str + ThirdPartyNetConstants.OPEN_TOKEN_INFO).parameter("access_token", str2).parameter(BaseAccountApi.KEY_IGNORE_COMMON_PARAM, "1").parameters(map).addHeader(tTHeader).post(), commonCallBack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public OpenTokenInfoResponse transformResponse(boolean z, ApiResponse apiResponse) {
        if (this.mResponse == null) {
            this.mResponse = new OpenTokenInfoResponse(z);
        }
        this.mResponse.error = apiResponse.mError;
        this.mResponse.errorMsg = apiResponse.mErrorMsg;
        return this.mResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        OpenTokenInfoResponse openTokenInfoResponse = new OpenTokenInfoResponse(false);
        this.mResponse = openTokenInfoResponse;
        openTokenInfoResponse.result = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        OpenTokenInfoResponse openTokenInfoResponse = new OpenTokenInfoResponse(true);
        this.mResponse = openTokenInfoResponse;
        openTokenInfoResponse.result = jSONObject;
        if (jSONObject2 != null) {
            this.mResponse.clientKey = jSONObject2.optString("client_key");
            this.mResponse.openId = jSONObject2.optString("open_id");
            JSONArray optJSONArray = jSONObject2.optJSONArray("scopes");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.getString(i));
            }
            this.mResponse.scopes = arrayList;
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(OpenTokenInfoResponse openTokenInfoResponse) {
        AccountMonitorUtil.onEvent(ThirdPartyNetConstants.EventName.OPEN_TOKEN_INFO, null, null, openTokenInfoResponse, this.mApiCall);
    }
}
