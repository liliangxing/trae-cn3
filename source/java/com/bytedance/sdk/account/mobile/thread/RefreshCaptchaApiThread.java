package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import com.bytedance.sdk.account.LegacyNetConstants;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.RefreshCaptchaQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.RefreshCaptchaCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.database.DBData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class RefreshCaptchaApiThread extends BaseAccountApi<MobileApiResponse<RefreshCaptchaQueryObj>> {
    private RefreshCaptchaQueryObj queryObj;

    private RefreshCaptchaApiThread(Context context, ApiRequest apiRequest, RefreshCaptchaQueryObj refreshCaptchaQueryObj, RefreshCaptchaCallback refreshCaptchaCallback) {
        super(context, apiRequest, refreshCaptchaCallback);
        this.queryObj = refreshCaptchaQueryObj;
    }

    public static RefreshCaptchaApiThread refreshCaptcha(Context context, int i, RefreshCaptchaCallback refreshCaptchaCallback) {
        RefreshCaptchaQueryObj refreshCaptchaQueryObj = new RefreshCaptchaQueryObj(i);
        return new RefreshCaptchaApiThread(context, new ApiRequest.Builder().url(LegacyNetConstants.getUserRefreshCaptcha()).parameters(getParams(refreshCaptchaQueryObj)).post(), refreshCaptchaQueryObj, refreshCaptchaCallback);
    }

    public static RefreshCaptchaApiThread refreshCaptcha(Context context, RefreshCaptchaCallback refreshCaptchaCallback) {
        return new RefreshCaptchaApiThread(context, new ApiRequest.Builder().url(LegacyNetConstants.getUserRefreshCaptcha()).post(), new RefreshCaptchaQueryObj(), refreshCaptchaCallback);
    }

    protected static Map<String, String> getParams(RefreshCaptchaQueryObj refreshCaptchaQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put(DBData.FIELD_TYPE, String.valueOf(refreshCaptchaQueryObj.mScenario));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<RefreshCaptchaQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 1000, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.queryObj.mNewCaptcha = jSONObject2.optString("captcha");
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<RefreshCaptchaQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.RECAPTCHA_CAPTCHA, "mobile", null, mobileApiResponse, this.mApiCall);
    }
}
