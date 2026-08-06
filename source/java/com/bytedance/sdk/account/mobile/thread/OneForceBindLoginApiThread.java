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
import com.bytedance.sdk.account.mobile.query.OneForceBindMobileQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.OneForceBindMobileCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OneForceBindLoginApiThread extends BaseAccountApi<MobileApiResponse<OneForceBindMobileQueryObj>> {
    private OneForceBindMobileQueryObj queryObj;

    public OneForceBindLoginApiThread(Context context, ApiRequest apiRequest, OneForceBindMobileQueryObj oneForceBindMobileQueryObj, OneForceBindMobileCallback oneForceBindMobileCallback) {
        super(context, apiRequest, oneForceBindMobileCallback);
        this.queryObj = oneForceBindMobileQueryObj;
    }

    public static OneForceBindLoginApiThread oneForceBindLogin(Context context, String str, String str2, String str3, int i, String str4, Map<String, String> map, OneForceBindMobileCallback oneForceBindMobileCallback) {
        OneForceBindMobileQueryObj oneForceBindMobileQueryObj = new OneForceBindMobileQueryObj(str, str2, str3, i);
        return new OneForceBindLoginApiThread(context, new ApiRequest.Builder().url(CommonNetConstants.getBindLogin()).parameters(getParams(str4, oneForceBindMobileQueryObj), map).post(), oneForceBindMobileQueryObj, oneForceBindMobileCallback);
    }

    private static Map<String, String> getParams(String str, OneForceBindMobileQueryObj oneForceBindMobileQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("token", StringUtils.encryptWithXor(oneForceBindMobileQueryObj.mToken));
        hashMap.put("from", StringUtils.encryptWithXor(oneForceBindMobileQueryObj.mFrom));
        if (!TextUtils.isEmpty(oneForceBindMobileQueryObj.mProfileKey)) {
            hashMap.put("profile_key", oneForceBindMobileQueryObj.mProfileKey);
        }
        hashMap.put("bind_logic_type", String.valueOf(oneForceBindMobileQueryObj.mBindLogicType));
        hashMap.put("mix_mode", "1");
        hashMap.put("provider_app_id", str);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<OneForceBindMobileQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 10005, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
        this.queryObj.mResultCode = jSONObject.optString("result_code");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.queryObj.mUserInfo = ApiHelper.UserApiHelper.parseUser(jSONObject, jSONObject2);
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<OneForceBindMobileQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.ONE_BIND_MOBILE, "mobile", AccountMonitorConstants.EventPlatform.SCENE_FORCE_BIND_MOBILE, mobileApiResponse, this.mApiCall);
    }
}
