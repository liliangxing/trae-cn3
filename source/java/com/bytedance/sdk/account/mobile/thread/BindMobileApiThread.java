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
import com.bytedance.sdk.account.mobile.query.BindMobileQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.BindMobileCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BindMobileApiThread extends BaseAccountApi<MobileApiResponse<BindMobileQueryObj>> {
    private BindMobileQueryObj queryObj;

    private BindMobileApiThread(Context context, ApiRequest apiRequest, BindMobileQueryObj bindMobileQueryObj, BindMobileCallback bindMobileCallback) {
        super(context, apiRequest, bindMobileCallback);
        this.queryObj = bindMobileQueryObj;
    }

    public static BindMobileApiThread bindMobile(Context context, String str, String str2, String str3, String str4, int i, Map<String, String> map, BindMobileCallback bindMobileCallback) {
        BindMobileQueryObj bindMobileQueryObj = new BindMobileQueryObj(str, str2, str3, str4, i);
        return new BindMobileApiThread(context, new ApiRequest.Builder().url(TextUtils.isEmpty(str3) ? CommonNetConstants.getUserBindMobileV1() : CommonNetConstants.getUserBindMobileV2()).parameters(getParams(bindMobileQueryObj), map).post(), bindMobileQueryObj, bindMobileCallback);
    }

    protected static Map<String, String> getParams(BindMobileQueryObj bindMobileQueryObj) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(bindMobileQueryObj.mCaptcha)) {
            hashMap.put("captcha", bindMobileQueryObj.mCaptcha);
        }
        hashMap.put("code", StringUtils.encryptWithXor(bindMobileQueryObj.mCode));
        hashMap.put("mobile", StringUtils.encryptWithXor(bindMobileQueryObj.mMobile));
        hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(bindMobileQueryObj.mPassword));
        hashMap.put("unbind_exist", StringUtils.encryptWithXor(String.valueOf(bindMobileQueryObj.mUnbindExist)));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<BindMobileQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 1013, this.queryObj);
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
    public void onSendEvent(MobileApiResponse<BindMobileQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.BIND, "mobile", null, mobileApiResponse, this.mApiCall);
    }
}
