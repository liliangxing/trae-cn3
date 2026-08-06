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
import com.bytedance.sdk.account.mobile.query.BindLoginObj;
import com.bytedance.sdk.account.mobile.thread.call.BindLoginCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BindLoginThread extends BaseAccountApi<MobileApiResponse<BindLoginObj>> {
    private BindLoginObj queryObj;

    private BindLoginThread(Context context, ApiRequest apiRequest, BindLoginObj bindLoginObj, BindLoginCallback bindLoginCallback) {
        super(context, apiRequest, bindLoginCallback);
        this.queryObj = bindLoginObj;
    }

    public static BindLoginThread bindLogin(Context context, String str, String str2, String str3, String str4, BindLoginCallback bindLoginCallback) {
        BindLoginObj bindLoginObj = new BindLoginObj(str, str2, str3, str4);
        return new BindLoginThread(context, new ApiRequest.Builder().url(CommonNetConstants.getBindLogin()).parameters(getParams(bindLoginObj)).post(), bindLoginObj, bindLoginCallback);
    }

    public static BindLoginThread bindLogin(Context context, String str, String str2, String str3, String str4, Map map, BindLoginCallback bindLoginCallback) {
        BindLoginObj bindLoginObj = new BindLoginObj(str, str2, str3, str4, map);
        return new BindLoginThread(context, new ApiRequest.Builder().url(CommonNetConstants.getBindLogin()).parameters(getParams(bindLoginObj), bindLoginObj.mExtendInfo).post(), bindLoginObj, bindLoginCallback);
    }

    private static Map<String, String> getParams(BindLoginObj bindLoginObj) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(bindLoginObj.mCaptcha)) {
            hashMap.put("captcha", bindLoginObj.mCaptcha);
        }
        hashMap.put("code", StringUtils.encryptWithXor(bindLoginObj.mCode));
        hashMap.put("mobile", StringUtils.encryptWithXor(bindLoginObj.mMobile));
        hashMap.put("profile_key", bindLoginObj.profile_key);
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<BindLoginObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 10005, this.queryObj);
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
    public void onSendEvent(MobileApiResponse<BindLoginObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.BIND_LOGIN, "mobile", null, mobileApiResponse, this.mApiCall);
    }
}
