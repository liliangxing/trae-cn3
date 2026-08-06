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
import com.bytedance.sdk.account.mobile.query.SendCodeQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.SendCodeCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.param.SendCodeParam;
import com.bytedance.sdk.account.save.database.DBData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SendCodeApiThread extends BaseAccountApi<MobileApiResponse<SendCodeQueryObj>> {
    private final SendCodeQueryObj queryObj;

    private SendCodeApiThread(Context context, ApiRequest apiRequest, SendCodeQueryObj sendCodeQueryObj, SendCodeCallback sendCodeCallback) {
        super(context, apiRequest, sendCodeCallback);
        this.queryObj = sendCodeQueryObj;
    }

    public static SendCodeApiThread sendCode(Context context, String str, String str2, int i, SendCodeCallback sendCodeCallback) {
        return sendCode(context, str, str2, i, 0, -1, sendCodeCallback);
    }

    public static SendCodeApiThread sendCode(Context context, String str, String str2, int i, int i2, int i3, SendCodeCallback sendCodeCallback) {
        SendCodeQueryObj sendCodeQueryObj = new SendCodeQueryObj(str, str2, i, i2, i3);
        return new SendCodeApiThread(context, sendCodeRequest(sendCodeQueryObj).url(CommonNetConstants.getUserSendCode()).post(), sendCodeQueryObj, sendCodeCallback);
    }

    public static SendCodeApiThread sendCode(Context context, String str, String str2, String str3, int i, SendCodeCallback sendCodeCallback) {
        SendCodeQueryObj sendCodeQueryObj = new SendCodeQueryObj(str, str2, str3, i);
        return new SendCodeApiThread(context, sendCodeRequest(sendCodeQueryObj).url(CommonNetConstants.getUserSendCode()).post(), sendCodeQueryObj, sendCodeCallback);
    }

    public static SendCodeApiThread sendCode(Context context, String str, String str2, int i, int i2, String str3, int i3, int i4, SendCodeCallback sendCodeCallback) {
        SendCodeQueryObj sendCodeQueryObj = new SendCodeQueryObj(str, str2, i, i2, str3, i3, i4);
        return new SendCodeApiThread(context, sendCodeRequest(sendCodeQueryObj).url(CommonNetConstants.getUserSendCode()).post(), sendCodeQueryObj, sendCodeCallback);
    }

    public static SendCodeApiThread sendCode(Context context, String str, String str2, int i, int i2, String str3, int i3, int i4, String str4, String str5, SendCodeCallback sendCodeCallback) {
        SendCodeQueryObj sendCodeQueryObj = new SendCodeQueryObj(str, str2, i, i2, str3, i3, i4, str4, str5);
        return new SendCodeApiThread(context, sendCodeRequest(sendCodeQueryObj).url(CommonNetConstants.getUserSendCode()).post(), sendCodeQueryObj, sendCodeCallback);
    }

    public static SendCodeApiThread sendCode(Context context, String str, String str2, int i, int i2, String str3, int i3, int i4, String str4, String str5, Map map, SendCodeCallback sendCodeCallback) {
        SendCodeQueryObj sendCodeQueryObj = new SendCodeQueryObj(str, str2, i, i2, str3, i3, i4, str4, str5, map);
        return new SendCodeApiThread(context, sendCodeRequest(sendCodeQueryObj).url(CommonNetConstants.getUserSendCode()).post(), sendCodeQueryObj, sendCodeCallback);
    }

    public static SendCodeApiThread sendCode(Context context, int i, String str, String str2, int i2, int i3, String str3, String str4, String str5, SendCodeCallback sendCodeCallback) {
        SendCodeQueryObj sendCodeQueryObj = new SendCodeQueryObj(i, str, str2, i2, i3, str3, str4, str5);
        return new SendCodeApiThread(context, sendCodeRequest(sendCodeQueryObj).url(CommonNetConstants.getUserSendCode()).post(), sendCodeQueryObj, sendCodeCallback);
    }

    public static SendCodeApiThread sendCode(Context context, SendCodeParam sendCodeParam, SendCodeCallback sendCodeCallback) {
        SendCodeQueryObj sendCodeQueryObj = new SendCodeQueryObj(sendCodeParam);
        return new SendCodeApiThread(context, sendCodeRequest(sendCodeQueryObj).url(CommonNetConstants.getUserSendCode()).post(), sendCodeQueryObj, sendCodeCallback);
    }

    private static ApiRequest.Builder sendCodeRequest(SendCodeQueryObj sendCodeQueryObj) {
        return new ApiRequest.Builder().parameters(getParams(sendCodeQueryObj), sendCodeQueryObj.mExtendInfo);
    }

    protected static Map<String, String> getParams(SendCodeQueryObj sendCodeQueryObj) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(sendCodeQueryObj.mMobile)) {
            hashMap.put("mobile", StringUtils.encryptWithXor(sendCodeQueryObj.mMobile));
        }
        if (!TextUtils.isEmpty(sendCodeQueryObj.mOldMobile)) {
            hashMap.put("old_mobile", StringUtils.encryptWithXor(sendCodeQueryObj.mOldMobile));
        }
        if (!TextUtils.isEmpty(sendCodeQueryObj.mCaptcha)) {
            hashMap.put("captcha", sendCodeQueryObj.mCaptcha);
        }
        hashMap.put(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(sendCodeQueryObj.mType)));
        hashMap.put("unbind_exist", StringUtils.encryptWithXor(String.valueOf(sendCodeQueryObj.mUnbindExist)));
        hashMap.put("mix_mode", "1");
        if (sendCodeQueryObj.checkRegister == 1) {
            hashMap.put("check_register", "1");
        } else if (sendCodeQueryObj.checkRegister == 0) {
            hashMap.put("check_register", "0");
        }
        if (!TextUtils.isEmpty(sendCodeQueryObj.mTicket)) {
            hashMap.put("ticket", sendCodeQueryObj.mTicket);
        }
        hashMap.put("auto_read", String.valueOf(sendCodeQueryObj.mAutoread));
        if (!TextUtils.isEmpty(sendCodeQueryObj.mSharkTicket)) {
            hashMap.put("shark_ticket", sendCodeQueryObj.mSharkTicket);
        }
        if (!TextUtils.isEmpty(sendCodeQueryObj.mAuthToken)) {
            hashMap.put("auth_token", sendCodeQueryObj.mAuthToken);
        }
        if (!TextUtils.isEmpty(sendCodeQueryObj.mUnusableMobileTicket)) {
            hashMap.put("unusable_mobile_ticket", sendCodeQueryObj.mUnusableMobileTicket);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<SendCodeQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        if (z) {
            this.queryObj.mError = 0;
            this.queryObj.mErrorMsg = "";
            this.queryObj.mDetailErrorCode = 0;
        }
        return new MobileApiResponse<>(z, 1002, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.queryObj.mResendTime = jSONObject2.optInt("retry_time", 30);
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<SendCodeQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.SEND_CODE, "mobile", this.apiRequest.parameter(DBData.FIELD_TYPE), mobileApiResponse, this.mApiCall);
    }
}
