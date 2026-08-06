package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.LegacyNetConstants;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.MobileQuickAuthObj;
import com.bytedance.sdk.account.mobile.thread.call.MobileQuickAuthCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.database.DBData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class MobileQuickAuthThread extends BaseAccountApi<MobileApiResponse<MobileQuickAuthObj>> {
    private MobileQuickAuthObj queryObj;

    private MobileQuickAuthThread(Context context, ApiRequest apiRequest, MobileQuickAuthObj mobileQuickAuthObj, MobileQuickAuthCallback mobileQuickAuthCallback) {
        super(context, apiRequest, mobileQuickAuthCallback);
        this.queryObj = mobileQuickAuthObj;
    }

    public static MobileQuickAuthThread quickAuth(Context context, String str, String str2, String str3, MobileQuickAuthCallback mobileQuickAuthCallback) {
        MobileQuickAuthObj mobileQuickAuthObj = new MobileQuickAuthObj(str, str2, str3);
        return new MobileQuickAuthThread(context, new ApiRequest.Builder().url(LegacyNetConstants.getSMSAuthPath()).parameters(getParams(mobileQuickAuthObj)).post(), mobileQuickAuthObj, mobileQuickAuthCallback);
    }

    public static MobileQuickAuthThread quickAuth(Context context, String str, String str2, String str3, Map<String, String> map, MobileQuickAuthCallback mobileQuickAuthCallback) {
        MobileQuickAuthObj mobileQuickAuthObj = new MobileQuickAuthObj(str, str2, str3);
        return new MobileQuickAuthThread(context, new ApiRequest.Builder().url(LegacyNetConstants.getSMSAuthPath()).parameters(getParams(mobileQuickAuthObj), map).post(), mobileQuickAuthObj, mobileQuickAuthCallback);
    }

    protected static Map<String, String> getParams(MobileQuickAuthObj mobileQuickAuthObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", StringUtils.encryptWithXor(mobileQuickAuthObj.mMobile));
        if (!TextUtils.isEmpty(mobileQuickAuthObj.mCaptcha)) {
            hashMap.put("captcha", mobileQuickAuthObj.mCaptcha);
        }
        hashMap.put("code", StringUtils.encryptWithXor(String.valueOf(mobileQuickAuthObj.mCode)));
        hashMap.put("mix_mode", "1");
        hashMap.put(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(26)));
        hashMap.put("fixed_mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<MobileQuickAuthObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 10003, this.queryObj);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        ApiHelper.mobileError(this.queryObj, jSONObject);
        this.queryObj.jsonResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        try {
            this.queryObj.mToken = jSONObject2.optString("token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.queryObj.jsonResult = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(MobileApiResponse<MobileQuickAuthObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventMobile.MOBILE_QUICK_AUTH, null, null, mobileApiResponse, this.mApiCall);
    }
}
