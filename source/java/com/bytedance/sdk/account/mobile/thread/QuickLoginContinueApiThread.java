package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.QuickLoginContinueQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.QuickLoginContinueCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class QuickLoginContinueApiThread extends BaseAccountApi<MobileApiResponse<QuickLoginContinueQueryObj>> {
    private QuickLoginContinueQueryObj queryObj;

    private QuickLoginContinueApiThread(Context context, ApiRequest apiRequest, QuickLoginContinueQueryObj quickLoginContinueQueryObj, QuickLoginContinueCallback quickLoginContinueCallback) {
        super(context, apiRequest, quickLoginContinueCallback);
        this.queryObj = quickLoginContinueQueryObj;
    }

    public static QuickLoginContinueApiThread quickLoginContinue(Context context, String str, String str2, QuickLoginContinueCallback quickLoginContinueCallback) {
        return quickLoginContinue(context, str, str2, null, quickLoginContinueCallback);
    }

    public static QuickLoginContinueApiThread quickLoginContinue(Context context, String str, String str2, Map<String, String> map, QuickLoginContinueCallback quickLoginContinueCallback) {
        QuickLoginContinueQueryObj quickLoginContinueQueryObj = new QuickLoginContinueQueryObj(str, str2);
        return new QuickLoginContinueApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserQuickContinueLogin()).parameters(getParams(quickLoginContinueQueryObj), map).post(), quickLoginContinueQueryObj, quickLoginContinueCallback);
    }

    public static QuickLoginContinueApiThread quickLoginContinue(Context context, String str, String str2, int i, Map map, QuickLoginContinueCallback quickLoginContinueCallback) {
        QuickLoginContinueQueryObj quickLoginContinueQueryObj = new QuickLoginContinueQueryObj(str, str2, i, map);
        return new QuickLoginContinueApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserQuickContinueLogin()).parameters(getParams(quickLoginContinueQueryObj), quickLoginContinueQueryObj.mExtendInfo).post(), quickLoginContinueQueryObj, quickLoginContinueCallback);
    }

    protected static Map<String, String> getParams(QuickLoginContinueQueryObj quickLoginContinueQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", StringUtils.encryptWithXor(quickLoginContinueQueryObj.mMobile));
        hashMap.put("sms_code_key", StringUtils.encryptWithXor(String.valueOf(quickLoginContinueQueryObj.mSmsCodekey)));
        if (quickLoginContinueQueryObj.mVcdAuth > 0) {
            hashMap.put("vcd_auth", String.valueOf(quickLoginContinueQueryObj.mVcdAuth));
        }
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<QuickLoginContinueQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, BaseApiResponse.API_MOBILE_QUEICK_LOGIN_CONTINUE, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.queryObj.mUserInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<QuickLoginContinueQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.LOGIN_CONTINUE, "mobile", "login_continue", mobileApiResponse, this.mApiCall);
    }
}
