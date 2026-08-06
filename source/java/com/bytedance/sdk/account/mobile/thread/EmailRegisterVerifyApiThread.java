package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.EmailRegisterVerifyQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.EmailRegisterVerifyCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.account.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class EmailRegisterVerifyApiThread extends BaseAccountApi<MobileApiResponse<EmailRegisterVerifyQueryObj>> {
    private EmailRegisterVerifyQueryObj queryObj;

    private EmailRegisterVerifyApiThread(Context context, ApiRequest apiRequest, EmailRegisterVerifyQueryObj emailRegisterVerifyQueryObj, EmailRegisterVerifyCallback emailRegisterVerifyCallback) {
        super(context, apiRequest, emailRegisterVerifyCallback);
        this.queryObj = emailRegisterVerifyQueryObj;
    }

    public static EmailRegisterVerifyApiThread emailRegisterVerify(Context context, String str, String str2, int i, Map map, String str3, EmailRegisterVerifyCallback emailRegisterVerifyCallback) {
        EmailRegisterVerifyQueryObj emailRegisterVerifyQueryObj = new EmailRegisterVerifyQueryObj(str, str2, i, map, str3);
        return new EmailRegisterVerifyApiThread(context, new ApiRequest.Builder().parameters(getParams(emailRegisterVerifyQueryObj), emailRegisterVerifyQueryObj.mExtendInfo).url(Utils.getUrl(ExtraNetConstants.getEmailRegisterVerifyPath(), str3)).post(), emailRegisterVerifyQueryObj, emailRegisterVerifyCallback);
    }

    public static EmailRegisterVerifyApiThread emailRegisterVerifyLogin(Context context, String str, String str2, int i, Map map, String str3, EmailRegisterVerifyCallback emailRegisterVerifyCallback) {
        EmailRegisterVerifyQueryObj emailRegisterVerifyQueryObj = new EmailRegisterVerifyQueryObj(str, str2, i, map, str3);
        return new EmailRegisterVerifyApiThread(context, new ApiRequest.Builder().parameters(getParams(emailRegisterVerifyQueryObj), emailRegisterVerifyQueryObj.mExtendInfo).url(Utils.getUrl(ExtraNetConstants.getEmailRegisterVerifyLoginPath(), str3)).post(), emailRegisterVerifyQueryObj, emailRegisterVerifyCallback);
    }

    protected static Map<String, String> getParams(EmailRegisterVerifyQueryObj emailRegisterVerifyQueryObj) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(emailRegisterVerifyQueryObj.mEmail)) {
            hashMap.put("email", StringUtils.encryptWithXor(emailRegisterVerifyQueryObj.mEmail));
        }
        hashMap.put(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(emailRegisterVerifyQueryObj.mType)));
        if (!TextUtils.isEmpty(emailRegisterVerifyQueryObj.mCode)) {
            hashMap.put("code", StringUtils.encryptWithXor(emailRegisterVerifyQueryObj.mCode));
        }
        hashMap.put("mix_mode", "1");
        hashMap.put("fixed_mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<EmailRegisterVerifyQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, BaseApiResponse.API_EMAIL_REGISTER_VERIFY, this.queryObj);
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
    public void onSendEvent(MobileApiResponse<EmailRegisterVerifyQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.EMAIL_REGISTER_VERIFY, "email", this.apiRequest.parameter(DBData.FIELD_TYPE), mobileApiResponse, this.mApiCall);
    }
}
