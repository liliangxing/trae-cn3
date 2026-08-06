package com.bytedance.sdk.account.information.method.can_modify;

import android.content.Context;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.information.UserInfoNetConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CanModifyUserJob extends BaseAccountApi<CanModifyUserResponse> {
    private boolean canSet;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public CanModifyUserJob(Context context, ApiRequest apiRequest, CanModifyUserCallback canModifyUserCallback) {
        super(context, apiRequest, canModifyUserCallback);
    }

    public static CanModifyUserJob canModifyUser(Context context, Set<String> set, CanModifyUserCallback canModifyUserCallback) {
        return new CanModifyUserJob(context, new ApiRequest.Builder().url(UserInfoNetConstants.getCanModifyUserPath()).parameter("targets", getTargets(set)).get(), canModifyUserCallback);
    }

    private static String getTargets(Set<String> set) {
        if (set == null || set.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(IWeiboService.Scope.EMPTY_SCOPE);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CanModifyUserResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CanModifyUserResponse canModifyUserResponse = new CanModifyUserResponse(z, UserInfoNetConstants.API_CAN_MODIFY_USER);
        if (z) {
            canModifyUserResponse.canSet = this.canSet;
        } else {
            canModifyUserResponse.error = apiResponse.mError;
            canModifyUserResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return canModifyUserResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.canSet = jSONObject2.optBoolean("can_set");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CanModifyUserResponse canModifyUserResponse) {
        AccountMonitorUtil.onEvent(UserInfoNetConstants.EventName.CAN_MODIFY_USER, null, null, canModifyUserResponse, this.mApiCall);
    }
}
