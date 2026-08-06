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
import com.bytedance.sdk.account.mobile.query.EmailCheckRegisterQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.EmailCheckRegisterCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.account.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class EmailCheckRegisterApiThread extends BaseAccountApi<MobileApiResponse<EmailCheckRegisterQueryObj>> {
    private EmailCheckRegisterQueryObj queryObj;

    private EmailCheckRegisterApiThread(Context context, ApiRequest apiRequest, EmailCheckRegisterQueryObj emailCheckRegisterQueryObj, EmailCheckRegisterCallback emailCheckRegisterCallback) {
        super(context, apiRequest, emailCheckRegisterCallback);
        this.queryObj = emailCheckRegisterQueryObj;
    }

    public static EmailCheckRegisterApiThread emailCheckRegister(Context context, String str, Map map, String str2, EmailCheckRegisterCallback emailCheckRegisterCallback) {
        EmailCheckRegisterQueryObj emailCheckRegisterQueryObj = new EmailCheckRegisterQueryObj(str, map, str2);
        return new EmailCheckRegisterApiThread(context, new ApiRequest.Builder().parameters(getParams(emailCheckRegisterQueryObj), emailCheckRegisterQueryObj.mExtendInfo).url(Utils.getUrl(ExtraNetConstants.getEmailCheckRegisterPath(), str2)).post(), emailCheckRegisterQueryObj, emailCheckRegisterCallback);
    }

    protected static Map<String, String> getParams(EmailCheckRegisterQueryObj emailCheckRegisterQueryObj) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(emailCheckRegisterQueryObj.mEmail)) {
            hashMap.put("email", StringUtils.encryptWithXor(emailCheckRegisterQueryObj.mEmail));
        }
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<EmailCheckRegisterQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, BaseApiResponse.API_EMAIL_CHECK_REGISTER, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.queryObj.is_registered = jSONObject2.optInt("is_registered");
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<EmailCheckRegisterQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.EMAIL_CHECK_REGISTER, "email", this.apiRequest.parameter(DBData.FIELD_TYPE), mobileApiResponse, this.mApiCall);
    }
}
