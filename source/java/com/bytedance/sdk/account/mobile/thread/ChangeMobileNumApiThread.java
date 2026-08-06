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
import com.bytedance.sdk.account.mobile.query.ChangeMobileNumQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.ChangeMobileNumCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ChangeMobileNumApiThread extends BaseAccountApi<MobileApiResponse<ChangeMobileNumQueryObj>> {
    private ChangeMobileNumQueryObj queryObj;

    private ChangeMobileNumApiThread(Context context, ApiRequest apiRequest, ChangeMobileNumQueryObj changeMobileNumQueryObj, ChangeMobileNumCallback changeMobileNumCallback) {
        super(context, apiRequest, changeMobileNumCallback);
        this.queryObj = changeMobileNumQueryObj;
    }

    public static ChangeMobileNumApiThread changeMobilenum(Context context, String str, String str2, String str3, ChangeMobileNumCallback changeMobileNumCallback) {
        ChangeMobileNumQueryObj changeMobileNumQueryObj = new ChangeMobileNumQueryObj(str, str2, str3);
        return new ChangeMobileNumApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserChangeMobile()).parameters(getParams(changeMobileNumQueryObj)).post(), changeMobileNumQueryObj, changeMobileNumCallback);
    }

    public static ChangeMobileNumApiThread changeMobilenum(Context context, String str, String str2, String str3, String str4, ChangeMobileNumCallback changeMobileNumCallback) {
        ChangeMobileNumQueryObj changeMobileNumQueryObj = new ChangeMobileNumQueryObj(str, str2, str3, str4);
        return new ChangeMobileNumApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserChangeMobile()).parameters(getParams(changeMobileNumQueryObj)).post(), changeMobileNumQueryObj, changeMobileNumCallback);
    }

    public static ChangeMobileNumApiThread changeMobilenum(Context context, String str, String str2, String str3, String str4, Map map, ChangeMobileNumCallback changeMobileNumCallback) {
        ChangeMobileNumQueryObj changeMobileNumQueryObj = new ChangeMobileNumQueryObj(str, str2, str3, str4, map);
        return new ChangeMobileNumApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserChangeMobile()).parameters(getParams(changeMobileNumQueryObj), changeMobileNumQueryObj.mExtendInfo).post(), changeMobileNumQueryObj, changeMobileNumCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<ChangeMobileNumQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 1011, this.queryObj);
    }

    protected static Map<String, String> getParams(ChangeMobileNumQueryObj changeMobileNumQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", StringUtils.encryptWithXor(changeMobileNumQueryObj.mMobile));
        if (!TextUtils.isEmpty(changeMobileNumQueryObj.mCaptcha)) {
            hashMap.put("captcha", changeMobileNumQueryObj.mCaptcha);
        }
        hashMap.put("code", StringUtils.encryptWithXor(changeMobileNumQueryObj.mCode));
        hashMap.put("mix_mode", "1");
        if (!TextUtils.isEmpty(changeMobileNumQueryObj.mTicket)) {
            hashMap.put("ticket", changeMobileNumQueryObj.mTicket);
        }
        return hashMap;
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
    public void onSendEvent(MobileApiResponse<ChangeMobileNumQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.CHANGE, "mobile", null, mobileApiResponse, this.mApiCall);
    }
}
