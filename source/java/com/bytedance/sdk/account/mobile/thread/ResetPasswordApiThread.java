package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.ResetPasswordQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.ResetPasswordCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ResetPasswordApiThread extends BaseAccountApi<MobileApiResponse<ResetPasswordQueryObj>> {
    private boolean mUpdateLoginStatus;
    private ResetPasswordQueryObj queryObj;

    private ResetPasswordApiThread(Context context, ApiRequest apiRequest, ResetPasswordQueryObj resetPasswordQueryObj, boolean z, ResetPasswordCallback resetPasswordCallback) {
        super(context, apiRequest, resetPasswordCallback);
        this.queryObj = resetPasswordQueryObj;
        this.mUpdateLoginStatus = z;
    }

    public static ResetPasswordApiThread resetPassword(Context context, String str, String str2, String str3, String str4, boolean z, ResetPasswordCallback resetPasswordCallback) {
        return resetPassword(context, str, str2, str3, str4, z, null, resetPasswordCallback);
    }

    public static ResetPasswordApiThread resetPassword(Context context, String str, String str2, String str3, String str4, boolean z, Map<String, String> map, ResetPasswordCallback resetPasswordCallback) {
        ResetPasswordQueryObj resetPasswordQueryObj = new ResetPasswordQueryObj(str, str2, str3, str4);
        return new ResetPasswordApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserResetPassword()).parameters(getParams(resetPasswordQueryObj), map).post(), resetPasswordQueryObj, z, resetPasswordCallback);
    }

    protected static Map<String, String> getParams(ResetPasswordQueryObj resetPasswordQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", StringUtils.encryptWithXor(resetPasswordQueryObj.mMobile));
        if (!TextUtils.isEmpty(resetPasswordQueryObj.mCaptcha)) {
            hashMap.put("captcha", resetPasswordQueryObj.mCaptcha);
        }
        hashMap.put("code", StringUtils.encryptWithXor(resetPasswordQueryObj.mCode));
        hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(resetPasswordQueryObj.mPassword));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<ResetPasswordQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 1003, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        if (this.mUpdateLoginStatus) {
            this.queryObj.mUserInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        } else {
            this.queryObj.mUserInfo = null;
        }
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<ResetPasswordQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.RESET_PASSWORD, "mobile", null, mobileApiResponse, this.mApiCall);
    }
}
