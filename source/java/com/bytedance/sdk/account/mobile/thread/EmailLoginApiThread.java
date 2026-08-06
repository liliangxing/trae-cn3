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
import com.bytedance.sdk.account.mobile.query.EmailLoginQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.EmailLoginQueryCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class EmailLoginApiThread extends BaseAccountApi<MobileApiResponse<EmailLoginQueryObj>> {
    private EmailLoginQueryObj queryObj;

    public EmailLoginApiThread(Context context, ApiRequest apiRequest, EmailLoginQueryObj emailLoginQueryObj, EmailLoginQueryCallback emailLoginQueryCallback) {
        super(context, apiRequest, emailLoginQueryCallback);
        this.queryObj = emailLoginQueryObj;
    }

    public static EmailLoginApiThread emailLogin(Context context, String str, String str2, String str3, Map<String, String> map, EmailLoginQueryCallback emailLoginQueryCallback) {
        EmailLoginQueryObj emailLoginQueryObj = new EmailLoginQueryObj(str, str2, str3);
        return new EmailLoginApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getEmailLogin()).parameters(getParams(emailLoginQueryObj), map).checkSupportMultiLogin().post(), emailLoginQueryObj, emailLoginQueryCallback);
    }

    protected static Map<String, String> getParams(EmailLoginQueryObj emailLoginQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("email", StringUtils.encryptWithXor(emailLoginQueryObj.mEmail));
        if (!TextUtils.isEmpty(emailLoginQueryObj.mCaptcha)) {
            hashMap.put("captcha", emailLoginQueryObj.mCaptcha);
        }
        hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(emailLoginQueryObj.mPassword));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<EmailLoginQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 1009, this.queryObj);
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
    public void onSendEvent(MobileApiResponse<EmailLoginQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.LOGIN, "email", null, mobileApiResponse, this.mApiCall);
    }
}
