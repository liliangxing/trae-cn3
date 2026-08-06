package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.LegacyNetConstants;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.MobilePassAuthObj;
import com.bytedance.sdk.account.mobile.thread.call.MobilePassAuthCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class MobilePassAuthThread extends BaseAccountApi<MobileApiResponse<MobilePassAuthObj>> {
    private MobilePassAuthObj queryObj;

    private MobilePassAuthThread(Context context, ApiRequest apiRequest, MobilePassAuthObj mobilePassAuthObj, MobilePassAuthCallback mobilePassAuthCallback) {
        super(context, apiRequest, mobilePassAuthCallback);
        this.queryObj = mobilePassAuthObj;
    }

    public static MobilePassAuthThread passAuth(Context context, String str, String str2, String str3, String str4, MobilePassAuthCallback mobilePassAuthCallback) {
        MobilePassAuthObj mobilePassAuthObj = new MobilePassAuthObj(str, str2, str3, str4);
        return new MobilePassAuthThread(context, new ApiRequest.Builder().url(LegacyNetConstants.getMobileAuthPath()).parameters(getParams(mobilePassAuthObj)).post(), mobilePassAuthObj, mobilePassAuthCallback);
    }

    protected static Map<String, String> getParams(MobilePassAuthObj mobilePassAuthObj) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(mobilePassAuthObj.mCaptcha)) {
            hashMap.put("captcha", mobilePassAuthObj.mCaptcha);
        }
        if (!TextUtils.isEmpty(mobilePassAuthObj.mMobile)) {
            hashMap.put("mobile", StringUtils.encryptWithXor(mobilePassAuthObj.mMobile));
        }
        if (!TextUtils.isEmpty(mobilePassAuthObj.mPassword)) {
            hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(mobilePassAuthObj.mPassword));
        }
        hashMap.put("mix_mode", "1");
        hashMap.put("verify_user_id", mobilePassAuthObj.mVerifyUserId);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<MobilePassAuthObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 10003, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.queryObj.mToken = jSONObject2.optString("token");
        this.queryObj.mUserInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<MobilePassAuthObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.MOBILE_PASS_AUTH, null, null, mobileApiResponse, this.mApiCall);
    }
}
