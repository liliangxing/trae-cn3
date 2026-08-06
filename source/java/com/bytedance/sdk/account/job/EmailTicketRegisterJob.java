package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class EmailTicketRegisterJob extends BaseAccountApi<UserApiResponse> {
    private IBDAccountUserEntity mUserEntity;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public EmailTicketRegisterJob(Context context, ApiRequest apiRequest, AbsApiCall<UserApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static EmailTicketRegisterJob register(Context context, String str, String str2, int i, int i2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        return new EmailTicketRegisterJob(context, new ApiRequest.Builder().url(ExtraNetConstants.getEmailTicketRegisterPath()).parameters(getParams(str, str2, i, i2), map).post(), commonCallBack);
    }

    protected static Map<String, String> getParams(String str, String str2, int i, int i2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(IGoogleService.ResponseKey.PASSWORD, StringUtils.encryptWithXor(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("email_ticket", str2);
        }
        hashMap.put(DBData.FIELD_TYPE, StringUtils.encryptWithXor(String.valueOf(i)));
        hashMap.put("email_logic_type", String.valueOf(i2));
        hashMap.put("mix_mode", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UserApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(z, BaseApiResponse.API_EMAIL_TICKET_REGISTER);
        if (z) {
            userApiResponse.userInfo = this.mUserEntity;
        } else {
            userApiResponse.error = apiResponse.mError;
            userApiResponse.errorMsg = apiResponse.mErrorMsg;
            userApiResponse.mDetailErrorMsg = apiResponse.mDetailErrorMsg;
        }
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.mUserEntity = ApiHelper.UserApiHelper.parseUserInfo(jSONObject);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UserApiResponse userApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.EMAIL_TICKET_REGISTER, null, null, userApiResponse, this.mApiCall);
    }
}
