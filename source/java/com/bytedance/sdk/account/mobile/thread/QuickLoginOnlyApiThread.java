package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.QuickLoginOnlyQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.QuickLoginOnlyCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class QuickLoginOnlyApiThread extends BaseAccountApi<MobileApiResponse<QuickLoginOnlyQueryObj>> {
    private QuickLoginOnlyQueryObj queryObj;

    private QuickLoginOnlyApiThread(Context context, ApiRequest apiRequest, QuickLoginOnlyQueryObj quickLoginOnlyQueryObj, QuickLoginOnlyCallback quickLoginOnlyCallback) {
        super(context, apiRequest, quickLoginOnlyCallback);
        this.queryObj = quickLoginOnlyQueryObj;
    }

    public static QuickLoginOnlyApiThread quickLoginOnly(Context context, String str, String str2, String str3, QuickLoginOnlyCallback quickLoginOnlyCallback) {
        return quickLoginOnly(context, str, str2, str3, null, quickLoginOnlyCallback);
    }

    public static QuickLoginOnlyApiThread quickLoginOnly(Context context, String str, String str2, String str3, Map<String, String> map, QuickLoginOnlyCallback quickLoginOnlyCallback) {
        QuickLoginOnlyQueryObj quickLoginOnlyQueryObj = new QuickLoginOnlyQueryObj(str, str2, str3);
        return new QuickLoginOnlyApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserQuickOnlyLogin()).parameters(getParams(quickLoginOnlyQueryObj), map).post(), quickLoginOnlyQueryObj, quickLoginOnlyCallback);
    }

    protected static Map<String, String> getParams(QuickLoginOnlyQueryObj quickLoginOnlyQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", StringUtils.encryptWithXor(quickLoginOnlyQueryObj.mMobile));
        if (!TextUtils.isEmpty(quickLoginOnlyQueryObj.mCaptcha)) {
            hashMap.put("captcha", quickLoginOnlyQueryObj.mCaptcha);
        }
        hashMap.put("code", StringUtils.encryptWithXor(String.valueOf(quickLoginOnlyQueryObj.mCode)));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<QuickLoginOnlyQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, BaseApiResponse.API_MOBILE_QUEICK_LOGIN_ONLY, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
        try {
            this.queryObj.mSmsCodekey = jSONObject.optString("sms_code_key");
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.queryObj.mUserInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<QuickLoginOnlyQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.LOGIN_ONLY, "mobile", "login_only", mobileApiResponse, this.mApiCall);
    }
}
