package com.bytedance.sdk.account.mobile.thread;

import android.content.Context;
import com.bytedance.sdk.account.ExtraNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.LogoutOthersApiResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class LogoutOthersThread extends BaseAccountApi<LogoutOthersApiResponse> {
    List<String> mLogoutUserIds;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public LogoutOthersThread(Context context, ApiRequest apiRequest, AbsApiCall<LogoutOthersApiResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
        this.mLogoutUserIds = new ArrayList();
    }

    public static LogoutOthersThread logoutOthers(Context context, AbsApiCall<LogoutOthersApiResponse> absApiCall) {
        return new LogoutOthersThread(context, new ApiRequest.Builder().url(ExtraNetConstants.getLogoutOthersPath()).post(), absApiCall);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public LogoutOthersApiResponse transformResponse(boolean z, ApiResponse apiResponse) {
        LogoutOthersApiResponse logoutOthersApiResponse = new LogoutOthersApiResponse(z, BaseApiResponse.API_LOGOUT_OTHERS);
        if (z) {
            logoutOthersApiResponse.setLogoutUserIds(this.mLogoutUserIds);
        } else {
            logoutOthersApiResponse.error = apiResponse.mError;
            logoutOthersApiResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return logoutOthersApiResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        JSONArray optJSONArray = jSONObject2.optJSONArray("logout_user_ids");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                this.mLogoutUserIds.add(optJSONArray.getString(i));
            }
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(LogoutOthersApiResponse logoutOthersApiResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EVENT_LOGOUT_OTHERS, null, null, logoutOthersApiResponse, this.mApiCall);
    }
}
