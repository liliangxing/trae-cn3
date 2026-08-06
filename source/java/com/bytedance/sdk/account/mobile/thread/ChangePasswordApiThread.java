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
import com.bytedance.sdk.account.mobile.query.ChangePasswordQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.ChangePasswordCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ChangePasswordApiThread extends BaseAccountApi<MobileApiResponse<ChangePasswordQueryObj>> {
    private ChangePasswordQueryObj queryObj;

    private ChangePasswordApiThread(Context context, ApiRequest apiRequest, ChangePasswordQueryObj changePasswordQueryObj, ChangePasswordCallback changePasswordCallback) {
        super(context, apiRequest, changePasswordCallback);
        this.queryObj = changePasswordQueryObj;
    }

    public static ChangePasswordApiThread changePassword(Context context, String str, String str2, String str3, ChangePasswordCallback changePasswordCallback) {
        ChangePasswordQueryObj changePasswordQueryObj = new ChangePasswordQueryObj(str, str2, str3);
        return new ChangePasswordApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserChangePassword()).parameters(getParams(changePasswordQueryObj)).post(), changePasswordQueryObj, changePasswordCallback);
    }

    public static ChangePasswordApiThread changePassword(Context context, String str, String str2, String str3, Map<String, String> map, ChangePasswordCallback changePasswordCallback) {
        ChangePasswordQueryObj changePasswordQueryObj = new ChangePasswordQueryObj(str, str2, str3);
        return new ChangePasswordApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserChangePassword()).parameters(getParams(changePasswordQueryObj), map).post(), changePasswordQueryObj, changePasswordCallback);
    }

    protected static Map<String, String> getParams(ChangePasswordQueryObj changePasswordQueryObj) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(changePasswordQueryObj.mCaptcha)) {
            hashMap.put("captcha", changePasswordQueryObj.mCaptcha);
        }
        hashMap.put("code", StringUtils.encryptWithXor(changePasswordQueryObj.mCode));
        hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(changePasswordQueryObj.mPassword));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<ChangePasswordQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 1010, this.queryObj);
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
    public void onSendEvent(MobileApiResponse<ChangePasswordQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.CHANGE_PASSWORD, "mobile", null, mobileApiResponse, this.mApiCall);
    }
}
