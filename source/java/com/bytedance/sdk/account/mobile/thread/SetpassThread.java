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
import com.bytedance.sdk.account.mobile.query.MobileQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.SetPassCall;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SetpassThread extends BaseAccountApi<MobileApiResponse<SetPassObj>> {
    private SetPassObj queryObj;

    public SetpassThread(Context context, ApiRequest apiRequest, SetPassObj setPassObj, SetPassCall setPassCall) {
        super(context, apiRequest, setPassCall);
        this.queryObj = setPassObj;
    }

    public static SetpassThread setPassword(Context context, String str, String str2, SetPassCall setPassCall) {
        SetPassObj setPassObj = new SetPassObj(str, str2);
        return new SetpassThread(context, new ApiRequest.Builder().url(CommonNetConstants.getSetPass()).parameters(getParams(setPassObj, null)).post(), setPassObj, setPassCall);
    }

    public static SetpassThread setPassword(Context context, String str, String str2, Map<String, String> map, SetPassCall setPassCall) {
        SetPassObj setPassObj = new SetPassObj(str, str2);
        return new SetpassThread(context, new ApiRequest.Builder().url(CommonNetConstants.getSetPass()).parameters(getParams(setPassObj, map)).post(), setPassObj, setPassCall);
    }

    protected static Map<String, String> getParams(SetPassObj setPassObj, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(setPassObj.captcha)) {
            hashMap.put("captcha", setPassObj.captcha);
        }
        hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(setPassObj.password));
        hashMap.put("mix_mode", "1");
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<SetPassObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 10002, this.queryObj);
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
    public void onSendEvent(MobileApiResponse<SetPassObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.SET_PASSWORD, "mobile", null, mobileApiResponse, this.mApiCall);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class SetPassObj extends MobileQueryObj {
        String captcha;
        String password;

        public SetPassObj(String str, String str2) {
            super(13);
            this.password = str;
            this.captcha = str2;
        }
    }
}
