package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.CsrfTokenManager;
import com.bytedance.sdk.account.SpecialNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.ScanQRCodeCallback;
import com.bytedance.sdk.account.api.response.ScanQRCodeResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SsoScanQRCodeJob extends BaseAccountApi<ScanQRCodeResponse> {
    private JSONObject mResult;
    private ScanQRCodeResponse mScanQRCodeResponse;

    public SsoScanQRCodeJob(Context context, ApiRequest apiRequest, AbsApiCall<ScanQRCodeResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static SsoScanQRCodeJob scanQRCode(Context context, String str, Map<String, String> map, ScanQRCodeCallback scanQRCodeCallback) {
        return new SsoScanQRCodeJob(context, new ApiRequest.Builder().parameter("token", str).parameters(map).url(SpecialNetConstants.getSsoAuthorizeScanQRCodePath()).post(), scanQRCodeCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public ScanQRCodeResponse transformResponse(boolean z, ApiResponse apiResponse) {
        ScanQRCodeResponse scanQRCodeResponse = this.mScanQRCodeResponse;
        if (scanQRCodeResponse == null) {
            scanQRCodeResponse = new ScanQRCodeResponse(z, BaseApiResponse.API_SCAN_QR_CODE);
        } else {
            scanQRCodeResponse.success = z;
        }
        if (!z) {
            scanQRCodeResponse.error = apiResponse.mError;
            scanQRCodeResponse.errorMsg = apiResponse.mErrorMsg;
        }
        scanQRCodeResponse.result = this.mResult;
        return scanQRCodeResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        ScanQRCodeResponse scanQRCodeResponse = new ScanQRCodeResponse(true, BaseApiResponse.API_SCAN_QR_CODE);
        this.mScanQRCodeResponse = scanQRCodeResponse;
        scanQRCodeResponse.csrfToken = jSONObject2.optString(CsrfTokenManager.SP_KEY_CSRF_TOKEN);
        this.mScanQRCodeResponse.sourceIcon = jSONObject2.optString("source_icon");
        this.mScanQRCodeResponse.extra = jSONObject2.optString("extra");
        this.mScanQRCodeResponse.expireTime = jSONObject2.optLong("expire_time");
        this.mScanQRCodeResponse.confirmedUrl = jSONObject2.optString("confirmed_url");
        JSONObject optJSONObject = jSONObject2.optJSONObject(TimonPipeline.KEY_SOURCE);
        if (optJSONObject != null) {
            this.mScanQRCodeResponse.title = optJSONObject.optString("title");
            this.mScanQRCodeResponse.desc = optJSONObject.optString("des");
            this.mScanQRCodeResponse.query = optJSONObject.optString("query");
        }
        this.mResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(ScanQRCodeResponse scanQRCodeResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.SCAN_QR_CODE, null, null, scanQRCodeResponse, this.mApiCall);
    }
}
