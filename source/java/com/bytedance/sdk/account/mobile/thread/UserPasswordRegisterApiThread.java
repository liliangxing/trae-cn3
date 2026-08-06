package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.mobile.query.UserPasswordRegisterQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.UserPasswordRegisterQueryCallback;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UserPasswordRegisterApiThread extends BaseAccountApi<MobileApiResponse<UserPasswordRegisterQueryObj>> {
    private UserPasswordRegisterQueryObj queryObj;

    private UserPasswordRegisterApiThread(Context context, ApiRequest apiRequest, UserPasswordRegisterQueryObj userPasswordRegisterQueryObj, UserPasswordRegisterQueryCallback userPasswordRegisterQueryCallback) {
        super(context, apiRequest, userPasswordRegisterQueryCallback);
        this.queryObj = userPasswordRegisterQueryObj;
    }

    public static UserPasswordRegisterApiThread userPasswordRegister(Context context, String str, String str2, Map<String, String> map, UserPasswordRegisterQueryCallback userPasswordRegisterQueryCallback) {
        UserPasswordRegisterQueryObj userPasswordRegisterQueryObj = new UserPasswordRegisterQueryObj(str, str2);
        return new UserPasswordRegisterApiThread(context, new ApiRequest.Builder().url(ExtraNetConstants.getUserPasswordRegister()).parameters(getParams(userPasswordRegisterQueryObj), map).post(), userPasswordRegisterQueryObj, userPasswordRegisterQueryCallback);
    }

    protected static Map<String, String> getParams(UserPasswordRegisterQueryObj userPasswordRegisterQueryObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("username", StringUtils.encryptWithXor(userPasswordRegisterQueryObj.mUserName));
        hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(userPasswordRegisterQueryObj.mPassword));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public MobileApiResponse<UserPasswordRegisterQueryObj> transformResponse(boolean z, ApiResponse apiResponse) {
        return new MobileApiResponse<>(z, 1023, this.queryObj);
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
    public void onSendEvent(MobileApiResponse<UserPasswordRegisterQueryObj> mobileApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.REGISTER, null, null, mobileApiResponse, this.mApiCall);
    }
}
