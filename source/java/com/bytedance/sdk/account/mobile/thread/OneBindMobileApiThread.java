package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonNetConstants;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.OneBindMobileQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.OneBindMobileCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OneBindMobileApiThread extends BaseAccountApi<MobileApiResponse<OneBindMobileQueryObj>> {
    private OneBindMobileQueryObj queryObj;

    private OneBindMobileApiThread(Context context, ApiRequest apiRequest, OneBindMobileQueryObj oneBindMobileQueryObj, OneBindMobileCallback oneBindMobileCallback) {
        super(context, apiRequest, oneBindMobileCallback);
        this.queryObj = oneBindMobileQueryObj;
    }

    public static OneBindMobileApiThread oneBindMobile(Context context, String str, String str2, String str3, int i, Map map, OneBindMobileCallback oneBindMobileCallback) {
        OneBindMobileQueryObj oneBindMobileQueryObj = new OneBindMobileQueryObj(str, str2, str3, i);
        return new OneBindMobileApiThread(context, new ApiRequest.Builder().url(TextUtils.isEmpty(str3) ? CommonNetConstants.getOneBindMobileV1() : CommonNetConstants.getOneBindMobileV2()).parameters(getParams(oneBindMobileQueryObj), map).post(), oneBindMobileQueryObj, oneBindMobileCallback);
    }

    protected static Map<String, String> getParams(OneBindMobileQueryObj oneBindMobileQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("token", StringUtils.encryptWithXor(oneBindMobileQueryObj.mToken));
        hashMap.put("from", StringUtils.encryptWithXor(oneBindMobileQueryObj.mFrom));
        if (!TextUtils.isEmpty(oneBindMobileQueryObj.mPassword)) {
            hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(oneBindMobileQueryObj.mPassword));
        }
        hashMap.put("unbind_exist", StringUtils.encryptWithXor(String.valueOf(oneBindMobileQueryObj.mUnbindExist)));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<OneBindMobileQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, BaseApiResponse.API_ONE_MOBILE_BIND_MOBILE, this.queryObj);
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
    public void onSendEvent(MobileApiResponse<OneBindMobileQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.ONE_BIND_MOBILE, "mobile", null, mobileApiResponse, this.mApiCall);
    }
}
