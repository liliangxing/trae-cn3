package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.SpecialNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.CheckQRCodeStatusCallback;
import com.bytedance.sdk.account.api.response.CheckQRCodeStatusResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CheckQRCodeStatusJob extends BaseAccountApi {
    private CheckQRCodeStatusResponse mCheckQRCodeStatusResponse;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public CheckQRCodeStatusJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static CheckQRCodeStatusJob checkQRCodeStatus(Context context, String str, String str2, int i, String str3, Map<String, String> map, CheckQRCodeStatusCallback checkQRCodeStatusCallback) {
        return new CheckQRCodeStatusJob(context, new ApiRequest.Builder().parameters(getParams(str, str2, i, str3), map).url(SpecialNetConstants.getQRCodeStatusPath()).get(), checkQRCodeStatusCallback);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected BaseApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CheckQRCodeStatusResponse checkQRCodeStatusResponse = this.mCheckQRCodeStatusResponse;
        if (checkQRCodeStatusResponse == null) {
            checkQRCodeStatusResponse = new CheckQRCodeStatusResponse(z, BaseApiResponse.API_GET_QR_CODE_STATUS);
        } else {
            checkQRCodeStatusResponse.success = z;
        }
        if (!z) {
            checkQRCodeStatusResponse.error = apiResponse.mError;
            checkQRCodeStatusResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return checkQRCodeStatusResponse;
    }

    private static Map<String, String> getParams(String str, String str2, int i, String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("token", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(TracingConstants.KEY_TRACE_NAME, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("extra", str3);
        }
        hashMap.put("scene", String.valueOf(i));
        return hashMap;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        CheckQRCodeStatusResponse checkQRCodeStatusResponse = new CheckQRCodeStatusResponse(true, BaseApiResponse.API_GET_QR_CODE_STATUS);
        this.mCheckQRCodeStatusResponse = checkQRCodeStatusResponse;
        checkQRCodeStatusResponse.qrCode = jSONObject2.optString("qrcode");
        this.mCheckQRCodeStatusResponse.status = jSONObject2.optString(PageDataManager.EXTRA_STATUS);
        this.mCheckQRCodeStatusResponse.appName = jSONObject2.optString("app_name");
        this.mCheckQRCodeStatusResponse.webName = jSONObject2.optString("web_name");
        this.mCheckQRCodeStatusResponse.qrCodeUrl = jSONObject2.optString("qrcode_index_url");
        this.mCheckQRCodeStatusResponse.token = jSONObject2.optString("token");
        this.mCheckQRCodeStatusResponse.redirectUrl = jSONObject2.optString(ITiktokService.ResponseConstants.REDIRECT_URL);
        this.mCheckQRCodeStatusResponse.extra = jSONObject2.optString("extra");
        this.mCheckQRCodeStatusResponse.scanAppId = jSONObject2.optInt("scan_app_id");
        JSONObject optJSONObject = jSONObject2.optJSONObject("user_data");
        if (optJSONObject != null) {
            jSONObject.put("data", optJSONObject);
            this.mCheckQRCodeStatusResponse.userInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, optJSONObject);
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(BaseApiResponse baseApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.CHECK_QR_CODE_STATUS, null, null, baseApiResponse, this.mApiCall);
    }
}
