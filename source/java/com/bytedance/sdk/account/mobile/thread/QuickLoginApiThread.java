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
import com.bytedance.sdk.account.mobile.query.QuickLoginQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.QuickLoginCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class QuickLoginApiThread extends BaseAccountApi<MobileApiResponse<QuickLoginQueryObj>> {
    private QuickLoginQueryObj queryObj;

    private QuickLoginApiThread(Context context, ApiRequest apiRequest, QuickLoginQueryObj quickLoginQueryObj, QuickLoginCallback quickLoginCallback) {
        super(context, apiRequest, quickLoginCallback);
        this.queryObj = quickLoginQueryObj;
    }

    public static QuickLoginApiThread quickLogin(Context context, String str, String str2, Integer num, String str3, QuickLoginCallback quickLoginCallback) {
        return quickLogin(context, str, str2, num, str3, null, quickLoginCallback);
    }

    public static QuickLoginApiThread quickLogin(Context context, String str, String str2, Integer num, String str3, Map<String, String> map, QuickLoginCallback quickLoginCallback) {
        QuickLoginQueryObj quickLoginQueryObj = new QuickLoginQueryObj(str, str2, num, str3);
        return new QuickLoginApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getUserQuickLogin()).parameters(getParams(quickLoginQueryObj), map).checkSupportMultiLogin().post(), quickLoginQueryObj, quickLoginCallback);
    }

    protected static Map<String, String> getParams(QuickLoginQueryObj quickLoginQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", StringUtils.encryptWithXor(quickLoginQueryObj.mMobile));
        if (!TextUtils.isEmpty(quickLoginQueryObj.mCaptcha)) {
            hashMap.put("captcha", quickLoginQueryObj.mCaptcha);
        }
        hashMap.put("code", StringUtils.encryptWithXor(String.valueOf(quickLoginQueryObj.mCode)));
        hashMap.put("mix_mode", "1");
        if (quickLoginQueryObj.mAuthOpposite != null) {
            hashMap.put("auth_opposite", String.valueOf(quickLoginQueryObj.mAuthOpposite));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<QuickLoginQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 1006, this.queryObj);
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
    public void onSendEvent(MobileApiResponse<QuickLoginQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.LOGIN, "mobile", "login", mobileApiResponse, this.mApiCall);
    }
}
