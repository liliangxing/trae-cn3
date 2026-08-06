package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.RegisterQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.RegisterCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.save.database.DBData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class RegisterApiThread extends BaseAccountApi<MobileApiResponse<RegisterQueryObj>> {
    private RegisterQueryObj queryObj;

    public RegisterApiThread(Context context, ApiRequest apiRequest, RegisterQueryObj registerQueryObj, RegisterCallback registerCallback) {
        super(context, apiRequest, registerCallback);
        this.queryObj = registerQueryObj;
    }

    public static RegisterApiThread register(Context context, String str, String str2, String str3, String str4, RegisterCallback registerCallback) {
        RegisterQueryObj registerQueryObj = new RegisterQueryObj(str, str2, str3, str4);
        return new RegisterApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserRegister()).parameters(getParams(registerQueryObj)).post(), registerQueryObj, registerCallback);
    }

    protected static Map<String, String> getParams(RegisterQueryObj registerQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", StringUtils.encryptWithXor(registerQueryObj.mMobile));
        hashMap.put("captcha", registerQueryObj.mCaptcha);
        hashMap.put("code", StringUtils.encryptWithXor(String.valueOf(registerQueryObj.mCode)));
        hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(registerQueryObj.mPassword));
        hashMap.put(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(registerQueryObj.mScenario)));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<RegisterQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 1004, this.queryObj);
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
    public void onSendEvent(MobileApiResponse<RegisterQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.REGISTER, "mobile", null, mobileApiResponse, this.mApiCall);
    }
}
