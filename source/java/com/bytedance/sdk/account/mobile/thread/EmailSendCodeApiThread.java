package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.EmailSendCodeQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.EmailSendCodeCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.account.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class EmailSendCodeApiThread extends BaseAccountApi<MobileApiResponse<EmailSendCodeQueryObj>> {
    private EmailSendCodeQueryObj queryObj;

    private EmailSendCodeApiThread(Context context, ApiRequest apiRequest, EmailSendCodeQueryObj emailSendCodeQueryObj, EmailSendCodeCallback emailSendCodeCallback) {
        super(context, apiRequest, emailSendCodeCallback);
        this.queryObj = emailSendCodeQueryObj;
    }

    public static EmailSendCodeApiThread emailSendCode(Context context, String str, String str2, String str3, int i, String str4, Map map, String str5, EmailSendCodeCallback emailSendCodeCallback) {
        EmailSendCodeQueryObj emailSendCodeQueryObj = new EmailSendCodeQueryObj(str, str2, str3, i, str4, map, str5);
        return new EmailSendCodeApiThread(context, sendCodeRequest(emailSendCodeQueryObj).url(Utils.getUrl(ExtraNetConstants.getEmailSendCode(), str5)).post(), emailSendCodeQueryObj, emailSendCodeCallback);
    }

    public static EmailSendCodeApiThread emailSendCodeWithLoginType(Context context, String str, String str2, String str3, int i, int i2, String str4, Map<String, String> map, EmailSendCodeCallback emailSendCodeCallback) {
        Map<String, String> hashMap = map == null ? new HashMap() : map;
        hashMap.put("email_logic_type", String.valueOf(i2));
        return emailSendCode(context, str, str2, str3, i, str4, hashMap, null, emailSendCodeCallback);
    }

    private static ApiRequest.Builder sendCodeRequest(EmailSendCodeQueryObj emailSendCodeQueryObj) {
        return new ApiRequest.Builder().parameters(getParams(emailSendCodeQueryObj), emailSendCodeQueryObj.mExtendInfo);
    }

    protected static Map<String, String> getParams(EmailSendCodeQueryObj emailSendCodeQueryObj) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(emailSendCodeQueryObj.mEmail)) {
            hashMap.put("email", StringUtils.encryptWithXor(emailSendCodeQueryObj.mEmail));
        }
        if (!TextUtils.isEmpty(emailSendCodeQueryObj.mCaptcha)) {
            hashMap.put("captcha", emailSendCodeQueryObj.mCaptcha);
        }
        hashMap.put(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(emailSendCodeQueryObj.mType)));
        if (!TextUtils.isEmpty(emailSendCodeQueryObj.mPassWord)) {
            hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(emailSendCodeQueryObj.mPassWord));
        }
        if (!TextUtils.isEmpty(emailSendCodeQueryObj.mNext)) {
            hashMap.put("next", emailSendCodeQueryObj.mNext);
        }
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<EmailSendCodeQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 1024, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<EmailSendCodeQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.EMAIL_SEND_CODE, "email", this.apiRequest.parameter(DBData.FIELD_TYPE), mobileApiResponse, this.mApiCall);
    }
}
