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
import com.bytedance.sdk.account.save.database.DBData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SendVoiceCodeApiThread extends BaseAccountApi<MobileApiResponse<SendCodeQueryObj>> {
    private SendCodeQueryObj queryObj;

    private SendVoiceCodeApiThread(Context context, ApiRequest apiRequest, SendCodeQueryObj sendCodeQueryObj, SendCodeCallback sendCodeCallback) {
        super(context, apiRequest, sendCodeCallback);
        this.queryObj = sendCodeQueryObj;
    }

    public static SendVoiceCodeApiThread sendVoiceCode(Context context, String str, String str2, int i, Map<String, String> map, SendCodeCallback sendCodeCallback) {
        return sendVoiceCode(context, str, str2, i, 0, map, sendCodeCallback);
    }

    public static SendVoiceCodeApiThread sendVoiceCode(Context context, String str, String str2, String str3, int i, SendCodeCallback sendCodeCallback) {
        SendCodeQueryObj sendCodeQueryObj = new SendCodeQueryObj(str, str2, str3, i);
        return new SendVoiceCodeApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getVoiceCodePath()).parameters(getParams(sendCodeQueryObj)).post(), sendCodeQueryObj, sendCodeCallback);
    }

    public static SendVoiceCodeApiThread sendVoiceCode(Context context, String str, String str2, int i, int i2, Map<String, String> map, SendCodeCallback sendCodeCallback) {
        SendCodeQueryObj sendCodeQueryObj = new SendCodeQueryObj(str, str2, i, i2, -1);
        return new SendVoiceCodeApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getVoiceCodePath()).parameters(getParams(sendCodeQueryObj), map).post(), sendCodeQueryObj, sendCodeCallback);
    }

    protected static Map<String, String> getParams(SendCodeQueryObj sendCodeQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", StringUtils.encryptWithXor(sendCodeQueryObj.mMobile));
        if (!TextUtils.isEmpty(sendCodeQueryObj.mOldMobile)) {
            hashMap.put("old_mobile", StringUtils.encryptWithXor(sendCodeQueryObj.mOldMobile));
        }
        hashMap.put("captcha", sendCodeQueryObj.mCaptcha);
        hashMap.put(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(sendCodeQueryObj.mType)));
        hashMap.put("unbind_exist", StringUtils.encryptWithXor(String.valueOf(sendCodeQueryObj.mUnbindExist)));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<SendCodeQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
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
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.SEND_VOICE_CODE, null, null, mobileApiResponse, this.mApiCall);
    }
}
